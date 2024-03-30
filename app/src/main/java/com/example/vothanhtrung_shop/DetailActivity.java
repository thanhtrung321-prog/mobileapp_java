package com.example.vothanhtrung_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //load danh sách thành phần của detailproduct
        TextView textView = findViewById(R.id.listcomponent);
        componetfood component = new componetfood(textView);
        component.Oncreated();
    }
}