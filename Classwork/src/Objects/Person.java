//package Objects;
//
//import java.util.ArrayList;
//
//public class Person {
//	private String firstName;
//	private String lastName;
//	private String middleName;
//	private boolean male;
//	public static int MAX_ALLOWED_BOOKS = 3;
//	private ArrayList<Book> checkedOutBooks;
//	Balance balance;
//
//	//constructor
//	//no return type: it "returns"(constructs) a Person
//	public Person(String firstName, String lastName, boolean male){
//		this.firstName = firstName; //Assigns firstname to the fn parameter
//		middleName = ""; //Default middle name
//		this.lastName = lastName; //this is used to specify the FIELD, whereas lastName by itself is the local parameter 
//		checkedOutBooks = new ArrayList<Book>();
//		this.male = male;
//		balance = new Balance();
//	}
//
//
//	//constructor for middle named people
//	public Person(String firstName, String middleName, String lastName, boolean male){
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		checkedOutBooks = new ArrayList<Book>();
//		this.male = male;
//		balance = new Balance();
//	}
//
//	public Balance getBalance(){
//		return balance;
//	}
//
//	public void checkOutBook(Book book){
//		book.setCheckedOut(true);
//		book.setCheckOutDate(System.currentTimeMillis());
//		book.setDueDate(System.currentTimeMillis()+30000);
//		checkedOutBooks.add(book);
//	}
//	public void returnBook(Book book){
//		book.updateConditions(System.currentTimeMillis());
//		balance.subtractLateFees((int)(System.currentTimeMillis() - book.getDueDate()) / 1000);
//		book.setCheckedOut(false);
//		book.setCheckOutDate(0) ;
//		book.setDueDate(0);
//		checkedOutBooks.remove(book);
//
//	}
//	public void renewBook(Book book){
//		book.setDueDate(System.currentTimeMillis()+30000);
//	}
//
//
//
//
//	public String getGenderPosessivePronoun(){
//		String boy = "his";
//		String girl = "her";
//		if(male) return boy;
//		return girl;
//
//	}
//	public String getLibraryDescription(){
//		String description = getFirstName() + " is thinking of borrowing a book" + "\n" + "Balance is: " +balance.getAmount();
//		return description;
//	}
//
//
//	public boolean isMale() {
//		return male;
//	}
//
//	public ArrayList<Book> getCheckedOutBooks() {
//		return checkedOutBooks;
//	}
//
//
//	public String toString(){
//		return firstName+" " +middleName+" " +lastName;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public String getMiddleName() {
//		return middleName;
//	}
//
//
//
//}
//
