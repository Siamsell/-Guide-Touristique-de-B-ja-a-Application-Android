package com.siham.guidetoristique;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private LinearLayout dotsLayout;
    private List<Integer> imageList;
    private int currentPosition = 0;
    private Handler autoScrollHandler = new Handler(Looper.getMainLooper());
    private Runnable autoScrollRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        imageView = findViewById(R.id.imageView);
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvTeam = findViewById(R.id.tvTeam);
        TextView tvMembers = findViewById(R.id.tvMembers);
        TextView textSite = findViewById(R.id.sitee);
        ImageView imagecat = findViewById(R.id.cat);
        ImageView imageSite = findViewById(R.id.site);

        imageSite.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Siteinfo.class);
            startActivity(intent);
        });
        imagecat.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Categorier.class);
            startActivity(intent);
        });
        TextView textCategories = findViewById(R.id.textCategories);
        textCategories.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Categorier.class);
            startActivity(intent);
        });

        textSite.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Siteinfo.class);
            startActivity(intent);
        });
        dotsLayout = findViewById(R.id.dotsLayout);

        imageList = new ArrayList<>();
        imageList.add(R.drawable.des);
        imageList.add(R.drawable.img10);
        imageList.add(R.drawable.img1);
        imageList.add(R.drawable.img2);
        imageList.add(R.drawable.img3);
        imageList.add(R.drawable.img4);
        imageList.add(R.drawable.img5);
        imageList.add(R.drawable.img6);
        imageList.add(R.drawable.img7);
        imageList.add(R.drawable.img8);
        imageList.add(R.drawable.img9);
        imageList.add(R.drawable.covv);
        imageList.add(R.drawable.ccv);
        addDotsIndicator(imageList.size(), currentPosition);
        startAutoScroll();

        // Add OnClickListener for the imageView
        imageView.setOnClickListener(v -> {
            currentPosition++;
            if (currentPosition >= imageList.size()) {
                currentPosition =0;
            }
            imageView.setImageResource(imageList.get(currentPosition));
            addDotsIndicator(imageList.size(), currentPosition);
        });

        currentPosition = 0;
        imageView.setImageResource(imageList.get(currentPosition));
        addDotsIndicator(imageList.size(), currentPosition);

    }


    private void addDotsIndicator(int count, int currentPosition) {
        dotsLayout.removeAllViews();
        for (int i = 0; i < count; i++) {
            TextView dot = new TextView(this);
            dot.setText("●");
            dot.setTextSize(14);
            dot.setTextColor(i == currentPosition ? Color.WHITE : Color.BLACK);
            dot.setPadding(4, 0, 4, 0);
            dotsLayout.addView(dot);
        }
    }

    private void startAutoScroll() {
        autoScrollRunnable = new Runnable() {
            @Override
            public void run() {
                if (currentPosition >= imageList.size()) {
                    currentPosition = 0;
                }
                imageView.setImageResource(imageList.get(currentPosition));
                addDotsIndicator(imageList.size(), currentPosition);
                currentPosition++;
                autoScrollHandler.postDelayed(this, 3000);
            }
        };
        autoScrollHandler.postDelayed(autoScrollRunnable, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        autoScrollHandler.removeCallbacks(autoScrollRunnable);
    }

    public void openGoogleMapsNavigation(View v) {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=36.755869,5.084331&mode=d");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        Intent chooser = Intent.createChooser(mapIntent, "Choisissez une application de navigation");
        startActivity(chooser);
    }

    public void goToInfoPage(View view) {
        Intent intent = new Intent(this, MoreInfoActivity.class);
        startActivity(intent);
    }

    public void switchLanguage(View view) {
        String currentLang = getResources().getConfiguration().locale.getLanguage();
        String newLang = currentLang.equals("ar") ? "en" : "ar";

        Locale newLocale = new Locale(newLang);
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
