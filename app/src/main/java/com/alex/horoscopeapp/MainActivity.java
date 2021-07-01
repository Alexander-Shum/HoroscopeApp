package com.alex.horoscopeapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private final List<HoroscopeData> horoscopeDataArrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    prepareHoroscopeData();
    }

    private void prepareHoroscopeData() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ImageView imageView = findViewById(R.id.imageView);

        HoroscopeAdapter horoscopeAdapter = new HoroscopeAdapter(this, horoscopeDataArrayList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
       recyclerView.setLayoutManager(manager);
       recyclerView.setAdapter(horoscopeAdapter);

        String[] zodiacArrayEng = {"taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius", "pisces"};
        String[] zodiacArrayRus = {"телец", "близнецы", "рак", "лев", "дева", "весы", "скорпион", "стрелец", "козерог", "водолей", "рыбы"};

        HoroscopeData horoscopeData = new HoroscopeData("ОВЕН", "aries200", imageView);
        horoscopeDataArrayList.add(horoscopeData);
//        for(String zodiac : zodiacArrayEng){
//            horoscopeData = new HoroscopeData(zodiac.toUpperCase(), zodiac.toLowerCase() + "200" , imageView);
//            horoscopeDataArrayList.add(horoscopeData);
//        }

        for (int i = 0; i < zodiacArrayEng.length; i++) {
            horoscopeData = new HoroscopeData(zodiacArrayRus[i].toUpperCase(), zodiacArrayEng[i].toLowerCase() + "200", imageView);
            horoscopeDataArrayList.add(horoscopeData);
        }

    }

}