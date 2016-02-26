
public class HiddenWord {

	private static String word;

	public static void main(String[] args) {
		HiddenWord hidden = new HiddenWord("HELLO");//the correct word
		System.out.println(HiddenWord.getHint("OLLEH")); //the incorrect word
	}

	public static String getHint(String input){
		String temp=""; //initialize
		for(int i=0;i<word.length();i++){
			String letter= input.substring(i,i+1);// ex. 1 = H 1+1 = E
			if(word.substring(i,i+1).equals(letter)){ 
				temp+=letter;// if the letter is correct it puts it in a temporary 
				//array then it loops again
			}else{
				if(word.indexOf(letter)>=0){
					temp+="+";//correct letter but wrong placement
				}else{
					temp+="*";// wrong letter
				}
			}

		}
		return temp;
	}

	public HiddenWord(String word){
		this.word = word; //constructor
	}
}
