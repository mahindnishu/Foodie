package com.javatpoint.user.foodie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javatpoint.user.foodie.otherClasses.MenuSelectIntoMenuCategories;
import com.javatpoint.user.foodie.R;

public class MenuCatAdapter extends BaseAdapter
{
    GridView gridView;
    LinearLayout linearLayout;
    private Context mContext;

    int[]mThumbIds;
    String[]textName;
    public MenuCatAdapter(Context c, int[] mThumbIds, String[] textName)
    {
        mContext = c;
        this.mThumbIds=mThumbIds;
        this.textName=textName;

    }

    public int getCount()
    {
        return textName.length;
    }

    public Object getItem(int position)
    {
        return textName[position];
    }

    public long getItemId(int position)
    {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if (convertView == null) {
            LayoutInflater layoutInflater=LayoutInflater.from(mContext);
            convertView=layoutInflater.inflate(R.layout.gridview_row,null);



        }
        linearLayout=convertView.findViewById(R.id.linear_grid);
        final TextView tvName=convertView.findViewById(R.id.textViewName);


        tvName.setText(textName[position]);
        linearLayout.setBackgroundResource(mThumbIds[0]);


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvName.getText().toString().equals("Salad Menu"))
                {
                    Intent intent=new Intent(mContext,MenuSelectIntoMenuCategories.class);
                    intent.putExtra("cat","Salad Menu");
                    mContext.startActivity(intent);
                }
            }
        });

        return convertView;
    }



}
