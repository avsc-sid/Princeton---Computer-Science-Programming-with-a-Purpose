// Assignment 2 - HelloGoodbye
public class HelloGoodbye {
    public static void main(String[] args) {
        // Get input command line arguments (names)
        String name1 = args[0];
        String name2 = args[1];

        // hello message in original input order
        System.out.println("Hello " + name1 + " and " + name2 + ".");

        // goodbye message with the names reversed
        System.out.println("Goodbye " + name2 + " and " + name1 + ".");
    }
}
