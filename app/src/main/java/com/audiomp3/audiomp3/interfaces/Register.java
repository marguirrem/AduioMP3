package com.audiomp3.audiomp3.interfaces;

import com.audiomp3.audiomp3.services.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by marlon on 29/01/18.
 */

public interface Register {


    @FormUrlEncoded
    @POST("api/user/register")
    Call<ResponseRegister> register(@Field("username") String username,
                                    @Field("first_name")String firstName,
                                    @Field("password") String password,
                                    @Field("last_name")String lastName,
                                    @Field("email")String email);
}
