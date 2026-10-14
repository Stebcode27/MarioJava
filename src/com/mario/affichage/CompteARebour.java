package com.mario.affichage;

public class CompteARebour implements Runnable{
	
	public final int PAUSE = 1000;
	public int compteur;
	public String str;
	
	public CompteARebour() {
		this.compteur = 100;
		this.str = "Temps restant : 100 sec";
		
		Thread comptearebours = new Thread(this);
		comptearebours.start();
	}
	
	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			try {
				Thread.sleep(PAUSE);
			}catch(InterruptedException e) {}
			this.compteur--;
			this.str = "Temps restant : " + this.compteur + " sec";
		}
		
	}

}
