package com.v_aim.stem1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

import static com.v_aim.stem1.MainActivity.SHAPE;

public class UserInputActivity extends AppCompatActivity {

    private String shape = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
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



        Intent in = getIntent();

        Bundle b = in.getExtras();
        shape = b.getString("SHAPE", "");


    }

    public void calculate(View v) {
        // click handling code

        HashMap hashMap = new HashMap<String, Double>();

        switch(shape) {
            case "circle": {
                EditText editText = (EditText) findViewById(R.id.editTextRadius);
                String value = editText.getText().toString();

                hashMap.put("radius", Double.parseDouble(value));
                break;
            }
            case "rectangle": {
                EditText editText = null;
                String value = null;
                editText = (EditText) findViewById(R.id.editTextHeight);
                value = editText.getText().toString();
                hashMap.put("height", Double.parseDouble(value));

                editText = (EditText) findViewById(R.id.editTextWidth);
                value = editText.getText().toString();
                hashMap.put("width", Double.parseDouble(value));
                break;

            }
            case "triangle": {
                EditText editText = null;
                String value = null;

                editText = (EditText) findViewById(R.id.editTextSide1);
                value = editText.getText().toString();
                hashMap.put("side1", Double.parseDouble(value));

                editText = (EditText) findViewById(R.id.editTextSide2);
                value = editText.getText().toString();
                hashMap.put("side2", Double.parseDouble(value));

                editText = (EditText) findViewById(R.id.editTextSide3);
                value = editText.getText().toString();

                hashMap.put("side3", Double.parseDouble(value));
                break;
            }
        }


        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra(SHAPE, shape);
        intent.putExtra("hashMap", hashMap);
        startActivity(intent);

    }



}
