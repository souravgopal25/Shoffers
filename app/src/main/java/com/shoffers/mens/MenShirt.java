package com.shoffers.mens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shoffers.Product;
import com.shoffers.R;

import java.util.ArrayList;
import java.util.List;

public class MenShirt extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Product> product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_shirt);
        recyclerView=findViewById(R.id.item_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        product =new ArrayList<>();

        readproduct();


    }

    private void readproduct() {
    }
}
