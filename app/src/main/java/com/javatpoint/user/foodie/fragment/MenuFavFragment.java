package com.javatpoint.user.foodie.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.javatpoint.user.foodie.adapter.FavMenuImageAdapter;
import com.javatpoint.user.foodie.R;

public class MenuFavFragment extends Fragment
{
    GridView gridView;
    FavMenuImageAdapter favMenuImageAdapter;
    public int[] fMenu = {
           R.raw.italian_food,R.raw.japanies_food,R.raw.nonveg_thali,R.raw.pestry,R.raw.pizzza};
    public String[] menuName={"Italian Food","Japanese Food","Nonveg Thali","Pestry","Pizza"};
    public int[] price={180,100,160,50,199};
    public static MenuFavFragment newInstance() {

        Bundle args = new Bundle();

        MenuFavFragment fragment = new MenuFavFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_your_favorites,null);


        gridView=view.findViewById(R.id.gridview);

        FavMenuImageAdapter favMenuImageAdapter=new FavMenuImageAdapter(getContext(),fMenu,menuName,price);
        gridView.setAdapter(favMenuImageAdapter);


        return view;

    }
}
