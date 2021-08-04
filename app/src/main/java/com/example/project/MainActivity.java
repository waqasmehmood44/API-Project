package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ApiINterface apiINterface;
 RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiINterface= RetrofitInstance.getRetrofit().create(ApiINterface.class);
        recyclerView=findViewById(R.id.recyclerview);
     apiINterface.getdata().enqueue(new Callback<List<ModelClass>>() {
             @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
       if(response.body().size()>0){
                     List<ModelClass> record = response.body();
                    Adapter adapter=new Adapter(MainActivity.this, record);
                   LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    recyclerView.setAdapter(adapter);
        }else
        {
            Toast.makeText(MainActivity.this,"List is Empty",Toast.LENGTH_SHORT).show();

        }
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}