package com.example.walid.tp2_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    final int ADD_ITEM_ACTIVITY = 0;
    ArrayAdapter<String> adapter;
    ArrayList<String> os;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.mylist);
        if (savedInstanceState != null)
            os = savedInstanceState.getStringArrayList("os");
        else {os = new ArrayList<>();os.add(0,"Android");os.add(1,"iOS");}
        adapter = new ArrayAdapter<String>(list.getContext(),
                android.R.layout.simple_list_item_1,os);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, AddOSActivity.class);
        startActivityForResult(intent, ADD_ITEM_ACTIVITY);
    }
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (requestCode != ADD_ITEM_ACTIVITY) return;
        if (resultCode != RESULT_OK) return;
       String item = data.getStringExtra("item");
        adapter.add(item);

    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("os", os);
    }
}
