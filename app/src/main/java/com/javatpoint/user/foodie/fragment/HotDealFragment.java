package com.javatpoint.user.foodie.fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;

public class HotDealFragment extends Fragment {

    public static HotDealFragment newInstance() {

        Bundle args = new Bundle();

        HotDealFragment fragment = new HotDealFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_hot_deals, null);

        return view;
    }
}
