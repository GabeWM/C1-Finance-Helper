package com.example.c1_finance_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.widget.*;
import android.view.View;

import java.util.*;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


public class BudgetActivity extends AppCompatActivity {

    private LinkedHashMap<String,Double> pieChartSlices;
    private Double total;
    private List<SliceValue> pieData;
    private EditText ETCategory;
    private EditText ETCost;
    private PieChartView pieChartView;
    private Integer counter;

    public BudgetActivity () {
        pieChartSlices = new LinkedHashMap<>();
        total = new Double (0);
        pieData = new ArrayList<>();
        counter = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        ETCategory = findViewById(R.id.category);
        ETCost = findViewById(R.id.cost);

        pieChartView = findViewById(R.id.chart);

        ETCategory.setHint("Enter a category: ");
        ETCost.setHint("Enter the price: ");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        pieChartSlices.put(ETCategory.getText().toString(), Double.parseDouble(ETCost.getText().toString()));
                        total += Double.parseDouble(ETCost.getText().toString());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    updatePieChart();
                    PieChartData pieChartData = new PieChartData(pieData);
                    pieChartData.setHasLabels(true).setValueLabelTextSize(8);
                    pieChartView.setPieChartData(pieChartData);
                    ETCost.setText("");
                    ETCategory.setText("");
            }
        });

    }

    private void updatePieChart() {
        List<Integer> colors = colors();
        counter = 0;
        pieData.clear();
        for (String category : pieChartSlices.keySet()) {
            pieData.add(new SliceValue((float) (pieChartSlices.get(category) / total), colors.get(counter)).setLabel(category));
            counter++;
        }
    }

    private List<Integer> colors (){
        List<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.BLACK);
        colors.add(Color.CYAN);
        colors.add(Color.DKGRAY);

        return colors;
    }
}
