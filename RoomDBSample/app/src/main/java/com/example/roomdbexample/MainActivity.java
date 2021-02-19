package com.example.roomdbexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;

import roomdb.Event;
import roomdb.EventDao;
import roomdb.EventDb;

public class MainActivity extends AppCompatActivity {

    private ListView eventList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.myToolBar));

        eventList = findViewById(R.id.event_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventDb db = Room.databaseBuilder(getApplicationContext(), EventDb.class, EventDb.DATABASE_NAME).allowMainThreadQueries().build();
        EventDao dao = db.eventDao();
        ArrayAdapter<Event> adapter = new EventListAdapter(getApplicationContext(), dao.getAllEvent());
        eventList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(this, CreateEventActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}