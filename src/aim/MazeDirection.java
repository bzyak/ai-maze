package aim;

enum MazeDirection {

    // CURRENT +0,+0
    //              NORTH
    //       -1,+1  +0,+1  +1,+1
    // WEST  -1,+0  +0,+0  +1,+0   EAST
    //       -1,-1  +0,-1  +1,-1
    //              SOUTH
    CURRENT(+0, +0),
    NORTH(+0, +1),
    SOUTH(+0, -1),
    WEST(-1, +0),
    EAST(+1, +0);

    private final int _x, _y;

    private MazeDirection(int _x, int _y) {
        this._x = _x;
        this._y = _y;
    }

    public int getNextX(int x, int y) {
        return x + _x;
    }

    public int getNextY(int x, int y) {
        return y + _y;
    }

}
