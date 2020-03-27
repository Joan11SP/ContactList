package com.software.develop.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.software.develop.Adapter.ActiviyItemList;
import com.software.develop.Manager.FirebaseContactManager;
import com.software.develop.Model.Contact;
import com.software.develop.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView list;
    private ListView listCity;
    private ActiviyItemList activiyItemList;
    private List<Contact> listContact = new ArrayList<>();
    private static final String extra="extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.listView);
        listCity = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(this);

        listContact = FirebaseContactManager.getInstance().getAllContacts();
        if(listContact != null && listContact.size()>0){
            list.setVisibility(View.VISIBLE);
            activiyItemList = new ActiviyItemList(this, listContact);
            list.setAdapter(activiyItemList);

        } else {

            list.setVisibility(View.GONE);

        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ListActivity.this,ContactActivity.class);
        String posi = listContact.get(position).getObjectId();
        intent.putExtra(extra,posi);
        startActivity(intent);
        Toast.makeText(this,"click sobre item"+position,Toast.LENGTH_LONG).show();
    }
}
