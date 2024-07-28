package com.foot.list_controle;

import android.app.Application;
import java.util.ArrayList;

public class ApplicationClass extends Application {
    private ArrayList<String> contacts = new ArrayList<>();

    public ArrayList<String> getContacts() {
        return contacts;
    }
}
