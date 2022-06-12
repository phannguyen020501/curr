package com.example.curr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> money;
    private EditText display;
    private EditText vndValue;
    Spinner firstCurrencySpinner;
    ArrayAdapter<String> money_adpeter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstCurrencySpinner = findViewById(R.id.firstCurrencySpinner);
        money = new ArrayList<>();
        money.add("USD");
        money.add("EUR");
        money.add("JPY");
        money.add("WON");

        vndValue = findViewById(R.id.vndValue);
        money_adpeter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,money);
        firstCurrencySpinner.setAdapter(money_adpeter);


        display = findViewById(R.id.firstValue);
        display.setShowSoftInputOnFocus(false);


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }
    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }

    public void clearBTN(View view){
        display.setText("");
    }

    public void bsBTN(View view){
        int cursorBTN = display.getSelectionStart();
        int textlen = display.getText().length();

        if(cursorBTN != 0 && textlen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorBTN-1, cursorBTN, "");
            display.setText(selection);
            display.setSelection(cursorBTN-1);
        }
    }

    public void equal(View view){
        String text = firstCurrencySpinner.getSelectedItem().toString();
        float money = Float.parseFloat(display.getText().toString());
        float money_exchange;
        double z =0;
        System.out.println(money);
        System.out.println(text);
        switch (text){
            case "USD":{
                z = 23.182;
                break;
            }
            case "EUR": {
                z = 24.385;
                break;
            }
            case "JPY":{
                z = 0.172;
                break;
            }
            case "WON": {
                z = 0.01872;
                break;
            }
        }

        money_exchange  = (float) (money*z);
        vndValue.setText(String.valueOf(money_exchange));
    }
}