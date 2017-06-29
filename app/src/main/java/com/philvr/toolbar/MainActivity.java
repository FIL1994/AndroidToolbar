package com.philvr.toolbar;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //scale logo
        Drawable logo = getResources().getDrawable(R.drawable.fil);
        Bitmap logoBitmap = ((BitmapDrawable) logo).getBitmap();
        logoBitmap = Bitmap.createScaledBitmap(logoBitmap, 100, 100, false);
        logo = new BitmapDrawable(getResources(), logoBitmap);

        //get the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(logo); //set the toolbar logo
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.R.drawable.ic_dialog_alert);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Toolbar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_email:
                Toast.makeText(this, "EMail", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }
}