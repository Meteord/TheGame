package edu.hm.jaumann.data.functionInterface;


/**Funktionsinterface, wird dazu verwendet die Runendlichen Effekte auf die Einheiten darzustellen.
 *
 * @param <T>
 */
public interface Applyer<T> {
    /**Objekt auf dem die Rundlichen Effekte angewandt werden.
     *
     * @param appied   auf das wards angewandt.
     */
      void apply(T appied);
}
