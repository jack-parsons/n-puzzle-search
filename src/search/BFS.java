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

    @Override
    public String getFringeOutput() {
        StringBuilder s = new StringBuilder();
        Object[] f2 = fringe.toArray();
        for (Object n : f2) {
            s.append(n.toString());
        }
        return s.toString();
    }

    @Override
    public Node[] getFringe() {
        return fringe.toArray(new Node[0]);
    }
}