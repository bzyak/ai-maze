package aim;

import java.awt.Color;

public interface IMazePainter {

    public void drawMaze();

    public int getSpeed();

    public void drawPath();

    public Color getBackgroundColor();

    public Color getPathPointColor();

    public Color getDestroyedPathColor();

    public double getPathPointWidth();

    public Color getNPointColor();

    public Color getWallColor();

    public double getNPointSize();

    public double getTopLeftIndex();

}
