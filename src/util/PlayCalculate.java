package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import unit.Bet;
import unit.BoardBall;
import unit.BoardField;
import unit.EBallState;
import unit.EBetType;
import unit.Play;
import unit.Player;

public class PlayCalculate {

	public static void calculateScore(Play play) {
		List<Player> players;
		int ballDock = -1;
		BoardBall ball = play.getBoard().getBall();
		// verify state
		if (ball.getState() != EBallState.DOCKED || ball.getDockNumber() == -1) {
			throw new RuntimeException("Incorrect state of ball");
		} else {
			ballDock = ball.getDockNumber();
		}
		// for each playeer
		players = play.getPlayers();
		for (Player player : players) {
			// for each bets of player
			ArrayList<Bet> bets = play.getPlayerBets().get(player);
			for (Bet bet : bets) {
				// check each fields
				ArrayList<BoardField> filds = new ArrayList<BoardField>(Arrays.asList(bet.getFields()));
				for (BoardField boardField : filds) {
					if (boardField.getNumber() == ballDock) {
						int winning = calculateWinning(bet.getValue(), bet.getBetType());
						player.increaseSaldo(winning);
						// go to next bet
						break;
					}
				}
			}
		}

	}

	private static int calculateWinning(int value, EBetType betType) {
		return betType.getMultiplier() * value + value;
	}
}
