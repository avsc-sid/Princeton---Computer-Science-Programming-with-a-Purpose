// Assignment 1 - HelloWorld
public class HelloWorld {
    public static void main(String[] args) {
        // print hello world on screen
        System.out.println("Hello, World");

        int[] a = new int[10];

        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;

        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];

        System.out.println(a[5]);

    }
}
