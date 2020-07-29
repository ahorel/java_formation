public class UseFoo {
	public String add(String string, Foo foo) {
	    return foo.method(string);
	}
	
	public static void main(String[] args) {
		UseFoo useFoo = new UseFoo();
		Foo foo = parameter -> parameter + " from lambda";
		String result = useFoo.add("Message ", foo);
		System.out.println(result);
		/*
		NameParser parser = new NameParser();
		Name res = (Name) parser.parse("Eric Clapton", Name::new);
		System.out.println("res name=" + res.getFirstName() + " res nickname=" + res.getLastName());
		*/
		
		NameParser parser = new NameParser();
		Name resWithLambda = (Name) parser.parse("Eric Clapton", (s1, s2) -> new Name(s1, s2));
		System.out.println("resWithLambda name=" + resWithLambda.getFirstName() + " res nickname=" + resWithLambda.getLastName());
	}
}