package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int number1;
    private int number2;
    Button try_again_button;
    TextView txt_win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try_again_button = (Button) findViewById(R.id.winbutton);
        Button tryagain = (Button) findViewById(R.id.winbutton);
        tryagain.setVisibility(View.INVISIBLE);
        txt_win = (TextView) findViewById(R.id.txtwin);
        randomnumber();
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

    private void randomnumber() {
        Random randomnum = new Random();
        number1 = randomnum.nextInt(1000);
    }

    public void buttonclick(View view) {
        chektherandom(view);


    }


    private void chektherandom(View view) {
        EditText txt = (EditText) findViewById(R.id.numbertxt);

        String strnum = txt.getText().toString();

        if (strnum.isEmpty()) {

            Toast.makeText(this, "Please enter the number in text", Toast.LENGTH_LONG).show();
        } else {
            number2 = Integer.parseInt(strnum);

            int minus = Math.abs(number1 - number2);
            if (minus <= 5 && minus > 0) {
                Toast.makeText(this, "The number is very close ", Toast.LENGTH_LONG).show();
            } else if (number1 > number2) {

                Toast.makeText(this, "Your number Smaller than Random ", Toast.LENGTH_LONG).show();
            } else if (number1 < number2) {

                Toast.makeText(this, "Your number bigger than random  ", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "You win", Toast.LENGTH_LONG).show();
                try_again_button.setVisibility(View.VISIBLE);
            }
            txt.setText("");
        }
    }
    public void Playagain(View view) {
        randomnumber();
        txt_win.setVisibility(View.INVISIBLE);
        try_again_button.setVisibility(View.INVISIBLE);
    }

}