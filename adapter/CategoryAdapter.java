
package com.siham.guidetoristique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.siham.guidetoristique.models.CategoryModel;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<CategoryModel> {

    public interface OnCategoryClickListener {
        void onCategoryClick(CategoryModel category);
    }

    private OnCategoryClickListener listener;

    public CategoryAdapter(Context context, List<CategoryModel> categories, OnCategoryClickListener listener) {
        super(context, 0, categories);
        this.listener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_category, parent, false);
        }


        CategoryModel category = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.categoryImage);
        TextView nameView = convertView.findViewById(R.id.categoryName);
        TextView descView = convertView.findViewById(R.id.categoryDescription);

        imageView.setImageResource(category.getImageResId());
        nameView.setText(category.getName());
        descView.setText(category.getDescription());

        convertView.setOnClickListener(v -> {
            if(listener != null) {
                listener.onCategoryClick(category);
            }
        });

        return convertView;
    }
}
