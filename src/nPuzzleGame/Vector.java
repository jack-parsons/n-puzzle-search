package src.nPuzzleGame;

class Vector {
    int x, y;
    Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int manhattan(Vector o) {
        return Math.abs(o.x-this.x) + Math.abs(o.y-this.y);
    }
}