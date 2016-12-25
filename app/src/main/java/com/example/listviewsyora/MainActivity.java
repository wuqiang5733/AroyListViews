package com.example.listviewsyora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<HashMap<String,String>> data = new ArrayList<>();
        data.add(new Customer("Customer 1","LastName 1").toHashMap());
        data.add(new Customer("Customer 2","LastName 2").toHashMap());
        data.add(new Customer("Customer 3","LastName 3").toHashMap());

        String[] hashMapProperities = {"FirstName",                       "LastName"};
        int[] textViewIds =           {R.id.list_item_customer_2_firstName,R.id.list_item_customer_2_lastName};

        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.list_item_customer_2,hashMapProperities,textViewIds);

        ListView listView = (ListView)findViewById(R.id.activity_main_listView);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }else if (id == R.id.menu_main_addItem){
//            customers.add(new Customer("Added" , " Customer"));
//            // After data changes , U must notify list adapter
//            adapter.notifyDataSetChanged();
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
