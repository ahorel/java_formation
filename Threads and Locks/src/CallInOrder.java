import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Avec le code suivant : 
public class Foo {
	public Foo() {
		//...
	}
	public void first() {
		// ...
	}
	public void second() {
		// ...
	}
	public void third() {
		// ...
	}
}
//La même instance de Foo sera passée à trois threads différents appliqués à chaque méthode
// Créer un mecanisme permettant d'appeler le threadA pour la méthode first en premier, puis le thread B pour la méthode second, et le thread C pour la méthode third

//Crée un lock car un thread va exécuter le constructor et d'autres threads vont appeler les methodes first second et third produisant des lock
// et des unlock
public class FooBad {
	private Lock lock1;
	private Lock lock2;
	
	public FooBad() {
		try{
			lock1 = new ReentrantLock();
			lock2 = new ReentrantLock();
			
			lock1.lock();
			lock2.lock();
		}
		catch(Exception e) {
			//...
		}
	 
	}
	
	public void first() {
		try{
			// ...
			lock1.unlock(); //mark finished with first	
		}
		catch(Exception e) {
			//...
		}
		
	}
	
	public void second() {
		try{
			lock1.lock();
			lock1.unlock(); //check if first is finished totally
			//...
			lock2.unlock();
		}
		catch(Exception e) {
			//...
		}
	}
	
	public void third() {
		try{
			lock2.unlock();
			lock2.lock();
		}
		catch(Exception e) {
			//...
		}
	}
}

//Utilisation des semaphores
public class FooGood {
	private Semaphore sem1;
	private Semaphore sem2;
	
	public FooGood() {
		try{
			sem1 = new Semaphore(1);
			sem2 = new Semaphore(2);
			
			sem1.acquire();
			sem2.acquire();
		}
		catch(Exception e) {
			//...
		}
	 
	}
	
	public void first() {
		try{
			// ...
			sem1.release(); //mark finished with first	
		}
		catch(Exception e) {
			//...
		}
		
	}
	
	public void second() {
		try{
			sem1.acquire();
			sem1.release(); //check if first is finished totally
			//...
			sem2.release();
		}
		catch(Exception e) {
			//...
		}
	}
	
	public void third() {
		try{
			sem2.acquire();
			sem2.release();
		}
		catch(Exception e) {
			//...
		}
	}
}