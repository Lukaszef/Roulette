package unit;

public class Player {

	private String nick;
	private int budgete;

	public Player(String nick, int budgete) {
		super();
		this.nick = nick;
		this.budgete = budgete;
	}

	public String getNick() {
		return nick;
	}

	public int getBudgete() {
		return budgete;
	}

	public void increaseSaldo(int winning) {
		this.budgete += winning;

	}

	@Override
	public String toString() {
		return "Player [nick=" + nick + ", budgete=" + budgete + "]";
	}

}
