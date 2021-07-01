package com.alex.horoscopeapp.horoscopes;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class JSON {

    public void getJSON(final String urlWebService, Context context, TextView textView, String time, String zodiacName) {
        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s ) {
                super.onPostExecute(s);
               try {
                    //set UI
                  loadIntoListView(s, context, textView, time, zodiacName);
                } catch (JSONException e) {
                    e.printStackTrace();
              }

            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;

                    while ((json = bufferedReader.readLine()) != null){
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }

            }
        }

        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }


    private void loadIntoListView(String json, Context context, TextView textView, String time , String zodiacName) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        HashMap<String, String> hashMapHoroscopes = new HashMap<>();

        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);

            //hashMap with horoscopes
            hashMapHoroscopes.put(obj.getString("name") , obj.getString(time));

        }

        for (int i = 0; i < hashMapHoroscopes.size(); i++) {
            textView.setText(hashMapHoroscopes.get(zodiacName));
        }


    }


}
