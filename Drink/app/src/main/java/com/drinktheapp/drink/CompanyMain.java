package com.drinktheapp.drink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyMain extends AppCompatActivity {

    TextView bar;
    ImageView barImage;
    int iteratorForName = 0;
    //String[] barName = {"Copper", "Styx", "Saluki", "SideTracks"};
    Bar copper = new Bar("Copper",0);
    Bar styx = new Bar("Styx",0);
    Bar saluki = new Bar("Saluki",0);
    Bar sidetracks = new Bar("SideTracks",0);
    Bar[] bars = {copper,styx,saluki,sidetracks};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iteratorForName = getIntent().getIntExtra("Bar", 0);
        bar = (TextView) findViewById(R.id.BarName);
        //barImage = (ImageView) findViewById(R.id.companyLogo);
        bar.setText(bars[iteratorForName].name);


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

    public void update(int updateValue) {
        if(iteratorForName == 0 && updateValue == -1)
            Toast.makeText(CompanyMain.this, "You are at the beginning!", Toast.LENGTH_SHORT).show();
        else if(iteratorForName == bars.length - 1 && updateValue == 1)
            Toast.makeText(CompanyMain.this, "You are at the end!", Toast.LENGTH_SHORT).show();
        else {
            iteratorForName += updateValue;
            bar.setText(bars[iteratorForName].name);
        }
    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(CompanyMain.this,MainList.class);
        CompanyMain.this.startActivity(newIntent);
        CompanyMain.this.finish();
    }

    public void buttonSetup(){
        final Button hourButton = (Button) findViewById(R.id.hoursButton);
        final Button nextButton = (Button) findViewById(R.id.nextBarButton);
        final Button previousButton = (Button) findViewById(R.id.previousBarButton);
        final Button twitterButton = (Button) findViewById(R.id.twitterButton);

        hourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newIntent = new Intent(CompanyMain.this,CompanyHours.class);
                newIntent.putExtra("Hours",iteratorForName);
                CompanyMain.this.startActivity(newIntent);
                CompanyMain.this.finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                update(1);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                update(-1);
            }
        });

        twitterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(CompanyMain.this, "Impementation for Twitter coming soon!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public Bar[] getBars(){
        return bars;
    }

}
