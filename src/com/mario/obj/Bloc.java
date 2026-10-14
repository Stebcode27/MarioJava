package com.mario.obj;

import javax.swing.ImageIcon;

public class Bloc extends Objet{
	
	public Bloc(int x, int y) {
		
		super(x, y, 46, 38);
		super.icoObjet = new ImageIcon(getClass().getResource("/images/bloc.png"));
		super.imgObjet = this.icoObjet.getImage();
	}

}
