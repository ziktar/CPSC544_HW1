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
		int playerDie1 = (int) (Math.random() * 6 + 1);
		int playerDie2 = (int) (Math.random() * 6 + 1);
		int computerDie1 = (int) (Math.random() * 6 + 1);
		int computerDie2 = (int) (Math.random() * 6 + 1);
		int result = (playerDie1 + playerDie2) - (computerDie1 + computerDie2);
		TextView tv = (TextView) findViewById(R.computer.dice);
		tv.setText(computerDie1 + " and " + computerDie2);
		tv = (TextView) findViewById(R.computer.sum);
		tv.setText("" + (computerDie1 + computerDie2)
				+ (result > 0 ? "" : result == 0 ? " (tie)" : " (win)"));
		tv = (TextView) findViewById(R.player.dice);
		tv.setText(playerDie1 + " and " + playerDie2);
		tv = (TextView) findViewById(R.player.sum);
		tv.setText("" + (playerDie1 + playerDie2)
				+ (result < 0 ? "" : result == 0 ? " (tie)" : " (win)"));
	}
}