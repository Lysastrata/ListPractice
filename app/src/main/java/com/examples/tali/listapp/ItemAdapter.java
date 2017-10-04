package com.examples.tali.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by tali on 8/31/17.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    String[] items;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_details, null);
        TextView nameTextView = v.findViewById(R.id.nameTextView);
        TextView priceTextView = v.findViewById(R.id.priceTextView);
        TextView descTextView= v.findViewById(R.id.descTextView);
        String name = items[i];
        String price = prices[i];
        String desc = descriptions[i];
        nameTextView.setText(name);
        priceTextView.setText(price);
        descTextView.setText(desc);
        return v;
    }
}
