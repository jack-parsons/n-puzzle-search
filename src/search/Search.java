package src.search;

import java.util.Collections;
import java.util.List;

public abstract class Search {
    public abstract Node getNextNode();
    public abstract void addNode(Node node);

    public Node findSolution(Node initialNode) throws NoSolutionException {
        addNode(initialNode);
        Node currentNode;
        while ((currentNode=getNextNode()) != null) {
            List<Node> l = currentNode.getSuccessors();
            Collections.shuffle(l);
            for (Node newNode : l) {
//                System.out.println(newNode.getState();
                if (newNode.goalTest()) {
                    return newNode;
                }
                addNode(newNode);
            }
        }
        throw new NoSolutionException("No solution found");
    }
}