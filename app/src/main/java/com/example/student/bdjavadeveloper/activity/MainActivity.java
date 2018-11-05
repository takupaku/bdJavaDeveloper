package com.example.student.bdjavadeveloper.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.student.bdjavadeveloper.api.ApiService;
import com.example.student.bdjavadeveloper.api.Client;


import com.example.student.bdjavadeveloper.R;


import com.example.student.bdjavadeveloper.adapter.LVAdapter;
import com.example.student.bdjavadeveloper.model.Item;
import com.example.student.bdjavadeveloper.model.javaDeveloperModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    List<Item> items= new ArrayList();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView=findViewById(R.id.recyclerId);

    }

    private void loadData() {
        ApiService apiService = Client.getClient().create(ApiService.class);
        Call<javaDeveloperModel> call = apiService.getAllItem();
        call.enqueue(new Callback<javaDeveloperModel>() {
            @Override
            public void onResponse(Call<javaDeveloperModel> call, Response<javaDeveloperModel> response) {


                items = response.body().getItems();
                LVAdapter lvAdapter = new LVAdapter(MainActivity.this,items);
                recyclerView.setAdapter(lvAdapter);

                items.get(0).getAvatarUrl();
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<javaDeveloperModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "FAILED", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
