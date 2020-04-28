import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;

	public Chopstick() {
		lock = new ReentrantLock();
	}
	public void pickup() {
		lock.lock();
	}
	
	public void putdown() {
		lock.unlock(); 
	}
}

// Solution 1 : Le philosophe d�pose la bi�re de gauche s'il ne peut pas obtenir la bi�re de droite 

public class Chopstick_solution1 {
	private Lock lock;

	public Chopstick_solution1() {
		lock = new ReentrantLock();
	}
	
	public boolean pickup() {
		return lock.tryLock();
	}
	
	public void putdown() {
		lock.unlock(); 
	}
}

//Solution 2 : Ajout de la m�thode getNumber pour identifier chaque ChopStick


public class Chopstick_solution2 {
	private Lock lock;
	private int number;
	
	public Chopstick_solution2(int n) {
		lock = new ReentrantLock();
		this.number = n;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void pickup() {
		lock.lock();
	}
	
	public void putdown() {
		lock.unlock(); 
	}
}