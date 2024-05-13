package my_project.model;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerupManager extends GraphicalObject {

    public PowerupManager(double x, double y) {
        this.x = x;
        this.y = y;
    }



    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(new Color(255, 0, 0));
        drawTool.drawFilledCircle(x, y, 30);
    }
}