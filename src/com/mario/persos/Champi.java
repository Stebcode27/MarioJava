package com.mario.persos;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.obj.Objet;

public class Champi extends Personnage implements Runnable{

	private ImageIcon icoChampi;
	private Image imgChampi;
	
	private final int PAUSE = 15;
	private int dxChampi;
	
	public Champi(int x, int y) {
		super(x, y, 30, 24);
		
		super.setToRight(true);
		super.setGo(true);
		
		this.icoChampi = new ImageIcon(getClass().getResource("/images/champi.png"));
		this.imgChampi = this.icoChampi.getImage();
		
		Thread chronoChamp = new Thread(this);
		chronoChamp.start();
	}

	public Image getImgChampi() {
		return imgChampi;
	}

	public void setImgChampi(Image imgChampi) {
		this.imgChampi = imgChampi;
	}

	public void bouge() {
		if(super.isToRight()) {this.dxChampi = 1;}
		else {this.dxChampi = -1;}
		super.setX(super.getX()+this.dxChampi);
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
	
	public void contact(Objet obj) {
			
			//contact horizontal
			if((super.contactAvant(obj) == true && this.isToRight() == true)) {
				this.dxChampi = -1;
				super.setToRight(false);
			}else if((super.contactArriere(obj) == true && this.isToRight() == false)) {
				super.setToRight(true);
				this.dxChampi = 1;
			}
	}
	
	public Image die() {
		String str;
		ImageIcon ico;
		Image img;
		
		this.dxChampi = 0;
		if(this.isToRight()==true) {str = "/images/champiMeurt.png";}
		else {str = "/images/champiMeurt.png";}
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		
		return img;
	}

}
