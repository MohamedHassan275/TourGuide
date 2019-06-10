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

public class ClickButton extends AppCompatActivity {

    private Button btnClickMe;

    private TourGuide mTourGuideHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_button);

        btnClickMe = (Button) findViewById(R.id.btnTest);

        mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.Click)
                .setPointer(new Pointer())
                .setToolTip(
                        new ToolTip()
                                .setTitle("Welcome...")
                                .setDescription("... to MrBool website!!")
                                .setBackgroundColor(Color.parseColor("#e54d26"))
                                .setShadow(true).setGravity(Gravity.TOP | Gravity.RIGHT))
                .setOverlay(new Overlay())
                .playOn(btnClickMe);

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTourGuideHandler.cleanUp();
            }
        });
    }
}
