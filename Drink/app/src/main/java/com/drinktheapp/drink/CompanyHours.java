package com.drinktheapp.drink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CompanyHours extends AppCompatActivity {
    int iteratorForHours = 0;
    String[] barName = {"Satuday:\n10pm-2am", "Styx Hours", "Saluki Hours", "SideTracks Hours"};
    TextView bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_hours);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iteratorForHours = getIntent().getIntExtra("Hours", 0);
        bar = (TextView) findViewById(R.id.BarHours);
        bar.setText(barName[iteratorForHours]);

        buttonSetup();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonSetup(){
        final Button specialsButton = (Button) findViewById(R.id.specialsButton);
        final Button eventsButton = (Button) findViewById(R.id.eventsButton);
        final Button mainPageButton = (Button) findViewById(R.id.mainPageButton);

        specialsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newIntent = new Intent(CompanyHours.this,CompanySpecials.class);
                newIntent.putExtra("Hours",iteratorForHours);
                CompanyHours.this.startActivity(newIntent);
                CompanyHours.this.finish();
            }
        });

        eventsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newIntent = new Intent(CompanyHours.this,CompanyEvents.class);
                newIntent.putExtra("Hours",iteratorForHours);
                CompanyHours.this.startActivity(newIntent);
                CompanyHours.this.finish();
            }
        });

        mainPageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newIntent = new Intent(CompanyHours.this,CompanyMain.class);
                newIntent.putExtra("Bar",iteratorForHours);
                CompanyHours.this.startActivity(newIntent);
                CompanyHours.this.finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(CompanyHours.this,CompanyMain.class);
        newIntent.putExtra("Bar",iteratorForHours);
        CompanyHours.this.startActivity(newIntent);
        CompanyHours.this.finish();
    }
}
