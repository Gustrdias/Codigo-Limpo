package br.com.ticktacktoe;

public class Check {
	private int count;
	private boolean tied;
	private boolean winner;
	
	public Check() {
		this.setCount(0);
		this.setTied(false);
		this.setWinner(false);
	}
	public void isWinner(Board board,Actions actions) {
		this.rowIsWin(board,actions.getMarked());
		this.columnIsWin(board,actions.getMarked());
		this.leftDiagonalWin(board, actions.getMarked());
		this.rightDiagonalWin(board, actions.getMarked());
		if(this.isWinner()) {
			System.out.println("O jogador "+actions.getPlayer()+" ganhou!");
			actions.setEndGame(true);
		}
	}
	public void rowIsWin(Board board,String marked) {
		for (int row = 0; row < Board.MAX_POSITIONS; row++) {
			this.resetCount();
			this.walksColumn(board,marked,row);
			if(this.winPlayer())
				return;
		}
	}
	public void walksColumn(Board board,String marked,int row) {
		for (int column = 0; column < Board.MAX_POSITIONS; column++) {
		     if (board.getOnePlay(row, column) == marked) {
		    	 this.incrementCount();
		     }
		 }
	}
	public void columnIsWin(Board board,String marked) {
		if(this.isWinner())
			return;
        for (int column = 0; column < Board.MAX_POSITIONS; column++) {
        	this.resetCount();
        	this.walksRow(board,marked,column);
			if(winPlayer())
				return;
		}
	}
	public void walksRow(Board board,String marked,int column) {
		for (int row = 0; row < Board.MAX_POSITIONS; row++) {
		     if (board.getOnePlay(row, column) == marked) {
		    	 this.incrementCount();
		     }
		 }
	}
	public void incrementCount() {
		this.count++;
	}
	public void resetCount() {
		this.setCount(0);
	}
	public boolean winPlayer() {
		if (this.getCount() == Board.MAX_POSITIONS) {
			this.setWinner(true);
			return true;
		}
		return false;
	}
	public void rightDiagonalWin(Board board,String marked) {
		if(this.isWinner())
			return;
		this.resetCount();
		for(int diagonal=0;diagonal < Board.MAX_POSITIONS;diagonal++) {
			if (board.getOnePlay(diagonal,diagonal) == marked) {
				this.incrementCount();
			}
		}
		this.winPlayer();
	}
	public void leftDiagonalWin(Board board,String marked) {
		if(this.isWinner())
			return;
		this.resetCount();
		int posDiagonalColumn = Board.MAX_POSITIONS-1;
		for(int posDiagonalRow = 0; posDiagonalRow < Board.MAX_POSITIONS; posDiagonalRow++) {
			if(board.getOnePlay(posDiagonalRow,posDiagonalColumn) == marked){
				this.incrementCount();
			}
			posDiagonalColumn--; 
		}
		this.winPlayer();
	}
	
	public void isTied(Board board,Actions actions) {
		playsRow(board);
		if(this.isTied()) {
			System.out.println("O jogo terminou empatado!");
			actions.setEndGame(true);
		}
	}
	public void playsRow(Board board) {
		for (int row = 0; row < Board.MAX_POSITIONS; row++) {
			this.playsColumns(board, row);
		 }
	}
	public void playsColumns(Board board,int row) {
		for (int column = 0; column < Board.MAX_POSITIONS; column++) {
			this.isTied();
		}
	}
	public void isTied(Board board,int row,int column) {
		if (board.getOnePlay(row,column) == Board.EMPTY_POSITIONS) 
			this.setTied(true);	
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isTied() {
		return tied;
	}
	public void setTied(boolean tied) {
		this.tied = tied;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
}
