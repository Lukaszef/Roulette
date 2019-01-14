package unit;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<BoardField> fields = new ArrayList<BoardField>();
	private BoardBall ball;

	public BoardBall getBall() {
		return ball;
	}

	public Board() {
		this.ball = new BoardBall();
	}

	public void addFields(BoardField field) {
		fields.add(field);
	}

	public List<BoardField> getFields() {
		return fields;
	}

	public BoardField getFieldByRowPosition(int row, int column) {
		for (BoardField boardField : fields) {
			if (boardField.getRow() == row && boardField.getCol() == column)
				return boardField;
		}
		throw new RuntimeException("There is not fields [" + row + "," + column + "]");
	}

	public BoardField getFieldById(int fieldId) {
		for (BoardField boardField : fields) {
			if (boardField.getNumber() == fieldId)
				return boardField;
		}
		throw new RuntimeException("There is not fields [" + fieldId + "]");
	}

}
