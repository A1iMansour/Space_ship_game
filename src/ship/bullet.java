package ship;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class bullet extends JPanel {
	int x=-100;
	int y;
	int prevy;
	int played=0;
	boolean eorp=true;//to choose the right image
	boolean notmissed=true;// to prevent blood from decreasing more than once from same bullet
	public bullet(int w, boolean t) {
		y=w;
		prevy=y;
		eorp=t;//enemy or player
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if(eorp) {
			Image img3 = new ImageIcon(getClass().getResource("/images/b2.png")).getImage();
		 	g2d.drawImage(img3,x, y, this);
		}
		else {
			Image img3 = new ImageIcon(getClass().getResource("/images/b.png")).getImage();
		 	g2d.drawImage(img3,x, y, this);
		}
	}
	public  void setx(int t) {//to prevent bullet from following ship
		if(x==-100) {
			x=t;
		}
	}
	public  void setx2nd(int t) {//to restart x
		
			x=t;
		
	}
	public  void sety(int t) {//to prevent bullet from following ship
		
			y=t;
		
	}
	public void move(int c) {
		if(eorp)
			y=y+c-Shoot.speed;
		else {
			if(y>=700)
				y=700;
			else
			y=y+c+Shoot.speed;
			
		}
	}
	public void movex(int c) {
		x=x+c+Shoot.speed;
		//System.out.println("this is x: "+x);/////////////////
	}
	public int getvisible() {
		if(y<=0) {
			x=-100;//to not follow plane see set x
			y=prevy;
			played=0;
			return 0;
			
		}
		else
			return 1;
	}
	public boolean getvisibleenemy(int e) {//for enemy/////////////////
		if(y>=700) {
			return true;
			
		}
		else
			return false;
	}
	public void playsound(int i) throws InterruptedException {
		if (played==0) {
		music s = new music();
		s.setFile(i);
		s.play();
		Thread.sleep(10);
		played =1;
		}
		
	}
	public void playsoundenemy(int i) throws InterruptedException {
		music s = new music();
		s.setFile(i);
		s.play();
		Thread.sleep(5);
		played =1;
	}
}
