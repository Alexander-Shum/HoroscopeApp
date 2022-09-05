package com.alex.horoscopeapp.ui.horoscope;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.horoscopeapp.HoroscopeAdapter;
import com.alex.horoscopeapp.HoroscopeData;
import com.alex.horoscopeapp.R;

import java.util.ArrayList;
import java.util.List;

public class HoroscopeFragment extends Fragment {


    private final List<HoroscopeData> horoscopeDataArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_horoscope, container, false);


        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        ImageView imageView = root.findViewById(R.id.imageView);




        HoroscopeAdapter horoscopeAdapter = new HoroscopeAdapter(getContext(), horoscopeDataArrayList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(horoscopeAdapter);

        String[] zodiacArrayEng = {"taurus", "gemini", "cancer", "leo", "virgo", "libra", "scorpio", "sagittarius", "capricorn", "aquarius", "pisces"};
        String[] zodiacArrayRus = {"телец", "близнецы", "рак", "лев", "дева", "весы", "скорпион", "стрелец", "козерог", "водолей", "рыбы"};

        HoroscopeData horoscopeData = new HoroscopeData("ОВЕН", "aries200", imageView);
        horoscopeDataArrayList.add(horoscopeData);

        for (int i = 0; i < zodiacArrayEng.length; i++) {
            horoscopeData = new HoroscopeData(zodiacArrayRus[i].toUpperCase(), zodiacArrayEng[i].toLowerCase() + "200", imageView);
            horoscopeDataArrayList.add(horoscopeData);
        }


        return root;
    }

}