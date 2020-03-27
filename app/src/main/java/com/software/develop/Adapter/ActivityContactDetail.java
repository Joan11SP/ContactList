package com.software.develop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.develop.Model.Contact;
import com.software.develop.R;

import org.w3c.dom.Text;

import java.util.List;

public class ActivityContactDetail extends ArrayAdapter<Contact> {
    private Context context;
    private List<Contact> contact;

    public  ActivityContactDetail(Context context,List<Contact>contact){
        super(context, R.layout.activity_contact);
        this.contact=contact;
        this.context=context;
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
        final ActivityContactDetail.ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ActivityContactDetail.ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.activity_contact, parent, false);
            viewHolder.mContactName = (TextView) view.findViewById(R.id.textnombre);
            viewHolder.mContactImage = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.contactCity = (TextView) view.findViewById(R.id.textciudad);
            viewHolder.contactDescription = (TextView) view.findViewById(R.id.textDescripcion);
            viewHolder.contactEmail = (TextView) view.findViewById(R.id.textcorreo);
            viewHolder.contactPhone = (TextView) view.findViewById(R.id.textelefono);

            view.setTag(viewHolder);

        } else {
            viewHolder = (ActivityContactDetail.ViewHolder) convertView.getTag();
            view = convertView;
        }

        // Set text with the item name
        viewHolder.mContactName.setText(contact.get(position).getName());


        // set text with the item city

        viewHolder.contactPhone.setText(contact.get(position).getPhone());
        viewHolder.contactCity.setText(contact.get(position).getCity());
        viewHolder.contactEmail.setText(contact.get(position).getEmail());
        viewHolder.contactDescription.setText(contact.get(position).getDescription());




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
        protected TextView contactDescription;
        protected  TextView contactPhone;
        protected TextView contactEmail;


    }
}

