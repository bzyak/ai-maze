package aim;

public final class Maze {

    protected Cell[][] cells;
    protected IMazeStrategy algorithm;
    protected IMazeBuilder builder;
    protected IMazePainter painter;

    public Maze(int size) {
        this.algorithm = new BFirstStrategy(this);
        this.builder = new RBacktrackingBuilder(size, this);
        this.painter = new DMazePainter(this);
    }

}
