package firsttry;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;

import sun.audio.*;

public class MyCanvas extends Canvas implements KeyListener {
	private static final boolean Faceright = false;
	//global variables
	Goodguy samurai = new Goodguy(10,100,30,50,"images/naruto.png");
	GameCharacter2 ryuchar = new GameCharacter2(1400,100,30,50,"images/ryu1.png");
	LinkedList Mybadguys = new LinkedList();
	LinkedList Mybullets = new LinkedList();
	LinkedList MyHadouken = new LinkedList();
	int hpn = 100;
	int hpr = 100;
	int score1 = 0;
	int score2 = 0;
	int xhp = samurai.getxCoord() + samurai.getWidth()/2;
	int yhp = samurai.getyCoord() + samurai.getHeight();
	Font myFont = new Font ("Arial", 1, 50);
	Font Font1 = new Font ("Arial", 1, 250);
	
	
	
	//construter
	public MyCanvas() {
		this.setSize(1440,900);
		this.addKeyListener(this);
		playIt("images/pirates.wav");
		
		Random rand = new Random();
		int winwidth = this.getWidth();
		int winheight = this.getHeight();
		for (int i = 0; i < 10; i++) {
			badguyone bg = new badguyone(rand.nextInt(winwidth), rand.nextInt(winheight), 50, 50, "images/monster2.png");
			Rectangle r = new Rectangle(100,100,30,30);
			if (r.contains(samurai.getxCoord(),samurai.getyCoord())) {
				System.out.println("badguy on top of naruto");
				continue;
			}
			Mybadguys.add(bg);
		  }
		}
	 
