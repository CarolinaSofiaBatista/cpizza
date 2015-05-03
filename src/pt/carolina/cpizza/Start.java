package pt.carolina.cpizza;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Start extends Applet implements MouseListener{

	int xpos = 0; 
	int ypos = 0;

	public void init() {
		addMouseListener(this);
	}

	public void start() {
		System.out.println("Starting...");
	}

	public void stop() {
		System.out.println("Stoping...");
	}

	public void paint(Graphics g) {        
		g.drawRect(0, 10, 100, 50);
		g.fillArc(100/2-25/2, 35-25/2, 25, 25, 0, 360);
		g.drawRect(120, 10, 100, 50);
		g.fillArc(100/2-35/2+120, 35-35/2, 35, 35, 0, 360);
		g.drawRect(240, 10, 100, 50);
		g.fillArc(100/2-45/2+240, 35-45/2, 45, 45, 0, 360);
		g.setColor(Color.red);         
		g.drawString("Welcome to SuperPizza!",10,150);  
		
		g.drawString("(" + xpos + "," + ypos + ")", xpos, ypos);
//		System.out.println("(" + xpos + "," + ypos + ")");

//		Define as dimensões q queres para dps adicionar verificar se o clique foi dentro do quadrado
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		xpos = e.getX(); 
		ypos = e.getY();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
