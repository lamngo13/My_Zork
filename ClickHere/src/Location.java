public interface Location {
    int getXCord();

    int getYCord();

    String getOpeningText();

    String getHelpText();

    String getName();

    void setXCord(int newX);

    void setYCord(int newY);

    void setOpeningText(String newOpening);

    void setHelpText(String newHelp);

    void setShouldOpen(boolean newVal);

    AnItem getIndexItem(int slot);

    AnItem returnNamedItem(String theName);

    void removeItem(String theName);

    void addItem(AnItem toAdd);
}
