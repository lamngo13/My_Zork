import java.util.*;
public class Main {

    //TODO HELLO THIS IS RUNABLE!!!!!
    //TODO I had to configure my machine a bit strange for class, so if you're getting some system error, go to file > project structure and change the SDK and build it

    //these are fields for them main class and in the main method, i create an instance of 'main' because forming the code with encapsulating methods makes it a lot more readable
    boolean isPlaying;
    boolean hasOpened;
    boolean shouldOpenInventory;
    boolean overWorldMoveOk;
    boolean stillReadingInput;
    boolean isInventory;
    boolean inCombat;

    String typeOfCommand;
    String XasString;
    String YasString;
    String itemToAdd;
    String target;

    int invCommand;
    int addSlot;
    int dropSlot;
    int yourWeaponNumber;

    ALocation startingLocation;
    ALocation loc1;
    ALocation firstCombatZone;
    ALocation loc3;
    ALocation loc4;
    ALocation loc5;
    ALocation loc6;
    ALocation loc7;
    ALocation loc8;
    ALocation currentLocation;
    ALocation tempCurrLoc;

    Scanner sc;
    Player pro;

    AnItem testItem;
    AnItem note;
    AnItem attackingItem;

    ANPC wolfOne;
    ANPC wolfTwo;
    ANPC theTarget;

    public static void main(String[] args) {
        Main runner = new Main();
        runner.run(args);
        }
        //encapsulated main methods am I right

