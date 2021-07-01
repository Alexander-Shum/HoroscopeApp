package com.alex.horoscopeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.alex.horoscopeapp.horoscopes.JSON;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ShowHoroscope extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_show_horoscope, container, false);
        JSON json = new JSON();

        Bundle bundle = this.getArguments();
        String zodiacName = bundle.getString("zodiacName", "Овен");




        TextView textViewHoroscope = root.findViewById(R.id.horoscope);
        ImageView imageView = root.findViewById(R.id.zodiacImage);
        TextView textViewData = root.findViewById(R.id.textViewData);
        TextView textViewZodiacName = root.findViewById(R.id.zodiacName);
        Button buttonDay = root.findViewById(R.id.buttonDay);
        Button buttonWeek = root.findViewById(R.id.buttonWeek);
        Button buttonMonth = root.findViewById(R.id.buttonMonth);

        textViewZodiacName.setText(zodiacName);
        getData(textViewData);

        json.getJSON("https://botsale.club/getdata.php", getContext(), textViewHoroscope, "day", firstUpperCase(zodiacName));

        buttonDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                json.getJSON("https://botsale.club/getdata.php", getContext(), textViewHoroscope, "day", firstUpperCase(zodiacName));
            }
        });

        buttonWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                json.getJSON("https://botsale.club/getdata.php", getContext(), textViewHoroscope, "week", firstUpperCase(zodiacName));
            }
        });

        buttonMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                json.getJSON("https://botsale.club/getdata.php", getContext(), textViewHoroscope, "month", firstUpperCase(zodiacName));
            }
        });


        switch (zodiacName) {
            case "ВОДОЛЕЙ":
                imageView.setImageResource(R.drawable.aquarius200);
                break;
            case "ОВЕН":
                imageView.setImageResource(R.drawable.aries200);
                break;
            case "РАК":
                imageView.setImageResource(R.drawable.cancer200);
                break;
            case "КОЗЕРОГ":
                imageView.setImageResource(R.drawable.capricorn200);
                break;
            case "БЛИЗНЕЦЫ":
                imageView.setImageResource(R.drawable.gemini200);
                break;
            case "ЛЕВ":
                imageView.setImageResource(R.drawable.leo200);
                break;
            case "ВЕСЫ":
                imageView.setImageResource(R.drawable.libra200);
                break;
            case "РЫБЫ":
                imageView.setImageResource(R.drawable.pisces200);
                break;
            case "СТРЕЛЕЦ":
                imageView.setImageResource(R.drawable.sagittarius200);
                break;
            case "СКОРПИОН":
                imageView.setImageResource(R.drawable.scorpio200);
                break;
            case "ТЕЛЕЦ":
                imageView.setImageResource(R.drawable.taurus200);
                break;
            case "ДЕВА":
                imageView.setImageResource(R.drawable.virgo200);
                break;
        }

//        Toolbar toolbar =  getActivity().findViewById(R.id.toolbar);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().onBackPressed();
//            }
//        });

        return root;

    }



    public String firstUpperCase (String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    public void getData(TextView textView){
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        textView.setText(dateText);
    }

}