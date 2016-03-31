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

public class CompanySpecials extends AppCompatActivity {
    int iteratorForSpecials = 0;
    String[] barSpecials = {"Saturday:\n$3.50 BUDWEISER & BUD LIGHT 16OZ BOTTLES\n" +
            "$3.50 SHOCK TOP BOTTLES\n" +
            "$3.25 ALL THREE OLIVES VODKA FLAVORS\n" +
            "$4.75 THREE OLIVES VODKA & RED BULL\n" +
            "$3.00 JIM BEAM & JIM BEAM APPLE\n" +
            "$3.00 MALIBU RUM\n" +
            "$3.00 FIREBALL SHOTS\n" +
            "$4.00 JAGER BOMBS\n" +
            "$2.00 KAMIKAZE, RED HEADED SLUT & ONE NIGHT STAND SHOTS",
            "Styx Specials", "Saluki Specials", "SideTracks Specials"};
    TextView bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_specials);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iteratorForSpecials = getIntent().getIntExtra("Hours", 0);
        bar = (TextView) findViewById(R.id.BarSpecials);
        bar.setText(barSpecials[iteratorForSpecials]);

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
                Intent newIntent = new Intent(CompanySpecials.this,CompanyHours.class);
                newIntent.putExtra("Hours",iteratorForSpecials);
                CompanySpecials.this.startActivity(newIntent);
                CompanySpecials.this.finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent newIntent = new Intent(CompanySpecials.this,CompanyHours.class);
        newIntent.putExtra("Hours",iteratorForSpecials);
        CompanySpecials.this.startActivity(newIntent);
        CompanySpecials.this.finish();
    }
}

