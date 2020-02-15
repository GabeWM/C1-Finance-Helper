package com.example.c1_finance_helper;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.statisticsMenu){
            startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
        }
        else if(id == R.id.goalMenu){
            startActivity(new Intent(MainActivity.this, GoalActivity.class));
        }
        else if(id == R.id.budgetMenu){
            startActivity(new Intent(MainActivity.this, BudgetActivity.class));
        }
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
