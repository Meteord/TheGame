package edu.hm.jaumann.data.basic;
import com.badlogic.gdx.math.Vector2;

public class Objekt {
  /**
   * H�he des Objektes.
   */
    private final int level;
    /**
     * Postion des Objektes;
     */
    private final Vector2 loc;
    /**Legt fest ob die Einheit für den Gegner sichtbar ist.
     */
    private boolean invisivible;
    /**
     * Name des Objektes.
     */
    private final String name;

    /** Konstruktor
     *
     * @param y yKOordinate
     * @param x xKoordinate
     * @param level Höhenlevel des Objetks.
     */
    public Objekt(final float y, final float x, final int level, final String name) {

        this.level = level;
        this.name = name;
        loc = new Vector2(y,x);
    }

    public int getLevel() {
        return level;
    }

    public boolean isInvisivible() {
        return invisivible;
    }
    public void toogleInvis() {
        invisivible = isInvisivible() ? false: true;
    }

    public String getName() {
        return name;
    }

	public Vector2 getLoc() {
		return loc;
	}


    
}
