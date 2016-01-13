package Objects;

public class Term{
	private double coefficient;
	private String variable;
	private int exponent;
	private boolean constant;//this is true if a Term has no variable expression

	public Term(double coefficient, String var, int exp){
		this.coefficient = coefficient;
		variable = var;
		exponent = exp;
		if(variable.isEmpty()){
			constant = true;
			exponent = 0;
		}
		else{
			constant = false;
		}
		if(coefficient == 0){
			variable = "";
			exponent = 0;
		}
	}	
		
//		//if(!var.equals("")){
//		constant = false;
//	} else constant = true; exp = 0;}
//if(coefficient ==0){variable = ""; exponent = 0;
//	}

	//a constructor for constant: 
	Term(double constant){
		coefficient = constant;
		variable = "";
		exponent = 0;
		this.constant = true;
	}

	public Term getAddInverse(){
		return new Term((0.0 - coefficient), variable, exponent); 
	}

	public int getDegree(){
		return exponent;
	}

	public boolean isPositive(){
		if(coefficient >= 0){
			return true;
		}
		return false;
	}
	
	/**
	* @param s
	* @param t
	* @return 'true' if s and t are like terms (same variable and exponent)
	*/
	public static boolean areLikeTerms(Term s, Term t){		//>>>>>> 4.1 <<<<<<<<
		if(s.getVariable().equals(t.getVariable()) && s.getExponent() == t.getExponent()){
				return true;
		}
		return false;
	}

	/**
	* returns a new Term with same variable and exponent as s and t but combined coefficient
	* @param s
	* @param t
	* @return
	*/
	public static Term combine(Term s, Term t){     //>>>>>>> 4.1<<<<<<<<<<
		return new Term(s.getCoefficient() + t.getCoefficient(), s.getVariable(), s.getExponent());
	}

	public void setCoefficient(double d) {  //>>>>>>>>>>>>>>>>>>>>>  ?????????????????????  <<<<<<<<<<<<<
			coefficient = d;
	}

	public String toString(){
		if(exponent == 1 || exponent == 0){
			if(variable.isEmpty()){
				return "" + (int)coefficient;
			}
			else if(coefficient == 1){
				return variable;
			}
			else if(coefficient == -1){
				return "-" + variable;
			}
			else if (coefficient == 0){
				return "" + variable;
			}
			return (int)coefficient + variable;
		}
		return (int)coefficient + variable + "^" + exponent; 
		
		
	}
	
	
	

	public double getCoefficient() {
		return coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public int getExponent() {
		return exponent;
	}

	public boolean isConstant() {
		return constant;
	}

}