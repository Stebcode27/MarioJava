package com.mario.persos;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.mario.jeu.Main;
import com.mario.obj.Objet;
import com.mario.obj.Piece;

public class Mario extends Personnage{

	private Image ImgMario;
	private ImageIcon IcoMario;
	private boolean jump; //true si mario saute
	private int cptJump; //duree et hauteur du saut
	
	public Mario(int x, int y) {
		super(x, y, 55, 76);
		
		this.IcoMario = new ImageIcon(getClass().getResource("/images/marioStart.png"));
		this.ImgMario = this.IcoMario.getImage();
	}

	
	//Getters
	public Image getImageMario() {return ImgMario;}
	public boolean isJump() {return jump;}
	
	//Setters
	public void setJump(boolean jump) {this.jump = jump;}
	
	//Methodes
	public Image jump() {
		
		ImageIcon ico;
		Image img;
		String str;
		
		this.cptJump++;
		
		//Montee de Mario
		if(this.cptJump <= 40) {
			if(this.getY() > Main.scene.getHauteurPlafond()){
				this.setY(this.getY() - 8);
			}else {
				this.cptJump = 46;
			}
			if(this.isToRight() == true) {
				str = "/images/marioFly.png";
			}else {
				str = "/images/marioFly1.png";
			}
		//Retombee du saut
		}else if(this.getY() + this.getHeight() < Main.scene.getySol()) {
			this.setY(this.getY() + 3);
			if(this.isToRight() == true) {
				str = "/images/marioFly.png";
			}else {
				str = "/images/marioFly1.png";
			}
		//Fin du saut
		}else {
			if(this.isToRight() == true) {
				str = "/images/marioStart.png";
			}else {
				str = "/images/marioGo.png";
			}
			this.jump = false;
			this.cptJump = 0;
		}
		
		//affichage de l'image de mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
	public void contact(Objet obj) {
		
		//contact horizontal
		if((super.contactAvant(obj) == true && this.isToRight() == true) || (super.contactArriere(obj) == true && this.isToRight() == false)) {
			Main.scene.setDx(0);
			this.setGo(false);
		}
		
		//contact avec un objet en dessous
		if(super.contactDessous(obj) == true && this.jump == true) {	//mario saute sur un objet
			Main.scene.setySol(obj.getY());
		}else if(super.contactDessous(obj) == false){	//mario tombe sur le sol
			Main.scene.setySol(430);
			if(this.jump == false) {this.setY(379);}
		}
		
		//contact avec un objet au dessus
		if(super.contactDessus(obj) == true) {
			Main.scene.setHauteurPlafond(obj.getY() + obj.getHeight());
		}else if(super.contactDessus(obj) == false && this.jump == false){
			Main.scene.setHauteurPlafond(0);
		}
	}
	
	public boolean contactPiece(Piece pie) {
		if(this.contactArriere(pie)==true || this.contactAvant(pie)==true || this.contactDessous(pie)==true || this.contactDessus(pie)==true) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Image marche(String nom, int freq) {
		
		String str;
		ImageIcon Ico;
		Image Img = null;
		
		if(this.go == false || Main.scene.getAbs() <= 0 || Main.scene.getAbs() > 4990) {
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
	
	public void contact(Personnage perso) {
		if((super.contactAvant(perso)==true) || super.contactArriere(perso)==true) {
			this.setGo(false);
			this.setAlive(false);
		}else if(super.contactDessous(perso)==true) {
			perso.setGo(false);
			perso.setAlive(false);
		}
	}
	
}
