package src.nPuzzleGame;

import src.search.*;

import java.util.List;

class SearchTest {
    public static void main(String[] args) {
        Search search;
        switch (args[0]) {
            case "DFS":
                search = new DFS();
                break;
            case "BFS":
                search = new BFS();
                break;
            case "IDS":
                search = new IDS();
                break;
            case "ASTAR":
                search = new AStar();
                break;
            default:
                throw new IllegalArgumentException(String.format("Invalid search: %s", args[0]));
        }
        String[] initialBoard = {
                "----",
                "----",
                "----",
                "ABC☺",
        };
        NPuzzleState goalState = new NPuzzleState(new String[] {
                "----",
                "-A--",
                "-B--",
                "-C--",
        });
        Node initialNode = new NPuzzleNode(null, null, new NPuzzleState(initialBoard), goalState, 0, 0);
        try {
            Solution sol = search.findSolution(initialNode);
            List<Action> actions = sol.getActions();
            for (Action action : actions) {
                System.out.println(action);
            }
            System.out.println("Nodes explored: " + sol.getNodesExplored());
            System.out.println("Depth reached: " + actions.size());
        } catch (NoSolutionException e) {
            System.out.println("No Solution found...");
        }
    }
}