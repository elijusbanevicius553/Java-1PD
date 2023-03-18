import java.util.*;
public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "Hello");
        System.out.println(pair.getFirst());    // Output: 10
        System.out.println(pair.getSecond());   // Output: Hello
        pair.setFirst(20);
        pair.setSecond("World");
        System.out.println(pair.getFirst());    // Output: 20
        System.out.println(pair.getSecond());   // Output: World
        List<Automobilis> automobiliuSarasas = new ArrayList<>();
        automobiliuSarasas.add(new Automobilis("Audi", 2023));
        automobiliuSarasas.add(new Automobilis("BMW", 2024));
        automobiliuSarasas.add(new Automobilis("Mercedes", 2022));
        automobiliuSarasas.add(new Automobilis("Tesla", 2025));

        // Rūšiavimas pagal metus (Comparator)
        automobiliuSarasas.sort(Comparator.comparing(Automobilis::getMetai));
        System.out.println("Automobiliai pagal metus:");
        automobiliuSarasas.forEach(System.out::println);

        // Rūšiavimas pagal markę (Comparable)
        Collections.sort(automobiliuSarasas);
        System.out.println("\nAutomobiliai pagal markę:");
        automobiliuSarasas.forEach(System.out::println);

        // Rūšiavimas pagal markę atvirkštine tvarka (Comparator)
        automobiliuSarasas.sort(Comparator.comparing(Automobilis::getMarke).reversed());
        System.out.println("\nAutomobiliai pagal markę atvirkštine tvarka:");
        automobiliuSarasas.forEach(System.out::println);

        // Rūšiavimas pagal metus atvirkštine tvarka (Comparator)
        automobiliuSarasas.sort(Comparator.comparing(Automobilis::getMetai).reversed());
        System.out.println("\nAutomobiliai pagal metus atvirkštine tvarka:");
        automobiliuSarasas.forEach(System.out::println);
    }
}