    public void run(String[] args) {
        myFormattedPrint("Welcome to my work in progress game! It is strongly based on the text-based game Zork and elements of dungeons and dragons.  Further instructions follow below.  Thank you and have fun! :)");
        //myFormattedPrint() prints a string with many line breaks instead of the regular print which prints one very long line.
        System.out.println();

        while (isPlaying) {

            //opening/next text logic
            tempCurrLoc = currentLocation;
            if (currentLocation.getShouldOpen()) {
                myFormattedPrint(currentLocation._openingText);
                //mark current location as visited?? Below
                currentLocation.setShouldOpen(false);
            } else {
                myFormattedPrint(currentLocation.getNextText());
            }

            //combat loop
            if (currentLocation.getCombat()) {
                currentLocation.setCombat(false);
                inCombat = true;
            }
            while (inCombat) {
                //inCombat = false;
                System.out.print("You are in combat with: ");
                currentLocation.listNPCs();
                System.out.println();
                for (int i = 0; i < 10; i++) {
                    if (currentLocation.getSpecificNPC(i) != null) {
                        System.out.print("The " + currentLocation.getSpecificNPC(i).getName() + "attacks you with its " + currentLocation.getSpecificNPC(i).getWeapon() + " for " + currentLocation.getSpecificNPC(i).getDamage() + " damage!");
                        System.out.println();
                        pro.loseHealth(currentLocation.getSpecificNPC(i).getDamage());
                    }
                }
                System.out.println();
                System.out.println("Your current health is: " + pro.getHealth());
                System.out.print("Which target would you like to attack?: ");
                currentLocation.listNPCs();
                System.out.println();
                target = sc.next();
                //select the target
                for (int j = 0; j < 10; j++) {
                    if(currentLocation.getSpecificNPC(j) != null) {
                        if (target.equals(currentLocation.getSpecificNPC(j).getName())) {
                            theTarget = currentLocation.getSpecificNPC(j);
                        }
                    }
                }
                System.out.print("What item would you like to attack the target with? Give slot number:");
                System.out.println();
                pro.listInventory();
                yourWeaponNumber = sc.nextInt();
                attackingItem = pro.getInventory()[yourWeaponNumber];
                System.out.println();
                System.out.println("You attack the " + theTarget.getName() + " with your " + attackingItem.getName() + " for " + attackingItem.getDamage() + " damage!");
                System.out.println();
                theTarget.loseHealth(attackingItem.getDamage());
                // this is just my thing for debugging
                for (int l = 0; l < 10; l++) {
                    if (currentLocation.getSpecificNPC(l) != null) {
                        System.out.println("health of: " + currentLocation.getSpecificNPC(l).getName() + " is " + currentLocation.getSpecificNPC(l).getHealth());
                        currentLocation.removeDeads();
                        // test line!
                    }
                }
                for (int m = 0; m < 10; m++) {
                    inCombat = false;
                    if (currentLocation.getSpecificNPC(m) != null) {
                        inCombat = true;
                        m = 10;
                    }
                }
            }
            //end combat loop
            if (currentLocation.getPostCombat() != null) {
                myFormattedPrint(currentLocation.getPostCombat());
            }


            System.out.println("commands: (right/left/up/down/openInventory/help/currentLocation)");
            String str = sc.next();
            processCommand(str);

            // validate that the player is in bounds (if type of command is overworld movement)
            switch (typeOfCommand) {
                case "overworldMovement" -> {
                    if (pro.getX() < 0) {
                        System.out.println("error! too far left!");
                        pro.setX(pro.getX()+1);
                        //maybe print flavor text based on the location
                    }
                    if (pro.getX() > 2) {
                        System.out.println("error! too far right!");
                        pro.setX(pro.getX()-1);
                    }
                    if (pro.getY() < 0) {
                        System.out.println("error! too far down!");
                        pro.setY(pro.getY()+1);
                        //flavor text and decide height too
                    }
                    if (pro.getY() > 2) {
                        System.out.println("error! too high!");
                        pro.setY(pro.getY()-1);
                    }
                }
                // END OF OVERWORLD MOVEMENT TYPE COMMAND
                case "inventory" -> {
                    while (shouldOpenInventory) {
                        myFormattedPrint("\n" + "To access an item, type the slot number. example: typing 0 inspects the first item which is a water flask. " +
                                "Type 999 to return from this item menu. Type 111 to add an item to your inventory if there is an available item. " +
                                "Type 222 to drop an item.");
                        invCommand = sc.nextInt();
                        if (invCommand == 999) {
                            shouldOpenInventory = false;
                        } else if (invCommand == 111) {
                            System.out.println("Type the name of the item you'd like to add.");
                            System.out.print("possible items: ");
                            for (int i = 0; i < 10; i++) {
                                if (currentLocation.getIndexItem(i) != null) {
                                    System.out.print(currentLocation.getIndexItem(i).getName());
                                }
                            }
                            System.out.println();
                            itemToAdd = sc.next();
                            System.out.println("which slot would you like to add this to?");
                            addSlot = sc.nextInt();
                            pro.addToInventory(currentLocation.returnNamedItem(itemToAdd), addSlot);
                            //now remove this item from the location
                            currentLocation.removeItem(itemToAdd);
                            pro.listInventory();
                            System.out.println();

                        } else if (invCommand == 222) {
                            System.out.println("Type the slot containing the item you wish to drop.");
                            dropSlot = sc.nextInt();
                            currentLocation.addItem(pro.getInventory()[dropSlot]);
                            pro.discardItem(pro.getInventory()[dropSlot]);
                            System.out.println("item has been dropped");
                            pro.listInventory();
                        }
                        else {
                                pro.getInventory()[invCommand].display();
                                System.out.println();
                                pro.listInventory();
                            }
                    }
                }
                //END OF INVENTORY TYPE COMMAND
            }

            XasString = Integer.toString(pro.getX());
            YasString = Integer.toString(pro.getY());
            // make string for better concatenation in the future
            System.out.println("Your current coordinates are: ("
            + XasString +" , " + YasString + ")");
            //tell player where they are!
            switch (XasString + YasString) {
                case "00" -> currentLocation = startingLocation;
                case "01" -> currentLocation = loc1;
                case "02" -> currentLocation = firstCombatZone;
                case "10" -> currentLocation = loc3;
                case "11" -> currentLocation = loc4;
                case "12" -> currentLocation = loc5;
                case "20" -> currentLocation = loc6;
                case "21" -> currentLocation = loc7;
                case "22" -> currentLocation = loc8;
            }

            //currentLocation.setShouldOpen(false);
            //LINE ABOVE IS A TEST
            //hasOpened = tempCurrLoc == currentLocation;
            //MOVED UP?
            //if in new location, set opening text to activate, otherwise don't
            typeOfCommand = "nocommand";
            //reset this variable
        }
        //end of whole loop

        //nothing that matters should be below this lol
    }
    // constructor of "main"
    public Main() {
        isPlaying = true;
        hasOpened = false;
        shouldOpenInventory = false;
        overWorldMoveOk = true;
        stillReadingInput = true;
        isInventory = false;
        typeOfCommand = "nocommand";
        inCombat = false;
        //XasString;
        //YasString;
        //invCommand;

        //TODO make this below a separate function and just call it, because it's wayy too crowded
        // public void makeLocations{ below }

        //items
        testItem = new AnItem("testItem", 1, 1, "bruh machine");
        note = new AnItem("note", 0, 1, "The note reads: Sorry I had to leave you here. After what happened in the forest, I went north to get help.  I should be back by morning.  Stay there and take care of yourself.\n" +
                "-C" + '\n' + "You get a feeling that whoever C is, they should have returned by now…");

        //NPCS
        wolfOne = new ANPC(5,"wolfOne","jaws",3);
        wolfTwo = new ANPC(5, "wolfTwo", "jaws", 3);
        //public ANPC(int health, String name, String weapon, int damage)

        startingLocation = new ALocation(0,0,"You wake up in a small clearing.  To the south west, and east, there is a forest that seems to be impassable.  To the north, there is a small stream and mountains in the distance.  On the ground, there is a small note. To interact with objects in a location, type openInventory to open the inventory menu, then follow those instructions.\n","You get a feeling you should head north... (To do this, type 'up')", "location 0", note);
        loc1 = new ALocation(0,1,"You walk north.  The forest continues on either side of your path.  On the ground, you see bloodstains and some tattered bits of clothing.  You also hear howling from an unknown animal in the distance.","The remnants of a conflict still litter the ground.", "location 1",testItem);
        firstCombatZone = new ALocation(0,2,"The howling grows closer, and two wolves suddenly appear from the east-side forest! They attack you!","NEXTTEXT for this location", "location 2", wolfOne, true, wolfTwo, "Congratulations! You have completed the demo! In the future you should head east and explore the main story! Thank you for your time :)");
        //ALocation(int xCord, int yCord, String openingText, String helpText, String name, AnItem itemOne, AnItem itemTwo, ANPC theNPCone, boolean combat, ANPC theNPCtwo)
        loc3 = new ALocation(1,0,"open3","help text for location: 3 todo", "location 3");
        loc4 = new ALocation(1,1,"open4","help text for location: 4 todo", "location 4");
        loc5 = new ALocation(1,2,"open5","help text for location: 5 todo", "location 5");
        loc6 = new ALocation(2,0,"open6","help text for location: 6 todo", "location 6");
        loc7 = new ALocation(2,1,"open7","help text for location: 7 todo", "location 7");
        loc8 = new ALocation(2,2,"open8","help text for location: 8 todo", "location 8");



        currentLocation = startingLocation;
        tempCurrLoc = startingLocation;
        sc = new Scanner(System.in);
        pro = new APlayer();
    }

