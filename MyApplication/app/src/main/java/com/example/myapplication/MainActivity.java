package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.delaunator.Delaunator;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float[] vertex={(float)0.0, (float)0.0,(float)7, (float)1, (float)0,(float)7, (float)1, (float)1, (float)7, (float)0,(float)1, (float)7};
        int[] index = new Delaunator().delaunator(vertex);
        for (int i=0;i<index.length;i++) {
            Log.i("##########", String.valueOf(index[i]));
        }
    }
}
