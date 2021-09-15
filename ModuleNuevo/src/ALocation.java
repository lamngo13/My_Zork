public class ALocation implements Location{
    // Fields: xcord, ycordopening text, text triggered by -help, entities in that location.
    int _xCord, _yCord;
    String _openingText, _helpText;
    // type object, like monster or item or something

    //def gonna overload the constructor.  OR inherit it!
    public ALocation(int xCord, int yCord, String openingText, String helpText) {
        _xCord = xCord;
        _yCord = yCord;
        _openingText = openingText;
        _helpText = helpText;
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
}
