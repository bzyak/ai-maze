package aim;

// Breadth First Search
public class BFirstStrategy implements IMazeStrategy {

    private final Maze _maze;
    private boolean _isDone = false;

    public BFirstStrategy(Maze _maze) {
        this._maze = _maze;
    }

    private void start(int x, int y) {

        Cell curr = _maze.cells[x][y];

        if (_maze.builder.isWithinBoundaries(x, y)) {
            return;
        }
        if (_isDone || curr.isIsVisited()) {
            return;
        }
        curr.visit();

        double x0 = x + 0.5;
        double y0 = y + 0.5;
        double width = 0.2;

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(x0, y0, width, width);
        StdDraw.show(_maze.painter.getSpeed());

        if (_maze.builder.isMazeEnd(x, y)) {
            _isDone = true;
        }

        if (curr.north == MazeObject.EMPTY) {
            start(
                    MazeDirection.NORTH.getNextX(x, y),
                    MazeDirection.NORTH.getNextY(x, y));
        }
        if (curr.south == MazeObject.EMPTY) {
            start(
                    MazeDirection.SOUTH.getNextX(x, y),
                    MazeDirection.SOUTH.getNextY(x, y));
        }
        if (curr.west == MazeObject.EMPTY) {
            start(
                    MazeDirection.WEST.getNextX(x, y),
                    MazeDirection.WEST.getNextY(x, y));
        }

        if (curr.east == MazeObject.EMPTY) {
            start(
                    MazeDirection.EAST.getNextX(x, y),
                    MazeDirection.EAST.getNextY(x, y));
        }

        if (_isDone) {
            return;
        }

        _maze.cells[x][y].setDestroy();

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(x0, y0, width, width);
        StdDraw.show(_maze.painter.getSpeed());
    }

    @Override
    public void findPath() {
        _isDone = false;
        start(_maze.builder.getStartX(), _maze.builder.getStartY());
        _maze.painter.drawPath();
    }
}
