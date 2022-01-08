public class ALocation{
    int _xCord, _yCord;
    String _openingText, _nextText, _name, _postCombat;
    boolean _shouldOpen;
    boolean _combat;
    AnItem[] _items;
    ANPC[] _npcs;


    public ALocation(int xCord, int yCord, String openingText, String helpText, String name) {
        this(xCord, yCord, openingText, helpText, name, null, null, false, null);
    }

    //constructor with array of npcs as parameter
    public ALocation(int xCord, int yCord, String openingText, String helpText, String name, ANPC[] theNPCLIST) {
        this(xCord, yCord, openingText, helpText, name, null, theNPCLIST, false, null);
    }


    public ALocation(int xCord, int yCord, String openingText, String helpText, String name, AnItem[] theItems) {
        this(xCord, yCord, openingText, helpText, name, theItems, null, false, null);
    }

    // has both NPC list and Item list and combat stuff
    public ALocation(int xCord, int yCord, String openingText, String helpText, String name, AnItem[] theItems, ANPC[] theNPCLIST, boolean combat, String postCombat) {
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
        _nextText = helpText;
        _name = name;
        _shouldOpen = true;
        _items = theItems;
        _npcs = theNPCLIST;
        _combat = combat;
        _postCombat = postCombat;
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

    @Override
    public String getPostCombat() { return _postCombat; }

}

