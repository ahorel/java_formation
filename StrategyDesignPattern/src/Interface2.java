
@FunctionalInterface
public interface Interface2 {
	public String method2();
	default void log(String str) {
		System.out.println("Logger avec l'interface2 =" + str);
	}
}

