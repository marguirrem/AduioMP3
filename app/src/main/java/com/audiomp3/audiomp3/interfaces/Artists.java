package com.audiomp3.audiomp3.interfaces;

import com.audiomp3.audiomp3.services.ResponseArtists;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Artists {

    @Headers("Content-Type: application/json")
    @POST("api/artists")
    Call<List<ResponseArtists>> getArtists();
}
