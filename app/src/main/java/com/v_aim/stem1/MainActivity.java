package com.v_aim.stem1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity{
    public static final String SHAPE = "SHAPE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        Button mClickButton1 = (Button)findViewById(R.id.button1);
//        mClickButton1.setOnClickListener(this);
//        Button mClickButton2 = (Button)findViewById(R.id.button2);
//        mClickButton2.setOnClickListener(this);
//        Button mClickButton3 = (Button)findViewById(R.id.button3);
//        mClickButton3.setOnClickListener(this);
//        Button mClickButton4 = (Button)findViewById(R.id.button4);
//        mClickButton4.setOnClickListener(this);

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

    public void chooseShape(View v) {
        // click handling code
        String shape = "";
        switch (v.getId()) {
            case  R.id.button1: {
                // do something for button 1 click
                shape = "circle";
                break;
            }

            case R.id.button2: {
                // do something for button 2 click
                shape = "rectangle";
                break;
            }
            case  R.id.button3: {
                // do something for button 1 click
                shape = "triangle";
                break;
            }

            case R.id.button4: {
                // do something for button 2 click
                shape = "trapezium";
                break;
            }
            //.... etc
        }
        Intent intent = new Intent(this, UserInputActivity.class);
        intent.putExtra(SHAPE, shape);
        startActivity(intent);

    }

}
