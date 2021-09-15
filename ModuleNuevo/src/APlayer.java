public class APlayer implements Player {

    Item[] _inventory;
    int _health, _wealth;
    
    public APlayer() {
        // initial values
        _inventory = new Item[10];
        _health = 30;
        _wealth = 10;
    }

    @Override
    public Item[] getInventory() {
        return _inventory;
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
    public void addToInventory(Item toBeAdded) {
        // jk list the slots.
        if (_inventory[9] != null) {
            // or should it be 10 idk
            for (int i = 0; i < _inventory.length; i++) {
                if (_inventory[i] == null) {
                    _inventory[i] = toBeAdded;
                    i = 10;
                    //pseudobreak
                }
            }
        }
        else {
            System.out.println("Your inventory is full.");
        }
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
