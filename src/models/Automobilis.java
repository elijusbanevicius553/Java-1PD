package models;

import annotations.ClassAnnotation;
import annotations.FieldAnnotation;
import annotations.MethodAnnotation;
import exceptions.InvalidMarkeException;
import exceptions.InvalidMetaiException;
import lombok.Data;

@Data
@ClassAnnotation(name = "John Doe", date = "2023-01-01")
public class Automobilis implements Comparable<Automobilis> {
    @FieldAnnotation(name = "Jane Doe", date = "2023-02-01")
    private String marke;

    @FieldAnnotation(name = "John Doe", date = "2023-03-01")
    private int metai;

    @Override
    public int compareTo(Automobilis o) {
        return marke.compareTo(o.marke);
    }

    @MethodAnnotation(name = "James Doe", date = "2023-04-01")
    public void myMethod() {
        // Method implementation here
    }

    public void deprecatedMethod() {
        System.out.println("This method is deprecated.");
    }

    public Automobilis(String marke, int metai) throws InvalidMarkeException {
        if (marke == null || marke.isEmpty()) {
            throw new InvalidMarkeException("Marke negali būti tuščia arba null");
        }
        if (metai < 1900 || metai > 2100) {
            throw new InvalidMetaiException("Metai turi būti tarp 1900 ir 2100");
        }
        this.marke = marke;
        this.metai = metai;
    }
}
