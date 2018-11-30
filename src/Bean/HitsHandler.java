package Bean;

import java.util.*;

public class HitsHandler {

    public ArrayDeque<Hit> getPreviousHits() {
        return previousHits.clone();
    }

    public void setPreviousHits(ArrayDeque<Hit> previousHits) {
        this.previousHits = previousHits;
    }

    private ArrayDeque<Hit> previousHits = new ArrayDeque<>();
}