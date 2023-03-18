import java.util.*;

class Automobilis implements Comparable<Automobilis> {
    private String marke;
    private int metai;

    public Automobilis(String marke, int metai) {
        this.marke = marke;
        this.metai = metai;
    }

    public String getMarke() {
        return marke;
    }

    public int getMetai() {
        return metai;
    }

    @Override
    public int compareTo(Automobilis o) {
        return marke.compareTo(o.marke);
    }

    @Override
    public String toString() {
        return "Automobilis{" +
                "marke='" + marke + '\'' +
                ", metai=" + metai +
                '}';
    }
}
