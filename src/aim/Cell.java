package aim;

public class Cell {

    protected MazeObject north = MazeObject.WALL;
    protected MazeObject south = MazeObject.WALL;
    protected MazeObject west = MazeObject.WALL;
    protected MazeObject east = MazeObject.WALL;
    private boolean _isVisited = false;
    private boolean isDestroyed = false;

    public void setIsVisited(boolean _isVisited) {
        this._isVisited = _isVisited;
    }

    protected boolean isIsVisited() {
        return _isVisited;
    }

    public void setDestroy() {
        this.isDestroyed = true;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    protected void visit() {
        _isVisited = true;
    }

}
