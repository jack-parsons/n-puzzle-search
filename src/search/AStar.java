package src.search;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStar extends Search {
    private PriorityQueue<Node> fringe = new PriorityQueue<>();

    public Node getNextNode() {
        return fringe.poll();
    }

    public void addNode(Node node) {
        fringe.add(node);
    }

    @Override
    public String getFringeOutput() {
        StringBuilder s = new StringBuilder();
        Object[] f2 = fringe.toArray();

        while(!fringe.isEmpty()) {
            s.append(fringe.poll());
        }
        for (Object o : f2) {
            addNode((Node)o);
        }
        return s.toString();
    }

    @Override
    public Node[] getFringe() {
        return fringe.toArray(new Node[0]);
    }
}