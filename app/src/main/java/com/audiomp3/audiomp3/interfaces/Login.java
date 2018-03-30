package com.audiomp3.audiomp3.interfaces;

import com.audiomp3.audiomp3.services.ResponseLogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Login {

    @Headers("Content-Type: application/json")
    @POST("api/user/login")
    Call<ResponseLogin> login(@Query("email")String email, @Query("password") String password);
}
