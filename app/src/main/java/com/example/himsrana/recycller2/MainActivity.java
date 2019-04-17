package com.example.himsrana.recycller2;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements ImageAdapter.ListItemClickListener {

    private RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    private int[] images = {R.drawable.pic1,R.drawable.pic2,
    R.drawable.pic3,R.drawable.pic4,R.drawable.pic5};

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.images_list);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        imageAdapter = new ImageAdapter(images,this);
        recyclerView.setAdapter(imageAdapter);

    }

    @Override
    public void onListItemClickListener(int clickedItemIndex) {
        Toast.makeText(this, "Clicked",
                Toast.LENGTH_SHORT).show();

    }
}
