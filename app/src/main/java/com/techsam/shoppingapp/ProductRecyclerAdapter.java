package com.techsam.shoppingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<Product> list;

    public ProductRecyclerAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.design_product_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerAdapter.ViewHolder holder, int position) {
        Picasso.get().load(list.get(position).getProductImg()).into(holder.img);




        holder.title.setText(list.get(position).getProductTitle());
        holder.price.setText(""+list.get(position).getProductPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.product_img);
            title = itemView.findViewById(R.id.product_title);
            price = itemView.findViewById(R.id.product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = getAdapterPosition();

                    Intent intent = new Intent(context,ProductDetails.class);

                    intent.putExtra("PRICE",list.get(pos).getProductPrice()+"");
//                    intent.putExtra("AVAILABLEQTY",list.get(pos).getProductAvlQty());
                    intent.putExtra("TITLE",list.get(pos).getProductTitle());
                    context.startActivity(intent);
                }
            });

        }
    }
}
