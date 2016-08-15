package com.iamrajendra.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.iamrajendra.myapplication.adapter.SectionRecyclerViewAdapter;
import com.iamrajendra.myapplication.model.SectionItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SectionActivity extends AppCompatActivity {


    private Map<String, List<String>> mMap_month;
    List<SectionItem> mList_sectionItem;
    private RecyclerView mRecyclerView;
    private SectionRecyclerViewAdapter secctionrva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(10));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mList_sectionItem = new ArrayList<>();
        mMap_month = new TreeMap<>();
        mMap_month.put("week1", getDays());
        mMap_month.put("week2", getDays());
        mMap_month.put("week3", getDays());
        mMap_month.put("week4", getDays());

        Iterator it = mMap_month.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());

            String current_key = (String) pair.getKey();


            List<String> mlist_string = (List<String>) pair.getValue();

            mList_sectionItem.add(new SectionItem(current_key, mlist_string.get(0).toString()));
            for (int i = 0; i < mlist_string.size(); i++) {
                mList_sectionItem.add(new SectionItem(mlist_string.get(i).toString()));
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        secctionrva = new SectionRecyclerViewAdapter(this, this, mList_sectionItem);
        mRecyclerView.setAdapter(secctionrva);


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<String> getDays() {
        List<String> mlist_days = new ArrayList<>();
        mlist_days.add("Monday");
        mlist_days.add("Tuesday");
        mlist_days.add("wednusday");
        mlist_days.add("Thusday");
        mlist_days.add("Friday");
        mlist_days.add("Saterday");
        mlist_days.add("Sunday");
        return mlist_days;
    }
}
