package com.example.memeroteca_paulm;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MemeInterface {

    String BASE_URL = "https://api.imgflip.com/";
    @GET("get_memes")
    Call<List<Meme>> getMemes();
}
