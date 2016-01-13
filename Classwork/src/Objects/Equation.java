package Objects;
import java.util.ArrayList;

import java.util.ArrayList;

public class Equation{

	private ArrayList<Term> leftSide;
	private ArrayList<Term> rightSide;
	private boolean cancelRight;
	private ArrayList<Double> solution;

	public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide){
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	public boolean isLinear(){
		return isOfDegree(1);
	}

	public boolean isQuadratic(){
		return isOfDegree(2);
	}

	public boolean isOfDegree(int degree){
		int maxDegree = 0;
		int minDegree = 0;
		String variable = "";
		for(Term t:leftSide){
			if(t.getDegree() > maxDegree){
				maxDegree = t.getDegree();
			}
			if(t.getDegree() < minDegree){
				return false;
			}
			if(!t.isConstant()){
				variable = t.getVariable();
			}
		}
		for(Term t:rightSide){
			if(t.getDegree() > maxDegree){
				maxDegree = t.getDegree();
			}
			if(!t.isConstant()){
				variable = t.getVariable();
			}
		}
		if(maxDegree == degree && variablesMatch(variable)){
			return true;
		}

		else{
			return false;
		}
	}

	private boolean variablesMatch(String s){
		for(Term t:leftSide){
			if(!t.isConstant() && !t.getVariable().equals(s)){
				return false;
			}
		}
		for(Term t:rightSide){
			if(!t.isConstant() && !t.getVariable().equals(s)){
				return false;
			}
		}
		return true;
	}

	public boolean isSolveable(){
		if(isLinear() || isQuadratic()){
			return true;
		}
		return false;
	}

	public boolean cancelRight(){
		if(getHighestDegreeTerm(leftSide).getExponent() > getHighestDegreeTerm(rightSide).getExponent()){
			cancelRight = true;
		}
		else if(getHighestDegreeTerm(rightSide).getExponent() > getHighestDegreeTerm(leftSide).getExponent()){
			cancelRight = false;
		}
		else if(getHighestDegreeTerm(leftSide).getCoefficient() > getHighestDegreeTerm(rightSide).getCoefficient()){
			cancelRight = true;
		}
		else if(getHighestDegreeTerm(rightSide).getCoefficient() > getHighestDegreeTerm(leftSide).getCoefficient()){
			cancelRight = false;
		}
		return cancelRight;
	}		
//	Term highestLeft = getHighestDegreeTerm(leftSide);
//	Term highestRight = getHighestDegreeTerm(rightSide);
//	
//	
//	if(highestRight.getDegree() < highestLeft.getDegree() && highestRight.isPositive())return false;
//	if(highestRight.getDegree() < highestLeft.getDegree() && !highestRight.isPositive())return true;
//	if(highestRight.getDegree() > highestLeft.getDegree() && highestRight.isPositive())return false;
//	if(highestRight.getDegree() > highestLeft.getDegree() && !highestRight.isPositive())return true;
//	if(highestRight.getDegree() == highestLeft.getDegree() && highestLeft.getCoefficient() > highestRight.getCoefficient()) return true;
//	else return false;
//	}
	
	

	
	public String getSideString(ArrayList<Term> side){
		String s = "";
		try{
			s=side.get(0).toString();
		}
		catch(Exception e){
			s = "0";
		}
		for(int i =1;i<side.size();i++){
			if(side.get(i).isPositive())s+=" + "+side.get(i);
			else s+=" - "+side.get(i).toString().replaceFirst("-", "");
		}
		return s;
	}
	
	public String toString(){
//	
//		String returnString = "";
//		for(Term x: this.leftSide){
//			if(x.isPositive()){
//				if(this.leftSide.indexOf(x)==0){
//					returnString += x.toString();	
//				}
//				else{
//					returnString += " + " + x.toString();	
//				}
//			}
//			else{
//				returnString += " - " + x.toString();
//			}
//		}
//		returnString += " = ";
//		for(Term x: this.rightSide){
//			if(x.isPositive()){
//				if(this.rightSide.indexOf(x)==0){
//					returnString += x.toString();	
//				}
//				else{
//					returnString += " + " + x.toString();	
//				}
//			}
//			else{
//				returnString += "-" + x.toString();
//			}
//		}
//		return returnString;
//	}
		String termString = "";
		for(int index = 0; index < leftSide.size(); index ++){
			Term a = leftSide.get(index);
			if(index == 0){
				termString += a;
			}
			else if(a.toString().indexOf("-") == 0 && index != 0){
				a = a.getAddInverse();
				termString += " - " + a;
			}
			else if(index != leftSide.size()){
				termString += " + " + a;
			}
		}
		
		termString += " = ";
		
		for(int index = 0; index < rightSide.size(); index ++){
			Term b = rightSide.get(index);
			if(index == 0){
				termString += b;
			}
			else if(b.toString().indexOf("-") == 0 && index != 0){
				b = b.getAddInverse();
				termString += " - " + b;
			}
			else if(index != rightSide.size()){
				termString += " + " + b;
			}
		}
		return termString;
//				try{
//					termString = side.get(0).toString();
//				}
//				catch(Exception e){
//					termString = "0";
//				}
//				for(int index = 1; index < side.size(); index ++){
//					if(side.get(index).isPositive()){
//						termString += " + " + side.get(index);
//					}
//					else{
//						termString += " - " + side.get(index).toString().replaceFirst("-", "");
//					}
//				}
	}

	public static Term getHighestDegreeTerm(ArrayList<Term> side){ 
		int highestExponent = 0;
		Term greatestDegree = null;
		for(Term a: side){
			if(a.getExponent() > highestExponent){
				highestExponent = a.getExponent();
				greatestDegree = a;
			}
		}
		return greatestDegree;
	}

	/**
	 * adds the additiveInverse of everything on the sideBeingCancelled
	 * to both sides of the Equation
	 * @param sideBeingCanceled
	 */
	public void toZeroOnOneSide(ArrayList<Term> sideBeingCanceled){
		ArrayList<Term> addIn = new ArrayList<Term>();
		
		for(Term a : sideBeingCanceled){
			addIn.add(a.getAddInverse());
		
		}
		for(Term t:addIn){
			leftSide.add(t);
			rightSide.add(new Term(t.getCoefficient(), t.getVariable(), t.getExponent()));
		}
	}

	/**
	 * @param side - simplifies the specified side of the equation
	 * Notes: This method should check every Term on the specified side of the equation 
	 * with every other Term to check if they are like terms (use Term.areLikeTerms(Term s, Term t)
	 * If they are, it should reassign the current Term to the combined result (use Term.combine(Term s, Term t)
	 * and remove the one with which it combined.
	 * Finally, if the resulting term has a coefficient of zero should be removed.
	 * 
	 * For example, Suppose side contains 5x + 3 -5x. Call the three terms a, b and c, respectively
	 * 1. It checks to see if 5x and 3 (a and b) are like terms, they are not
	 * 2. It checks to see if 5x and -5x (a and c) are like terms, they are
	 * 3. Since 5x and -5x are like terms, a = Term.combine(a, c) then leftSide.remove(c)
	 * 4. Now side contains 0x + 3. Since term a has a coefficient of zero, remove it.
	 * 5. Now side contains 3. 
	 * 
	 * ONE MORE NOTE: Since you will be removing items from side, use a standard for loop
	 * and remember that when something is moved, everything "slides over"
	 */
	public void simplify(ArrayList<Term> side){					//>>>>>> 4.1 <<<<<<<
		//		for(int index = 0; index < side.size(); index ++){
		//		for(int index2 = index + 1; index2 < side.size(); index2 ++){
		//			if(Term.areLikeTerms(side.get(index), side.get(index2))){
		//				side.add(Term.combine(side.get(index), side.get(index2)));
		//				side.remove(side.get(index));
		//				side.remove(side.get(index2));
		//				index --;
		//				index2 --;
		//			}
		//		}
		//	}
		//	for(Term a : side){
		//		if(a.getCoefficient() == 0.0){
		//			side.remove(a);
		//		}
		//	}

		//nested for loop to compare every term to every other term
		//checking for "like Terms"
		for(Term t : side){
			for(Term s: side){
				if(t!= s && t.getCoefficient()!=0){
					if(Term.areLikeTerms(s, t)){
						Term result = Term.combine(s, t);
						t.setCoefficient(result.getCoefficient());
						s.setCoefficient(0);
					}
				}
			}

		}
		for(int i = side.size()-1; i > -1; i--){
			if(side.get(i).getCoefficient()==0){
				side.remove(i);
			}
		}
		if(side.size() == 0){
			side.add(new Term(0, "", 0));
		}
	
	}
	/**
	 * @param sideWithVariable - we can assume the side with a variable is of the form ax + b
	 * @return the solution
	 * 
	 * Example: 3x + 21 = 0
	 * 1. Identify the constant term in the sideWithVariable (21)
	 * 2. Identify the variable term in the sideWithVariable (3x)
	 * 3. Add the additive inverse of the constant Term to both sides of the equation (3x = -21)
	 * 4. Multiple both sides by the additive inverse of the coefficient of the variable term (.33333333)
	 */
	public void solveLinear(ArrayList<Term> sideWithVariable){
		Term a = new Term(0);
		Term b = new Term(0);
		for(Term i : sideWithVariable){
			if(i.isConstant()){
				b = i;
			}
			else a = i;
		}
		leftSide.add(a.getAddInverse());
		rightSide.add(a.getAddInverse());
		multiplyScalar(leftSide, (1/b.getCoefficient()));
		multiplyScalar(rightSide, (1/b.getCoefficient()));
		
//		Term constant = new Term(0);
//		for(Term a : sideWithVariable){
//			if(a.getVariable().equals("")){
//				constant = a.getAddInverse();
//			}
//
//		}
//		leftSide.add(constant);
//		rightSide.add(new Term(constant.getCoefficient(), constant.getVariable(), constant.getExponent()));
//		simplify(leftSide);
//		simplify(rightSide);
//		return 1/(constant.getCoefficient());
	}

	/**
	 * 
	 * @param side
	 * @param scalar
	 * multiplies all Terms on the given side by the given scalar
	 * (Hint: use setCoefficient(double))
	 */
	
	public void solveQuadratic(Equation eq){
	    	factor(eq.leftSide);
	 }
	    
	    
	public void multiplyScalar(ArrayList<Term> side, double scalar){      //>>>>>4.1<<<<<
		double multiScalar;
		for(int i = 0; i < side.size(); i++){
			multiScalar = side.get(i).getCoefficient()* scalar;
		}			
	}
	
	public void factor(ArrayList<Term> eq){					// >>>>>>4.3<<<<<<<<<
//		double a = eq.get(0).getCoefficient();		//figuring out the number of exponents
//		double b = eq.get(1).getCoefficient();
//		double c = eq.get(2).getCoefficient();
//		double d = math.sqrt(b*b) - 4*(a*c);				//squaring
//		
//		double[] positiveFacts = null;
//		double[] negativeFacts = null;
//		
//		for(int i = 0; i < a*c; i++){	
//			if((a*c)%i == 0){				
//               positiveFacts[i] = i;
//               negativeFacts[i] = -1;
//			}
//		}	
//		
//		if(d > 0){
//	            System.out.println("There are two real roots in the equation");
//	        }
//	     if(d == 0){
//	            System.out.println("There is one real root that repeats");
//	        }
//	     if(d < 0){
//	            System.out.println("There are no real roots");
//	        }
	}
	//double a = 0.0;
	//double b = 0.0;
	//double c = 0.0;
	//for(Term t :eq.getLifeSide(){		
		//if(t.getDegree() == 2){
		//double a = t.getCoefficient();
		//			}
		//	if(t.getDegree() ==1){
		//double b = t.getCoefficient();
		//	}
		//if(t.isConstant()){
		//	c = t.getCoefficient();
		//	}
	//	}	
	//double d = math.sqrt(b*b - 4*(a*c));
	//	double positiveRoot = (-b+d)/(2*a);
	//	double negativeRoot = (-b-d)/(2*a);
	//QuadraticForm qf = new QuadraticForm(-b+"", b*b - 4 *(a *c))+ "",2*a + "");
	//gui.addStep(qf, plug in to the quadratic formula
	//gui.addStep("The positive root is "+positiveRoot);
	public ArrayList<Term> getLeftSide() {
		return leftSide;
	}

	public ArrayList<Term> getRightSide() {
		return rightSide;
	}

	public boolean isCancelRight() {
		return cancelRight;
	}

	public ArrayList<Double> getSolution() {
		return solution;
	}
}