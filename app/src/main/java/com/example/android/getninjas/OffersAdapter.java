package com.example.android.getninjas;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gabriel Palomino on 1/15/2017.
 */

public class OffersAdapter extends ArrayAdapter {

    ArrayList arrayList = new ArrayList();

    public OffersAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Offer object) {
        super.add(object);
        arrayList.add(object);
    }

    @Override
    public void clear() {
        super.clear();
        arrayList.clear();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;

        row = convertView;

        final OfferHolder offerHolder;

        Offer offer = (Offer) this.getItem(position);

        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);

            offerHolder = new OfferHolder();
            offerHolder.link = offer.getLink();
            offerHolder.openOfferRL = (RelativeLayout) row.findViewById(R.id.openOfferRL);
            offerHolder.readCircle = (RelativeLayout) row.findViewById(R.id.read_layout);
            offerHolder.titleTextView = (TextView) row.findViewById(R.id.title_textView);
            offerHolder.nameTextView = (TextView) row.findViewById(R.id.name_textView);
            offerHolder.addressTextView = (TextView) row.findViewById(R.id.address_textView);
            offerHolder.creationDateTextView = (TextView) row.findViewById(R.id.creationDate_textView);
            row.setTag(offerHolder);
        } else {
            offerHolder = (OfferHolder) row.getTag();
        }

        offerHolder.openOfferRL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                OfferHolder offerH = (OfferHolder) v.getTag();
                Intent intent = new Intent(getContext(), ItemActivity.class);
                intent.putExtra("offerLink", offerH.link);
                getContext().startActivity(intent);
            }
        });



        if (offer.isRead()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                offerHolder.readCircle.setBackground(getContext().getDrawable(R.drawable.read_circle));
            }
        } else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                offerHolder.readCircle.setBackground(getContext().getDrawable(R.drawable.unread_circle));
            }
        }
        offerHolder.titleTextView.setText(offer.getTitle());
        offerHolder.nameTextView.setText(offer.getUserName());
        offerHolder.addressTextView.setText(offer.getNeighborhood() + " - " + offer.getCity());

        try {
            String[] splitedDateHour = offer.getCreationDate().split("T");
            String[] splitedDate = splitedDateHour[0].split("-");
            offerHolder.creationDateTextView.setText(splitedDate[2] + " de " + monthName(Integer.parseInt(splitedDate[1])));
        } catch (Exception e){
            offerHolder.creationDateTextView.setText("Erro");
        }

        return row;
    }

    public String monthName(int date){
        switch (date){
            case 1:
                return "jan";
            case 2:
                return "fev";
            case 3:
                return "mar";
            case 4:
                return "abr";
            case 5:
                return "mai";
            case 6:
                return "jun";
            case 7:
                return "jul";
            case 8:
                return "ago";
            case 9:
                return "set";
            case 10:
                return "out";
            case 11:
                return "nov";
            case 12:
                return "dez";
            default:
                return "jan";
        }
    }

    static class OfferHolder{
        TextView titleTextView, nameTextView, addressTextView, creationDateTextView;
        RelativeLayout readCircle, openOfferRL;
        String link;
    }


}
