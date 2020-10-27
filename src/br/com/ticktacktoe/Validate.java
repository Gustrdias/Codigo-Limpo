package br.com.ticktacktoe;

public class Validate {

	public boolean rowValue(int row) {
		if(row-1 < Board.MAX_POSITIONS)
			return true;
		return false;
	}
	public boolean columnValue(int column) {
		if(column-1 < Board.MAX_POSITIONS)
			return true;
		return false;
	}
	public boolean positionCompleted(int row,int column,Board board) {
		if(board.getOnePlay(row-1, column-1).equals(" ")) {
			return false;
		}
		return true;
	}
	public boolean isValid(int row ,int column,Board board) {
		if(rowValue(row) && columnValue(column) && !positionCompleted(row, column, board))
			return true;
		return false;
	}
}
