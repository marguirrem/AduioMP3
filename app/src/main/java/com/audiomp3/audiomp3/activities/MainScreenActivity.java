package com.audiomp3.audiomp3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.audiomp3.audiomp3.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainScreenActivity extends AppCompatActivity {

    @BindView(R.id.imageLogo)
    ImageView imageLogo;
    @BindView(R.id.btnInicio)
    Button Inicio;
    @BindView(R.id.btnRegistro)
    Button Registro;
    @BindView(R.id.layoutImage)
    LinearLayout layoutImage;
    @BindView(R.id.buttons)
    LinearLayout buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnInicio)
    public void iniciar() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnRegistro)
    public void crear() {
        Intent intent = new Intent(getApplicationContext(), Registro.class);
        startActivity(intent);
    }
}
