package com.example.finalprojecttake2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author William Dixon
 * @version 2.0
 */

public class LockerAdapter extends ArrayAdapter<TheLocker> {

    private final Context context;
    private LockerList lockList;

    public LockerAdapter(Context context, int rowLayout, int dummyTV, LockerList lockList) {
        super(context, rowLayout, dummyTV, lockList.getList());
        this.context = context;
        this.lockList = lockList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.locker_item, null);
        TheLocker ll = lockList.getTheLocker(position);

        TextView lockID=(TextView)view.findViewById(R.id.lockerRowID);
        lockID.setText(ll.getId() + "");

        TextView lockURL=(TextView)view.findViewById(R.id.lockerRowURL);
        lockURL.setText(ll.getUrlAddress().toString());

        TextView lockTag=(TextView)view.findViewById(R.id.lockerRowTag);
        lockTag.setText(ll.getFilter().toString());

        return(view);
    }
}
