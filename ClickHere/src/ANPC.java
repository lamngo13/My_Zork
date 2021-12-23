public class ANPC extends APlayer implements NPC {
    //lowkey should just inherit a bunch of stuff from APlayer
    String _s1, _s2, _s3, _s4, _s5, _s6;
    // these should be voice lines
    Item _singleItem;
    String _name;
    String _weapon;
    int _damage;

    public ANPC(int health, Item singleItem, String name) {
        _name = name;
        _health = health;
        _singleItem = singleItem;
    }

    public ANPC(int health, String name) {
        _name = name;
        _health = health;
    }

    public ANPC(int health, String name, String weapon, int damage) {
        _health = health;
        _name = name;
        _weapon = weapon;
        _damage = damage;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public String getWeapon() {
        return _weapon;
    }

    @Override
    public int getDamage() {
        return _damage;
    }

    @Override
    public void loseHealth(int toLose) {
        _health -= toLose;
        if (_health <= 0) {
            System.out.println(_name + " has died!");

        }
    }
}
