package unit;

public class Bet {

	private Board board;
	private BoardField[] fields;
	private Player player;
	private Play play;
	private EBetType betType;
	private int value;

	public Bet(Board board, Play play, Player player, BoardField[] fields, EBetType betType, int value)
			throws Exception {
		this.board = board;
		this.play = play;
		this.player = player;
		this.fields = fields;
		this.betType = betType;
		this.value = value;
		// check values count
		validateCount(betType, fields);
	}

	private void validateCount(EBetType betType, BoardField[] fields) throws Exception {
		// validate table count
		if (betType.getFieldsCount() != fields.length) {

			throw new Exception(
					"For defined bet " + betType + " value of fields equal " + fields.length + " is not proper");
		}
		// validate doubels
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields.length; j++) {
				if (fields[i] == fields[j] && i != j) {
					throw new Exception("Value  " + fields[j].toString() + " is doubled in bet ");
				}

			}
		}		
	}
	
	public Board getBoard() {
		return board;
	}

	public BoardField[] getFields() {
		return fields;
	}

	public Player getPlayer() {
		return player;
	}

	public Play getPlay() {
		return play;
	}

	public EBetType getBetType() {
		return betType;
	}

	public int getValue() {
		return value;
	}
}
