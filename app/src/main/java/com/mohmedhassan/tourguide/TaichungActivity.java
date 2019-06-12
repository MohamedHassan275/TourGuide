package com.mohmedhassan.tourguide;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by akueisara on 10/4/2016.
 */
public class TaichungActivity extends AppCompatActivity {
    private ArrayList<Atraction> atractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of atractions
        atractions = new ArrayList<Atraction>();
        Location caihongjuanVillage = new Location(getResources().getString(R.string.taichung_attraction_name_1));
        caihongjuanVillage.setLatitude(24.13646);
        caihongjuanVillage.setLongitude(120.61139);
        atractions.add(new Atraction(getResources().getString(R.string.taichung_attraction_name_1), getResources().getString(R.string.taichung_attraction_phone_1), getResources().getString(R.string.taichung_attraction_address_1), getResources().getString(R.string.taichung_attraction_imageurl_1), caihongjuanVillage));

        Location tunghaiUniversity = new Location(getResources().getString(R.string.taichung_attraction_name_2));
        tunghaiUniversity.setLatitude(24.18486);
        tunghaiUniversity.setLongitude(120.60598);
        atractions.add(new Atraction(getResources().getString(R.string.taichung_attraction_name_2),
                getResources().getString(R.string.taichung_attraction_phone_2), getResources().getString(R.string.taichung_attraction_address_2),
                getResources().getString(R.string.taichung_attraction_imageurl_2), tunghaiUniversity));

        Location wulingFarm = new Location(getResources().getString(R.string.taichung_attraction_name_3));
        wulingFarm.setLatitude(24.35511);
        wulingFarm.setLongitude(121.31046);
        atractions.add(new Atraction(getResources().getString(R.string.taichung_attraction_name_3),
                getResources().getString(R.string.taichung_attraction_phone_3), getResources().getString(R.string.taichung_attraction_address_3),
                getResources().getString(R.string.taichung_attraction_imageurl_3), wulingFarm));

        Location kaomeiWetland = new Location(getResources().getString(R.string.taichung_attraction_name_4));
        kaomeiWetland.setLatitude(24.3117824);
        kaomeiWetland.setLongitude(120.5481198);
        atractions.add(new Atraction(getResources().getString(R.string.taichung_attraction_name_4),
                getResources().getString(R.string.taichung_attraction_phone_4), getResources().getString(R.string.taichung_attraction_address_4),
                getResources().getString(R.string.taichung_attraction_imageurl_4), kaomeiWetland));

        AtractionAdapter adapter = new AtractionAdapter(this, atractions);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = atractions.get(position).getLocation().getLatitude();
                double lon = atractions.get(position).getLocation().getLongitude();
                String keyword = atractions.get(position).getAttractionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
