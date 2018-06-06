package com.audiomp3.audiomp3.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.audiomp3.audiomp3.R;
import com.audiomp3.audiomp3.interfaces.Login;
import com.audiomp3.audiomp3.interfaces.Register;
import com.audiomp3.audiomp3.services.ResponseLogin;
import com.audiomp3.audiomp3.services.ResponseRegister;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

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
        hideKeyBorad();
        progressBar.setVisibility(View.VISIBLE);
        View view = new View(this);
        new Peticion(this,view,etUsuario.getText().toString().trim(),
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

    private void hideKeyBorad() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }catch (NullPointerException npe){
            Log.e(getLocalClassName(),Log.getStackTraceString(npe));
        }
    }
    public class Peticion extends AsyncTask<Void,Void,Void>{
        String email;
        String password;
        Context context;
        View view;

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        public Peticion(Context context, View view,String email, String password){
            this.email = email;
            this.password= password;
            this.context = context;
            this.view = view;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //constante de la url a la que se hace la petición
            final String url = "http://192.168.0.18:8000";

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

                                String user_id = response.body().getId();
                                String username = response.body().getUsername();
                                //String pass = etPass.getText().toString().trim();
                                String name = response.body().getFirstName();
                                String lastName = response.body().getLastName();
                                String email = response.body().getEmail();
                                Log.e("After","photo: "+response.body().getPhoto());
                                String photo = response.body().getPhoto();
                                rememberMe(user_id,username,name,lastName,email,photo);

                                Toast.makeText(context,"Usuario "+response.body().getFirstName()+" logeado con exito!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(context, HomeActivity.class);
                                context.startActivity(i);
                                ((Activity) context).finish();
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



        private void rememberMe(String user_id,String username,String name,String
                lastName,String email,String photo){
            //save id of user from websrvice on sharedpreferences
            SharedPreferences sharedPref =getSharedPreferences("user",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("user_id",user_id);
            editor.putString("username",username);
            editor.putString("first_name",name);
            editor.putString("last_name",lastName);
            editor.putString("email",email);
            editor.putString("photo",photo);
            editor.apply();


        }
    }

}
