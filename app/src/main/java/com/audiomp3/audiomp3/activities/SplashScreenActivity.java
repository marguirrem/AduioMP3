package com.audiomp3.audiomp3.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.audiomp3.audiomp3.R;
import com.audiomp3.audiomp3.interfaces.Login;
import com.audiomp3.audiomp3.services.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
        String user_id = sharedPref.getString("user_id", "0");
        final String email = sharedPref.getString("email", "0");
        final String pass = sharedPref.getString("pass", "0");

        if (!user_id.equals("0")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    new PeticionLogin(email, pass).execute();
                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }
    }

    public class PeticionLogin extends AsyncTask<Void, Void, Void> {
        String email;
        String pass;

        public PeticionLogin(String email, String pass) {
            this.email = email;
            this.pass = pass;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //progresBar2.hide();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            //final String url ="http://muekka403.000webhostapp.com/webservices/";
            final String url = "http://192.168.0.18:8000";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Login service = retrofit.create(Login.class);
            Call<ResponseLogin> call = service.login(this.email, this.pass);

            try {
                call.enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                        if (response.isSuccessful()) {
                            Toast.makeText(SplashScreenActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SplashScreenActivity.this, HomeActivity.class);
                            SplashScreenActivity.this.startActivity(i);
                            ((Activity) SplashScreenActivity.this).finish();
                        } else {
                            Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                            SplashScreenActivity.this.startActivity(i);
                            ((Activity) SplashScreenActivity.this).finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(SplashScreenActivity.this, "No se pudo Acceder!", Toast.LENGTH_LONG).show();
                        SplashScreenActivity.this.finish();
                    }
                });

            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return null;
        }
    }

}
