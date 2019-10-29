package src.search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Search {
    private Queue<Node> fringe = new LinkedList<>();

    public Node getNextNode() {
        return fringe.poll();
    }

    public void addNode(Node node) {
        fringe.add(node);
    }
}