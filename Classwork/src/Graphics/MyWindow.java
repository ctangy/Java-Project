package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener {
	int width = 1000;
	int height = 1000;
	Hero tubs;
	Hero tubby;
	boolean itemPickedUp;

	BufferedImage landscape;
	
	public static void main(String[] args) {
		new MyWindow();

	}

	public MyWindow(){
			//the following are JFrame methods
		tubs = new Hero("tubs3","/images/Heroes/tubs3.png",100,200);
		tubby = new Hero("tubbs","/images/Heroes/tubbs.png",250,200);
		itemPickedUp = false;
		landscape = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 =(Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		
		setVisible(true);
		setSize(width,height);	//units in px
		setLocation(200,150);	//200px right, 150 px down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//static constant reference for special close operation
		addKeyListener(this);
		
	}

	public void paintLandscape(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics g){
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		
		g2.setColor(new Color(50,100,200));
		g2.fillRect(0, 0, width, height);
		
		g2.drawImage(landscape,0,0,null);
		
		
		if(Math.abs(tubby.getX()-tubs.getX()) + Math.abs(tubby.getY()-tubs.getY()) < 10)
			{
				itemPickedUp = true;
			}
		if(!itemPickedUp)g2.drawImage(tubs.getImage(),tubs.getX(),tubs.getY(),null);
			
		g2.drawImage(tubby.getImage(),tubby.getX(),tubby.getY(),null);
		
		
		
//			//Graphics is a crayon box
//			//Graphics2d is like an art kit
		
//		Graphics2D g2 = (Graphics2D)g;
//		g2.setColor(Color.white);
//		g2.fillRect(0, 0, width, height);
//		
//		//Ovals
//		
//		
//		//x,y,width,height,startDEG, lengthDEG
//		g2.drawArc(50, 300, 200, 100, 0, 60);	
//		g2.drawArc(150, 300, 200, 100, 0, -60);
//		
//		//String, x, y
//		g2.drawString("Strings are drawn "+ "like this", 250,300);
//		
//		//lines: startX,startY, endX, endY
//		g2.drawLine(0, 0, width, height);
//		
//		//random
//		g2.drawLine(470,280,520,300);
//		g2.drawLine(650,280,580,300);
//		g2.drawLine(500,300,500,325);
//		g2.drawLine(600,300,600,325);
//		g2.drawArc(460, 350, 200, 100, 0, 180);
//		
//
//
//		
////		int squareD = 20;
////		int margin = 2;
////		
////		for(int x = 0; x < width; x += squareD +margin){
////			for(int y = 0; y < height; y += squareD +margin){
////				//////g2.fillRect(x, y, squareD, squareD);
////				color++;
////				if(color >250){
////					color= 0;
////					g2.setColor(new Color(0,0,color));
////					g2.fillRect(x, y, squareD, squareD);
////				}
////				else{
////					g2.setColor(new Color(0,0,color));
////					g2.fillRect(x, y, squareD, squareD);
////				}		
////			}
////		}
//		//draw the bufferedImage on the canvas
		g.drawImage(image,0,0,null);

		}

	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			tubby.moveUp();
	
			
		}
		else if(key == KeyEvent.VK_DOWN){
			tubby.moveDown();

		}
		else if(key == KeyEvent.VK_RIGHT){
			tubby.moveRight();

		}
		else if(key == KeyEvent.VK_LEFT){
			tubby.moveLeft();

		}
		repaint();
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}




