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

public class CompanyEvents extends AppCompatActivity {
    int iteratorForEvents = 0;
    String[] barEvents = {"Saturday:\nMurphy500", "Styx Events", "Saluki Events", "SideTracks Events"};
    TextView bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iteratorForEvents = getIntent().getIntExtra("Hours", 0);
        bar = (TextView) findViewById(R.id.BarEvents);
        bar.setText(barEvents[iteratorForEvents]);

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
        final Button hoursButton = (Button) findViewById(R.id.hoursButton);

        hoursButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newIntent = new Intent(CompanyEvents.this,CompanyHours.class);
                newIntent.putExtra("Hours",iteratorForEvents);
                CompanyEvents.this.startActivity(newIntent);
                CompanyEvents.this.finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(CompanyEvents.this,CompanyHours.class);
        newIntent.putExtra("Hours",iteratorForEvents);
        CompanyEvents.this.startActivity(newIntent);
        CompanyEvents.this.finish();
    }
}

