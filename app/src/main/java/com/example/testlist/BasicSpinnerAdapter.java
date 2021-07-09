package com.example.testlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class BasicSpinnerAdapter extends BaseAdapter {

    private ArrayList<String> mSpinnerItems;
    private ArrayList<String> mData;
    private Context mContext;
    private ArrayList<Integer>imagesource;

    public BasicSpinnerAdapter(ArrayList<Integer> mimagesource, ArrayList<String> data, ArrayList<String> spinnerItems, MainActivity context) {
        mData = data;
        mContext = context;
        mSpinnerItems = spinnerItems;
        imagesource = mimagesource;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        //final    viewHolder holder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_item_spinner, null);
            /*
            holder = new viewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.title);
            holder.image = (ImageView) convertView.findViewById(R.id.photo);

            convertView.setTag(holder);
            */

        }

        TextView textView = (TextView) view.findViewById(R.id.title);
        Spinner spinner = (Spinner) view.findViewById(R.id.row_item_spinner);
        ImageView iconView = (ImageView) view.findViewById(R.id.photo);


        textView.setText(mData.get(position));
        iconView.setImageResource(imagesource.get(position));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mSpinnerItems);
        spinner.setAdapter(adapter);
        return view;


    }
    public class viewHolder {

        TextView name;
        ImageView image;

    }
}
