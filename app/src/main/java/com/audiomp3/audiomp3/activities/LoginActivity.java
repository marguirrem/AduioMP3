package com.audiomp3.audiomp3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.audiomp3.audiomp3.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.txtUsuario)
    EditText txtUsuario;
    @BindView(R.id.txtPassword)
    EditText txtPassword;
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
}
