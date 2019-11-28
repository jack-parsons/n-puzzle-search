package src.search;

import java.util.Stack;

public class DLS extends Search {
    private Stack<Node> fringe = new Stack<>();
    private int depthLimit;

    DLS (int depthLimit) {
        this.depthLimit = depthLimit;
    }

    public Node getNextNode() {
        if (!fringe.empty())
            return fringe.pop();
        else
            return null;
    }

    public void addNode(Node node) {
        if (node.getDepth() <= depthLimit)
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