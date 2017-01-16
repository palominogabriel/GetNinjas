package com.example.android.getninjas;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gabriel Palomino on 1/15/2017.
 */

public class JSONHandler extends AsyncTask<Void,Void,String> {

    String uri_entrypoint;

    JSONHandler(String uri_entrypoint){
        this.uri_entrypoint = uri_entrypoint;
    }

    @Override
    protected String doInBackground(Void... params) {
        String jsonString;
        try {
            URL url = new URL(uri_entrypoint);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((jsonString = bufferedReader.readLine()) != null){
                stringBuilder.append(jsonString + "\n");
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            return stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
