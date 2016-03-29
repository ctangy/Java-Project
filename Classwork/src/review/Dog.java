package review;

public class Dog implements Animals {

	public Dog(){
		Animals a = new Dog();
		Frog b = new Frog();
		
		Dog c = (Dog) a;
		Animals d = b;
		Animals[] animals = {c,b};
		d.ribbit();
		animals[0].wagTail();
	}

	public void wagTail() {
		// TODO Auto-generated method stub
		
	}

	public void ribbit() {
		// TODO Auto-generated method stub
		
	}
}


