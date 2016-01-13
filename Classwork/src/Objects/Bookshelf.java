//package Objects;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//import javax.swing.JFrame;
//
//public class Bookshelf {
//
//	/**
//	 * @param args
//	 */
//	public static void stuff() {
//		Person author1 = new Person("Noah", "Webster", true);
//		Person author2 = new Person("Anthony", "Burgess", true);
//		Person author3 = new Person("Phillip" , "K." , "Dick", true);
//
//		Book book1 = new Book("Dictionary" , 1001, author1);
//		Book book2 = new Book("Clockwork Orange",749, author2);
//		Book book3 = new Book("Do Androids Dream of Electric Sheep?", 500, author3);
//
//		Person person1 = new Person("Sugar", "Cat", true);
//		Person person2 = new Person("Gerry", "Dog", true);
//		Person person3 = new Person("Fishie", "Fish", false);
//		
//		book2.setJacketColor(Color.orange);
//
//		ArrayList<Book> shelf = new ArrayList<Book>();
//		ArrayList<Book> creepyBooks = new ArrayList<Book>();
//		ArrayList<Person> libraryCardHolders = new ArrayList<Person>();
//		
//		shelf.add(book1);
//		book1.setJacketColor(Color.cyan);
//		shelf.add(book2);
//		book2.setJacketColor(Color.yellow);
//		shelf.add(book3);
//		book3.setJacketColor(new Color(250,0,0));
//		shelf.add(new Book("The Man in the High Castle", 600, author3));
//		Book book5 = new Book("The Minority Report", 589, author3);
//		book5.setJacketColor(Color.magenta);
//		shelf.add(0,book5);
//		
//		libraryCardHolders.add(person1);
//		libraryCardHolders.add(person2);
//		libraryCardHolders.add(person3);
//		
//		printAll(shelf);
//
//
//		Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 
//
//		lib.setSize(new Dimension(600,600));
//
//		lib.setVisible(true);
//
//		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//	public static void sortByAuthor(final boolean ascending, ArrayList<Book>shelf){
//		Collections.sort(shelf,new Comparator<Book>(){
//			public int compare(Book a, Book b){
//				String aLast = a.getAuthor().getLastName();
//				String bLast = b.getAuthor().getLastName();
//				if(ascending){
//					return aLast.compareTo(bLast);
//				}
//				else{
//					return bLast.compareTo(aLast);
//				}
//			}
//		});	
//	}
//
//	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf){
//		Collections.sort(shelf,new Comparator<Book>(){
//			public int compare(Book a, Book b){
//				int aLast = a.getNumberofPages();
//				int bLast = b.getNumberofPages();
//				if(ascending){
//					return aLast - bLast;
//				}
//				else{
//					return bLast-aLast;
//				}
//			}
//		});
//
//
//	}
//	public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf){
//		Collections.sort(shelf,new Comparator<Book>(){
//			public int compare(Book a, Book b){
//				int aLast = a.getHeight();
//				int bLast = b.getHeight();
//				if(ascending){
//					return aLast - bLast;
//				}
//				else{
//					return bLast-aLast;
//				}
//			}
//		});
//	}	
//
//	public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf){
//		Collections.sort(shelf,new Comparator<Book>(){
//			public int compare(Book a, Book b){
//				String aLast = a.getTitle();
//				String bLast = b.getTitle();
//				if(ascending){
//					return aLast.compareTo(bLast);
//				}
//				else{
//					return bLast.compareTo(aLast);
//				}
//			}
//		});	
//	}
//
//
//
//	private static void arrayListStuff(ArrayList<Book>shelf){
//		/**
//		 * <Book> or <?> is a generic type. It tells the constructor WHAT is
//		 * 		 in the Arraylist. We use generics to save ourselves
//		 * 		 the trouble of type casting.
//		 * new Arraylist<?>()* constructor does not need to specify
//		 *  	length. (Default is 10, but it doesn't matter, 
//		 *  	it adjusts as you add objects to it)
//		 * note that ArrayList IS Indexed (item 0 is always at index 0, 
//		 * 		item 1 is always at index 1, and so on) You can iterate through it
//		 * you cannot make an ArrayList of primitives
//		 * 		(no int, boolean, etc) IF you wish to make an 
//		 * 		ArrayList of ints, you use the wrapper class 
//		 * 		int is Integer, double is Double, etc)
//		 */
//		/**
//		 * TASK:
//		 * Make sure "shelf" has all the books we have created so far on it.
//		 * Make a new ArrayList called creepyBooks.
//		 * Programmatically add to the "creepyBooks"  every
//		 * book by Phillip K.Dick
//		 */
//
//
//		//add things to an ArrayList(remember, for arrays, we did:
//		//array[0] = book1 ; //specify index
//		//above does not specify index, book1 is automatically index 0
//
//
//		//you can construct at the same time:
//
//
//		//to get something from an ArrayList (recall to get something 
//		//from array:
//		//System.out.println(array[0])
//		//		System.out.println("The first book on the shelf is " +
//		//				shelf.get(0)); //LOSE POINTS IF YOU DO THIS WRONG!!
//		//		
//		//		//iterate through an ArrayList using a for-each:
//		//		System.out.println("\n>>>>>>>>>>>>>> USING A FOR-EACH LOOP <<<<<<<<<<<<");
//		//		for(Book b:shelf)System.out.println(b);
//		//		
//		//		// Adding Objects at specified indices
//		//		shelf.remove(book1);
//		//		//task:remove all books with the word "The" in the title
//		//		for(int i = 0; i <shelf.size(); i++){
//		//			if(shelf.get(i).toString().toLowerCase().contains("the")){
//		//				shelf.remove(i);
//		//			}
//		//		}
//		//		
//		//		
//		//		//to get the length of ArrayList
//		//		//recall using arrays:
//		//		//array.length
//		//		System.out.println("\nThe length (size) of the shelf is " +
//		//				shelf.size() + " books.");
//		//		
//		//		//iterate through an ArrayList, using standard for loop:
//		//		System.out.println("\n >>>>>>>>>>>>>>>> USING A STANDARD LOOP <<<<<<<<<<<<<<");
//		//		for(int i = 0; i<shelf.size(); i++){
//		//			System.out.println(shelf.get(i));
//		//			
//		//		}
//		//		
//		//		//identifying whether or not an Object is in the list
//		//		//getting the index of an Object in an ArrayList
//		//		if(shelf.contains(book2)){
//		//			System.out.println(book2.getTitle()+ " is book #"+shelf.indexOf(book2)+ " on the shelf.");
//		//		}
//		//		for(Book b:shelf){
//		//			if(b.getAuthor().toString().equals("Phillip K. Dick")){
//		//				creepyBooks.add(b);
//		//				b.setOnFire();
//		//			}
//		//		}
//		//		System.out.println("\n The books in the creepy collection include:");
//		//		printAll(creepyBooks);
//		//	
//
//	}
//
//	private static void printAll(ArrayList list){
//		for(int i=0; i <list.size(); i++){
//			System.out.println(list.get(i));
//		}
//	}
//
//}
