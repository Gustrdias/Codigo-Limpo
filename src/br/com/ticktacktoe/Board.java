package br.com.ticktacktoe;

import java.util.Arrays;

public class Board {
	public static int MAX_POSITIONS = 3;
	public static String EMPTY_POSITIONS = " ";
	private String plays[][]= new String[MAX_POSITIONS][MAX_POSITIONS];
	private String mold;
	
	public void initPlays() {
		for (String[] play : this.plays) {
		    Arrays.fill(play,EMPTY_POSITIONS);
		}
	}
	public void createMold(){ 
		this.mold = "    1   2   3";
		this.mold += "\n---------------\n";
		rowMold();
	}
	public void rowMold() {
		for (int row = 0; row < MAX_POSITIONS; row++) {
			this.mold += (row + 1) + " | ";
			columnMold(row);
			this.mold += "\n---------------\n";
		}
	}
	public void columnMold(int row) {
		for (int column = 0; column < MAX_POSITIONS; column++) {
			this.mold +=this.plays[row][column] + " | ";
		}
	}
	public void changeValueMold(int row,int column,String marked) {
		this.plays[row-1][column-1]= marked;
	}
	public void PrintMold(){
		try {
			System.out.println(mold);
		}catch(NullPointerException nullBoard) {
			createMold();
		}
	}
	public String[][] getPlays() {
		return this.plays;
	}
	public String getOnePlay(int row,int column) {
		return this.plays[row][column];
	}
	public void setPlays(String[][] plays) {
		this.plays = plays;
	}
	public String getMold() {
		return this.mold;
	}
	public void setMold(String mold) {
		this.mold = mold;
	}
	
}
