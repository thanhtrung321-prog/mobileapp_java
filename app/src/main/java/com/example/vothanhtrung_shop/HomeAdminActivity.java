package com.example.vothanhtrung_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeAdminActivity extends AppCompatActivity {

    private ConstraintLayout addproduct;// Khai báo biến addproduct ở đây
    protected ConstraintLayout allproduct;
    protected  ConstraintLayout profileadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        // Ánh xạ và gán giá trị cho addproduct trong phương thức onCreate()
        addproduct = findViewById(R.id.Addproduct);
        allproduct=findViewById(R.id.Allproductview);
        profileadmin=findViewById(R.id.profileAdmin);
        profileadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeAdminActivity.this,AdminprofileActivity.class);
                startActivity(intent);
            }
        });

        allproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeAdminActivity.this,AllProductActivity.class);
                startActivity(intent);
            }
        });

        // Thiết lập sự kiện click cho addproduct
        addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến DetailActivity khi người dùng nhấn vào addproduct
                Intent intent = new Intent(HomeAdminActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
