package com.software.develop.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.develop.Adapter.ActivityContactDetail;
import com.software.develop.Adapter.ActiviyItemList;
import com.software.develop.Manager.FirebaseContactManager;
import com.software.develop.Model.Contact;
import com.software.develop.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactActivity extends AppCompatActivity {

    private static final String extra="extra";
    private TextView textNombre,textCity,textEmail,textPhone,textDescription;
    private ActivityContactDetail contactDetail;
    private HashMap<String,Contact> listContact= new HashMap();
    private Glide glide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Bundle extras = getIntent().getExtras();
        String position = extras.getString(extra,"");

        textCity = (TextView) findViewById(R.id.textciudad);
        textNombre = (TextView) findViewById(R.id.textnombre);
        textPhone = (TextView) findViewById(R.id.textelefono);
        textEmail = (TextView)findViewById(R.id.textcorreo);
        textDescription = (TextView) findViewById(R.id.textDescripcion);

        Contact contact = FirebaseContactManager.getInstance().getContactByObjectId(position);
        textCity.setText(contact.getCity());
        textNombre.setText(contact.getName());
        textDescription.setText(contact.getDescription());
        textEmail.setText(contact.getEmail());
        textPhone.setText(contact.getPhone());
    }
}
