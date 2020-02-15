package com.example.c1_finance_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.Purchase;

import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.model.*;

import java.util.*;

import android.graphics.Color;

public class StatisticsActivity extends AppCompatActivity {

    private Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //Pie Chart
        PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();
        sliceValues(pieData);
        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(8);
        pieChartView.setPieChartData(pieChartData);
    }

    //Figures out the "cut" of each pie slice
    private void sliceValues (List<SliceValue> pieData) {
        double total = 0;
        HashMap<String, Double> sections = new HashMap<>();

        //Add Sections to the pie chart
        sections.put("housing", new Double(0));
        sections.put("food", new Double(0));
        sections.put("transportation", new Double(0));
        sections.put("health", new Double(0));
        sections.put("personalAndFamily", new Double(0));

        List<Purchase> purchasesList = data.getPurchaseList();
        List<Merchant> merchantsList = data.getMerchantsList();

        for (Purchase purchase : purchasesList) {
            for (Merchant merchant: merchantsList) {
                if (purchase.getMerchantId() == merchant.getId()) {
                    // important note we are just showing proof of concept this part would be vastly larger as it would organize
                    // every category possible into a certain subsection of categories pre determined

                    //Housing
                    if (merchant.getCategories().contains("lodging") || merchant.getCategories().contains("housing")) {
                        total+= purchase.getAmount();
                        sections.put("housing", sections.getOrDefault("housing", new Double(0)) + purchase.getAmount());
                    }
                    // Food
                    else if (merchant.getCategories().contains("grocery_or_supermarket") || merchant.getCategories().contains("food")) {
                        total+= purchase.getAmount();
                        sections.put("food", sections.getOrDefault("food", new Double(0)) + purchase.getAmount());
                    }
                    //Transportation
                    else if (merchant.getCategories().contains("car_dealer") || merchant.getCategories().contains("transportation")) {
                        total+= purchase.getAmount();
                        sections.put("transportation", sections.getOrDefault("transportation", new Double(0)) + purchase.getAmount());
                    }
                    //Health
                    else if (merchant.getCategories().contains("health")) {
                        total+= purchase.getAmount();
                        sections.put("health", sections.getOrDefault("health", new Double(0)) + purchase.getAmount());
                    }
                    //Personal and Family
                    else if (merchant.getCategories().contains("movies") || merchant.getCategories().contains("Personal_And_Family")) {
                        total+= purchase.getAmount();
                        sections.put("personalAndFamily", sections.getOrDefault("personalAndFamily", new Double(0)) + purchase.getAmount());
                    }
                    //Does not fall into category
                    else {
                        System.out.println("ERROR DID NOT MATCH");
                    }
                }
            }
        }

        int i = 0;
        List<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.rgb(1,53,79));
        colors.add(Color.rgb(0, 255, 255));
        colors.add(Color.rgb(5, 5, 5));
        colors.add(Color.rgb(197, 39, 43));
        colors.add(Color.rgb(133, 28, 45));

        for(String section : sections.keySet()) {
            pieData.add(new SliceValue((float) (sections.get(section)/total), colors.get(i)).setLabel(section));
            i++;
        }

    }


}
