public interface Player {

    //inventory health wealth
    Item[] getInventory();

    int getHealth();

    int getWealth();

    int getX();

    int getY();

    void setX(int newX);

    void setY(int newY);

    void listInventory();

    void addToInventory(Item toBeAdded, int slotNumber);
    //overload this with other *types of items* that can be added to the inventory.

    void loseHealth(int toBeLost);

    void gainHealth(int toBeGained);

    void setHealth(int newHealth);

    void setWealth(int newWealth);
}
