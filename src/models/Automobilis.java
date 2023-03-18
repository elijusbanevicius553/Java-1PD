package models;

import annotations.ClassAnnotation;
import annotations.FieldAnnotation;
import annotations.MethodAnnotation;
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
    public Automobilis(String marke, int metai) {
        this.marke = marke;
        this.metai = metai;
    }
    @MethodAnnotation(name = "James Doe", date = "2023-04-01")
    public void myMethod() {

    }

    public void deprecatedMethod() {
        System.out.println("This method is deprecated.");
    }

}