    //static function that automatically makes a new line so very long strings don't go off the screen
    //I must be missing something haha because this took a while to code! Because for a while it would cut off mid-word
    public static void myFormattedPrint(String theString) {
        int currStringLength = theString.length();
        int counter = 0;
        //int onlyCharCounter = 0;
        boolean areWeDone = false;
        boolean shouldNewLineNext = false;
        boolean firstRun = true;

        while (!areWeDone) {
            System.out.print(theString.charAt(counter));
            //new stuff
            //if (theString.charAt(counter) == '\n') {
              //  counter = 0;
            //}
            //end new stuff
            if (shouldNewLineNext && theString.charAt(counter) == ' ') {
                shouldNewLineNext = false;
                System.out.print("\n");
                counter++;
                currStringLength--;
            }
            else {
                if ((counter % 70) == 0 && !firstRun) {
                    if (theString.charAt(counter) != ' ') {
                        shouldNewLineNext = true;
                    } else {
                        System.out.print("\n");
                    }
                }

                counter++;
                currStringLength--;
                firstRun = false;
            }

            if (currStringLength == 0) {
                areWeDone = true;
                System.out.print("\n");
            }
        }
    }

    //command method
    public void processCommand(String input) {
        switch (input) {
            case "addItem" -> {
                typeOfCommand = "inventory";
                shouldOpenInventory = true;
                //do another scanner?
                //make another loop to loop through possible items and match name with getter
                //but rn I'm just gonna test my method
                pro.addToInventory(testItem,5);
                pro.listInventory();
            }
            case "openInventory" -> {
                typeOfCommand = "inventory";
                shouldOpenInventory = true;
                pro.listInventory();
                System.out.print("\n");
            }
            case "currentLocation" -> {
                typeOfCommand = "help";
                System.out.println("your current location is: " + currentLocation.getName());
            }
            case "help" -> {
                typeOfCommand = "help";
                System.out.println(currentLocation._nextText);
            }
            case "right" -> {
                pro.setX(pro.getX()+1);
                typeOfCommand = "overworldMovement";
            }
            case "up" -> {
                pro.setY(pro.getY()+1);
                typeOfCommand = "overworldMovement";
            }
            case "left" -> {
                pro.setX(pro.getX()-1);
                typeOfCommand = "overworldMovement";
            }
            case "down" -> {
                pro.setY(pro.getY()-1);
                typeOfCommand = "overworldMovement";
            }

            case "listCommands" -> {
                System.out.println("current possible commands: (listCommands/up/down/left/right/openInventory/help/currentLocation)");
                typeOfCommand = "help";
            }
            // not 100% sure on switch statements
            default -> {
                myFormattedPrint("Error: invalid input. Current acceptable commands are (listCommands/up/down/left/right/openInventory/help/currentLocation)");
            }
        }
    }
}

