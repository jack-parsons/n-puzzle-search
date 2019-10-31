package src.nPuzzleGame;

import src.search.*;

class Main {
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
            for (Action action : search.findSolution(initialNode).getActions()) {
                System.out.println(action);
            }
        } catch (NoSolutionException e) {
            System.out.println("No Solution found...");
        }
    }
}