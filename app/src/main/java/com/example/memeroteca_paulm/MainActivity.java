package com.example.memeroteca_paulm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    ListView memesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memesListView = findViewById(R.id.memesListView);

        getMemes();
    }

    private void getMemes() {
        Call<List<Meme>> call = RetrofitClient.getInstance().getMemeInterface().getMemes();
        call.enqueue(new Callback<List<Meme>>() {
            @Override
            public void onResponse(Call<List<Meme>> call, Response<List<Meme>> response) {
                List<Meme> memeList = response.body();
                String[] oneMeme = new String[memeList.size()];

                for (int i = 0; i < memeList.size(); i++) {
                    oneMeme[i] = memeList.get(i).getName();
                }

                memesListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneMeme));
            }

            @Override
            public void onFailure(Call<List<Meme>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}