package my_project.model;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PowerupManager extends GraphicalObject {

    private Timer timer;
    private boolean powerUpActiveFast;
    private boolean powerUpActiveSlow;

    public PowerupManager(double x, double y) {
        this.x = x;
        this.y = y;
        this.timer = new Timer();
        this.powerUpActiveFast = false;
        this.powerUpActiveSlow = false;
    }



    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(new Color(255, 0, 0));
        drawTool.drawFilledCircle(x, y, 30);
    }

    public void startPowerUpFast(long duration){
       if(!powerUpActiveFast){
           powerUpActiveFast = true;
           timer.schedule(new TimerTask() {
               @Override
               public void run() {
                   powerUpActiveFast = false;
               }
           }, duration);
           timer.schedule(new TimerTask() {
               @Override
               public void run() {
                   powerUpActiveFast = false;
               }
           }, 5000);
       }
    }

    public void startPowerUpSlow(long duration){
        if(!powerUpActiveSlow){
            powerUpActiveSlow = true;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    powerUpActiveSlow = false;
                }
            }, duration);
        }
    }

    public void checkCollisionWithPLayer(){
        if (player != null && powerUpActiveFast){
            double distance = Math.sqrt(Math.pow(player.getX() - x, 2) + Math.pow(player.getY() - y, 2));
            if (distance < 30){
                player.setSpeed(player.getSpeed()*2);
                powerUpActiveFast = false;
            }
        }
    }
}