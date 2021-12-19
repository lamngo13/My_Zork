public class ALocation implements Location{
    int _xCord, _yCord;
    String _openingText, _helpText, _name;
    boolean _shouldOpen;
    AnItem[] _items;
//_items = new Item[10];
    //def gonna overload the constructor.  OR inherit it!
    public ALocation(int xCord, int yCord, String openingText, String helpText, String name) {
        _items = new AnItem[10];
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
        _helpText = helpText;
        _name = name;
        _shouldOpen = true;
    }

    public ALocation(int xCord, int yCord, String openingText, String helpText, String name, AnItem itemOne) {
        _items = new AnItem[10];
        _items[0] = itemOne;
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
        _helpText = helpText;
        _name = name;
        _shouldOpen = true;
    }

    @Override
    public int getXCord() {
        return _xCord;
    }

    @Override
    public int getYCord() {
        return _yCord;
    }

    @Override
    public String getOpeningText() {
        return _openingText;
    }

    @Override
    public String getHelpText() {
        return _helpText;
    }

    @Override
    public void setXCord(int newX) {
        _xCord = newX;
    }

    @Override
    public void setYCord(int newY) {
        _yCord = newY;
    }

    @Override
    public void setOpeningText(String newOpening) {
        _openingText = newOpening;
    }

    @Override
    public void setHelpText(String newHelp) {
        _helpText = newHelp;
    }

    @Override
    public void setShouldOpen(boolean newVal) { _shouldOpen = newVal;}

    @Override
    public String getName() { return _name; }

    @Override
    public AnItem getIndexItem(int slot) {
        return _items[slot];
    }

    @Override
    public AnItem returnNamedItem(String theName) {
        for (int i = 0; i < 10; i++) {
            if(_items[i] != null) {
                if (theName.equals(_items[i].getName())) {
                    return _items[i];
                }
            }
        }
        System.out.println("error! Item not found");
        return null;
    }

    @Override
    public void removeItem(String theName) {
        for (int i = 0; i < 10; i++) {
            if(_items[i] != null) {
                if (theName.equals(_items[i].getName())) {
                    _items[i] = null;
                    return;
                }
            }
        }
        System.out.println("error! Item not found");
    }

    @Override
    public void addItem(AnItem toAdd) {
        for (int i = 0; i < 10; i++) {
            if (_items[i] == null) {
                _items[i] = toAdd;
                return;
            }
        }
    }

}

