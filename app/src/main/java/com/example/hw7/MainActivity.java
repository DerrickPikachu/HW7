package com.example.hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProductDataBase productDb;
    private TextView nameTxv;
    private TextView priceTxv;
    private ListView showList;
    private Spinner typeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productDb = ProductDataBase.generateDataBase(this);

        findViewById(R.id.addBtn).setOnClickListener(this);

        nameTxv = findViewById(R.id.nameInputFeild);
        priceTxv = findViewById(R.id.priceInputFeild);
        showList = findViewById(R.id.showData);

        typeSpinner = findViewById(R.id.typeSpinner);

        show();
    }

    @Override
    public void onClick(View v) {
        String name = nameTxv.getText().toString();
        int price = Integer.parseInt(priceTxv.getText().toString());
        int type = typeSpinner.getSelectedItemPosition();
        int target = 0;

        switch(type) {
            case 0:
                target = R.drawable.drink;
                break;
            case 1:
                target = R.drawable.food;
                break;
            case 2:
                target = R.drawable.tools;
                break;
            case 3:
                target = R.drawable.madeson;
        }

        productDb.newProduct(name, price, target);
        show();
    }

    private void show() {
//        ArrayList<String> name = new ArrayList<>();
//        ArrayList<Integer> price = new ArrayList<>();
//        String tem = "";
        SimpleCursorAdapter adapter = productDb.getAllData();
        showList.setAdapter(adapter);

//        for (int i=0; i<name.size(); i++) {
//            tem = tem + name.get(i) + " " + price.get(i).toString() + "\n";
//        }
//
//        showTxv.setText(tem);


    }

}
