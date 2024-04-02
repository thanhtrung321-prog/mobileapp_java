package com.example.vothanhtrung_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdminprofileActivity extends AppCompatActivity {
    protected ImageView pagehome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminprofile);
        pagehome=findViewById(R.id.page_home_admin);
        pagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminprofileActivity.this,HomeAdminActivity.class);
                startActivity(intent);
            }
        });
    }
}