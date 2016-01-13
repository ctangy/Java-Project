package Objects;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class SolverGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1846914429271950224L;
	public static int LINE_SPACING=25;
	public static int MARGIN=20;
	public static int EQ_MARGIN=450;

	SpringLayout layout;
	JTextField input;
	JButton submit;

	JLabel confirmInput;
	JLabel solveabilityMessage;

	ArrayList<JLabel> equationSteps;
	ArrayList<JLabel> descriptionSteps;
	int stepLine = 5;

	public SolverGUI() {
		layout= new SpringLayout();
		setLayout(layout);
		makeLayout();
		addListeners();
		equationSteps=new ArrayList<JLabel>();
		descriptionSteps=new ArrayList<JLabel>();

	}

	private void addListeners() {
		submit.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				try{
					Equation eq = Solver.interpretInput(input.getText());
					input.setText("");
					confirmInput.setForeground(Color.BLACK);
					confirmInput.setText(Solver.getConfirm(eq));
					String prefix = "";
					if(eq.isLinear())prefix="This is a linear equation and ";
					if(eq.isQuadratic())prefix="This is a quadratic equation and ";
					if(eq.isSolveable()){
						solveabilityMessage.setText(prefix+"I think I can solve it for you!");
						Solver.solve(eq);
					}else{
						solveabilityMessage.setText("It appears this equation cannot be solved. Is that right?");
					}


				}catch(Exception ex){
					ex.printStackTrace();
					confirmInput.setText(Solver.getNoTricks(input.getText()));
					confirmInput.setForeground(Color.RED);
				}
			}
		});
	}

	private void makeLayout() {
		input= new JTextField();
		submit = new JButton("Submit");
		confirmInput = new JLabel("");
		solveabilityMessage= new JLabel("");
		addMargined(new JLabel("Enter an equation:"),1,20,200);
		addMargined(input,1.8,MARGIN,400);
		addMargined(submit,1.8,420,75);
		addMargined(confirmInput,3,MARGIN,0);
		addMargined(solveabilityMessage,4,MARGIN,0);

	}

	private void addMargined(Component thing, double line, int margin, int width) {
		add(thing);
		layout.putConstraint(SpringLayout.WEST, thing, margin, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, thing, (int)(LINE_SPACING*line), SpringLayout.NORTH, this.getContentPane());
		if(width>0)layout.putConstraint(SpringLayout.EAST, thing, width, SpringLayout.WEST, thing);

	}

	public void addStep(Equation eq, String s){

		String st = "<html>"+eq.toString()+"</html>";
		st = st.replaceAll("\\^", "\\<sup\\>");
		for(Term t: eq.getLeftSide()){
			st = st.replace("<sup>"+t.getExponent(),"<sup>"+t.getExponent()+"</sup>");
		}
		for(Term t: eq.getRightSide()){
			st =st.replace("<sup>"+t.getExponent(),"<sup>"+t.getExponent()+"</sup>");
		}
		JLabel jle = new JLabel(st);
		JLabel jld= new JLabel(s);
		add(jle);
		add(jld);
		layout.putConstraint(SpringLayout.EAST, jle, EQ_MARGIN, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, jle, (int)(LINE_SPACING*stepLine), SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, jld, EQ_MARGIN+10, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, jld, (int)(LINE_SPACING*stepLine)+5, SpringLayout.NORTH, this.getContentPane());
		stepLine ++;
		equationSteps.add(jle);
		descriptionSteps.add(jld);
	}

	public void clearSteps(){
		stepLine=5;
		for(JLabel jl:equationSteps){
			remove(jl);
		}
		for(JLabel jl:descriptionSteps){
			remove(jl);
		}
		equationSteps.removeAll(equationSteps);
		descriptionSteps.removeAll(descriptionSteps);
	}

	public void addStep(QuadraticForm qf, String s) {
		JLabel jle = new JLabel(new ImageIcon(qf.getImage()));
		JLabel jld= new JLabel(s);
		add(jle);
		add(jld);
		layout.putConstraint(SpringLayout.EAST, jle, EQ_MARGIN, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, jle, (int)(LINE_SPACING*stepLine), SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, jld, EQ_MARGIN+10, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, jld, (int)(LINE_SPACING*stepLine)+5, SpringLayout.NORTH, this.getContentPane());
		stepLine +=2;
		equationSteps.add(jle);
		descriptionSteps.add(jld);
	}

	public void addStep(String s) {
		JLabel jld= new JLabel(s);
		add(jld);
		Graphics g = jld.getGraphics();
		int width = g.getFontMetrics().stringWidth(s);
		layout.putConstraint(SpringLayout.WEST, jld, EQ_MARGIN-width/2, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, jld, (int)(LINE_SPACING*stepLine)+5, SpringLayout.NORTH, this.getContentPane());
		stepLine ++;
		descriptionSteps.add(jld);
	}

}