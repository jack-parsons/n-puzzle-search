package src.nPuzzleGame;

import src.nPuzzleGame.NPuzzleNode;
import src.nPuzzleGame.NPuzzleState;
import src.search.*;

import java.util.Random;

public class SearchComparison {
    private static String[] generateStartingState() {
        return new String[] {
                "----",
                "----",
                "----",
                "ABC☺",
        };
    }

    private static Vector[] getMoves() {
        return new Vector[] {new Vector(1, 0), new Vector(0, 1), new Vector(-1, 0), new Vector(0, -1)};
    }

    private static NPuzzleState shuffleState(NPuzzleState state, int shuffleDepth) {
        Random rand = new Random();
        for (int i = 0; i < shuffleDepth; i++) {
            NPuzzleState newState = state.moveAgent(getMoves()[rand.nextInt(getMoves().length)]);
            state = newState==null ? state : newState;
        }
        return state;
    }

    public static void main(String[] args) {
        Search[] searches = {new DFS(), new BFS(), new IDS(), new AStar()};
        for (int d = 0; d < 100; d ++) {
            Node initialNode = new NPuzzleNode(null, null,
                    new NPuzzleState(SearchComparison.generateStartingState()),
                    shuffleState(new NPuzzleState(SearchComparison.generateStartingState()), d),
                    0, 0);
            int actualD = 0;
            for (Search search : searches) {
                try {
                    Solution sol = search.findSolution(initialNode.copy());
                    actualD = sol.getActions().size();
                    System.out.print(sol.getNodesExplored() + "\t");
                } catch (NoSolutionException e) {
                    System.out.println("No solution");
                    return;
                }
            }
            System.out.print(actualD);
            System.out.println();
        }
    }
}
