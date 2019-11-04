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

public class LastorderAdapter  extends ArrayAdapter {
    List list=new ArrayList();

    public LastorderAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(Last_order object) {
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
        View List;
        List = convertView;
       ContactHolder contactHolder;
        if (List==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            List = layoutInflater.inflate(R.layout.list_child,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.tx_id=(TextView) List.findViewById(R.id.tx_id);
            contactHolder.tx_name=(TextView) List.findViewById(R.id.tx_name);
            contactHolder.tx_address=(TextView) List.findViewById(R.id.tx_address);
            contactHolder.tx_mobile=(TextView) List.findViewById(R.id.tx_mobileno);
            contactHolder.tx_inbuilt=(TextView) List.findViewById(R.id.tx_inbuilt);
            contactHolder.tx_price=(TextView) List.findViewById(R.id.tx_price);
            List.setTag(contactHolder);

        }
        else {
            contactHolder=(ContactHolder) List.getTag();
        }
        Last_order last_order = (Last_order) this.getItem(position);
        contactHolder.tx_id.setText(last_order.getId());
        contactHolder.tx_name.setText(last_order.getName());
        contactHolder.tx_address.setText(last_order.getAddress());
        contactHolder.tx_mobile.setText(last_order.getMobileno());
        contactHolder.tx_inbuilt.setText(last_order.getWashingtextview());
        contactHolder.tx_price.setText(last_order.getRepairprice());
        return List;
    }
    static class ContactHolder {
        TextView tx_id, tx_name, tx_mobile, tx_address,tx_inbuilt,tx_price;
    }

}
