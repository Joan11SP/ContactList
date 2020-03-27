package com.software.develop.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.develop.Model.Contact;
import com.software.develop.R;

import java.util.List;

public class ActiviyItemList extends ArrayAdapter<Contact> {

    private Context context;
    private List<Contact> contact;

    public ActiviyItemList(Context context,List<Contact>contact) {
        super(context, R.layout.activity_activiy_item_list);
        this.context = context;
        this.contact = contact;

    }
    @Override
    public int getCount() {
        return contact.size();
    }

    @Override
    public Contact getItem(int position) {
        return contact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get a View that displays the data at the specified position in the data set
        View view;
        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.activity_activiy_item_list, parent, false);
            viewHolder.mContactName = (TextView) view.findViewById(R.id.textViewItemName);
            viewHolder.mContactImage = (ImageView) view.findViewById(R.id.image);
            viewHolder.contactCity = (TextView) view.findViewById(R.id.textViewItemCity);


            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        // Set text with the item name
        viewHolder.mContactName.setText(contact.get(position).getName());


        // set text with the item city
        viewHolder.contactCity.setText(contact.get(position).getCity());



        // Set image using Picasso library

        //Picasso.get().load(contactArrayList.get(position).getImageUrl()).into(viewHolder.mContactImage);

        // set imagen using Glide
        Glide.with(context)
                .load(contact.get(position).getImageUrl())
                .centerCrop()

                .into(viewHolder.mContactImage);



        return view;
    }

    static class ViewHolder {
        protected TextView mContactName;
        protected ImageView mContactImage;
        protected TextView contactCity;


    }
}
