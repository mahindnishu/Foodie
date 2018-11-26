package com.javatpoint.user.foodie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;

public class FavMenuImageAdapter extends BaseAdapter {
    GridView gridView;
    LinearLayout linearLayout;
    private Context fContext;

    int[]fMenu;
    String[]menuName;
    int[]price;
    public FavMenuImageAdapter(Context c,int[] fMenu,String[] menuName,int[] price )
    {
        fContext = c;
        this.fMenu=fMenu;
        this.menuName=menuName;
        this.price=price;

    }
    public int getCount()
    {
        return menuName.length;
    }

    public Object getItem(int position)
    {
        return menuName[position];
    }

    public long getItemId(int position)
    {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if (convertView == null) {
            LayoutInflater layoutInflater=LayoutInflater.from(fContext);
            convertView=layoutInflater.inflate(R.layout.fav_gridview_row,null);



        }
        linearLayout=convertView.findViewById(R.id.linear_grid);
        TextView tvName=convertView.findViewById(R.id.textViewName);
        TextView tvPrice=convertView.findViewById(R.id.textViewPrice);
        return convertView;
    }

}
