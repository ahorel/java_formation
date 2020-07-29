public class NameParser<T> {
    public  T parse(String name, Creator creator) {
        String[] tokens = name.split(" ");
        String firstName = tokens[0];
        String lastName = tokens[1];
        return (T) creator.create(firstName, lastName);
    }
}