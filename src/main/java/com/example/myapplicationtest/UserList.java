package com.example.myapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserList extends AppCompatActivity implements View.OnClickListener {


    private TextView textViewResult1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        textViewResult1 = findViewById(R.id.text_view_result1);


        textViewResult1.setOnClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Users>> call = jsonPlaceHolderApi.getUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                if(!response.isSuccessful()){
                    textViewResult1.setText("Code: " + response.code() + ". \n\nCheck your connection.");
                    return;
                }

                List<Users> users = response.body();

                for (Users users1 : users) {
                    String content = "";
                    content += "userID: " + users1.getUserID() + "\n\n\n";


                    if (users1.getUserID() == 1){
                        
                    }


                    textViewResult1.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Users>>  call, Throwable t) {
                textViewResult1.setText(t.getMessage());
            }
        });


    }

    @Override
    public void onClick(View v) {
            Intent i;
        if (v.getId() == R.id.text_view_result1){
        i = new Intent(this, MainActivity.class);
        startActivity(i);
        }

    }
}