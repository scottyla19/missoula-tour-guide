package com.example.android.missoulahoodguide;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by swlaforest on 4/15/2017.
 */

public class HoodLocationAdapter extends ArrayAdapter<HoodLocation> {
    public HoodLocationAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<HoodLocation> objects) {
        super(context, resource, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        HoodLocation loc = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.list_name);
        title.setText(loc.getmName());

        TextView address = (TextView) listItemView.findViewById(R.id.list_address);
            address.setText(loc.getmAddress());

        TextView props = (TextView) listItemView.findViewById(R.id.list_properties);
        props.setText(loc.getmProperties());
//        title.setText(loc.getmProperties());

        return listItemView;
    }
}
