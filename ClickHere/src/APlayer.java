public class APlayer implements Player {

    Item[] _inventory;
    int _health, _wealth, _x, _y;
    
    public APlayer() {
        _inventory = new Item[10];
        _inventory[0] = new AnItem("welcome book", 1, 1, "Hello! " +
                "TODO MAKE FLAVOR TEXT FOR THIS BOOK BUT ITS AN ITEM IN UR INVENTORY THATS COOL TO ME");
        _health = 30;
        _wealth = 10;
        _x = 0;
        _y = 0;

    }

    @Override
    public Item[] getInventory() {
        return _inventory;
    }

    @Override
    public void listInventory() {
        for(int i = 0; i < _inventory.length; i++) {
            System.out.print("slot [" + i + "]: ");
            if (_inventory[i] == null) { System.out.print("empty, "); }
            else { System.out.print(_inventory[i].getName() + ", "); }
        }
    }

    @Override
    public int getHealth() {
        return _health;
    }

    @Override
    public int getWealth() {
        return _wealth;
    }

    @Override
    public int getX() {
        return _x;
    }

    @Override
    public int getY() {
        return _y;
    }

    @Override
    public void setX(int newX) { _x = newX; }

    @Override
    public void setY(int newY) {
        _y = newY;
    }

    @Override
    public void addToInventory(Item toBeAdded, int slotNumber) {
    }

    @Override
    public void loseHealth(int toBeLost) {

    }

    @Override
    public void gainHealth(int toBeGained) {

    }

    @Override
    public void setHealth(int newHealth) {

    }

    @Override
    public void setWealth(int newWealth) {

    }
}
