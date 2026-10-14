package com.mario.persos;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.jeu.Main;
import com.mario.obj.Objet;

public class Personnage {
	
	private int width, height;		//dimensions du personnage
	private int x, y;		//position du personnage
	protected boolean toRight;		//vrai si le personnage est tourne vers la droite
	protected boolean go;		//le personnage marche ou pas
	public int cpt;		//compteur des pas du personnage
	protected boolean alive; 		//etat de mario relativement au contact avec un autre personnage
	
	
	public Personnage(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.go = false;
		this.toRight = true;
		this.alive = true;
	}

	//Getters
	public int getWidth() {return width;}
	
	public int getHeight() {return height;}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public boolean isToRight() {return toRight;}
	
	public boolean isGo() {return go;}
	
	public int getCpt() {return cpt;}
	
	public boolean isAlive() {return alive;}


	//Setters
	public void setX(int x) {this.x = x;}
	
	public void setY(int y) {this.y = y;}
	
	public void setToRight(boolean toRight) {this.toRight = toRight;}
	
	public void setGo(boolean go) {this.go = go;}
	
	public void setCpt(int cpt) {this.cpt = cpt;}
	
	public void setAlive(boolean alive) {this.alive = alive;}
	
	//Methodes
	
	public Image marche(String nom, int freq) {
		
		String str;
		ImageIcon Ico;
		Image Img = null;
		
		if(this.go == false) {
			if(this.toRight == true) {
				str = "/images/" + nom + "Start.png";
			}else {
				str = "/images/" + nom + "Go.png";
			}
		}else {
			this.cpt++;
			if(this.cpt / freq == 0) {
				if(this.toRight == true) {
					str = "/images/" + nom + "Start.png";
				}else {
					str = "/images/" + nom + "Go.png";
				}
			}else {
				if(this.toRight == true) {
					str = "/images/" + nom + "CourtDroite.png";
				}else {
					str = "/images/" + nom + "CourtGauche.png";
				}
			}
			if(this.cpt == 2*freq) {
				this.cpt = 0;
			}
		}
		
		//aaffichage de l'image du personnage
		
		Ico = new ImageIcon(getClass().getResource(str));
		Img = Ico.getImage();
		return Img;
	}
	
	public void move() {
		if(Main.scene.getAbs() >= 0) {
			this.x = this.x - Main.scene.getDx();
		}
	}
	
	protected boolean contactAvant(Objet obj) {
		
		if(this.x + this.width < obj.getX() || this.x + this.width > obj.getX() + 5 || this.y + this.height <= obj.getY() || this.y >= obj.getY() + obj.getHeight()) {
			return false;
		}else {
			return true;
		}
		
	}
	
	protected boolean contactArriere(Objet obj) {
		
		if(this.x > obj.getX() + obj.getWidth() || this.x + this.width < obj.getX()	+ obj.getWidth() - 5 || this.y + this.height <= obj.getY() || this.y >= obj.getY() + obj.getHeight()) {
			return false;
		}else {
			return true;
		}
		
	}
	
	protected boolean contactDessous(Objet obj) {
		//detection contact en dessous du perso
		if(this.x + this.width < obj.getX() + 5 || this.x > obj.getX() + obj.getWidth() - 5 || this.y + this.height < obj.getY() || this.y + this.height > obj.getY() + 5) {
			return false;
		}else {
			return true;
		}
		
	}
	
	protected boolean contactDessus(Objet obj) {
		//detection contact au dessus du perso
		if(this.x + this.width < obj.getX() + 5 || this.x > obj.getX() + obj.getWidth() - 5 || this.y < obj.getY() + obj.getHeight() || this.y > obj.getY() + obj.getHeight() + 5) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public boolean near(Objet o) {
		if((this.x > o.getX() - 10 && this.x < o.getX() + o.getWidth() + 10) || (this.x + this.width > o.getX() - 10 && this.x + this.width < o.getX() + o.getWidth() + 10)) {
			return true;
		}else {
			return false;
		}
	}
	
	protected boolean contactAvant(Personnage perso) {
		
		if(this.x + this.width < perso.getX() || this.x + this.width > perso.getX() + 5 || this.y + this.height <= perso.getY() || this.y >= perso.getY() + perso.getHeight()) {
			return false;
		}else {
			return true;
		}
		
	}
	
	protected boolean contactArriere(Personnage perso) {
		
		if(this.x > perso.getX() + perso.getWidth() || this.x + this.width < perso.getX()	+ perso.getWidth() - 5 || this.y + this.height <= perso.getY() || this.y >= perso.getY() + perso.getHeight()) {
			return false;
		}else {
			return true;
		}
		
	}
	
	protected boolean contactDessous(Personnage perso) {
		//detection contact en dessous du perso
		if(this.x + this.width < perso.getX() + 5 || this.x > perso.getX() + perso.getWidth() - 5 || this.y + this.height < perso.getY() || this.y + this.height > perso.getY() + 5) {
			return false;
		}else {
			return true;
		}
		
	}
	
	protected boolean contactDessus(Personnage perso) {
		//detection contact au dessus du perso
		if(this.x + this.width < perso.getX() + 5 || this.x > perso.getX() + perso.getWidth() - 5 || this.y < perso.getY() + perso.getHeight() || this.y > perso.getY() + perso.getHeight() + 5) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public boolean near(Personnage perso) {
		if((this.x > perso.getX() - 10 && this.x < perso.getX() + perso.getWidth() + 10) || (this.x + this.width > perso.getX() - 10 && this.x + this.width < perso.getX() + perso.getWidth() + 10)) {
			return true;
		}else {
			return false;
		}
	}
	
}
