package com.javatpoint.user.foodie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;
import com.javatpoint.user.foodie.model.MenuSelectModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SelectedMenuListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;

    ArrayList<MenuSelectModel> arrayList;

    public SelectedMenuListAdapter(Context applicationContext, ArrayList<MenuSelectModel> arrayList) {
        context=applicationContext;
        this.arrayList=arrayList;

        inflter=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.menu_select_listview_row, null);

        TextView textViewMenuName = view.findViewById(R.id.textViewMenuName);
        TextView textViewMenuPrice = view.findViewById(R.id.textViewMenuPrice);

        ImageView menuImage = view.findViewById(R.id.menuImage);

        textViewMenuName.setText(arrayList.get(i).getName());
        textViewMenuPrice.setText(" "+arrayList.get(i).getPrice());

        String url=arrayList.get(i).getImage();
        System.out.println("urlllll "+url);

        Picasso.with(context).load(arrayList.get(i).getImage()).fit().into(menuImage);

        return view;
    }
}

