package com.example.android.getninjas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gabriel Palomino on 1/17/2017.
 */

public class ItemAdapter extends ArrayAdapter<ItemQA> {


    public ItemAdapter(Context context, ArrayList<ItemQA> itens) {
        super(context, 0, itens);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemQA itemQA = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_qa, parent, false);
        }

        TextView question = (TextView) convertView.findViewById(R.id.question_text_view);
        TextView answer = (TextView) convertView.findViewById(R.id.answer_text_view);

        question.setText(itemQA.getQuestion());
        answer.setText(itemQA.getAnswer());

        return convertView;
    }


}
