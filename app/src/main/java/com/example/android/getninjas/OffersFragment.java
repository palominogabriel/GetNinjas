package com.example.android.getninjas;

/**
 * Created by Gabriel Palomino on 1/11/2017.
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class OffersFragment extends Fragment{

    String offersLink;
    ListView listView;
    OffersAdapter offersAdapter;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String jsonString;

    private SwipeRefreshLayout swipeContainer;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Retrieve the offers link from MainActivity
        Bundle args = getArguments();
        offersLink = args.getString("offersLink");



        View rootView = inflater.inflate(R.layout.offers, container, false);

        return rootView;
    }

    public void getOffersViews(OffersAdapter offersAdapter) throws ExecutionException, InterruptedException, JSONException {
        jsonString = new JSONHandler(offersLink).execute().get();
        jsonObject = new JSONObject(jsonString);
        jsonArray = jsonObject.getJSONArray("offers");

        int count = 0;
        boolean read;
        String creationDate, title, userName, city, neighborhood, uf, link;
        while(count < jsonArray.length()){
            JSONObject jsonObject = jsonArray.getJSONObject(count);
            read = jsonObject.getString("state").equals("unread");
            creationDate = jsonObject.getJSONObject("_embedded").getJSONObject("request").getString("created_at");
            title = jsonObject.getJSONObject("_embedded").getJSONObject("request").getString("title");
            userName = jsonObject.getJSONObject("_embedded").getJSONObject("request").getJSONObject("_embedded").getJSONObject("user").getString("name");
            city = jsonObject.getJSONObject("_embedded").getJSONObject("request").getJSONObject("_embedded").getJSONObject("address").getString("city");
            neighborhood = jsonObject.getJSONObject("_embedded").getJSONObject("request").getJSONObject("_embedded").getJSONObject("address").getString("neighborhood");
            uf = jsonObject.getJSONObject("_embedded").getJSONObject("request").getJSONObject("_embedded").getJSONObject("address").getString("uf");
            link = jsonObject.getJSONObject("_links").getJSONObject("self").getString("href");

            Offer offer = new Offer(read, creationDate, title, userName, city, neighborhood, uf, link);

            offersAdapter.add(offer);
            count++;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.offers_listview);

        offersAdapter = new OffersAdapter(getActivity().getApplicationContext(), R.layout.row_layout);

        listView.setAdapter(offersAdapter);


        // Set Refresh action
        swipeContainer = (SwipeRefreshLayout) getActivity().findViewById(R.id.offers_swipeContainer);
        if(swipeContainer != null) {
            swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    offersAdapter.clear();

                    try {
                        getOffersViews(offersAdapter);
                    } catch (ExecutionException | InterruptedException | JSONException e) {
                        e.printStackTrace();
                    }

                    // Now we call setRefreshing(false) to signal refresh has finished
                    swipeContainer.setRefreshing(false);
                }
            });
        }

        try {
            getOffersViews(offersAdapter);
        } catch (ExecutionException | InterruptedException | JSONException e) {
            e.printStackTrace();
        }
    }
}
