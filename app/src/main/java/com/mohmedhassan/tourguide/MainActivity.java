package com.mohmedhassan.tourguide;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class MainActivity extends AppCompatActivity {

    private Button btnClickMe1, btnClickMe2, btnClickMe3;

    private TourGuide mTourGuideHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClickMe1 = findViewById(R.id.btnTest1);
        btnClickMe2 = findViewById(R.id.btnTest2);
        btnClickMe3 = findViewById(R.id.btnTest3);

        mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.Click)
                .setPointer(new Pointer())
                .setToolTip(
                        new ToolTip()
                                .setTitle("Welcome...")
                                .setDescription("... to MrBool website!!")
                                .setBackgroundColor(Color.parseColor("#e54d26"))
                                .setShadow(true)
                                .setGravity(Gravity.BOTTOM | Gravity.RIGHT))
                .setOverlay(new Overlay())
                .playOn(btnClickMe1);

        btnClickMe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTourGuideHandler.cleanUp();

                mTourGuideHandler
                        .setToolTip(new ToolTip()
                                .setTitle("Here you'll find...")
                                .setDescription("... a lot of good tutorials")
                                .setBackgroundColor(Color.parseColor("#4b4b4b")))
                        .playOn(btnClickMe2);

            }
        });
        btnClickMe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTourGuideHandler.cleanUp();

                mTourGuideHandler
                        .setToolTip(new ToolTip()
                                .setTitle("Enjoy!!!")
                                .setDescription("and leave a comment if you like it! :)")
                                .setBackgroundColor(Color.parseColor("#0E37EC"))
                                .setGravity(Gravity.TOP | Gravity.RIGHT))
                        .playOn(btnClickMe3);
            }
        });
        btnClickMe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTourGuideHandler.cleanUp();
            }
        });

    }
}
