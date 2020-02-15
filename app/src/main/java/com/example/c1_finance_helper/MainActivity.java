package com.example.c1_finance_helper;

import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.model.*;

import android.os.Bundle;
import java.util.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(10, Color.RED).setLabel("Health"));
        pieData.add(new SliceValue(30, Color.BLUE).setLabel("Housing"));
        pieData.add(new SliceValue(20, Color.GREEN).setLabel("Food"));
        pieData.add(new SliceValue(30, Color.MAGENTA).setLabel("Transportation"));
        pieData.add(new SliceValue(5, Color.YELLOW).setLabel("Personal and Family"));
        pieData.add(new SliceValue(5, Color.BLACK).setLabel("Other"));
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(8);
        pieChartView.setPieChartData(pieChartData);

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

        return super.onOptionsItemSelected(item);
    }
}
