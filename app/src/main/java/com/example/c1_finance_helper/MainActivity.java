package com.example.c1_finance_helper;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent myIntent = null;

        /*
        if(id == R.id.statisticsMenu){
            myIntent = new Intent(MainActivity.this, StatisticsActivity.class);
            startActivity(myIntent);

            //return false;
        }
        else if(id == R.id.goalMenu){
            myIntent = new Intent(MainActivity.this, GoalActivity.class);
            startActivity(myIntent);
        }

        else if(id == R.id.budgetMenu){
            myIntent = new Intent(MainActivity.this,BudgetActivity.class);
            startActivity(myIntent);
        }
        */

<<<<<<< HEAD
=======
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
>>>>>>> parent of 4f1d409... menu update

        return super.onOptionsItemSelected(item);
    }
}
