package pt.carolina.cpizza;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Start extends Applet implements MouseListener, MouseMotionListener {
	int xpos = 0; 
	int ypos = 0;
	int pizzaSize = -1;

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
		g.drawRect(120, 10, 100, 50);
		g.drawRect(240, 10, 100, 50);
		g.setColor(Color.red);
		g.fillArc(100/2-25/2, 35-25/2, 25, 25, 0, 360);
		g.fillArc(100/2-35/2+120, 35-35/2, 35, 35, 0, 360);
		g.fillArc(100/2-45/2+240, 35-45/2, 45, 45, 0, 360);
		g.drawString("Welcome to SuperPizza!",10,150);  
//		g.drawString("(" + xpos + "," + ypos + ")", xpos, ypos);
		writePizzaSize(g, pizzaSize);
//		System.out.println("(" + xpos + "," + ypos + ")");

//		Define as dimensões q queres para dps adicionar verificar se o clique foi dentro do quadrado
	}
	
	private void writePizzaSize(Graphics g, int pizzaSize){
		if(pizzaSize == 0){
			g.drawString("Pizza S Selected", 10,200); 
		}else if(pizzaSize == 1){
			g.drawString("Pizza M Selected", 10,200);
		}else if(pizzaSize == 2){
			g.drawString("Pizza L Selected", 10,200);
		}else{
			g.drawString("", 10,200);
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse pressed...");
		
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		xpos = e.getX(); 
		ypos = e.getY();
		
		if(xpos < 100 && xpos > 0 && ypos < 60 && ypos > 10){
			pizzaSize = 0;
		}else{
			pizzaSize = -1;
		}
		repaint();
	} 

	
}
