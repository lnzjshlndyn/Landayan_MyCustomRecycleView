package com.example.josh.mycustomrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvAndroidVesions;
    int[] logo;
    String[] codename, version, api, date;
    ArrayList<AndroidVersion> list;
    CustomAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroidVesions = (RecyclerView) findViewById(R.id.recycleview);
        logo = new int[]{
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake,
                R.drawable.cupcake
                };

        codename = getResources().getStringArray(R.array.codename);
        version = getResources().getStringArray(R.array.version);
        api = getResources().getStringArray(R.array.api);
        date = getResources().getStringArray(R.array.date);

        list = new ArrayList<AndroidVersion>();

        layoutManager = new LinearLayoutManager(this);
        //layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        rvAndroidVesions.setLayoutManager(layoutManager);
        rvAndroidVesions.setHasFixedSize(true);
        for(int i = 0; i < codename.length; i++){
            new AndroidVersion(logo[i], codename[i], version[i], api[i], date[i]);
        }

        adapter = new CustomAdapter(list);

        rvAndroidVesions.setAdapter(adapter);
    }
}
