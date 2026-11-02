package com.siham.guidetoristique.adapter;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.siham.guidetoristique.R;
import com.siham.guidetoristique.models.Site;
import com.siham.guidetoristique.models.SiteImage;

import java.util.List;

public class imagePagerAdapter extends ArrayAdapter<SiteImage> {
    Context context;
    List<SiteImage> sites;
    public imagePagerAdapter(Context context, List<SiteImage> sites) {
        super(context, 0,sites);
        this.context = context;
        this.sites  =sites;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.image_pager_item, parent, false);
        }

        SiteImage s = sites.get(position);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(s.path);


        return convertView;
    }



}
