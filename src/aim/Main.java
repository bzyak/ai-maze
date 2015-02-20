package aim;

public class Main {

    public static void main(String[] args) {
        StdDraw.show(0);
        Maze maze = new Maze(50);
        maze.builder.buildMaze();
        maze.painter.drawMaze();
        maze.algorithm.findPath();
    }
}
