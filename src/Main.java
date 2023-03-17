public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "Hello");
        System.out.println(pair.getFirst());    // Output: 10
        System.out.println(pair.getSecond());   // Output: Hello
        pair.setFirst(20);
        pair.setSecond("World");
        System.out.println(pair.getFirst());    // Output: 20
        System.out.println(pair.getSecond());   // Output: World
    }
}