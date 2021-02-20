package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.adapter.MyListAdapter;
import com.example.myapplication.api.APIClient;
import com.example.myapplication.apiInterface.APIInterface;
import com.example.myapplication.model.Root;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    RecyclerView recyclerView;
    ArrayList<Root> postData;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<Root>> call2 = apiInterface.doGetUserList();
        call2.enqueue(new Callback <ArrayList<Root>> () {
            @Override
            public void onResponse(Call<ArrayList<Root>>  call, Response<ArrayList<Root>>  response) {
                Log.e("enums",response.body()+"");
                postData = response.body();
                recyclerView.setVisibility(View.VISIBLE);
                MyListAdapter myListAdapter = new MyListAdapter(postData,MainActivity.this,recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(myListAdapter);
            }
            @Override
            public void onFailure(Call<ArrayList<Root>>  call, Throwable t) {
                Log.e("onFailure",t.getMessage());
            }
          
        });
    }
}