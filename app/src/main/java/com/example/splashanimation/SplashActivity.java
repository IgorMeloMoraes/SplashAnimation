package com.example.splashanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    // Variaveis Globais
    TextView txtLogo, txtInfo;
    ImageView imgLogo;
    Animation topAnim, bottomAnim;

    // Constante do valor de tempo em milissegundos
    private static final int SPLASH_SCREEN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hooks
        txtLogo = findViewById(R.id.txt_logo);
        txtInfo = findViewById(R.id.txt_info);
        imgLogo = findViewById(R.id.img_logo);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        // Setar animações
        imgLogo.setAnimation(topAnim);
        txtLogo.setAnimation(bottomAnim);
        txtInfo.setAnimation(bottomAnim);

        // Classe Handler para gerar a ação de tempo de tela e passar a proxima intent
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);
    }


}