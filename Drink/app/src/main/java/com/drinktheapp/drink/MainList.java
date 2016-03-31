package com.drinktheapp.drink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static com.drinktheapp.drink.R.id.scrollLayout;

public class MainList extends AppCompatActivity {
    //String[] barName = {"Copper", "Styx", "Saluki", "SideTracks"};
    Bar copper = new Bar("Copper",0);
    Bar styx = new Bar("Styx",0);
    Bar saluki = new Bar("Saluki",0);
    Bar sidetracks = new Bar("SideTracks",0);
    Bar[] bars = {copper,styx,saluki,sidetracks};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addButtons();

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

    public void addButtons(){

        Button barButton;
        LinearLayout layout = (LinearLayout) findViewById(scrollLayout);

        for(int i = 0; i < bars.length; i++){
            barButton = new Button(this);
            layout.addView(barButton);
            barButton.setText(bars[i].name);
            final int index = i;
            barButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent newIntent = new Intent(MainList.this, CompanyMain.class);
                    newIntent.putExtra("Bar", index);
                    MainList.this.startActivity(newIntent);
                    MainList.this.finish();
                }
            });
        }
    }
}
