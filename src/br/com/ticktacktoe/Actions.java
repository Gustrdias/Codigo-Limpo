package br.com.ticktacktoe;

public class Actions {
	
	private int player;
	private String marked;
	private boolean endGame;
	
	
	public Actions() {
		this.setPlayer(1);
		this.setMarked("X");
		this.setEndGame(false);
	}
	public void nextTurn() {
		changePlayer();
		changeMarked();
	}
	public void changePlayer() {
		if(this.getPlayer() == 1)
			this.setPlayer(2);
		else
			this.setPlayer(1);
	}
	public void changeMarked() {
		if(this.getMarked()== "X")
			this.setMarked("O");
		else
			this.setMarked("X");
	}
	public void loopGame() {
		Board board=new Board();
		Keyboard keyboard=new Keyboard();
		Validate validateActions= new Validate();
		Check check= new Check();
		board.initPlays();
		board.createMold();
		board.PrintMold();
		
		while (!isEndGame()) {
			keyboard.rowChoice(this.getPlayer());
			keyboard.columnChoice();
			
			if(validateActions.isValid(keyboard.getRow(),keyboard.getColumn(),board)) {
				board.changeValueMold(keyboard.getRow(),keyboard.getColumn(),this.getMarked());
				board.createMold();
				board.PrintMold();
				check.isWinner(board,this);
				check.isTied(board,this);
				this.nextTurn();
			}else {
				System.out.println("Jogada Inválida, digite novamente!");
			}
		}
		keyboard.closeScanner();
	}
	
	public boolean isEndGame() {
		return endGame;
	}
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public String getMarked() {
		return marked;
	}
	public void setMarked(String marked) {
		this.marked = marked;
	}
	
}
