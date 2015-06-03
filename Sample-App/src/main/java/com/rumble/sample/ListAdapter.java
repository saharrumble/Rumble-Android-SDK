package com.rumble.sample;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rumble.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Spannable> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, ArrayList<Spannable> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_console, null);
        }

        Spannable p = getItem(position);
//        SpannableString p=new SpannableString("hello world");
//        p.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC),
//                0,p.length(), 0);
//        Spannable p = new SpannableString("analytics sdk got message:,'%s' ");
//        p.setSpan(new ForegroundColorSpan(Color.CYAN), 0, p.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.text1);

            if (tt1 != null) {
                tt1.setText(p, TextView.BufferType.SPANNABLE);
            }

        }

        return v;
    }

}