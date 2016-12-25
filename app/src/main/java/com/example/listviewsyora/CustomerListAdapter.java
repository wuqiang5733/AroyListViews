package com.example.listviewsyora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mac on 2016/12/25.
 */

public class CustomerListAdapter extends BaseAdapter {
    private final ArrayList<Customer> customers;
    private final Context context;
    private final LayoutInflater layoutInflater;

    public CustomerListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        customers = new ArrayList<>();
    }

    public void add(Customer customer) {
        customers.add(customer);
        notifyDataSetChanged();
    }

    public void remove(Customer customer) {
        customers.remove(customer);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return customers.size();
    }

    @Override
    public Customer getItem(int i) {
        return customers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View ConvertView, ViewGroup viewGroup) {

        CustomerViewHolder viewHolder;

        if (ConvertView == null) {
            ConvertView = layoutInflater.inflate(R.layout.list_item_customer_2, viewGroup, false);
            viewHolder = new CustomerViewHolder();
            viewHolder.FirstName = (TextView) ConvertView.findViewById(R.id.list_item_customer_2_firstName);
            viewHolder.LastName = (TextView) ConvertView.findViewById(R.id.list_item_customer_2_lastName);
            ConvertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomerViewHolder) ConvertView.getTag();
        }

        Customer customer = getItem(position);
        viewHolder.FirstName.setText(customer.getFirstName());
        viewHolder.LastName.setText(customer.getLastName());
        return ConvertView;
    }

    private class CustomerViewHolder {
        public TextView FirstName;
        public TextView LastName;
    }
}
