package src.search;

import java.util.List;

public class Solution {
    private List<Action> actions;
    private int nodesGenerated;
    private int nodesStored;
    private Node finalNode;

    Solution(Node finalNode, int nodesGenerated, int nodesStored) {
        this.actions = finalNode.getActions();
        this.nodesGenerated = nodesGenerated;
        this.nodesStored = nodesStored;
        this.finalNode = finalNode;
    }

    public List<Action> getActions() {
        return actions;
    }
    public int getNodesGenerated() {
        return nodesGenerated;
    }
    public int getNodesStored() {
        return nodesStored;
    }
    public Node getFinalNode() {
        return finalNode;
    }
}
