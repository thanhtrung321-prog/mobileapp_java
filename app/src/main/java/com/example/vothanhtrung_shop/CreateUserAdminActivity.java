package com.example.vothanhtrung_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CreateUserAdminActivity extends AppCompatActivity {
    protected  ImageView pagehomeadduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_admin);
        pagehomeadduser=findViewById(R.id.page_home_admin_adduser);
        pagehomeadduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CreateUserAdminActivity.this,HomeAdminActivity.class);
                startActivity(intent);
            }
        });
    }
}