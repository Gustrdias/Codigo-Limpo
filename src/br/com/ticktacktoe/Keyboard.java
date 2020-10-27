package br.com.ticktacktoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Keyboard {
	private Scanner scanner = new Scanner(System.in);
	private int row;
	private int column;
	
	public void rowChoice(int currentPlayer) {
		System.out.println("Jogador " + currentPlayer + " digite a posi��o (linha): ");
		try {
			this.row = this.scanner.nextInt();
		}catch(InputMismatchException notInteger) {
			System.out.println("Voc� digitou um valor inv�lido");
			rowChoice(currentPlayer);
		}
		
	}
	public void columnChoice() {
		System.out.println("Agora digite a posi��o (coluna): ");
		try {
			this.column =this.scanner.nextInt();
		}catch(InputMismatchException notInteger) {
			System.out.println("Voc� digitou um valor inv�lido");
			columnChoice();
		}
		
	}
	public void closeScanner() {
		this.scanner.close();
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
}
