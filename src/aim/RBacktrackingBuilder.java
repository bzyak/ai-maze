package aim;

// Recursive Backtracking
import java.util.Random;

// http://cs.stanford.edu/people/eroberts/courses/cs106b/handouts/19-recursive-backtracking.pdf
public class RBacktrackingBuilder implements IMazeBuilder {

    protected final Maze MAZE;
    protected final int SIZE;
    protected final int BORDERS = 2;
    protected final int FINAL_X;
    protected final int FINAL_Y;
    protected final int START_X;
    protected final int START_Y;
    protected final Random RANDOM = new Random();

    public RBacktrackingBuilder(int _size, Maze _maze) {
        this.MAZE = _maze;
        this.SIZE = _size;
        this.FINAL_X = RANDOM.nextInt(_size) + 1;
        this.FINAL_Y = RANDOM.nextInt(_size) + 1;
        this.START_X = RANDOM.nextInt(_size) + 1;
        this.START_Y = RANDOM.nextInt(_size) + 1;
    }

    @Override
    public void buildMaze() {
        initCells();
        markNorthSouthBordersVisited();
        markWestEastBordersVisited();
        buildMaze(1, 1);
        resetCells();
    }

    public void initCells() {
        MAZE.cells = new Cell[SIZE + BORDERS][SIZE + BORDERS];
        for (int x = 0; x < SIZE + BORDERS; x++) {
            for (int y = 0; y < SIZE + BORDERS; y++) {
                MAZE.cells[x][y] = new Cell();
            }
        }
    }

    public void resetCells() {
        for (int x = 1; x <= SIZE; x++) {
            for (int y = 1; y <= SIZE; y++) {
                MAZE.cells[x][y].setIsVisited(false);
            }
        }
    }

    public void markNorthSouthBordersVisited() {
        for (int i = 0; i < SIZE + 2; i++) {
            MAZE.cells[i][0].visit();
            MAZE.cells[i][SIZE + 1].visit();
        }
    }

    public void markWestEastBordersVisited() {
        for (int y = 0; y < SIZE + 2; y++) {
            MAZE.cells[0][y].visit();
            MAZE.cells[SIZE + 1][y].visit();
        }
    }

    public boolean isVisitedAt(int x, int y, MazeDirection dir) {
        return MAZE.cells[dir.getNextX(x, y)][dir.getNextY(x, y)].isIsVisited();
    }

    public boolean hasAnyUnvisitedCellAt(int x, int y) {
        return !isVisitedAt(x, y, MazeDirection.NORTH)
                || !isVisitedAt(x, y, MazeDirection.EAST)
                || !isVisitedAt(x, y, MazeDirection.SOUTH)
                || !isVisitedAt(x, y, MazeDirection.WEST);
    }

    public void moveToNorth(int x, int y) {
        MAZE.cells[MazeDirection.CURRENT.getNextX(x, y)][MazeDirection.CURRENT.getNextY(x, y)].north = MazeObject.EMPTY;
        MAZE.cells[MazeDirection.NORTH.getNextX(x, y)][MazeDirection.NORTH.getNextY(x, y)].south = MazeObject.EMPTY;
    }

    public void moveToEast(int x, int y) {
        MAZE.cells[MazeDirection.CURRENT.getNextX(x, y)][MazeDirection.CURRENT.getNextY(x, y)].east = MazeObject.EMPTY;
        MAZE.cells[MazeDirection.EAST.getNextX(x, y)][MazeDirection.EAST.getNextY(x, y)].west = MazeObject.EMPTY;
    }

    public void moveToSouth(int x, int y) {
        MAZE.cells[MazeDirection.CURRENT.getNextX(x, y)][MazeDirection.CURRENT.getNextY(x, y)].south = MazeObject.EMPTY;
        MAZE.cells[MazeDirection.SOUTH.getNextX(x, y)][MazeDirection.SOUTH.getNextY(x, y)].north = MazeObject.EMPTY;
    }

    public void moveToWest(int x, int y) {
        MAZE.cells[MazeDirection.CURRENT.getNextX(x, y)][MazeDirection.CURRENT.getNextY(x, y)].west = MazeObject.EMPTY;
        MAZE.cells[MazeDirection.WEST.getNextX(x, y)][MazeDirection.WEST.getNextY(x, y)].east = MazeObject.EMPTY;
    }

    public void buildMaze(int x, int y) {
        MAZE.cells[x][y].visit();
        while (hasAnyUnvisitedCellAt(x, y)) {
            while (true) {
                double r = Math.random();
                if (r < 0.25 && !isVisitedAt(x, y, MazeDirection.NORTH)) {
                    moveToNorth(x, y);
                    buildMaze(x, y + 1);
                    break;
                } else if (r >= 0.25 && r < 0.50 && !isVisitedAt(x, y, MazeDirection.EAST)) {
                    moveToEast(x, y);
                    buildMaze(x + 1, y);
                    break;
                } else if (r >= 0.5 && r < 0.75 && !isVisitedAt(x, y, MazeDirection.SOUTH)) {
                    moveToSouth(x, y);
                    buildMaze(x, y - 1);
                    break;
                } else if (r >= 0.75 && r < 1.00 && !isVisitedAt(x, y, MazeDirection.WEST)) {
                    moveToWest(x, y);
                    buildMaze(x - 1, y);
                    break;
                }
            }
        }
    }

    @Override
    public boolean isWithinBoundaries(int x, int y) {
        return x == 0 || y == 0 || x == SIZE + 1 || y == SIZE + 1;
    }

    @Override
    public boolean isMazeEnd(int x, int y) {
        return x == FINAL_X && y == FINAL_Y;
    }

    @Override
    public int getMazeSize() {
        return SIZE;
    }

    @Override
    public int getFinalX() {
        return FINAL_X;
    }

    @Override
    public int getFinalY() {
        return FINAL_Y;
    }

    @Override
    public int getStartX() {
        return START_X;
    }

    @Override
    public int getStartY() {
        return START_Y;
    }

}
