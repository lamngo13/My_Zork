public class AnItem implements Item{
    String _name;
    int _weight;
    //def gonna inheit this bad boy

    public AnItem(String name, int weight) {
        _name = name;
        _weight = weight;
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
    public void setName(String newName) {
        _name = newName;
    }

    @Override
    public void setWeight(int newWeight) {
        _weight = newWeight;
    }
}
