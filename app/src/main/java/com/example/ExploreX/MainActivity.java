package com.example.ExploreX;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.ExploreX.Fragments.HomeFragment;
import com.example.ExploreX.Fragments.NotificationFragment;
import com.example.ExploreX.Fragments.ProfileFragment;
import com.example.ExploreX.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;
///testestes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_coba);

        meowBottomNavigation = findViewById(R.id.meowBottom);

        //add item menu
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_search_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_library_add_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_notifications_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_baseline_person_24));
        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1 :
                        fragment = new HomeFragment();
                        break;
                    case 2 :
                        fragment = new SearchFragment();
                        break;
                    case 3 :
                        fragment = null;
                        startActivity(new Intent(MainActivity.this , PostActivity.class));
                        break;
                    case 4 :
                        fragment = new NotificationFragment();
                        break;
                    case 5 :
                        fragment = new ProfileFragment();
                        break;

                }

                loadFragment(fragment);
            }
        });

        meowBottomNavigation.setCount(1, "10");

        //set default
        meowBottomNavigation.show(1, true);

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}

