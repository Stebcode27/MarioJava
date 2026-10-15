package com.mario.jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mario.affichage.CompteARebour;
import com.mario.affichage.Score;
import com.mario.obj.Bloc;
import com.mario.obj.Objet;
import com.mario.obj.Piece;
import com.mario.obj.Tuyau;
import com.mario.persos.Champi;
import com.mario.persos.Mario;

@SuppressWarnings("serial")
public class Scene extends JPanel{
	
	//champs
	private ImageIcon IcoFond;
	private Image ImgFond;
	private Image ImgFond1;
	
	private ImageIcon ChateauIco;
	private Image ChateauImg;
	
	private int xFond1;
	private int xFond2;
	private int dx;
	private int abs;
	private int ySol;
	private int hauteurPlafond;
	
	public Mario mario;
	public Champi champi;
	
	public Tuyau tuyau1;
	public Tuyau tuyau2;
	public Tuyau tuyau3;
	public Tuyau tuyau4;
	public Tuyau tuyau5;
	public Tuyau tuyau6;
	public Tuyau tuyau7;
	public Tuyau tuyau8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	
	public Champi champi1;
	public Champi champi2;
	public Champi champi3;

	private ImageIcon IcoChateauFin;
	private Image ImgChateauFin;
	
	private ArrayList<Objet> listElements;
	private ArrayList<Piece> listBonus;
	private ArrayList<Champi> listChampi;
	
	private Score score;
	private Font police;
	
	private CompteARebour compte_a_rebour;
	
	//constructeur
	public Scene()
	{
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 830;
		this.dx = 0;
		this.abs = -1;
		this.ySol = 430;
		this.hauteurPlafond = 0;
		
		IcoFond = new ImageIcon(getClass().getResource("/images/font1.png"));
		this.ImgFond = this.IcoFond.getImage();
		this.ImgFond1 = this.IcoFond.getImage();
		
		ChateauIco = new ImageIcon(getClass().getResource("/images/chateau.png"));
		this.ChateauImg = this.ChateauIco.getImage();
		
		mario = new Mario(270, 379);
		
		tuyau1 = new Tuyau(555, 365);
		tuyau2 = new Tuyau(1190, 365);
		tuyau3 = new Tuyau(1600, 365);
		tuyau4 = new Tuyau(1850, 365);
		tuyau5 = new Tuyau(2500, 365);
		tuyau6 = new Tuyau(3200, 365);
		tuyau7 = new Tuyau(4000, 365);
		tuyau8 = new Tuyau(5000, 365);
		
		piece1 = new Piece(806, 120);
		piece2 = new Piece(1006, 220);
		piece3 = new Piece(1306, 220);
		piece4 = new Piece(1756, 240);
		piece5 = new Piece(1996, 250);
		piece6 = new Piece(2206, 290);
		piece7 = new Piece(2956, 350);
		piece8 = new Piece(3706, 190);
		piece9 = new Piece(4106, 195);
		piece10 = new Piece(4506, 220);
		
		bloc1 = new Bloc(800, 150);
		bloc2 = new Bloc(1000, 250);
		bloc3 = new Bloc(1300, 250);
		bloc4 = new Bloc(1750, 270);
		bloc5 = new Bloc(1990, 280);
		bloc6 = new Bloc(2200, 320);
		bloc7 = new Bloc(2950, 380);
		bloc8 = new Bloc(3700, 220);
		bloc9 = new Bloc(4100, 225);
		bloc10 = new Bloc(4500, 250);

		champi = new Champi(850, 429);
		champi1 = new Champi(2000, 429);
		champi2 = new Champi(3000, 429);
		champi3 = new Champi(4000, 429);
		
		IcoChateauFin = new ImageIcon(getClass().getResource("/images/chateau.png"));
		this.ImgChateauFin = this.IcoChateauFin.getImage();
		
		listElements = new ArrayList<Objet> ();
		listBonus = new ArrayList<Piece> ();
		listChampi = new ArrayList<Champi> ();
		
		listElements.add(this.tuyau1);
		listElements.add(this.tuyau2);
		listElements.add(this.tuyau3);
		listElements.add(this.tuyau4);
		listElements.add(this.tuyau5);
		listElements.add(this.tuyau6);
		listElements.add(this.tuyau7);
		listElements.add(this.tuyau8);
		
		listElements.add(this.bloc1);
		listElements.add(this.bloc2);
		listElements.add(this.bloc3);
		listElements.add(this.bloc4);
		listElements.add(this.bloc5);
		listElements.add(this.bloc6);
		listElements.add(this.bloc7);
		listElements.add(this.bloc8);
		listElements.add(this.bloc9);
		listElements.add(this.bloc10);
		
		listBonus.add(this.piece1);
		listBonus.add(this.piece2);
		listBonus.add(this.piece3);
		listBonus.add(this.piece4);
		listBonus.add(this.piece5);
		listBonus.add(this.piece6);
		listBonus.add(this.piece7);
		listBonus.add(this.piece8);
		listBonus.add(this.piece9);
		listBonus.add(this.piece10);

		listChampi.add(this.champi);
		listChampi.add(this.champi1);
		listChampi.add(this.champi2);
		listChampi.add(this.champi3);
		score = new Score();
		
		police = new Font("consolas", Font.PLAIN, 14);
		
		compte_a_rebour = new CompteARebour();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
	}

