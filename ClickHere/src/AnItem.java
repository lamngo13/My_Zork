public class AnItem implements Item{
    String _name;
    String _flavortext;
    int _weight, _damage;
    //def gonna inheit this bad boy

    public AnItem(String name, int weight) {
        _name = name;
        _weight = weight;
    }

    public AnItem(String name, int weight, int damage) {
        _name = name;
        _weight = weight;
        _damage = damage;
    }

    public AnItem(String name, int weight, int damage, String flavortext) {
        _name = name;
        _weight = weight;
        _damage = damage;
        _flavortext = flavortext;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void display() {
        System.out.println("flavortext: " + _flavortext);
        System.out.println("name: " + _name);
        System.out.println("weight: " + _weight);
        System.out.println("damage: " + _damage);
    }

    @Override
    public String getFlavorText() { return _flavortext; }

    @Override
    public int getWeight() {
        return _weight;
    }

    @Override
    public int getDamage() {
        return _damage;
    }

    @Override
    public void setName(String newName) {
        _name = newName;
    }

    @Override
    public void setWeight(int newWeight) {
        _weight = newWeight;
    }

    @Override
    public void setDamage(int newDamage) {
        _damage = newDamage;
    }
}
