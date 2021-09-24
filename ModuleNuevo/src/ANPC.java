public class ANPC extends APlayer implements NPC {
    //lowkey should just inherit a bunch of stuff from APlayer
    String _s1, _s2, _s3, _s4, _s5, _s6;
    Item _singleItem;

    public ANPC(int health, Item singleItem) {
        _health = health;
        _singleItem = singleItem;
    }
}
