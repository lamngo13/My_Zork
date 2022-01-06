public interface Location {
    int getXCord();

    int getYCord();

    String getOpeningText();

    String getNextText();

    String getName();

    void setXCord(int newX);

    void setYCord(int newY);

    void setOpeningText(String newOpening);

    void setHelpText(String newHelp);

    void setShouldOpen(boolean newVal);

    boolean getShouldOpen();

    AnItem getIndexItem(int slot);

    AnItem returnNamedItem(String theName);

    void removeItem(String theName);

    void addItem(AnItem toAdd);

    ANPC getSpecificNPC(int theIndex);

    void listNPCs();

    boolean getCombat();

    void setCombat(boolean toSet);

    void removeDeads();

    String getPostCombat();

}
