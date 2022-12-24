package com.techsam.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Cart extends AppCompatActivity {
    RecyclerView recyclerView;
    CartAdapter adapter;
    TextView grandTotal;
    int gTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.cartrecycler);
        grandTotal = findViewById(R.id.subtotalx);
        adapter = new CartAdapter(this,MainActivity.cartList);

        LinearLayoutManager llm = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);



        for (Product p:MainActivity.cartList){
            gTotal +=p.getProductPrice();
        }

        grandTotal.setText(""+gTotal);

    }

    public void deliverydetails(View view) {
        Intent intent = new Intent(Cart.this,DeliveryDetails.class);
//        intent.putExtra("title",title);
//        intent.putExtra("price",p);
//        intent.putExtra("qty",value);

        startActivity(intent);
    }
}