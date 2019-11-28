package src.search;

import java.util.Collections;
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
    public abstract Node copy();
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
        Collections.reverse(actions);
        return actions;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        System.out.println(String.format("Depth:%d, Action:%s\nCost estimate:%s\n%s", getDepth(), getAction(), getEstimate(), getState()));
        return s.toString();
    }

    public List<Node> getParents() {
        List<Node> ps = new LinkedList<>();
        Node cur = this;
        while (cur.getParent() != null) {
            ps.add(cur.getParent());
            cur = cur.getParent();
        }
        return ps;
    }
}