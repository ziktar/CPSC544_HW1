package edu.fullerton.cpsc544.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DiceRoller extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tv = new TextView(this);
        tv.setText("Hello, Android 2");
        setContentView(tv);
    }
}