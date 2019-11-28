package src.search;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Search {
    public abstract Node getNextNode();
    public abstract void addNode(Node node);
    public abstract String getFringeOutput();
    public abstract Node[] getFringe();
    int nodesGenerated = 1;

    boolean isRandom() {
        return false;
    }

    public Solution findSolution(Node initialNode) throws NoSolutionException {
        return findSolution(initialNode, isRandom());
    }

    public int getNumberNodesStored() {
        // Set only stores one copy of duplicates
        Set<Node> nodes = new HashSet<>();
        for (Node node : getFringe()) {
            nodes.addAll(node.getParents());
            nodes.add(node);
        }
        return nodes.size();
    }

    public Solution findSolution(Node initialNode, boolean random) throws NoSolutionException {
        addNode(initialNode);
        Node currentNode;
        while ((currentNode=getNextNode()) != null) {
            if (currentNode.goalTest()) {
                // +1 for the node just popped
                return new Solution(currentNode, nodesGenerated, getNumberNodesStored()+1);
            }
            List<Node> l = currentNode.getSuccessors();

            if (random) Collections.shuffle(l);

            for (Node newNode : l) {
                addNode(newNode);
                nodesGenerated++;
            }

//            System.out.println("\n***Next iteration***");
//            System.out.println(currentNode);
//            System.out.println("*******Fringe*******");
//            System.out.println(getFringeOutput());
        }
        throw new NoSolutionException("No solution found");
    }
}