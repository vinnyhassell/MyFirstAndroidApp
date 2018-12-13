package com.example.vinnyhassell.myfirstapp;

public class Search {

    public Search() {
    }

    public Search(String searchName, boolean searchEnabled) {
        this.searchName = searchName;
        this.searchEnabled = searchEnabled;
    }

    private String searchName;
    private boolean searchEnabled;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public boolean isSearchEnabled() {
        return searchEnabled;
    }

    public void setSearchEnabled(boolean searchEnabled) {
        this.searchEnabled = searchEnabled;
    }
}
