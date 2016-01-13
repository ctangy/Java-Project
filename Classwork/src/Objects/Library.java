//package Objects;
///**
// * This version of Library provide buttons for visualizing the sort of the books
// */
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Cursor;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ComponentEvent;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.image.BufferedImage;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.swing.JPanel;
//import javax.swing.Timer;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.SpringLayout;
//
//public class Library extends JFrame{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -242645458485054340L;
//
//	public static int BASELINE = 10;
//	public static int MARGIN = 450;                                      
//	public static int LINE_SPACE = 30;
//	public static int BUTTON_SPACE = 100;
//	public static int CENTERLINE = 200;
//	public static double PERSON_VIEW_LINE =7;
//	public static int PERSON_VIEW_HEIGHT =500;
//	public static int REHELVE_Y =7;
//	public static int REHELVE_X =20;
//
//	public static int SORT_TITLE=0;
//	public static int SORT_AUTHOR=1;
//	public static int SORT_SIZE=2;
//	public static int SORT_LENGTH=3;
//
//	private ArrayList<Book> shelfAsItIsNow;
//	private int base;
//	private SpringLayout layout;
//	private JLabel selectedBook;
//	private JLabel selectedBookDescription;
//	private JLabel selectedPerson;
//	private JCheckBox ascending;
//	private JButton checkOut; 
//	private JButton sortTitle;
//	private JButton sortAuthor;
//	private JButton sortHeight;
//	private JButton sortPages;
//	private JButton reshelve;
//	private JLabel warning;
//	private JPanel personBooks;
//	private SpringLayout personLayout;
//	private JComboBox<Person> people; 
//	private ArrayList<BookSpot> bookSpots;
//	private Person activePerson;
//	private Book activeBook;
//	private BufferedImage bookStack;
//
//	public Library(ArrayList<Book> bookshelf, ArrayList<Person> people) {
//		shelfAsItIsNow = bookshelf;
//
//		redoBookImage();
//
//		//create all Components (Buttons and ComboBoxes), etc
//		this.people= new JComboBox<Person>();
//		selectedBook = new JLabel("No Book selected yet");
//		selectedBookDescription = new JLabel("The books look inspiring, stacked so neatly on the shelf.");
//		selectedPerson = new JLabel("");
//		ascending = new JCheckBox("Ascending");
//		checkOut = new JButton("Check Out");
//		checkOut.setEnabled(false);
//		sortTitle=new JButton("Title");
//		sortAuthor=new JButton("Author");
//		sortHeight=new JButton("Size");
//		sortPages=new JButton("Length");
//
//		warning = new JLabel("");
//		warning.setForeground(Color.RED);
//		reshelve=new JButton("Reshelve for $5");
//		personBooks = new JPanel();
//		personBooks.setBackground(Color.WHITE);
//		personLayout=new SpringLayout();
//		personBooks.setLayout(personLayout);
//		personBooksAdd(reshelve, REHELVE_Y, 0, REHELVE_X);
//
//		for(Person p:people)this.people.addItem(p);
//		//makes the first person on the list the active person, if one exists
//		try{
//			activePerson=this.people.getItemAt(0);
//			selectedPerson.setText(activePerson.getLibraryDescription());
//
//		}catch(Exception e){
//
//		}
//		makeLayout();
//		Timer timer = new Timer(1000, new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				updateCheckedOutBooks();
//				reshelve.setEnabled(activePerson.getBalance().canWork(System.currentTimeMillis()));
//			}
//		});
//		timer.start();
//	}
//
//	public void paint(Graphics g){
//		Graphics2D g2 = (Graphics2D)g;
//		g2.setColor(Color.WHITE);
//		g2.fillRect(0, 0, getWidth(), getHeight());
//		paintComponents(g);
//		g2.setColor(Color.BLACK);
//		g2.drawLine(0, getHeight()-BASELINE, getWidth(), getHeight()-BASELINE);
//		g.drawImage(bookStack, CENTERLINE-bookStack.getWidth()/2, getHeight()-BASELINE-bookStack.getHeight(), this);
//
//	}
//
//	private void redoBookImage() {
//		try{
//			selectedPerson.setText(activePerson.getLibraryDescription());
//		}catch(Exception e){
//
//		}
//		bookSpots=new ArrayList<BookSpot>();
//		int maxWidth=0;
//		int height =0;
//		for(Book b:shelfAsItIsNow){
//			if(b.getHeight()>maxWidth)maxWidth=b.getHeight();
//			height+=b.getThickness();
//		}
//		height++;
//		maxWidth++;
//		bookStack = new BufferedImage(maxWidth, height, BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g2= bookStack.createGraphics();
//		g2.setColor(Color.WHITE);
//		g2.fillRect(0, 0, bookStack.getWidth(), bookStack.getHeight());
//		base = bookStack.getHeight();
//		for(Book b:shelfAsItIsNow){
//			if(!b.getCheckedOut()){
//				g2.setColor(b.getJacketColor());
//				int bookX1 = (maxWidth-b.getHeight())/2;
//				int bookY1 = base -b.getThickness();
//				g2.fillRect(bookX1, bookY1,b.getHeight(), b.getThickness());
//				g2.setColor(Color.BLACK);
//				g2.drawRect(bookX1, bookY1,b.getHeight(), b.getThickness());
//				int fontHeight = g2.getFontMetrics().getHeight();
//				int fontDip = g2.getFontMetrics().getDescent();
//				int fontWidth = g2.getFontMetrics().stringWidth(b.getTitle());
//				if(b.getThickness()>fontHeight)g2.drawString(b.getTitle(), maxWidth/2-fontWidth/2, base-b.getThickness()/2+fontHeight/2-fontDip);
//				BookSpot bspot = new BookSpot(b, CENTERLINE-b.getHeight()/2, bookY1+getHeight()-bookStack.getHeight()-BASELINE,b.getHeight(),b.getThickness());
//				bookSpots.add(bspot);
//				base = base-b.getThickness();
//			}
//		} 
//	}
//
//	private void makeLayout(){;
//
//	layout = new SpringLayout();
//	getContentPane().setBackground(Color.WHITE);
//	setLayout(layout);
//	basicAdd(new JLabel("Sort books by..."),1,0);
//	basicAdd(ascending,2,0);
//	arrangeSortButton(sortTitle,1,SORT_TITLE);
//	arrangeSortButton(sortAuthor,2,SORT_AUTHOR);
//	arrangeSortButton(sortHeight,3,SORT_SIZE);
//	arrangeSortButton(sortPages,4,SORT_LENGTH);
//	basicAdd(people,3,240);
//	basicAdd(checkOut,6,100);
//	marginAdd(selectedBook,6,0,105);
//	marginAdd(selectedBookDescription,6.5,0,105);
//	basicAdd(personBooks, PERSON_VIEW_LINE, 500);
//	layout.putConstraint(SpringLayout.SOUTH, personBooks, PERSON_VIEW_HEIGHT, SpringLayout.SOUTH, this);
//	//tries to add information about the person checking out books, if a person is selected
//	basicAdd(warning, 5,0);
//	try{
//		basicAdd(selectedPerson, 4,0);
//	}catch(Exception e){
//
//	}
//
//
//	addListeners();
//	}
//
//	private void marginAdd(Component component, double level, int width, int margin) {
//		add(component);
//		layout.putConstraint(SpringLayout.WEST, component, MARGIN+margin, SpringLayout.WEST, this);
//		if(width!=0)layout.putConstraint(SpringLayout.EAST, component, MARGIN+margin+width, SpringLayout.WEST, this);
//		layout.putConstraint(SpringLayout.NORTH, component, (int)(LINE_SPACE*level), SpringLayout.NORTH, this);
//	}
//
//	private void personBooksAdd(Component component, double level, int width, int margin) {
//		personBooks.add(component);
//		personLayout.putConstraint(SpringLayout.WEST, component, margin, SpringLayout.WEST, personBooks);
//		if(width!=0)personLayout.putConstraint(SpringLayout.EAST, component, margin+width, SpringLayout.WEST, personBooks);
//		personLayout.putConstraint(SpringLayout.NORTH, component, (int)(LINE_SPACE*level), SpringLayout.NORTH, personBooks);
//	}
//
//	public void basicAdd(Component c, double level, int width){
//		marginAdd(c, level, width, 0);
//	}
//
//	private void arrangeSortButton(JButton b, int c, final int sortType) {
//		add(b);
//		layout.putConstraint(SpringLayout.WEST,b,MARGIN+c*BUTTON_SPACE,SpringLayout.WEST,this);
//		layout.putConstraint(SpringLayout.EAST,b,MARGIN+(c+1)*BUTTON_SPACE-5,SpringLayout.WEST,this);
//		layout.putConstraint(SpringLayout.NORTH, b, LINE_SPACE*2, SpringLayout.NORTH, this);
//		b.addActionListener(new ActionListener() {
//
//
//			public void actionPerformed(ActionEvent e) {
//				if(sortType == SORT_TITLE)Bookshelf.sortByTitle(ascending.isSelected(), shelfAsItIsNow);
//				if(sortType == SORT_AUTHOR)Bookshelf.sortByAuthor(ascending.isSelected(), shelfAsItIsNow);
//				if(sortType == SORT_SIZE)Bookshelf.sortByHeight(ascending.isSelected(), shelfAsItIsNow);
//				if(sortType == SORT_LENGTH)Bookshelf.sortByPageNumber(ascending.isSelected(), shelfAsItIsNow);
//				redoBookImage();
//				repaint();
//			}
//		});
//	}
//
//	private void updateCheckedOutBooks(){
//		personBooks.removeAll();
//		String s = (activePerson.isMale())?
//				activePerson+" currently has nothing checked out under "+activePerson.getGenderPosessivePronoun()+" name.":
//					activePerson+" has the following titles checked out under "+activePerson.getGenderPosessivePronoun()+" name.";
//
//		personBooksAdd(new JLabel(s), .8,0,0);
//		personBooksAdd(reshelve, REHELVE_Y, 0, REHELVE_X);
//		int count = 0;
//		for(final Book b: activePerson.getCheckedOutBooks()){
//			int width=180;
//			personBooksAdd(new JLabel(b.getTitle()), 2, width,count*width+5);
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");    
//			Date outDate = new Date(b.getCheckOutDate());
//			Date dueDate = new Date(b.getDueDate());
//			personBooksAdd(new JLabel("Checked out: "+sdf.format(outDate)), 3, width,count*width+5);
//			personBooksAdd(new JLabel("Due: "+sdf.format(dueDate)), 4, width,count*width+5);
//			personBooksAdd(new JLabel("Time left: "+(b.getSecondsRemaining())), 5, width,count*width+5);
//			JButton returnBook = new JButton("Return");
//			returnBook.addActionListener(new ActionListener() {
//
//				public void actionPerformed(ActionEvent e) { 
//					activePerson.returnBook(b);
//					updateCheckedOutBooks();
//					personBooks.revalidate();
//					personBooks.repaint();
//					redoBookImage();
//					repaint();
//
//
//				}
//			});
//			JButton renewBook = new JButton("Renew");
//			renewBook.addActionListener(new ActionListener() {
//
//				public void actionPerformed(ActionEvent e) {
//					if(b.getDueDate()<System.currentTimeMillis()){
//						warning.setText(activePerson+", you cannot renew an overdue book!");
//					}else if(activePerson.getBalance().getAmount()<0){
//						warning.setText(activePerson+", you cannot renew a book when you owe money!");
//					}else{
//						activePerson.renewBook(b);
//						updateCheckedOutBooks();
//					}
//
//				}
//			});
//			personBooksAdd(returnBook, 6, width/2,count*width);
//			personBooksAdd(renewBook, 6, width/2,count*width + width/2+5);
//			count++;
//		}
//		layout.putConstraint(SpringLayout.SOUTH, personBooks, PERSON_VIEW_HEIGHT, SpringLayout.SOUTH, this);
//		personBooks.revalidate();
//		personBooks.repaint();
//	}
//
//	private void addListeners() {
//		this.addComponentListener(new java.awt.event.ComponentAdapter() 
//		{
//			public void componentResized(ComponentEvent e)
//			{ 
//				redoBookImage();
//			}
//		});
//		checkOut.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				try{
//					if(activePerson.getBalance().getAmount()>=0){
//						activePerson.checkOutBook(activeBook);
//						warning.setText("");
//						selectedBook.setText("No Book selected");
//						selectedBookDescription.setText("The books look inspiring, stacked so neatly on the shelf.");
//						checkOut.setEnabled(false);
//						updateCheckedOutBooks();
//						redoBookImage();
//						repaint();
//					}else{
//						warning.setText(activePerson+" owes money to the library! Reshelve some books to make it up.");
//					}
//				}catch(Exception ex){
//
//				}
//
//			}
//		});
//		reshelve.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				long lastWorked = activePerson.getBalance().getLastWorked();
//				double priorAmount = activePerson.getBalance().getAmount();
//				long timeNow = System.currentTimeMillis();
//				String s = activePerson.getBalance().earnMoney(timeNow);
//				if(timeNow-lastWorked<10 && activePerson.getBalance().getAmount()>priorAmount){
//					warning.setText("YOU CHEATED! NO MONEY FOR YOU!");
//					activePerson.getBalance().setAmount(0);
//				}else{
//					selectedPerson.setText(activePerson.getLibraryDescription());
//					warning.setText(activePerson+" "+s);
//				}
//			}
//		});
//		people.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				try{
//					activePerson=people.getItemAt(people.getSelectedIndex());
//					selectedPerson.setText(activePerson.getLibraryDescription());
//					warning.setText("");
//					updateCheckedOutBooks();
//				}catch(Exception ex){}
//			}
//		});
//		addMouseListener(new MouseListener() {
//
//			public void mouseReleased(MouseEvent e) {
//
//
//			}
//
//			public void mousePressed(MouseEvent e) {
//
//
//			}
//
//			public void mouseExited(MouseEvent e) {
//
//
//			}
//
//			public void mouseEntered(MouseEvent e) {
//				boolean overBook=false;
//				for(BookSpot r:bookSpots){
//					if(r.contains(e.getX(), e.getY())){
//						Library.this.getRootPane().setCursor(new Cursor(Cursor.HAND_CURSOR));
//						overBook = true;
//					}
//				}
//				if(!overBook)Library.this.getRootPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//			}
//
//			public void mouseClicked(MouseEvent e) {
//				for(BookSpot r:bookSpots){
//					if(r.contains(e.getX(), e.getY())){
//						activeBook=r.getBook();
//						if(activePerson.getCheckedOutBooks().size()<Person.MAX_ALLOWED_BOOKS)checkOut.setEnabled(true);
//						selectedBook.setText(activeBook.toString());
//						selectedBookDescription.setText(activeBook.getDescription());
//						System.out.println(activeBook.getTitle());
//					}
//				}
//			}
//		});
//
//	}
//
//	private class BookSpot extends Rectangle{
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 2376420981255342038L;
//		private Book book;
//
//		public BookSpot(Book b, int x1, int y1, int x, int y) {
//			super(x1,y1,x,y);
//			book = b;
//		}
//
//		public Book getBook() {
//			return book;
//		}
//
//		public void setBook(Book book) {
//			activeBook = book;
//		}
//
//
//	}
//
//}
