
public interface Interface1 {
	public void method1();
	default void log(String str) {
		System.out.println("Logger avec l'interface1 =" + str);
	}
}
