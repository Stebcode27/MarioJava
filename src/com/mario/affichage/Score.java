package com.mario.affichage;

public class Score {
	
	private final int NBRE_TOTAL_PIECES = 10;
	
	private int nbre_pieces;
	
	public Score() {
		this.nbre_pieces = 0;
	}

	public int getNbre_pieces() {
		return nbre_pieces;
	}

	public void setNbre_pieces(int nbre_pieces) {
		this.nbre_pieces = nbre_pieces;
	}

	public int getNBRE_TOTAL_PIECES() {
		return NBRE_TOTAL_PIECES;
	}
	
}
