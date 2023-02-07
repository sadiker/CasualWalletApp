package com.example.casualwalletapp.models;

import java.util.ArrayList;
import java.util.List;

public class ReplyNews {

    private boolean success;
    ArrayList<News> result;

    public ReplyNews() {}

    public ReplyNews(boolean success, ArrayList<News> result) {
        this.success = success;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<News> getResult() {
        return result;
    }

    public void setResult(ArrayList<News> result) {
        this.result = result;
    }
}
