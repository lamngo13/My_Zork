public class AnItem implements Item{
    String _name;
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

    @Override
    public String getName() {
        return _name;
    }

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