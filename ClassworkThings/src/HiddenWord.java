
public class HiddenWord {
	
	 public static String word;
	
	public static void main(String[] args) {
		HiddenWord hidden = newh HiddenWord("HELLO");
		System.out.println(hidden.getHint(HALLO);
	}
	
	public static String getHint(String input){
		String temp="";
		for(int i=0;i<word.length();i++){
			String letter= input.substring(i,i+1);
			if(word.substring(i,i+1).equals(letter)){
				temp+=letter;
			}else{
				if(word.indexOf(letter)>=0){
					temp+="+";
				}else{
					temp+="*";
				}
			}
		return temp;
		
	}
	
	public HiddenWord(String word){
		this.word = word;
	}
