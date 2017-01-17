package com.example.android.getninjas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Gabriel Palomino on 1/15/2017.
 */

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String uri = intent.getStringExtra("offerLink");
        setTitle("Oferta");
        setContentView(R.layout.item_activity);

        TextView itemTitle = (TextView) findViewById(R.id.item_title);

        long distance;
        int lead_price;
        String title;
        String question;
        String answer;
        ArrayList<ItemQA> qa = new ArrayList<>();
        String user_name;
        String user_email;
        ArrayList<String> phones = new ArrayList<>();
        String city;
        String neighborhood;
        String uf;
        Double latitude;
        Double longitude;
        String accept_link;
        String reject_link;

        String infoString;
        try {
            String jsonString = new JSONHandler(uri).execute().get();
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray info = jsonObject.getJSONObject("_embedded").getJSONArray("info");
            distance = jsonObject.getLong("distance");
            lead_price = jsonObject.getInt("lead_price");
            title = jsonObject.getString("title");

            // Get all questions
            for(int i = 0; i < info.length(); ++i) {
                question = info.getJSONObject(i).getString("label");
                answer = info.getJSONObject(i).getString("value").replace("\"","").replace("[","").replace("]","");
                qa.add(new ItemQA(question,answer));
            }

            user_name = jsonObject.getJSONObject("_embedded").getJSONObject("user").getString("name");
            user_email = jsonObject.getJSONObject("_embedded").getJSONObject("user").getString("email");

            JSONArray ja = jsonObject.getJSONObject("_embedded").getJSONObject("user").getJSONObject("_embedded").getJSONArray("phones");
            // Get all phones
            for(int j = 0; j < ja.length(); ++j){
                phones.add(ja.getJSONObject(j).getString("number"));
            }

            city = jsonObject.getJSONObject("_embedded").getJSONObject("address").getString("city");
            neighborhood = jsonObject.getJSONObject("_embedded").getJSONObject("address").getString("neighborhood");
            uf = jsonObject.getJSONObject("_embedded").getJSONObject("address").getString("uf");
            latitude = jsonObject.getJSONObject("_embedded").getJSONObject("address").getJSONObject("geolocation").getDouble("latitude");
            longitude = jsonObject.getJSONObject("_embedded").getJSONObject("address").getJSONObject("geolocation").getDouble("longitude");
            accept_link = jsonObject.getJSONObject("_links").getJSONObject("accept").getString("href");
            reject_link = jsonObject.getJSONObject("_links").getJSONObject("reject").getString("href");
            itemTitle.setText(title);


        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }

        ListView listView = (ListView) findViewById(R.id.questions_list) ;

        ItemAdapter itemAdapter = new ItemAdapter(this, qa);

        listView.setAdapter(itemAdapter);

    }
}
