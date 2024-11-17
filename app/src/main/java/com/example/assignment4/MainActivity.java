package com.example.assignment4;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Custom ListView
        ListView listView = findViewById(R.id.listView);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Oppo", R.drawable.ic_launcher_foreground));
        items.add(new Item("Samsung", R.drawable.ic_launcher_foreground));
        items.add(new Item("Vivo", R.drawable.ic_launcher_foreground));

        CustomAdapter customAdapter = new CustomAdapter(this, items);
        listView.setAdapter(customAdapter);

        // Setup Expandable ListView
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        List<String> listGroup = new ArrayList<>();
        HashMap<String, List<String>> listChild = new HashMap<>();

        listGroup.add("Mobile Phone");
        listGroup.add("Laptop");

        List<String> Phone = new ArrayList<>();
        Phone.add("Oppo");
        Phone.add("Samsung");
        Phone.add("Vivo");

        List<String> Laptop = new ArrayList<>();
        Laptop.add("Asus");
        Laptop.add("Hp");
        Laptop.add("Lenovo");

        listChild.put(listGroup.get(0), Phone);
        listChild.put(listGroup.get(1), Laptop);

        CustomExpandableListAdapter expandableAdapter = new CustomExpandableListAdapter(this, listGroup, listChild);
        expandableListView.setAdapter(expandableAdapter);
       }
}