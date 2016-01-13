//package Objects;
//
//import java.awt.Color;
//
//public class Book{
//	private String title;
//	private int numberOfPages;
//	private Person author; //custom class in this package
//	private Color jacketColor;  //class from java.awt
//	private boolean wasLitOnFire;
//	private int height;
//	private int thickness;
//	private long checkOutDate;
//	private long dueDate;
//	public boolean checkedOut;
//	private String description;
//	private int accumlatedUse;
//	public static String[] conditions = {"Wow, its a brand new book. Never see those nowadays" ,
//										"Book is slightly used. Not bad looking",
//										"Only a few pages are bent!",
//										"The book is starting to fall apart.", 
//										"Oh god, its an old crumbly book. Look at that booger smear."
//										};
//
//
//	public static int DEFAULT_HEIGHT = 300;
//
//	public Book(String title, int numOfPages, Person author){
//		this.title = title;
//		this.numberOfPages = numOfPages;
//		this.author = author;
//		jacketColor = Color.gray;
//		wasLitOnFire = false;
//		height = DEFAULT_HEIGHT+(int)(Math.random()*100);
//		thickness = numberOfPages/10;
//		checkedOut = false;
//		checkOutDate = 0;
//		dueDate = 0;
//		description = conditions[0];
//		accumlatedUse = 0;
//	}
//	
//	public String getDescription(){
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public int getAccumlatedUse() {
//		return accumlatedUse;
//	}
//
//	public void setAccumlatedUse(int accumlatedUse) {
//		this.accumlatedUse = accumlatedUse;
//	}
//	
//
//
//
//	public long getSecondsRemaining(){
//		return(dueDate - System.currentTimeMillis())/1000;
//
//	}
//
//	public long getDueDate() {
//		return dueDate;
//	}
//	public void setDueDate(long dueDate) {
//		this.dueDate = dueDate;
//	}
//
//
//	public long getCheckOutDate(){
//		return checkOutDate;
//	}
//	public void setCheckOutDate(long checkOutDate){
//		this.checkOutDate = checkOutDate;
//	}
//
//
//	public boolean getCheckedOut() {
//		return checkedOut;
//	}
//	public void setCheckedOut(boolean checkedOut) {
//		this.checkedOut = checkedOut;
//	}
//
//	public int getThickness() {
//		return thickness;
//	}
//
//	public void setThickness(int thickness) {
//		this.thickness = thickness;
//	}
//
//	public int getHeight() {
//		return height;
//	}
//
//	public Color getJacketColor() {
//		return jacketColor;
//	}
//
//	public void setJacketColor(Color jacketColor) {
//		this.jacketColor = jacketColor;
//	}
//
//	
//	public String toString(){
//		if(wasLitOnFire){
//			return "\"" +title+ "\", by an author whose name you cannot make out  , is " +numberOfPages+" pages";
//		}
//		else{
//			return "\"" +title+ "\", by "  +author+ " , is " +numberOfPages+" pages";
//		}
//	}
//	
//		public void updateConditions(long timeOfReturn){
//		accumlatedUse += (int)(timeOfReturn - checkOutDate) / 1000;
//		if(accumlatedUse >10) description = conditions[1];
//		if(accumlatedUse >30) description = conditions[2];
//		if(accumlatedUse >45) description = conditions[3];
//		if(accumlatedUse >60) description = conditions[4];
//		}
//	
//
//
//	//getter
//	public String getTitle(){
//		return title;
//	}
//
//	public int getNumberofPages(){
//		return numberOfPages;
//	}
//
//	public Person getAuthor(){
//
//		return author;
//	}
//
//	public void setOnFire(){
//		jacketColor = Color.black;
//		title = "The title of this book is too charred to make out";
//		wasLitOnFire = true;
//	}
//}
