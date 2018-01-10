package com.audiomp3.audiomp3.activities;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.audiomp3.audiomp3.R;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    ContentLoadingProgressBar registerProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        validateForm();
    }

    public void validateForm(){
        if (etFirstName.getText().equals("")){
            etFirstName.setError("Debe llenar este campo");
        }
        if (etLastName.getText().equals("")){
            etLastName.setError("Debe llenar este campo");
        }
        if (etEmail.getText().equals("")){
            etEmail.setError("Debe llenar este campo");
        }if (etPassword.getText().equals("")){
            etPassword.setError("Debe llenar este campo");
        }if (etConfirmPassword.getText().equals("")){
            etConfirmPassword.setError("Debe llenar este campo");
        }

        if(etPassword.getText() != etConfirmPassword.getText()){
            etPassword.setError("Las contraseñas no coinciden!");
            etConfirmPassword.setError("Las contraseñas no coinciden!");
        }
    }
}
