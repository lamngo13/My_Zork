public class ALocation implements Location{
    int _xCord, _yCord;
    String _openingText, _helpText, _name;
    boolean _shouldOpen;

    //def gonna overload the constructor.  OR inherit it!
    public ALocation(int xCord, int yCord, String openingText, String helpText, String name) {
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

}

