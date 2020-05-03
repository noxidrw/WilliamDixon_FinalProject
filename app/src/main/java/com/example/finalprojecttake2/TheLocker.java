package com.example.finalprojecttake2;

/**
 * @author William Dixon
 * @version 2.0
 */

public class TheLocker {
    private String id;
    private String urlAddress;
    private String filter;

    public TheLocker(String urlAddress, String filter) {
        this.urlAddress = urlAddress;
        this.filter = filter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return urlAddress + ", " + filter;
    }
}