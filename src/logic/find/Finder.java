package logic.find;

/**
 * All objects inheriting Finder can find themselves within other sets or their own indexes.
 */
public interface Finder {
    /**
     * Used to find own instance in a collection of same class objects.
     * @param o
     * The object that is searched.
     * @return
     * The object's instance from a collection.
     */
    Object find(Object o);

    /**
     * Used to find index of own instance in a collection of same class objects.
     * @param o
     * The object that is searched.
     * @return
     * The object's index in a collection.
     */
    int findIndex(Object o);
}
