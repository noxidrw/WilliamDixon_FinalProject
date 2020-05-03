package com.example.finalprojecttake2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author William Dixon
 * @version 2.0
 */

public class ItemAdd extends AppCompatActivity {

    TextView urlEntry;
    TextView tagEntry;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        urlEntry = (TextView) findViewById(R.id.addItemURL);
        tagEntry = (TextView) findViewById(R.id.addItemTag);
        addButton = (Button) findViewById(R.id.button);

        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(urlEntry.getText().length() < 8){
                    Toast.makeText(getApplicationContext(), "Add a valid URL Please!", Toast.LENGTH_LONG).show();
                }else {
                    TheLockerDataSource dbSource = new TheLockerDataSource(getApplicationContext());
                    TheLocker tempLocker = dbSource.createTheLocker(urlEntry.getText().toString(), tagEntry.getText().toString());
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
    }
}