	//Getters
	public int getDx() {return dx;}
	public int getAbs() {return abs;}
	public int getxFond1() {return xFond1;}
	public int getxFond2() {return xFond2;}
	public int getySol() {return ySol;}
	public int getHauteurPlafond() {return hauteurPlafond;}

	//Setters
	public void setDx(int dx) {this.dx = dx;}
	public void setAbs(int abs) {this.abs = abs;}
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}
	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}
	public void setySol(int ySol) {this.ySol = ySol;}
	public void setHauteurPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	//mathodes
	public void deplacementFond()
	{
		if(this.abs >= 0 && this.abs <= 4990) {
			this.abs = this.abs + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
		
		if(this.xFond1 == -880) {
			this.xFond1 = 880;
		}else if(xFond2 == -880) {
			this.xFond2 = 880;
		}else if(xFond1 == 880) {
			this.xFond1 = -880;
		}else if(xFond2 == 880) {
			this.xFond2 = -880;
		}
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		//detection du contact avec objet
		for(int i=0; i<this.listElements.size(); i++) {
			if(this.mario.near(this.listElements.get(i))) this.mario.contact(this.listElements.get(i));
			for(Champi c : listChampi) {
				if(c.near(this.listElements.get(i))) c.contact(this.listElements.get(i));
			}
		}
		
		//detection piece
		for(int i=0;i<this.listBonus.size();i++) {
			if(this.mario.near(this.listBonus.get(i))) {
				if(this.mario.contactPiece(this.listBonus.get(i))) {
					this.listBonus.remove(i);
					this.score.setNbre_pieces(this.score.getNbre_pieces() + 1);
				}
			}
		}
		
		for(Champi c : listChampi) {
			if(this.mario.near(c)) {this.mario.contact(c);}
		}
		
		this.deplacementFond();
		if(this.abs >=0 && this.abs <= 4990) {
			for(int i=0;i<this.listElements.size(); i++) this.listElements.get(i).move();
			for(int i=0; i<this.listBonus.size(); i++) this.listBonus.get(i).move();
			for(Champi c : listChampi) {
				c.move();
			}
		}
		
		g2.drawImage(this.ImgFond, this.xFond1, 0, null);  //dessin de l'image de fond
		g2.drawImage(this.ImgFond1, this.xFond2, 0, null);
		g2.drawImage(ChateauImg, 50 - this.abs, 198, null);

		for(int i=0; i<this.listElements.size(); i++) {
			g2.drawImage(this.listElements.get(i).getImgObjet(), this.listElements.get(i).getX(), this.listElements.get(i).getY(), null);
		}
		for(int i=0; i<listBonus.size(); i++) {
			g2.drawImage(this.listBonus.get(i).bouge(), this.listBonus.get(i).getX(), this.listBonus.get(i).getY(), null);
		}
		g2.drawImage(ImgChateauFin, 5500 - this.abs, 198, null);
		
		if(this.mario.isJump()) {
			g2.drawImage(this.mario.jump(), this.mario.getX(), this.mario.getY(), null);
		}else {
			g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
		}
		
		for(Champi c : listChampi) {
			if(c.isAlive()) {
				g2.drawImage(c.getImgChampi(), c.getX(), c.getY(), null);
			}else {
				g2.drawImage(c.die(), c.getX(), c.getY(), null);
			}
		}
		
		g2.setFont(police);
		g2.drawString(this.score.getNbre_pieces() + " pièces trouvée(s) sur " + this.score.getNBRE_TOTAL_PIECES(), 600, 30);
		g2.drawString(this.compte_a_rebour.getStr(), 5, 30);
	}
}
