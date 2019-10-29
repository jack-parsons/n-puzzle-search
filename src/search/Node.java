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
    @Override
    public int compareTo(Node o) {
        return this.getEstimate().compareTo(o.getEstimate());
    }
    public List<Action> getActions() {
        List<Action> actions = new LinkedList<>();
        Node curNode = this;
        while ((curNode=curNode.getParent()) != null) {
            actions.add(curNode.getAction());
        }
        return actions;
    }
}