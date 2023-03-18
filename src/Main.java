import java.util.*;
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> automobilisPair = new Pair<>("Audi", 2023);
        System.out.println(automobilisPair.getFirst()); // Output: Audi
        System.out.println(automobilisPair.getSecond()); // Output: 2023
        automobilisPair.setFirst("BMW");
        automobilisPair.setSecond(2024);
        System.out.println(automobilisPair.getFirst()); // Output: BMW
        System.out.println(automobilisPair.getSecond()); // Output: 2024
        List<Automobilis> automobiliuSarasas = new ArrayList<>();
        automobiliuSarasas.add(new Automobilis("Audi", 2023));
        automobiliuSarasas.add(new Automobilis("BMW", 2024));
        automobiliuSarasas.add(new Automobilis("Mercedes", 2022));
        automobiliuSarasas.add(new Automobilis("Tesla", 2025));

        // Rūšiavimas pagal markę (Comparable)
        Collections.sort(automobiliuSarasas);
        System.out.println("\nAutomobiliai pagal markę:");
        automobiliuSarasas.forEach(System.out::println);

        // Rūšiavimas pagal metus (Comparator)
        automobiliuSarasas.sort(automobilisPagalMetai);
        System.out.println("\nAutomobiliai pagal metus:");
        automobiliuSarasas.forEach(System.out::println);

        // Rūšiavimas pagal markę atvirkštine tvarka (Comparator)
        automobiliuSarasas.sort(automobilisPagalMarkeAtvirkstineTvarka);
        System.out.println("\nAutomobiliai pagal markę atvirkštine tvarka:");
        automobiliuSarasas.forEach(System.out::println);

        // Rūšiavimas pagal metus atvirkštine tvarka (Comparator)
        automobiliuSarasas.sort(automobilisPagalMetaiAtvirkstineTvarka);
        System.out.println("\nAutomobiliai pagal metus atvirkštine tvarka:");
        automobiliuSarasas.forEach(System.out::println);
    }
    public static Comparator<Automobilis> automobilisPagalMarke = new Comparator<Automobilis>() {
        @Override
        public int compare(Automobilis o1, Automobilis o2) {
            return o1.getMarke().compareTo(o2.getMarke());
        }
    };

    public static Comparator<Automobilis> automobilisPagalMetai = new Comparator<Automobilis>() {
        @Override
        public int compare(Automobilis o1, Automobilis o2) {
            return o1.getMetai() - o2.getMetai();
        }
    };

    public static Comparator<Automobilis> automobilisPagalMarkeAtvirkstineTvarka = new Comparator<Automobilis>() {
        @Override
        public int compare(Automobilis o1, Automobilis o2) {
            return o2.getMarke().compareTo(o1.getMarke());
        }
    };

    public static Comparator<Automobilis> automobilisPagalMetaiAtvirkstineTvarka = new Comparator<Automobilis>() {
        @Override
        public int compare(Automobilis o1, Automobilis o2) {
            return o2.getMetai() - o1.getMetai();
        }
    };
}