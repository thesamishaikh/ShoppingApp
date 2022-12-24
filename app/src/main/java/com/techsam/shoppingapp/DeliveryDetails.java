package com.techsam.shoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeliveryDetails extends AppCompatActivity {
    TextInputLayout name,contact,address;
    DatabaseReference db;
    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        address = findViewById(R.id.address);

        db = FirebaseDatabase.getInstance().getReference();


//        String title = getIntent().getStringExtra("title");
//        int price = getIntent().getIntExtra("price",0);
//        int q = getIntent().getIntExtra("qty",0);





         order = new Order();
//        order.setProductTitle(title);
//        order.setProductPrice(price);
//        order.setProductQty(q);



    }

    public void submit(View view) {

        String n = name.getEditText().getText().toString();
        String c = contact.getEditText().getText().toString();
        String a = address.getEditText().getText().toString();
        String pushKey = db.child("Orders").push().getKey();

        order.setCustomerName(n);
        order.setCustomerContact(c);
        order.setCustomerAddress(a);
        order.setId(pushKey);
        order.setList(MainActivity.cartList);
        order.setStatus("Pending");

        db.child("Orders").child(pushKey).setValue(order).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(DeliveryDetails.this, "Order Submitted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DeliveryDetails.this,MainActivity.class));
                finish();
            }
        });
    }
}