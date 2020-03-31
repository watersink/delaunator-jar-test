package com.example.delaunator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.delaunator.Delaunator;
import com.example.delaunator.R;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    private Delaunator delaunator = new Delaunator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        float[] vertex={(float)0.0, (float)0.0,(float)7, (float)1, (float)0,(float)7, (float)1, (float)1, (float)7, (float)0,(float)1, (float)7};
        int[] index = delaunator.delaunator(vertex);
        for (int i=0;i<index.length;i++) {
            Log.i("##########", String.valueOf(index[i]));
        }


    }

}
