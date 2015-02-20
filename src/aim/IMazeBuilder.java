package aim;

// http://www.oodesign.com/builder-pattern.html
public interface IMazeBuilder {

    public void buildMaze();

    public int getMazeSize();

    public boolean isWithinBoundaries(int x, int y);

    public boolean isMazeEnd(int x, int y);

    public int getFinalX();

    public int getFinalY();

    public int getStartX();

    public int getStartY();

}
