
package com.siham.guidetoristique.adapter;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.siham.guidetoristique.Generator;
import com.siham.guidetoristique.R;
import com.siham.guidetoristique.models.Site;
import com.siham.guidetoristique.models.SiteImage;

import java.util.List;

public class SiteAdapter extends ArrayAdapter<Site> {

    public SiteAdapter(Context context, List<Site> sites) {
        super(context, 0, sites);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.site_item, parent, false);
        }
        Site site = getItem(position);
        LinearLayout  imageContainer = convertView.findViewById(R.id.horizontalContainer);

        for (SiteImage img : site.images) {
            ImageView imageView = new ImageView(getContext());
            imageView.setAdjustViewBounds(true);
            imageView.setMinimumHeight(600);
            imageView.setMaxHeight(800);
            imageView.setImageResource(img.path);
            imageView.setClipToOutline(true);
            imageContainer.addView(imageView);
        }
        Button btnCall;
        btnCall= convertView.findViewById(R.id.btnCall);
        TextView name = convertView.findViewById(R.id.name);
        TextView description = convertView.findViewById(R.id.description);
        TextView telephone = convertView.findViewById(R.id.phone);
        TextView email = convertView.findViewById(R.id.email);
        Button btnEmail = convertView.findViewById(R.id.btnEmail);
        Button btnSms = convertView.findViewById(R.id.btnSms);
        TextView reviewsTextView = convertView.findViewById(R.id.reviews) ;
        StringBuilder stars = new StringBuilder();
        int rating = 3;

        for (int i = 0; i < rating; i++) {
            stars.append("★"); // Ajouter une étoile pleine
        }
        name.setText(site.name);
        description.setText(site.description);
        telephone.setText(site.telephone);
        email.setText(site.email);

        Generator.setupCallButton(getContext(), telephone, btnCall);
        Generator.setupEmailButton(getContext(),email , btnEmail);
        Generator.setupSmsButton(getContext(), telephone, btnSms);
        if (site.getReviews() != null && !site.getReviews().isEmpty()) {
            StringBuilder reviewsText = new StringBuilder();
            for (String review : site.getReviews()) {
                reviewsText.append(review).append("\n");
            }
            reviewsTextView.setText(reviewsText.toString());  // Mettre les avis dans le TextView
        }






        TextView locationTextView = convertView.findViewById(R.id.textViewLocation);


        locationTextView.setText("📍 " + site.getLocation());
        return convertView;

    }
}
