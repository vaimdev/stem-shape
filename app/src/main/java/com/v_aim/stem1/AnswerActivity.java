package com.v_aim.stem1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class AnswerActivity extends AppCompatActivity {

    private String shape = "";
    private HashMap<String, Double> hashMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
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
        hashMap = (HashMap<String, Double>)b.getSerializable("hashMap");

        TextView tvArea = (TextView) findViewById(R.id.textViewArea);
        TextView tvPerimeter = (TextView) findViewById(R.id.textViewPerimeter);


        switch(shape) {
            case "circle": {
                Double radius = hashMap.get("radius");
                tvArea.setText(calCircleArea(radius).toString());
                tvPerimeter.setText(calCircleCircumference(radius).toString());
                break;
            }
            case "rectangle": {
                Double width = hashMap.get("width");
                Double height = hashMap.get("height");
                tvArea.setText(calRectArea(width, height).toString());
                tvPerimeter.setText(calRectPerimeter(width, height).toString());
                break;

            }
            case "triangle": {
                Double side1 = hashMap.get("side1");
                Double side2 = hashMap.get("side2");
                Double side3 = hashMap.get("side3");
                tvArea.setText(calTriangleArea(side1, side2, side3).toString());
                tvPerimeter.setText(calTrianglePerimeter(side1, side2, side3).toString());
                break;
            }
        }


    }


    private Double calCircleArea(Double radius) {
        return  3.14159 * radius * radius;
    }
    private Double calCircleCircumference(Double radius) {
        return 3.14159 * radius * 2;
    }

    private Double calRectArea(Double width, Double height) {
        return width * height;
    }

    private Double calRectPerimeter(Double width, Double height) {
        return 2.0 * width * height;
    }

    private Double calTriangleArea(Double side1, Double side2, Double side3) {
        Double temp = (side1 + side2 + side3) / 2.0;

        return (temp - side1) * (temp - side2) * (temp - side3);
    }

    private Double calTrianglePerimeter(Double side1, Double side2, Double side3) {
        return side1 + side2 + side3;
    }



}
