package edu.hm.jaumann.data.basic;

/**
 * /*
 * Autor: Michael
 * Date: 18.08.13
 * Projektname: $(PROJEKT_NAME)
 * Deskription:
 * Package: $(PACKAGE_NAME)
 * Hochschule München, Fakultät 07 für Mathematik und Informatik
 * Praktikum Softwareentwicklung II,
 * Studiengruppe IF2A java version 1.7.0_07,
 * getestet unter Win7 Home Premium
 * Created with IntelliJ IDEA.
 */
public abstract class Location {
    /**
     * XKoord des Objekts.
     */
    private int x;
    /**
     * YKoord des Objekts.
     */
    private int y;

    public Location(final int y, final int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    private void setY(final int y) {
        this.y = y;
    }

    public int getX() {

        return x;
    }

    private void setX(final int x) {
        this.x = x;
    }

    public double getDistance(final Location other)
    {
        return StrictMath.hypot(other.getX()- this.getX(), other.getY()- this.getY());
    }
    public void shift(final int x, final int y)
    {
        setX(x);
        setY(y);

    }
}
