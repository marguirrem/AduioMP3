package com.audiomp3.audiomp3.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.audiomp3.audiomp3.R;
import com.audiomp3.audiomp3.interfaces.Login;
import com.audiomp3.audiomp3.interfaces.Register;
import com.audiomp3.audiomp3.services.ResponseLogin;
import com.audiomp3.audiomp3.services.ResponseRegister;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginEtUsuario)
    EditText etUsuario;
    @BindView(R.id.loginEtPassword)
    EditText etPassword;
    @BindView(R.id.btnSigIn)
    Button btnIniciar;
    @BindView(R.id.loginProgress)
    ProgressBar progressBar;
    @BindView(R.id.tvMessagePassword)
    TextView tvMessagePassword;
    @BindView(R.id.tvMessageSignUp)
    TextView tvMessageSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSigIn)
    public void singIn(){
        progressBar.setVisibility(View.VISIBLE);
        new Peticion(this,etUsuario.getText().toString().trim(),
                etPassword.getText().toString().trim()).execute();
    }

    @OnClick(R.id.tvMessageSignUp)
    public void singUp(){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.tvMessagePassword)
    public void recoverPassword(){
        Toast.makeText(this, "Recover Password", Toast.LENGTH_SHORT).show();
    }

    public class Peticion extends AsyncTask<Void,Void,Void>{
        String email;
        String password;
        Context context;

        public Peticion(Context context,String email,String password){
            this.email = email;
            this.password= password;
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            final String url = "http://192.168.0.18/AudioMP3/public/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Login service = retrofit.create(Login.class);

            Call<ResponseLogin> call = service.login(this.email,this.password);
            try {

                call.enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        if (response.isSuccessful()) {
                            if(response.code()==200){

                                Toast.makeText(context,"Usuario "+response.body().getUsername()+" logeado con exito!", Toast.LENGTH_SHORT).show();
                                /*Intent i = new Intent(context, LoginActivity.class);
                            context.startActivity(i);
                            ((Activity) context).finish();*/
                            }
                            else{
                                Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            Toast.makeText(context, "No se pudo Acceder! intente más tarde", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(context, "Error, intente más tarde", Toast.LENGTH_LONG).show();
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
