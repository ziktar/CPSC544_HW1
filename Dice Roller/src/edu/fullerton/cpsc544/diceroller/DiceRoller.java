package edu.fullerton.cpsc544.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DiceRoller extends Activity implements OnClickListener {
	private int[] playerDie = new int[2];
	private int[] computerDie = new int[2];
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
		rollDice();
		
		int result = computeWinner(getUserDieRollSum(), getComputerDieRollSum());
		
		TextView tv = (TextView) findViewById(R.computer.dice);
		tv.setText(getComputerDie(1) + " and " + getComputerDie(2));
		tv = (TextView) findViewById(R.computer.sum);
		tv.setText("" + (getComputerDieRollSum())
				+ (result > 0 ? "" : result == 0 ? " (tie)" : " (win)"));
		tv = (TextView) findViewById(R.player.dice);
		tv.setText(getUserDie(1) + " and " + getUserDie(2));
		tv = (TextView) findViewById(R.player.sum);
		tv.setText("" + (getUserDieRollSum())
				+ (result < 0 ? "" : result == 0 ? " (tie)" : " (win)"));
	}

	public void rollDice() {
		playerDie[0] = (int) (Math.random() * 6 + 1);
		playerDie[1] = (int) (Math.random() * 6 + 1);

		computerDie[0] = (int) (Math.random() * 6 + 1);
		computerDie[1] = (int) (Math.random() * 6 + 1);
	}

	public int getUserDie(int i) {
		return playerDie[i - 1];
	}

	public int getComputerDie(int i) {
		return computerDie[i - 1];
	}

	public int getUserDieRollSum() {
		return getUserDie(1) + getUserDie(2);
	}

	public int getComputerDieRollSum() {
		return getComputerDie(1) + getComputerDie(2);
	}

	public int computeWinner(int userSum, int computerSum) {
		int result = userSum - computerSum;
		return (result > 0 ? 1 : result < 0 ? -1 : 0);
	}
}