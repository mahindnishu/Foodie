package com.javatpoint.user.foodie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;
import com.javatpoint.user.foodie.adapter.MenuCatAdapter;

public class MenuCatFragment extends Fragment {
    MenuCatAdapter menuCatAdapter;
    LinearLayout linearLayout;
    GridView gridView;
    Context context;
    TextView textView;

    public static MenuCatFragment newInstance() {

        Bundle args = new Bundle();

        MenuCatFragment fragment = new MenuCatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu_categories,null);

        gridView=view.findViewById(R.id.gridview);

        String[] cat={"Indian","Chinese","Japanese","Italian","Mexican","Salad Menu"};
        int[] img={R.raw.south_indian,R.raw.pizzza,R.raw.japanies_food,R.raw.italian_food,R.raw.italian_food,R.raw.salad};
        menuCatAdapter=new MenuCatAdapter(getContext(),img,cat);

        gridView.setAdapter(menuCatAdapter);

        return view;
    }
}
