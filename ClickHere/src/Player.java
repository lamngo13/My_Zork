public interface Player {

    //inventory health wealth
    AnItem[] getInventory();

    int getHealth();

    int getWealth();

    int getX();

    int getY();

    void setX(int newX);

    void setY(int newY);

    void listInventory();

    void addToInventory(AnItem toBeAdded, int slotNumber);
    //overload this with other *types of items* that can be added to the inventory. That's in the far future.

    void loseHealth(int toBeLost);

    void gainHealth(int toBeGained);

    void setHealth(int newHealth);

    void setWealth(int newWealth);

    void discardItem(AnItem toBeDiscarded);

    //shape TriangleBruh = new triangle(parameters)
    //shape[]
}
