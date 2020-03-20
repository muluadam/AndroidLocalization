package com.adam.localization;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        try {
            Locale locale;
            locale = new Locale(LocaleHelper.getLanguage(getApplicationContext()));
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            //this.getBaseContext().getResources().up
            this.getBaseContext().getResources().updateConfiguration(config,
                    this.getBaseContext().getResources().getDisplayMetrics());

        } catch (Exception e) {
            e.printStackTrace();
        }
        toolbar.setTitle(getResources().getString(R.string.title));
        FloatingActionButton fabam = findViewById(R.id.fab_am);
        fabam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocaleHelper.setLocale(getApplicationContext(),"AM");
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        FloatingActionButton faben = findViewById(R.id.fab_en);
        faben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
                LocaleHelper.setLocale(getApplicationContext(),"EN");
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

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
}
