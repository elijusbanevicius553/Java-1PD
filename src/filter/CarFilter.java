package filter;

import models.Automobilis;

@FunctionalInterface
public interface CarFilter {
    boolean filter(Automobilis automobilis);
}