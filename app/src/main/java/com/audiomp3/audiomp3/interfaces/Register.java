package com.audiomp3.audiomp3.interfaces;

import com.audiomp3.audiomp3.services.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by marlon on 29/01/18.
 */

public interface Register {

    @Headers("Content-Type: application/json")
    @POST("api/user/register")
    Call<ResponseRegister> register(@Query("username") String username,
                                    @Query("first_name")String firstName,
                                    @Query("password") String password,
                                    @Query("last_name")String lastName,
                                    @Query("email")String email);
}
