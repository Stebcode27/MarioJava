package com.mario.obj;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Objet implements Runnable{
	
	private int cpt;
	private final int PAUSE=15;

	public Piece(int x, int y) {
		super(x, y, 26, 25);
		
		super.icoObjet = new ImageIcon(getClass().getResource("/images/piece.png"));
		super.imgObjet = this.icoObjet.getImage();
	}
	
	public Image bouge() {
		String str;
		ImageIcon ico;
		Image img;
		
		this.cpt++;
		
		if(this.cpt / 100 == 0) str = "/images/piece.png";
		else str = "/images/piece2.png";
		if(this.cpt == 200) this.cpt = 0;
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

	@Override
	public void run() {
		try {Thread.sleep(20);}
		catch(InterruptedException e) {}
		
		while(true) {
			this.bouge();
			
			try {Thread.sleep(this.PAUSE);}
			catch(InterruptedException e) {}
		}
	}
}
