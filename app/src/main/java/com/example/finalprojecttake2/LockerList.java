package com.example.finalprojecttake2;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author William Dixon
 * @version 2.0
 */

public class LockerList extends AppCompatActivity {
    // The list of the locker items from the db
    private ArrayList<TheLocker> lockerList = new ArrayList<TheLocker>();
    private TheLockerDataSource dbSource;


    public LockerList(TheLockerDataSource dbSourceIn) {
        dbSource = dbSourceIn;
        lockerList = new ArrayList<TheLocker>();
    }

    public void getListOfItems() {
        lockerList = new ArrayList<TheLocker>(dbSource.getAllUrlocker());
    }

    public int getSize(){
        return lockerList.size();
    }

    public List getList() {
        return lockerList;
    }

    public TheLocker getTheLocker(Integer index) {
        return lockerList.get(index);
    }

    public void remove(Integer index){  // not completed for this version of the code - for the future
        lockerList.remove(index);
    }

}
