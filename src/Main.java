import annotations.ClassAnnotation;
import annotations.FieldAnnotation;
import annotations.MethodAnnotation;
import exceptions.InvalidMetaiException;
import exceptions.InvalidMarkeException;
import filter.CarFilter;
import models.Automobilis;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InvalidMarkeException {
        System.out.println("================= PAIR =================");
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

        System.out.print("========= Comparable/Comparator =========");
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

        try {
            // Gauname Automobilis klasės anotaciją
            System.out.println("================= ANOTACIJOS ============");
            Class<Automobilis> automobilisClass = Automobilis.class;
            ClassAnnotation classAnnotation = automobilisClass.getAnnotation(ClassAnnotation.class);
            System.out.println("Automobilis KLASĖS anotacija: " + classAnnotation.name() + ", " + classAnnotation.date());

            // Gauname laukų anotacijas
            Field[] fields = automobilisClass.getDeclaredFields();
            for (Field field : fields) {
                FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
                if (fieldAnnotation != null) {
                    System.out.println("Laukas " + field.getName() + " su anotacija: " + fieldAnnotation.name() + ", " + fieldAnnotation.date());
                }
            }

            // Gauname metodų anotacijas
            Method[] methods = automobilisClass.getDeclaredMethods();
            for (Method method : methods) {
                MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
                if (methodAnnotation != null) {
                    System.out.println("Metodas " + method.getName() + " su anotacija: " + methodAnnotation.name() + ", " + methodAnnotation.date());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("============= EXCEPTIONS ============");
        try {
            Automobilis auto1 = new Automobilis("", 2023); // Ši eilutė sukels InvalidMarkeException
        } catch (InvalidMarkeException e) {
            System.out.println("Klaida sukuriant automobilį: " + e.getMessage());
        }

        try {
            Automobilis auto2 = new Automobilis("Audi", 1850); // Ši eilutė sukels InvalidMetaiException
        } catch (InvalidMetaiException e) {
            System.out.println("Klaida sukuriant automobilį: " + e.getMessage());
        }

        System.out.println("=============== FILTER/INTERFACE ============");
        // Sukuriame CarFilter interfeiso objektą, kuris filtruos automobilius pagal metus
        CarFilter carFilter = (automobilis) -> automobilis.getMetai() > 2023;

        List<Automobilis> filteredCars = automobiliuSarasas.stream()
                .filter(carFilter::filter)
                .collect(Collectors.toList());

        System.out.println("\nAutomobiliai, vyresni nei 2023 metai:");
        filteredCars.forEach(System.out::println);

        // Panaudojame java.util.function.Predicate interfeisą filtravimui
        Predicate<Automobilis> predicate = (automobilis) -> automobilis.getMarke().startsWith("B");

        List<Automobilis> bmwCars = automobiliuSarasas.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println("\nAutomobiliai, kurių markė prasideda raide B:");
        bmwCars.forEach(System.out::println);
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