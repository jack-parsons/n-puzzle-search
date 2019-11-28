package src.search;

import java.util.Stack;

public class DFS extends Search {
    private Stack<Node> fringe = new Stack<>();

    /**
     * DFS needs the order the nodes are added to the queue to be random for an infinite depth
     * This is to stop it getting trapped in a cycle, for example contiguously going left.
     */
    @Override
    boolean isRandom() {
        return true;
    }

    public Node getNextNode() {
        return fringe.pop();
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