package com.example.vothanhtrung_shop;

import static com.example.vothanhtrung_shop.R.id.minusButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

// Import lớp ProductAdapter từ package tương ứng
import com.example.vothanhtrung_shop.adaptar.ProductAdapter;

public class AllProductActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private RecyclerView rcvProduct;
    private ProductAdapter mProductAdapter;
    private List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        ImageView viewhome=findViewById(R.id.imageViewBack);
        viewhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AllProductActivity.this, HomeAdminActivity.class);
                startActivity(intent);
            }
        });


        rcvProduct = findViewById(R.id.recyclerViewProducts);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();
        mProductAdapter = new ProductAdapter(this, productList);
        rcvProduct.setAdapter(mProductAdapter);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("products");

        fetchDataFromFirebase();
    }

    private void fetchDataFromFirebase() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productList.clear();

                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {

                    String productName = productSnapshot.child("namedetaiproduct").getValue(String.class);
                    int productPrice = productSnapshot.child("priceproduct").getValue(Integer.class);
                    String imageUrl = productSnapshot.child("imageUrlProduct").getValue(String.class);

                    Product product = new Product(productName, productPrice, imageUrl);
                    productList.add(product);
                }

                mProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase", "Error fetching data", databaseError.toException());
            }
        });
    }
}
