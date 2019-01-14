package unit;

import java.util.Random;

import util.RulletteConstant;

public class BoardBall {

	private volatile EBallState state;
	private int dockNumber = -1;

	public BoardBall() {
		this.state = EBallState.INIT;
	}

	public void roll() {
		Random rand = new Random();
		this.dockNumber = rand.nextInt(RulletteConstant.FILDNUMBER);
		this.state = EBallState.DOCKED;
	}

	public EBallState getState() {
		return state;
	}

	public int getDockNumber() {
		return dockNumber;
	}

}
