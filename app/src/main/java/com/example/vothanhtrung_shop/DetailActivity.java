package com.example.vothanhtrung_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
        ImageView detailpage=findViewById(R.id.detail_page_home);
        detailpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailActivity.this,HomeAdminActivity.class);
                startActivity(intent);
            }
        });
    }

}