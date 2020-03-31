#include <jni.h>
#include <string>
#include <android/log.h>
#include "delaunator.hpp"
#include <vector>

#define TAG "delaunator_so"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)



extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_delaunator_Delaunator_delaunator(JNIEnv *env, jobject thiz, jfloatArray vertex) {
    // TODO: implement delaunator()

    std::vector<float> coords;
    jfloat* float_elems = env->GetFloatArrayElements(vertex, 0);
    for (jsize index=0; index<env->GetArrayLength(vertex);index++) {
        coords.push_back(float_elems[index]);
    }

    //triangulation happens here
    delaunator::Delaunator d(coords);
    int *buffer = new int[d.triangles.size()];
    if (!d.triangles.empty())
    {
        memcpy(buffer, &d.triangles[0], d.triangles.size()*sizeof(int));
    }

    jintArray jOutputData = env->NewIntArray(d.triangles.size());
    env->SetIntArrayRegion(jOutputData, 0, d.triangles.size(), buffer);
    delete []buffer;

    if (jOutputData == nullptr) return nullptr;
    return jOutputData;

}
