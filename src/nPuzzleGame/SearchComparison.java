package src.nPuzzleGame;

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
        int actualD = 0;
        NPuzzleState iState = state;
        while (actualD < shuffleDepth) {
            NPuzzleState newState = state.moveAgent(getMoves()[rand.nextInt(getMoves().length)]);
            state = newState==null ? state : newState;

            Node initialNode = new NPuzzleNode(null, null,
                    iState, state,0, 0);
            try {
                actualD = (new AStar()).findSolution(initialNode.copy()).getActions().size();
            } catch (NoSolutionException e) {
                e.printStackTrace();
            }
        }
        return state;
    }

    private static Search[] getSearches() {
        return new Search[]{new BFS(), new IDS(), new AStar()};
    }

    public static void main(String[] args) {
        boolean timeComplexity = false;
        int maxD = 10, iters = 100;
        for (int d = 1; d <= maxD; d++) {
            int[] averages = new int[getSearches().length];
            for (int i = 0; i < iters; i++){
                Search[] searches = getSearches();
                Node initialNode = new NPuzzleNode(null, null,
                        new NPuzzleState(SearchComparison.generateStartingState()),
                        shuffleState(new NPuzzleState(SearchComparison.generateStartingState()), d),
                        0, 0);

                for (int s = 0; s < searches.length; s ++) {
                    try {
                        Solution sol = searches[s].findSolution(initialNode.copy());
                        if (timeComplexity)
                            averages[s] += sol.getNodesGenerated();
                        else
                            averages[s] += sol.getNodesStored();
//                        if (s==0)
//                        System.out.println(sol.getNodesGenerated());
                    } catch (NoSolutionException e) {
                        System.out.println("No solution");
                        return;
                    }
                }
            }
            System.out.print("\n" + d + "\t");
            for (int s = 0; s < getSearches().length; s ++) {
                System.out.print(averages[s]/iters + "\t");
            }
        }
    }
}
