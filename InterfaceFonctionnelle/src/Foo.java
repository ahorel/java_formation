@FunctionalInterface
interface TestFunctionalInterface {
	public abstract void sayHello(String a, String b);
}

@FunctionalInterface
public interface TestInterface {
	public abstract void show(int n);
	public static void hello() {
		System.out.println("static method");
	}
	public default void test() {
		System.out.println("default method");
	}
}

@FunctionalInterface
public interface Foo {
    String method(String string);
}

public class UseFoo {
	public String add(String string, Foo foo) {
	    return foo.method(string);
	}
}

public class FooHandle {
	public void handler() {
		UseFoo useFoo = new UseFoo();
		Foo foo = parameter -> parameter + " from lambda";
		String result = useFoo.add("Message ", foo);
		System.out.println(result);
		
		TestInterface g = (n) -> System.out.println(n);
	}
}
