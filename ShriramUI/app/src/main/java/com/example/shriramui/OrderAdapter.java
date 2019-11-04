package com.example.shriramui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends ArrayAdapter {
    List list=new ArrayList();

    public OrderAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(Orders object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {

        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View list;
        list = convertView;
        ContactHolder contactHolder;
        if (list==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            list = layoutInflater.inflate(R.layout.list_content,parent,false);
            contactHolder=new OrderAdapter.ContactHolder();
            contactHolder.tx_name=(TextView) list.findViewById(R.id.tx_name);
            contactHolder.tx_city=(TextView) list.findViewById(R.id.tx_city);
            contactHolder.tx_address=(TextView) list.findViewById(R.id.tx_address);
            contactHolder.tx_mobile=(TextView) list.findViewById(R.id.tx_mobileno);
            contactHolder.tx_requirement=(TextView) list.findViewById(R.id.tx_requirement);
            list.setTag(contactHolder);

        }
        else {
            contactHolder=(ContactHolder) list.getTag();
        }
        Orders orders = (Orders) this.getItem(position);
        contactHolder.tx_name.setText(orders.getName());
        contactHolder.tx_city.setText(orders.getCity());
        contactHolder.tx_address.setText(orders.getAddress());
        contactHolder.tx_mobile.setText(orders.getMobile());
        contactHolder.tx_requirement.setText(orders.getRequirement());
        return list;
    }
    static class ContactHolder {
        TextView tx_name, tx_mobile, tx_city,tx_address,tx_requirement;
    }
}
