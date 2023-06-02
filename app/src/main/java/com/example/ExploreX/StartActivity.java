package com.example.ExploreX;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // Durasi tampilan splash screen dalam milidetik (misalnya 3000ms = 3 detik)
    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Menampilkan layout splash screen
        setContentView(R.layout.activity_start);

        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("LOGIN_STATUS", MODE_PRIVATE);

        // Menggunakan Handler untuk menjalankan kode setelah durasi SPLASH_DURATION
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cek status login pengguna
                if (isUserLoggedIn()) {
                    // Jika pengguna sudah login sebelumnya, langsung pindah ke MainActivity
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Menutup StartActivity agar tidak dapat kembali ke splash screen dengan tombol back
                } else {
                    // Jika pengguna belum login sebelumnya, pindah ke LoginActivity
                    Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        }, SPLASH_DURATION);
    }

    private boolean isUserLoggedIn() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        boolean isLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false);

        return (currentUser != null && isLoggedIn);
    }
}
