package Objects;

import java.awt.Color;

import java.awt.Font;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;



import javax.swing.JLabel;

public class QuadraticForm{



	private BufferedImage equation;

	private int width;

	private int height;

	public QuadraticForm(String nonRadical, String radical, String denominator) {

		BufferedImage sample = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = sample.createGraphics();

		int fontHeight = g.getFontMetrics().getHeight();

		int fontDip = g.getFontMetrics().getDescent();

		int nonRadicalWidth = g.getFontMetrics().stringWidth(nonRadical + " + v");



		int expInsert = 0;

		if(radical.indexOf("^")>-1){

			String sub = radical.substring(0, radical.indexOf("^"));

			radical = radical.replace("^2","  ");

			expInsert=nonRadicalWidth+g.getFontMetrics().stringWidth(sub);

		}

		int radicalWidth = g.getFontMetrics().stringWidth(radical);

		int denominatorWidth = g.getFontMetrics().stringWidth(denominator);

		width = nonRadicalWidth+radicalWidth;

		height = 2*fontHeight+2*fontDip+5;

		equation = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2= equation.createGraphics();

		g2.setColor(Color.BLACK);

		g2.drawString(nonRadical + " ± v", 0, fontHeight);

		g2.drawString(radical, nonRadicalWidth, fontHeight);

		g2.drawString(denominator, (width-denominatorWidth)/2, fontDip+2*fontHeight);

		g2.drawLine(nonRadicalWidth,3, width,3);

		g2.drawLine(0,fontHeight+fontDip, width,fontHeight+fontDip);

		g2.setFont(new Font("Times",Font.PLAIN,8));

		int expHeight = g2.getFontMetrics().getHeight();

		if(expInsert!=0)g2.drawString(2+"", expInsert, expHeight+3);

	}
	public int getWidth() {

		return width;

	}
	public int getHeight() {

		return height;

	}


	public BufferedImage getImage(){

		return equation;

	}



}