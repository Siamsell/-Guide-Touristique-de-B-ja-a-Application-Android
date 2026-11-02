package com.siham.guidetoristique;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.siham.guidetoristique.adapter.imagePagerAdapter;
import com.siham.guidetoristique.adapter.SiteAdapter;
import com.siham.guidetoristique.Generator;
import com.siham.guidetoristique.models.SiteType;

public class Siteinfo extends AppCompatActivity {

    ListView siteListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_info);
        String type = getIntent().getStringExtra("type");

        if(type == null){
            type = SiteType.HOTEL;
            Toast.makeText(this, "null type", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "type = "+type, Toast.LENGTH_SHORT).show();

        }

        siteListView = findViewById(R.id.site_list);

        SiteAdapter siteAdapter = new SiteAdapter(Siteinfo.this, Generator.generateSites( Siteinfo.this, type));

        siteListView.setAdapter(siteAdapter);
    }

}