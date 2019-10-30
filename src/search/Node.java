package src.search;

import java.util.LinkedList;
import java.util.List;

public abstract class Node implements Comparable<Node> {
    public abstract Node getParent();
    public abstract Action getAction();
    public abstract State getState();
    public abstract Comparable getEstimate();
    public abstract List<Node> getSuccessors();
    public abstract boolean goalTest();
    public abstract int getDepth();
    @Override
    public int compareTo(Node o) {
        return this.getEstimate().compareTo(o.getEstimate());
    }
    public List<Action> getActions() {
        List<Action> actions = new LinkedList<>();
        Node curNode = this;
        while (curNode != null) {
            if (curNode.getAction() != null) {
                actions.add(curNode.getAction());
            }
            curNode=curNode.getParent();
        }
        return actions;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        System.out.println(String.format("Depth: %d\n%s" ,getDepth(), getState()));
        return s.toString();
    }
}