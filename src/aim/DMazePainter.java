package aim;

// Dark Maze Painter
import java.awt.Color;

public class DMazePainter implements IMazePainter {

    private final Maze _MAZE;

    public DMazePainter(Maze _maze) {
        this._MAZE = _maze;
        StdDraw.setXscale(0, _maze.builder.getMazeSize() + 2);
        StdDraw.setYscale(0, _maze.builder.getMazeSize() + 2);
    }

    @Override
    public void drawMaze() {

        StdDraw.setPenColor(getNPointColor());
        StdDraw.filledRectangle(
                _MAZE.builder.getFinalX() + getTopLeftIndex(),
                _MAZE.builder.getFinalY() + getTopLeftIndex(),
                getNPointSize(),
                getNPointSize());
        StdDraw.filledRectangle(
                _MAZE.builder.getStartX() + getTopLeftIndex(),
                _MAZE.builder.getStartY() + getTopLeftIndex(),
                getNPointSize(),
                getNPointSize()
        );
        StdDraw.setPenColor(StdDraw.DARK_GRAY);

        for (int x = 1; x <= _MAZE.builder.getMazeSize(); x++) {
            for (int y = 1; y <= _MAZE.builder.getMazeSize(); y++) {
                if (_MAZE.cells[x][y].south == MazeObject.WALL) {
                    StdDraw.line(x, y, x + 1, y);
                }
                if (_MAZE.cells[x][y].north == MazeObject.WALL) {
                    StdDraw.line(x, y + 1, x + 1, y + 1);
                }
                if (_MAZE.cells[x][y].west == MazeObject.WALL) {
                    StdDraw.line(x, y, x, y + 1);
                }
                if (_MAZE.cells[x][y].east == MazeObject.WALL) {
                    StdDraw.line(x + 1, y, x + 1, y + 1);
                }
            }

        }
        StdDraw.show(500);
    }

    @Override
    public void drawPath() {
        for (int x = 1; x <= _MAZE.builder.getMazeSize(); x++) {
            for (int y = 1; y <= _MAZE.builder.getMazeSize(); y++) {
                if (_MAZE.cells[x][y].isDestroyed()) {
                    StdDraw.setPenColor(getBackgroundColor());
                    StdDraw.filledRectangle(
                            x + getTopLeftIndex(),
                            y + getTopLeftIndex(),
                            getPathPointWidth() * 2,
                            getPathPointWidth() * 2);
                }
            }

        }
        StdDraw.show();
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public Color getBackgroundColor() {
        return Color.BLACK;
    }

    @Override
    public Color getPathPointColor() {
        return Color.GREEN;
    }

    @Override
    public Color getDestroyedPathColor() {
        return Color.RED;
    }

    @Override
    public double getPathPointWidth() {
        return 0.2;
    }

    @Override
    public Color getNPointColor() {
        return Color.CYAN;
    }

    @Override
    public Color getWallColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    public double getNPointSize() {
        return 0.35;
    }

    @Override
    public double getTopLeftIndex() {
        return 0.5;
    }

}
