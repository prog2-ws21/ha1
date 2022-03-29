package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.DummyBowlImpl;
import htw.berlin.wi.prog2.domain.Bowl;

public class BowlBuilder {

    public BowlBuilder add(Ingredient ingredient) {
        // TODO hier die Annahme von Zutaten implementieren
        return this; // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im BowlBuilderTest)
    }

    public Bowl buildPrecomputed() {
        // TODO hier stattdessen die neue Klasse PrecomputedBowl verwenden
        return new DummyBowlImpl();
    }

    public Bowl buildDynamicallyComputed() {
        // TODO hier stattdessen die neue Klasse DynamicallyComputedBowl verwenden
        return new DummyBowlImpl();
    }
}
