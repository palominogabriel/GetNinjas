package com.example.android.getninjas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        setContentView(R.layout.item_activity);

        TextView txt = (TextView) findViewById(R.id.distance);

        try {
            String jsonString = new JSONHandler(uri).execute().get();
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray info = jsonObject.getJSONArray("info");
            txt.setText(Integer.toString(jsonObject.getInt("distance")));

        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }


    }
}
