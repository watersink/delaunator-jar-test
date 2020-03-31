package com.example.delaunator;

public class Delaunator {

    static {
        System.loadLibrary("delaunator-jni");
    }

    public native int[] delaunator(float[] vertex);
}
