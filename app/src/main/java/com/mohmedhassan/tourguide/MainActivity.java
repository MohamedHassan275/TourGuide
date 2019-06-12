package com.mohmedhassan.tourguide;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class MainActivity extends AppCompatActivity {

    TextView kaohsiung,taipei,tainan,taichung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         kaohsiung =  findViewById(R.id.kaohsiung);
         taipei =  findViewById(R.id.taipei);
         tainan =  findViewById(R.id.tainan);
         taichung =  findViewById(R.id.taichung);

        taipei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taipeiIntent = new Intent(MainActivity.this, TaipeiActivity.class);
                startActivity(taipeiIntent);
            }
        });


        taichung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taichungIntent = new Intent(MainActivity.this, TaichungActivity.class);
                startActivity(taichungIntent);
            }
        });


        tainan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tainanIntent = new Intent(MainActivity.this, TainanActivity.class);
                startActivity(tainanIntent);
            }
        });


        kaohsiung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kaohsiungIntent = new Intent(MainActivity.this, KaohsiungActivity.class);
                startActivity(kaohsiungIntent);
            }
        });

    }
}
