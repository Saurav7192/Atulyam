package com.sauravkumar71920gmail.atulyam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    Toolbar  mControlToolbar;
    FirebaseDatabase mFirebaseDatabase;
    ListView mlistView;
    ArrayList<String> mNotification = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mControlToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mControlToolbar.setTitle("Notification");
        mControlToolbar.setTitleTextColor(getResources().getColor(R.color.white));

       mlistView = (ListView) findViewById(R.id.text_list_view);

        mFirebaseDatabase = FirebaseDatabase.getInstance();


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mNotification);

       mlistView.setAdapter(arrayAdapter);

        mFirebaseDatabase.getReference("Events").child("Notification").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value = dataSnapshot.getValue(String.class);
                mNotification.add(value);

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
