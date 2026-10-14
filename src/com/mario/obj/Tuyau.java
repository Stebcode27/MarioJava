package com.mario.obj;

import javax.swing.ImageIcon;

public class Tuyau extends Objet{	
	
	public Tuyau(int x, int y) {
		
		super(x, y, 90, 57);
		super.icoObjet = new ImageIcon(getClass().getResource("/images/tuyau.png"));
		this.imgObjet = this.icoObjet.getImage();
	}

}
