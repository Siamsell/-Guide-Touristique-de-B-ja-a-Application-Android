package com.siham.guidetoristique;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {
    private TextView tvMoreInfo;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
b1=findViewById(R.id.btngo);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affiche(v);
            }
        });


    }

    public void affiche(View v){
        Intent intent = new Intent(MoreInfoActivity.this,Categorier.class);
        startActivity(intent);
    }
}
