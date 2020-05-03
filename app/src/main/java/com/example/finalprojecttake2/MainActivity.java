package com.example.finalprojecttake2;

import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

/**
 * @author William Dixon
 * @version 2.0
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private TheLockerDataSource dbSource;

    ListView lockList;
    LockerList lockerList;
    ArrayAdapter<TheLocker> lockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbSource = new TheLockerDataSource(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lockList = (ListView) findViewById(R.id.theLockerListView);
        lockerList = new LockerList(dbSource);
        lockerList.getListOfItems();
        lockAdapter = new LockerAdapter(this, R.layout.locker_item, R.id.lockerRowID, lockerList);
        lockAdapter.setDropDownViewResource(R.layout.locker_item);
        lockList.setAdapter(lockAdapter);
        Log.d("Validate_Size", "Database had this many entries: " + lockerList.getSize());

        if(lockerList.getSize() == 0){
            Toast.makeText(getApplicationContext(), "Database is Empty!", Toast.LENGTH_LONG).show();
            Snackbar.make(getWindow().getDecorView(), "Database is Empty!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }

        lockList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                TheLocker tl = (TheLocker) parent.getItemAtPosition(position);
                String pass;
                if(tl.getUrlAddress().substring(0,4).compareToIgnoreCase("http") != 0){
                    pass = "https://" + tl.getUrlAddress();
                    Log.d("not zero", tl.getUrlAddress().substring(0,4)); // used for validation
                }else{
                    pass = tl.getUrlAddress();
                    Log.d("IS zero", tl.getUrlAddress().substring(0,4));  // used for validation
                }
                Toast.makeText(getApplicationContext(), "You picked URL " + tl.getUrlAddress(), Toast.LENGTH_LONG).show();
                // Below launches URL but checks for appropriate application before launching
                Uri webpage = Uri.parse(pass);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(webIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                if (activities.size() > 0){
                    startActivity(webIntent);
                }
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ItemAdd.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        //Setup Menu Actions
        if(id == R.id.sw_create_new){
            startActivity(new Intent(MainActivity.this, ItemAdd.class));
            return true;
        }

        if(id == R.id.sw_create_new_2){
            startActivity(new Intent(MainActivity.this, ItemAdd.class));
            return true;
        }

        if(id == R.id.sw_remove_entry){
            Toast.makeText(getApplicationContext(), "This functionality for future release", Toast.LENGTH_LONG).show();
            return true;
        }

        if(id == R.id.action_settings){
            Snackbar.make(getWindow().getDecorView(), "This functionality for future release", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
