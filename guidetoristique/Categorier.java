
package com.siham.guidetoristique;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.siham.guidetoristique.models.CategoryModel;
import com.siham.guidetoristique.models.SiteType;

import java.util.ArrayList;
import java.util.List;

public class Categorier extends AppCompatActivity {

    private ListView listView;
    private List<CategoryModel> categoryList;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listView = findViewById(R.id.listViewCategories);
        categoryList = new ArrayList<>();
        categoryList.add(new CategoryModel(getString(R.string.beaches), getString(R.string.beaches_desc), R.drawable.bea, SiteType.BEACHES));
        categoryList.add(new CategoryModel(getString(R.string.mountains), getString(R.string.mountains_desc), R.drawable.jb, SiteType.MONTAINS));
        categoryList.add(new CategoryModel(getString(R.string.historical_sites), getString(R.string.historical_sites_desc), R.drawable.ma, SiteType.TOURIST));
        categoryList.add(new CategoryModel(getString(R.string.museums), getString(R.string.museums_desc), R.drawable.img3, SiteType.MUSEUMS));
        categoryList.add(new CategoryModel(getString(R.string.restaurants), getString(R.string.restaurants_desc),R.drawable.rest, SiteType.RESTAURANT));
        categoryList.add(new CategoryModel(getString(R.string.parks),getString(R.string.parks_desc), R.drawable.pqrck, SiteType.JARDIN));
        categoryList.add(new CategoryModel(getString(R.string.hotels), getString(R.string.hotels_desc),R.drawable.hotl, SiteType.HOTEL));
        adapter = new CategoryAdapter(this, categoryList, category -> {
            Intent intent = new Intent(Categorier.this, Siteinfo.class);
            intent.putExtra("type", category.getType());
            startActivity(intent);
        });

        listView.setAdapter(adapter);
    }
}
