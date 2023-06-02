package com.example.ExploreX;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // Durasi tampilan splash screen dalam milidetik (misalnya 3000ms = 3 detik)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Menampilkan layout splash screen
        setContentView(R.layout.activity_start);

        // Menggunakan Handler untuk menjalankan kode setelah durasi SPLASH_DURATION
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Setelah durasi SPLASH_DURATION berakhir, pindah ke LoginActivity
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Menutup StartActivity agar tidak dapat kembali ke splash screen dengan tombol back
            }
        }, SPLASH_DURATION);

//        Button register = findViewById(R.id.register);
//        Button login = findViewById(R.id.login);


    }
}
