public class ALocation implements Location{
    int _xCord, _yCord;
    String _openingText, _nextText, _name;
    boolean _shouldOpen;
    boolean _shouldStartCombat;
    AnItem[] _items;
    ANPC[] _npcs;

//_items = new Item[10];
    //def gonna overload the constructor.  OR inherit it!
    public ALocation(int xCord, int yCord, String openingText, String helpText, String name) {
        _items = new AnItem[10];
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
        _nextText = helpText;
        _name = name;
        _shouldOpen = true;
    }

    //intellej says theres a problem here?
     public ALocation(int xCord, int yCord, String openingText, String helpText, String name, AnItem itemOne) {
        _items = new AnItem[10];
        _items[0] = itemOne;
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
         _nextText = helpText;
        _name = name;
        _shouldOpen = true;
    }

    public ALocation(int xCord, int yCord, String openingText, String helpText, String name, ANPC theNPCone, boolean combat, ANPC theNPCtwo) {
        _shouldStartCombat = true;
        _npcs = new ANPC[10];
        _npcs[0] = theNPCone;
        _npcs[3] = theNPCtwo;
        _items = new AnItem[10];
        //_items[0] = itemOne;
        //_items[1] = itemTwo;
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
        _nextText = helpText;
        _name = name;
        _shouldOpen = true;
    }

    //big huge constructor
     public ALocation(int xCord, int yCord, String openingText, String helpText, String name, AnItem itemOne, AnItem itemTwo, ANPC theNPCone, ANPC theNPCtwo) {
        _npcs = new ANPC[10];
        _npcs[0] = theNPCone;
        _npcs[3] = theNPCtwo;
        _items = new AnItem[10];
        _items[0] = itemOne;
        _items[1] = itemTwo;
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
         _nextText = helpText;
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
    public String getNextText() {
        return _nextText;
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
    public boolean getShouldOpen() { return _shouldOpen; }

    @Override
    public void setHelpText(String newHelp) {
        _nextText = newHelp;
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

    @Override
    public ANPC getSpecificNPC(int theIndex) {
        return _npcs[theIndex];
    }

    @Override
    public void listNPCs() {
        for (int i = 0; i < 10; i++) {
            if (_npcs[i] != null) {
                System.out.print(_npcs[i].getName() + ", ");
            }
        }
    }

    @Override
    public boolean getCombat() {
        return _shouldStartCombat;
    }

    @Override
    public void setCombat(boolean toSet) {
        _shouldStartCombat = toSet;
    }

    @Override
    public void removeDeads() {
        for (int i = 0; i < 10; i++) {
            if (_npcs[i] != null) {
                if (_npcs[i].getHealth() <= 0) {
                    System.out.println("The " + _npcs[i].getName() + " has died!");
                    _npcs[i] = null;
                }
            }
        }
    }

}

