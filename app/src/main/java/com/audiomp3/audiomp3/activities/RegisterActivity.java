package com.audiomp3.audiomp3.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.audiomp3.audiomp3.R;
import com.audiomp3.audiomp3.interfaces.Register;
import com.audiomp3.audiomp3.services.ResponseRegister;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {


    @BindView(R.id.etFirstName)
    EditText etFirstName;
    @BindView(R.id.etLastName)
    EditText etLastName;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;
    @BindView(R.id.btnSignUp)
    Button btnSignUp;
    @BindView(R.id.registerProgress)
    ProgressBar registerProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignUp)
    public void signUp() {
        View view = new View(this);
        registerProgress.setVisibility(View.VISIBLE);
        hideKeyBorad();
        new Peticion(this, view, etFirstName.getText().toString().trim(), etLastName.getText().toString().trim(),
                etConfirmPassword.getText().toString().trim(), etEmail.getText().toString().trim(),
                etPassword.getText().toString().trim(),this.registerProgress).execute();

    }

    public void validateForm() {

        if (etFirstName.getText().equals("")) {
            etFirstName.setError("Debe llenar este campo");
        }
        if (etLastName.getText().equals("")) {
            etLastName.setError("Debe llenar este campo");
        }
        if (etEmail.getText().equals("")) {
            etEmail.setError("Debe llenar este campo");
        }
        if (etPassword.getText().equals("")) {
            etPassword.setError("Debe llenar este campo");
        }
        if (etConfirmPassword.getText().equals("")) {
            etConfirmPassword.setError("Debe llenar este campo");
        }

        if (etPassword.getText() != etConfirmPassword.getText()) {
            etPassword.setError("Las contraseñas no coinciden!");
            etConfirmPassword.setError("Las contraseñas no coinciden!");
        }
        registerProgress.setVisibility(View.GONE);
    }

    private void hideKeyBorad() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }

    public class Peticion extends AsyncTask<Void, Void, Void> {
        String username;
        String password;
        String first_name;
        String last_name;
        String email;
        View view;
        Context context;
        ProgressBar progressBar;


        public Peticion(Context context, View view, String first_name, String last_name,
                        String username, String email, String password,ProgressBar progressBar) {
            this.username = username;
            this.password = password;
            this.first_name = first_name;
            this.last_name = last_name;
            this.view = view;
            this.context = context;
            this.email = email;
            this.progressBar = progressBar;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            this.progressBar.setVisibility(View.GONE);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            //final String url ="http://muekka403.000webhostapp.com/webservices/";
            final String url = "http://192.168.0.18/AudioMP3/public/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Register service = retrofit.create(Register.class);

            Call<ResponseRegister> call = service.register(this.username, this.first_name, this.password,
                    this.last_name, this.email);
            try {

                call.enqueue(new Callback<ResponseRegister>() {
                    @Override
                    public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(context,"Usuario " + response.body().getUsername()+" creado con exito!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(context, LoginActivity.class);
                            context.startActivity(i);
                            ((Activity) context).finish();
                        } else {
                            Log.e("Error","codigo2: "+response.code()+response.toString());
                            Toast.makeText(context, "No se pudo Acceder! intente más tarde", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseRegister> call, Throwable t) {
                        Toast.makeText(context, "Fallo en la petición", Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                });


            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
