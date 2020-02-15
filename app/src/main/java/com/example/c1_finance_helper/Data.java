package com.example.c1_finance_helper;

import com.reimaginebanking.api.nessieandroidsdk.constants.*;
import com.reimaginebanking.api.nessieandroidsdk.models.Merchant;
import com.reimaginebanking.api.nessieandroidsdk.models.*;

import java.util.*;

public class Data {
    private Account account;
    private Customer customer;
    private List<Merchant> merchantsList;
    private List<Purchase> purchaseList;

    public Data () {
        account = new Account ("A00001", AccountType.CREDITCARD, "Mag's Account", 14145, 30000, "333", "123456");
        Address address = new Address ("123", "Elms St", "Germantown", "MD", "23712");
        customer = new Customer ("123456", "Mag", "UMD", address);
        merchantsList = new ArrayList<>();
        purchaseList = new ArrayList<>();

        //Merchant One
        Address addressMerchantOne = new Address ("1050", "Woodward Avenue", "Detroit", "MI", "48226");
        Geocode geocodeMerchantOne = new Geocode(-20f, 20f);
        List<String> categoriesMerchantOne = new ArrayList<String>();
        categoriesMerchantOne.add("lodging");
        categoriesMerchantOne.add("home");
        categoriesMerchantOne.add("loan");
        merchantsList.add(new Merchant("M00001", "Rocket Mortgage", categoriesMerchantOne, addressMerchantOne, geocodeMerchantOne));

        //Merchant Two
        Address addressMerchantTwo = new Address ("10", "Falls Rd", "Potomac", "MD", "20854");
        Geocode geocodeMerchantTwo = new Geocode(-200f, -200f);
        List<String> categoriesMerchantTwo = new ArrayList<String>();
        categoriesMerchantTwo.add("grocery_or_supermarket");
        categoriesMerchantTwo.add("food");
        categoriesMerchantTwo.add("safeway");
        merchantsList.add(new Merchant("M00002", "Safeway", categoriesMerchantTwo, addressMerchantTwo, geocodeMerchantTwo));

        //Merchant Three
        Address addressMerchantThree = new Address ("69", "Stadium Dr", "LA", "CA", "11111");
        Geocode geocodeMerchantThree = new Geocode(100f, 10f);
        List<String> categoriesMerchantThree = new ArrayList<String>();
        categoriesMerchantThree.add("car_dealer");
        categoriesMerchantThree.add("transportation");
        categoriesMerchantThree.add("car");
        merchantsList.add(new Merchant("M00003", "BMW", categoriesMerchantThree, addressMerchantThree, geocodeMerchantThree));

        //Merchant Four
        Address addressMerchantFour = new Address ("909", "Healthy Dr", "Pittsburgh", "PA", "666");
        Geocode geocodeMerchantFour = new Geocode(666f, -666f);
        List<String> categoriesMerchantFour = new ArrayList<String>();
        categoriesMerchantFour.add("health");
        categoriesMerchantFour.add("medicine");
        categoriesMerchantFour.add("healthcare");
        merchantsList.add(new Merchant("M00004", "Hospital", categoriesMerchantFour, addressMerchantFour, geocodeMerchantFour));

        //Merchant Five
        Address addressMerchantFive = new Address ("45642", "Broadway St", "Manhatten", "NY", "64222");
        Geocode geocodeMerchantFive = new Geocode(1f, -1f);
        List<String> categoriesMerchantFive = new ArrayList<String>();
        categoriesMerchantFive.add("movies");
        categoriesMerchantFive.add("personal");
        categoriesMerchantFive.add("broadway");
        merchantsList.add(new Merchant("M00005", "Movies", categoriesMerchantFive, addressMerchantFive, geocodeMerchantFive));

        //Purchase 1
        purchaseList.add(new Purchase ("P00001", "2020-2-15", "Complete", TransactionType.WITHDRAWAL, "A00001", "M00001", 2000, "Lodge at Rocket Mortgage", "balance"));
        purchaseList.add(new Purchase ("P00002", "2020-1-18", "Complete", TransactionType.WITHDRAWAL, "A00002", "M00002", 200, "Groceries at Safeway", "balance"));
        purchaseList.add(new Purchase ("P00003", "2020-1-31", "Complete", TransactionType.WITHDRAWAL, "A00003", "M00003", 1000, "Paying off BMW", "balance"));
        purchaseList.add(new Purchase ("P00004", "2020-2-01", "Complete", TransactionType.WITHDRAWAL, "A00004", "M00004", 500, "Daily Checkup", "balance"));
        purchaseList.add(new Purchase ("P00001", "2020-2-15", "Complete", TransactionType.WITHDRAWAL, "A00005", "M00005", 100, "Hella Expensive Movie", "balance"));
    }

    public Account getAccount() {
        return account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Merchant> getMerchantsList() {
        return merchantsList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }
}