	//@override
	public void paint (Graphics g) {
		//g.fillOval(100, 100, 10, 10);
		
		Image img = Toolkit.getDefaultToolkit().getImage("images/bckimage.jpg");
		g.drawImage(img,0,0,1440,900,this);
		g.drawImage(samurai.getImg(), samurai.getxCoord(), samurai.getyCoord(), samurai.getWidth(), samurai.getHeight(),  this);
		g.drawImage(ryuchar.getImg(), ryuchar.getxCoord(), ryuchar.getyCoord(), ryuchar.getWidth(), ryuchar.getHeight(),  this);
		
		if(hpn == 0) {
			g.setFont(Font1);
			g.setColor(Color.white);
			g.drawString("Game Over", 50, 500);
		}
		
		if(hpr == 0) {
			g.setFont(Font1);
			g.setColor(Color.white);
			g.drawString("Game Over", 50, 500);
		}
		
		g.setFont(myFont);
		g.setColor(Color.white);
		g.drawString("HP:" + hpn, 10, 50);
		g.drawString("HP:" + hpr, 1250, 50);
		
		g.drawRect(10, 60, 100, 30);
		g.setColor(Color.yellow);
		g.fillRect(10, 60, 100, 30);
		
		g.drawRect(1350, 60, 100, 30);
		g.setColor(Color.yellow);
		g.fillRect(1350, 60, 100, 30);
		
		g.drawString(" " + score1, 10, 800);
		g.setColor(Color.white);
		
		g.drawString(" " + score2, 900, 800);
		g.setColor(Color.white);
		
		
		
		//setting hit box for bad guys and projectile
		for(int i = 0; i < Mybadguys.size(); i++) {
			badguyone bg = (badguyone) Mybadguys.get(i);
			Rectangle kr = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(), bg.getHeight());
			Rectangle s = new Rectangle(ryuchar.getxCoord(), ryuchar.getyCoord(), ryuchar.getWidth(), ryuchar.getHeight());
			Rectangle a = new Rectangle(samurai.getxCoord(), samurai.getyCoord(), samurai.getWidth(), samurai.getHeight());
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			//bullets hitting badguys makes it disappear
			for (int j = 0; j < Mybullets.size(); j++) {
				Projectile1 b = (Projectile1) Mybullets.get(j);
				if (b.getxCoord() > this.getWidth()) { Mybullets.remove(b); }
				if (Goodguy.FaceRight == true) {
					b.setxCoord(b.getxCoord() + 1);
				} else {
					b.setxCoord(b.getxCoord() - 1);
				}
				g.drawImage(b.getImg(), b.getxCoord(), b.getyCoord(), b.getWidth(), b.getHeight(), this);
				
				Rectangle bp = new Rectangle(b.getxCoord(),b.getyCoord(),b.getWidth(), b.getHeight());
				if(bp.intersects(kr)) {
					Mybadguys.remove(bg);
					Mybullets.remove(j);
					System.out.println("badguy hit by projectile from naruto");
					playIt("images/punch.wav");
					if (hpn <= 97) {
						hpn = hpn + 3;
					}else {
						hpn = 100;
					}
					score1 = score1 + 1; 
			}	
				
				if(bp.intersects(s)) {
					Mybullets.remove(j);
					if(hpr < 20) {
						hpr = 0;
					} else {
						hpr = hpr - 20;
					}
				}
				
		repaint();
			}
			
			for (int j = 0; j < MyHadouken.size(); j++) {
				Projectile1 b = (Projectile1) MyHadouken.get(j);
				if (b.getxCoord() > this.getWidth()) { MyHadouken.remove(b); }
				if (GameCharacter2.FaceRight1 == true) {
					b.setxCoord(b.getxCoord() + 1);
				} else {
					b.setxCoord(b.getxCoord() - 1);
				}
				g.drawImage(b.getImg(), b.getxCoord(), b.getyCoord(), b.getWidth(), b.getHeight(), this);
				
				Rectangle bp = new Rectangle(b.getxCoord(),b.getyCoord(),b.getWidth(), b.getHeight());
				if(bp.intersects(kr)) {
					Mybadguys.remove(bg);
					MyHadouken.remove(j);
					System.out.println("badguy hit by projectile from ryu");
					playIt("images/punch.wav");
					if (hpr <= 97) {
						hpr = hpr + 3;
					}else {
						hpr = 100;
					}
					score2 = score2 + 1;
			}
				if(bp.intersects(a)) {
					MyHadouken.remove(j);
					if(hpn < 20) {
						hpn = 0;
					} else {
						hpn = hpn - 20;
					}
				}
				if(hpn == 0) {
					g.setFont(Font1);
					g.setColor(Color.white);
					g.drawString("Game Over", 50, 500);
					samurai.remove(a);
				}
				
				if(hpr == 0) {
					g.setFont(Font1);
					g.setColor(Color.white);
					g.drawString("Game Over", 50, 500);
					ryuchar.remove(a);
				}
				
				
				
				repaint();
			}	
		}
	}

	public void keyPressed(KeyEvent e) {
		
		System.out.println(e);
		
		
		if (e.getKeyCode() == 32) {
			
			Projectile1 bullet = new Projectile1(samurai.getxCoord(), samurai.getyCoord(),50,50,"images/Lshuriken.png");
			Mybullets.add(bullet);
			playIt("images/gun.wav");
		}
		
		if (e.getKeyCode() == 70) {
			Projectile1 hadouken = new Projectile1(ryuchar.getxCoord(), ryuchar.getyCoord(),50,50,"images/hadouken1.png");
			MyHadouken.add(hadouken);
			playIt("images/gun.wav");
		}
		//naruto hitting badguy
		samurai.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());
		
	//	for (int j = 0; j < MyHadouken.size(); j++) {
	//		Projectile1 bo = (Projectile1) MyHadouken.get(j);
		for (int b = 0; b < Mybadguys.size(); b++) {
			badguyone bg = (badguyone) Mybadguys.get(b);
			Rectangle s = new Rectangle(samurai.getxCoord(), samurai.getyCoord(), samurai.getWidth(), samurai.getHeight());
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
	//		Rectangle bs = new Rectangle(bo.getxCoord(),bo.getyCoord(),bo.getWidth(), bo.getHeight());
		
			if (s.intersects(r)) {
				System.out.println("badguy hit by naruto");
				Mybadguys.remove(b);
				playIt("images/punch.wav");
				hpn = hpn - 5;
				score1 = score1 - 1;
				
			}
	//		if (s.intersects(bs)) {
	//			System.out.println("naruto hit by ryu projectile");
	//			MyHadouken.remove(bo);
	//			playIt("images/punch.wav");
	//			hpn = hpn - 5;
				
	//		}

			
		}
		//ryu hitting badguy
		ryuchar.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());	
		//for (int g = 0; g < Mybullets.size(); g++) {
			//Projectile1 m = (Projectile1) Mybullets.get(g);
		for (int b = 0; b < Mybadguys.size(); b++) {
			badguyone bg = (badguyone) Mybadguys.get(b);
			Rectangle s = new Rectangle(ryuchar.getxCoord(), ryuchar.getyCoord(), ryuchar.getWidth(), ryuchar.getHeight());
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			//Rectangle bp = new Rectangle(m.getxCoord(),m.getyCoord(),m.getWidth(), m.getHeight());
			
			if (s.intersects(r)) {
				System.out.println("badguy hit by ryu");
				Mybadguys.remove(b);
				playIt("images/punch.wav");
				hpr = hpr - 5;
				score2 = score2 - 1;
			}
			
			//if (s.intersects(bp)) {
			//	System.out.println("ryu hit by naruto projectile");
			//	Mybullets.remove(bp);
			//	playIt("images/punch.wav");
			//	hpr = hpr - 20;
			//}
			
		}
		
		repaint();
	}	
		//}
//}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void playIt(String filename) {
		
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			System.out.println(e);
		}
	
	}
}