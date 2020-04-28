
public class Philosopher extends Thread {
	private int bites = 10;
	private Chopstick left;
	private Chopstick right;
	
	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
	}
	
	private void eat() {
		pickUp();
		chew();
		putDown();
	}
	
	private void putDown() {
		right.putdown();
		left.putdown();
	}
	
	private void pickUp() {
		right.pickup();
		left.pickup();
	}
	
	private void chew() {
		//
	}
	
	public void run() {
		for (int i = 0 ; i < bites; i++) {
			eat();
		}
	}
}
// => mène à un dead lock et dans le thread utilisé tous les philosophes ont utilisé la bière de gauche et attendent la bière de droite 

// Solution 1, les philosophes posent la bière de gauche si ils ne sont pas capables de prendre celle de droite

public class Philosopher_solution1 extends Thread{
	private int bites = 10;
	private Chopstick_solution1 left;
	private Chopstick_solution1 right;
	
	private boolean pickup() {
		//Attempt to pick up
		if(!(left.pickup())) {
			return false;
		}
		if(!right.pickup()) {
			left.putdown();
			return false;
		}
		return true;
	}
	
	public void eat() {
		if(pickup()) {
			chew();
			putdown();
		}
	}
	
	private void chew() {
		//
	}
	
	private void putdown() {
		right.putdown();
		left.putdown();
	}
}

//If we can't pick up the right chopstick, we release the left one 

// Solution 2 : Prioritize the chop sticks with a label from 0 to N. Each philosophes will try to get on his left hand the lowered number chopstick first.
// This will mean each philosophers will try to get the left one before the right one 

public class Philosopher_solution2 extends Thread{
	private int bites = 10;
	private Chopstick_solution2 lower;
	private Chopstick_solution2 higher;
	private int index;
	
	public Philosopher_solution2(int i, Chopstick_solution2 left, Chopstick_solution2 right) {
		index = i;
		if(lower.getNumber() <= higher.getNumber()) {
			this.lower = left;
			this.higher = right;
		} else {
			this.lower = right;
			this.higher = left;
		}
	}
	
	private boolean pickup() {
		//Attempt to pick up
		lower.pickup();
		higher.pickup();
	}
	
	public void eat() {
		pickup();
		chew();
		putdown();
	}
	
	private void chew() {
		//
	}
	
	private void putdown() {
		higher.putdown();
		lower.putdown();
	}
	
	public void run () {
		for (int i = 0; i < bites; i++) {
			eat();
		}
	}
}