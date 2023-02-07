package com.example.casualwalletapp.models;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Currency {

    private Map<String,String> USD;
    private Map<String,String> EUR;
    private Map<String,String> GBP;

    private Map<String,String> GA;

    private Map<String,String> XU100;

    private Map<String,String>  C,GAG,BTC,ETH;

    public Map<String, String> getUSD() {
        return USD;
    }

    public void setUSD(Map<String, String> USD) {
        this.USD = USD;
    }

    public Map<String, String> getEUR() {
        return EUR;
    }

    public void setEUR(Map<String, String> EUR) {
        this.EUR = EUR;
    }

    public Map<String, String> getGBP() {
        return GBP;
    }

    public void setGBP(Map<String, String> GBP) {
        this.GBP = GBP;
    }

    public Map<String, String> getGA() {
        return GA;
    }

    public void setGA(Map<String, String> GA) {
        this.GA = GA;
    }

    public Map<String, String> getXU100() {
        return XU100;
    }

    public void setXU100(Map<String, String> XU100) {
        this.XU100 = XU100;
    }
}
