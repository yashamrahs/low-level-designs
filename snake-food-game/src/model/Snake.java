package model;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Snake {
    private Deque<Pair> body;
    private Map<Pair, Boolean> positionMap;

    public Snake() {
        body = new LinkedList<>();
        positionMap = new HashMap<>();

        Pair start = new Pair(0, 0);
        body.offerFirst(start);
        positionMap.put(start, true);
    }

    public Deque<Pair> getBody() {
        return body;
    }

    public Map<Pair, Boolean> getPositionMap() {
        return positionMap;
    }
}
