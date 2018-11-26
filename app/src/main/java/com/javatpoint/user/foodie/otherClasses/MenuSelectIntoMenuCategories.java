package com.javatpoint.user.foodie.otherClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.javatpoint.user.foodie.R;
import com.javatpoint.user.foodie.adapter.SelectedMenuListAdapter;
import com.javatpoint.user.foodie.interfaces.MenuInterface;
import com.javatpoint.user.foodie.model.MenuSelectModel;

import java.util.ArrayList;

public class MenuSelectIntoMenuCategories extends AppCompatActivity implements MenuInterface
{
    ListView listview;

    DatabaseReference databaseReference;

    MenuSelectModel menuSelectModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_select_into_menucategories);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        final String cat=bundle.getString("cat");


        databaseReference= FirebaseDatabase.getInstance().getReference();

        listview = findViewById(R.id.menuListview);

        final ArrayList<MenuSelectModel> arrayList=new ArrayList<>();

        databaseReference.child("myrecepies").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    StorageReference mStorageRef;
                    mStorageRef = FirebaseStorage.getInstance().getReference();

                    menuSelectModel=noteDataSnapshot.getValue(MenuSelectModel.class);


                        MenuSelectModel menu1=new MenuSelectModel(menuSelectModel.getName(),menuSelectModel.getCat(),menuSelectModel.getFav(),menuSelectModel.getPrice(),menuSelectModel.getDesc(),menuSelectModel.getImage());

                        System.out.print("ghfbv f");
                        Log.d("response",menu1.getName());
                        arrayList.add(menu1);



                }

                Log.d("response",""+arrayList.size());
                SelectedMenuListAdapter selectedMenuList = new SelectedMenuListAdapter(getApplicationContext(),arrayList);
                listview.setAdapter(selectedMenuList);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}
