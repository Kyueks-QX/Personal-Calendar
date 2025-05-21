package logic.obj.uao;

/**
 * Adders for UserActionObjects.
 */
public interface UAOAdder {
    /**
     * Initializers call this function to call all functions that add UAOs.
     */
    void addAllInitUAO();
    /**
     * Creates and adds UserActionObjects.
     */
    void addUAO();
}
