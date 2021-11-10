package com.example.memeroteca_paulm;

import com.google.android.gms.common.api.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private MemeInterface memeInterface;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MemeInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        memeInterface = retrofit.create(MemeInterface.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public MemeInterface getMemeInterface() {
        return memeInterface;
    }
}
