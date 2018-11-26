package com.javatpoint.user.foodie.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.javatpoint.user.foodie.R;

public class YourOrdersFragment extends Fragment{
    ListView listView;
    String[] Date = {"25 jan 2018", "7 jul 2018", "15 jul 2018", "30 jul 2018", "10 sep 2018", "30 sep 2018", "25 oct 2018"};
    String[] Status = {"Completed", "Completed", "Incompleted", "On the way", "Completed", "Incompleted", "Incompleted"};
    String[] OrderNumber = {"#1", "#20", "#50", "#2", "#5", "#67", "#45"};
    String[] OrderPrice = {"$100", "$500", "$1000", "$200", "$250", "$600", "$1500"};

    public static YourOrdersFragment newInstance() {

        Bundle args = new Bundle();

        YourOrdersFragment fragment = new YourOrdersFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_your_orders,null);
        listView=view.findViewById(R.id.order_listview);



        return view;

    }
}
