package Bean;

public class Hit implements Cloneable{
    private double X, Y, R;
    private boolean isInArea;
    private String hitTime;

    public Hit(double X, double Y, double R, boolean isInArea, String hitTime) {
        this.X = X;
        this.Y = Y;
        this.R = R;
        this.isInArea = isInArea;
        this.hitTime = hitTime;
    }

    public String getHitTime() {
        return hitTime;
    }

    public void setHitTime(String hitTime) {
        this.hitTime = hitTime;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public boolean isInArea() {
        return isInArea;
    }

    public void setInArea(boolean inArea) {
        isInArea = inArea;
    }
}