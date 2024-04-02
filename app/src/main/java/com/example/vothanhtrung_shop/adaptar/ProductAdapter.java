package com.example.vothanhtrung_shop.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vothanhtrung_shop.Product;
import com.example.vothanhtrung_shop.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textViewProductName.setText(product.getName());
        holder.textViewProductPrice.setText(String.valueOf(product.getPrice()));

        // Load image using Glide library
        Glide.with(context).load(product.getImageUrl()).into(holder.imageViewProduct);

        // Set up quantity control
        holder.setupQuantityControl();
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textViewProductName;
        TextView textViewProductPrice;
        TextView quantityTextView;
        ImageButton minusButton;
        ImageButton plusButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice);
            quantityTextView = itemView.findViewById(R.id.quantity);
            minusButton = itemView.findViewById(R.id.minusButton);
            plusButton = itemView.findViewById(R.id.plusebutton);
        }

        public void setupQuantityControl() {
            // Set up click listeners for minus and plus buttons
            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Decrease quantity by 1 if greater than 1
                    int quantity = Integer.parseInt(quantityTextView.getText().toString());
                    if (quantity > 1) {
                        quantity--;
                        quantityTextView.setText(String.valueOf(quantity));
                    }
                }
            });

            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Increase quantity by 1
                    int quantity = Integer.parseInt(quantityTextView.getText().toString());
                    quantity++;
                    quantityTextView.setText(String.valueOf(quantity));
                }
            });
        }
    }
}
