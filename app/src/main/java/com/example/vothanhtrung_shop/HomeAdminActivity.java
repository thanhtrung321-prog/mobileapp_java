package com.example.vothanhtrung_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class HomeAdminActivity extends AppCompatActivity {

    private ConstraintLayout addproduct;// Khai báo biến addproduct ở đây
    protected ConstraintLayout allproduct;
    protected  ConstraintLayout profileadmin;
    protected  ConstraintLayout adduseradmin;
    protected ConstraintLayout logouthome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        // Ánh xạ và gán giá trị cho addproduct trong phương thức onCreate()
        addproduct = findViewById(R.id.Addproduct);
        allproduct=findViewById(R.id.Allproductview);
        profileadmin=findViewById(R.id.profileAdmin);
        adduseradmin=findViewById(R.id.addUserAdmin);
        logouthome=findViewById(R.id.logoutadminHome);
        logouthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị thông báo đăng xuất thành công
                Toast.makeText(HomeAdminActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();

                // Đặt thời gian chờ trước khi chuyển sang MainActivity
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Tạo Intent để chuyển đến MainActivity
                        Intent intent = new Intent(HomeAdminActivity.this, MainActivity.class);
                        startActivity(intent); // Chuyển sang MainActivity
                        finish(); // Kết thúc Activity hiện tại
                    }
                }, 600); // Đợi 1 giây trước khi chuyển sang MainActivity
            }
        });



        adduseradmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeAdminActivity.this,CreateUserAdminActivity.class);
                startActivity(intent);
            }
        });
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
