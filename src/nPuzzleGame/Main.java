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
        Node initialNode = new NPuzzleNode(null, null, new NPuzzleState(initialBoard), (NPuzzleState state) -> {
            for (int x = 0; x < state.getWidth(); x++) {
                for (int y = 0; y < state.getHeight(); y++) {
                    Vector pos = new Vector(x, y);
                    if (state.getCell(pos) != CellType.AGENT && goalState.getCell(pos) != state.getCell(pos)) {
                        return false;
                    }
                }
            }
            return true;
        }, 0);
        try {
            for (Action action : search.findSolution(initialNode).getActions()) {
                System.out.println(action);
            }
        } catch (NoSolutionException e) {
            System.out.println("No Solution found...");
        }
    }
}