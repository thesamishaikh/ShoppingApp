package com.techsam.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetails extends AppCompatActivity {
    int value = 0;
    TextView qty,totalQty,subTotal,textTitle,textPrice;
    int total = 0;
    int aQ,p;
    String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        qty = findViewById(R.id.value);//user selected qty
        totalQty = findViewById(R.id.totalqty);
        textTitle = findViewById(R.id.product_title_details);
        textPrice = findViewById(R.id.product_price_details);
        subTotal = findViewById(R.id.subtotal);

        title = getIntent().getStringExtra("TITLE");
//        aQ = getIntent().getIntExtra("AVAILABLEQTY",0);
//        p = getIntent().getStringExtra("PRICE");

        p = Integer.parseInt(getIntent().getStringExtra("PRICE"));




//        totalQty.setText(""+aQ);
        textPrice.setText("Rs. "+p);
        textTitle.setText(""+title);





    }

    public void add(View view) {


        int avlbQty = Integer.parseInt(totalQty.getText().toString());

        if(value<avlbQty){
            value++;
            qty.setText("" + value);

            total = value*p;

            subTotal.setText("Rs. "+total);

        }




    }

    public void minus(View view) {
        if (value > 0) {
            value--;
            qty.setText("" + value);
            subTotal.setText("Rs. "+(value*p));

        }


    }



    public void addcart(View view) {
        Product product = new Product();
        product.setProductTitle(title);
        product.setProductPrice(p);
        product.setProductAvlQty(value);
        MainActivity.cartList.add(product);


    }
}