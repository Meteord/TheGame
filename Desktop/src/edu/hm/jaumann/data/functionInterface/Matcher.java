package edu.hm.jaumann.data.functionInterface;

public interface Matcher<T> {
    /**Eine Beziehung zwischen zwei Objekten.
     *
     * @param agressor  Targetet den defensor.
     * @param defensor  wird mit effekten Belegt, kann aber auch den agressor zurueckschlagen.
     */
    void match(T agressor, T defensor);
}
