package edu.fullerton.cpsc544.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DiceRoller extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button myButton = (Button) findViewById(R.roll.button);
		myButton.setOnClickListener(this);
		updateRoll();
	}

	public void onClick(View src) {
		updateRoll();
	}

	protected void updateRoll() {
		TextView tv = (TextView) findViewById(R.text.text);
		int userDie1 = (int) (Math.random() * 6 + 1);
		int userDie2 = (int) (Math.random() * 6 + 1);
		int computerDie1 = (int) (Math.random() * 6 + 1);
		int computerDie2 = (int) (Math.random() * 6 + 1);
		tv.setText("You rolled " + userDie1 + " and " + userDie2 + "\n"
				+ "Computer rolled " + computerDie1 + " and " + computerDie2);
	}
}