package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result123);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Todo>> call = jsonPlaceHolderApi.getTodos();

        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {

                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code() + ". \n\nCheck your connection.");
                    return;
                }

                List<Todo> todos = response.body();

                for (Todo todo : todos) {
                    String content = "";
                    content += "userID: " + todo.getUserId() + "\n";
                    content += "ID: " + todo.getId() + "\n";
                    content += "Title: " + todo.getTitle() + "\n";
                    content += "Completed Task: " + todo.isCompleted() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}