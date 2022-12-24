package com.techsam.shoppingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class homeFragement extends Fragment {
    RecyclerView recyclerView;
    ProductRecyclerAdapter adapter;
    ArrayList<Product> list;
    MaterialToolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragement,container,false);
        recyclerView = view.findViewById(R.id.recyclerview);
        toolbar = view.findViewById(R.id.toolbar);

        toolbar.setOnMenuItemClickListener(new androidx.appcompat.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.cart:
                        startActivity(new Intent(getContext(),Cart.class));

                }

                return true;
            }
        });


        list = new ArrayList<>();

        list.add(new Product("WHITE COTTON UNSTITCHED ",2900,"https://www.junaidjamshed.com/media/catalog/product/j/j/jjms-3001_white__1.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=755&width=589&canvas=589:755"));
        list.add(new Product("BLACK COTTON UNSTITCHED KAMEEZ SHALWAR",3900,"https://www.junaidjamshed.com/media/catalog/product/2/1/2162_charcoal_grey_1_.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=755&width=589&canvas=589:755"));
        list.add(new Product("BLUE COTTON UNSTITCHED KAMEEZ SHALWAR",4900,"https://www.junaidjamshed.com/media/catalog/product/2/1/2162_charcoal_grey_1_.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=755&width=589&canvas=589:755"));
        list.add(new Product("RED KAMEEZ SHALWAR",2300,"https://www.junaidjamshed.com/media/catalog/product/2/1/2162_charcoal_grey_1_.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=755&width=589&canvas=589:755"));
        list.add(new Product("GREEN  UNSTITCHED KAMEEZ SHALWAR",6900,"https://www.junaidjamshed.com/media/catalog/product/2/1/2162_charcoal_grey_1_.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=755&width=589&canvas=589:755"));
        list.add(new Product(" KAMEEZ SHALWAR",2200,"https://www.junaidjamshed.com/media/catalog/product/2/1/2162_charcoal_grey_1_.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=755&width=589&canvas=589:755"));


        adapter = new ProductRecyclerAdapter(getContext(),list);
        GridLayoutManager glm = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
//        LinearLayoutManager llm = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);



        return  view;

    }
}