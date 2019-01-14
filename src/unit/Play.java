package unit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.PlayCalculate;

public class Play {

	private LocalDateTime playStart;
	private LocalDateTime playEnd;
	private Board board;

	private List<Player> players = new ArrayList<Player>();
	private ArrayList<Bet> bets = new ArrayList<Bet>();
	private Map<BoardField, ArrayList<Bet>> fieldBets = new HashMap<BoardField, ArrayList<Bet>>();
	private Map<Player, ArrayList<Bet>> playerBets = new HashMap<Player, ArrayList<Bet>>();

	public Play(Board board) {
		this.playStart = LocalDateTime.now();
		this.board = board;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public void addBet(Player player, BoardField[] fields, EBetType betType, int value) throws Exception {
		Bet bet = new Bet(this.board, this, player, fields, betType, value);
		bets.add(bet);
		// add bets per field
		for (BoardField boardField : fields) {
			if (fieldBets.get(boardField) == null) {
				fieldBets.put(boardField, new ArrayList<Bet>());
			}
			fieldBets.get(boardField).add(bet);
		}
		// add bets per player
		if (playerBets.get(player) == null) {
			playerBets.put(player, new ArrayList<Bet>());
		}
		playerBets.get(player).add(bet);
	}

	public void throwBall() {
		BoardBall ball = getBoard().getBall();
		ball.roll();
	}

	public void calculateScore() {
		PlayCalculate.calculateScore(this);
	}

	public Map<BoardField, ArrayList<Bet>> getFieldBets() {
		return fieldBets;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}

	public Map<Player, ArrayList<Bet>> getPlayerBets() {
		return playerBets;
	}

}