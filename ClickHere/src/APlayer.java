public class APlayer implements Player {

    AnItem[] _inventory;
    int _health, _wealth, _x, _y;
    
    public APlayer() {
        _inventory = new AnItem[10];
        //_inventory[0] = new AnItem("welcome book", 1, 1, "Hello! " +
                //"TOD MAKE FLAVOR TEXT FOR THIS BOOK BUT ITS AN ITEM IN UR INVENTORY THATS COOL TO ME");
        _inventory[1] = new AnItem("sword", 5, 5, "It is a sword.  You presume you can swing it at stuff");
        _inventory[0] = new AnItem("water flask", 2, 2, "It is a flask of water");
        _health = 30;
        _wealth = 10;
        _x = 0;
        _y = 0;
    }

    @Override
    public AnItem[] getInventory() {
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
    public void addToInventory(AnItem toBeAdded, int slotNumber) {
        if (_inventory[slotNumber] == null) {
            //case where adding to empty slot
            _inventory[slotNumber] = toBeAdded;
            System.out.println("the " + toBeAdded.getName() + " has been added to slot: " + slotNumber);
        } else {
            //case where adding to filled slot. Give option to add to another slot, or to discard an item.
            System.out.println("error! item slot is already filled. Open slots are: ");
            for (int i = 0; i < 10; i++) {
                if (_inventory[slotNumber] == null) {
                    System.out.print(slotNumber + ", ");
                }
            }
            System.out.println("to discard an item, write todo discard method");
        }
    }

    @Override
    public void loseHealth(int toBeLost) {
        _health -= toBeLost;
    }

    @Override
    public void gainHealth(int toBeGained) {
        _health =+ toBeGained;
    }

    @Override
    public void setHealth(int newHealth) {

    }

    @Override
    public void setWealth(int newWealth) {

    }

    @Override
    public void discardItem(AnItem toBeDiscarded) {
        for (int i = 0; i < 10; i++) {
            if (_inventory[i] == toBeDiscarded) {
                _inventory[i] = null;
            }
        }
    }
}
