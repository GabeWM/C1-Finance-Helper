package com.example.c1_finance_helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;
import com.reimaginebanking.api.nessieandroidsdk.models.Address;

import java.util.List;
import android.util.Log;

public class StatisticsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        NessieClient client = NessieClient.getInstance("9acc940321abe272c81d8329651cb93b");
        System.out.println("111111111111111111111111");

        client.MERCHANT.getMerchants(38.9897f, -76.9378f, 1000f, new NessieResultsListener() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("S222222222222222222222222");
                List<Merchant> merchants = (List<Merchant>) result;
                for(Merchant merchant : merchants) {
                    System.out.println(merchant);
                }
            }

            @Override
            public void onFailure(NessieError error) {
                System.out.println("ERRORERRORERRORERROR");
                System.out.println(error.getMessage());
            }
        });

    }





}
