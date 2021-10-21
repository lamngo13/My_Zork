public interface Item {
    String getName();

    String getFlavorText();

    int getWeight();

    int getDamage();

    void setName(String newName);

    void setWeight(int newWeight);

    void setDamage(int newDamage);

    void display();
}
