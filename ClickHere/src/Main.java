import java.util.*;
public class Main {
    //text to test version!!!
    //TODO HELLO THIS IS RUNABLE

    boolean isPlaying = true;
    boolean hasOpened = false;
    boolean shouldOpenInventory = false;
    boolean overWorldMoveOk = true;
    boolean stillReadingInput = true;
    String typeOfCommand = "nocommand";
    String XasString;
    String YasString;
    int invCommand;
    String startRoomOpenText = "Hello adventurer! You are in an open field.  To the north is a forrest.  On the ground there is a paper.  To pick up an item, type [pickup itemname] without the brackets.";
            //TODO FORMAT PRINTED TEXT

    //TODO make this below a separate function and just call it, because it's wayy too crowded
    // public void makeLocations{ below }
    ALocation loc0 = new ALocation(0,0,"open0","help text for location: 0 todo", "location 0");
    ALocation loc1 = new ALocation(0,1,"open1","help text for location: 1 todo", "location 1");
    ALocation loc2 = new ALocation(0,2,"open2","help text for location: 2 todo", "location 2");
    ALocation loc3 = new ALocation(1,0,"open3","help text for location: 3 todo", "location 3");
    ALocation loc4 = new ALocation(1,1,"open4","help text for location: 4 todo", "location 4");
    ALocation loc5 = new ALocation(1,2,"open5","help text for location: 5 todo", "location 5");
    ALocation loc6 = new ALocation(2,0,"open6","help text for location: 6 todo", "location 6");
    ALocation loc7 = new ALocation(2,1,"open7","help text for location: 7 todo", "location 7");
    ALocation loc8 = new ALocation(2,2,"open8","help text for location: 8 todo", "location 8");

    ALocation currentLocation = loc0;
    ALocation tempCurrLoc = loc0;
    Scanner sc= new Scanner(System.in);
    Player pro = new APlayer();

    public static void main(String[] args) {
        Main runner = new Main();
        runner.run(args);
        }

    public void run(String[] args) {

        System.out.println("Welcome to my ripoff of the game Zork! This is a text-based game that is a" +
                " work in progress.");
        System.out.println("Right now you are a player that can move around in the overworld" +
                " with a coordinate system using the following commands");
        System.out.println("Your current coordinates are (0,0) [also only go in quadrant 1]" + "\n");

        while (isPlaying) {
            tempCurrLoc = currentLocation;
            //store current location to check if player has moved to a different location
            if (!hasOpened) { System.out.println("opening text for current location: " + currentLocation._openingText); }
            //if in new location, print the opening text of that location

            System.out.println("commands: (right/left/up/down/openInventory/help/currentLocation)");
            String str = sc.next();
            //scan.nextLine vs scan.next? Looks like scan.next is fine.
            switch (str) {
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
                    System.out.println(currentLocation._helpText);
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
            }

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
                        System.out.println("\n" + "To access an item just type the slot number ie (0) accesses the first item" +
                        "type (999) to return from this item menu");
                        invCommand = sc.nextInt();
                        if (invCommand == 999) {
                            shouldOpenInventory = false;
                        } else {
                            pro.getInventory()[invCommand].display();
                            System.out.println("\n");
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
            + XasString +" ," + YasString + ")");
            //tell player where they are!
            switch (XasString + YasString) {
                case "00" -> currentLocation = loc0;
                case "01" -> currentLocation = loc1;
                case "02" -> currentLocation = loc2;
                case "10" -> currentLocation = loc3;
                case "11" -> currentLocation = loc4;
                case "12" -> currentLocation = loc5;
                case "20" -> currentLocation = loc6;
                case "21" -> currentLocation = loc7;
                case "22" -> currentLocation = loc8;
            }

            hasOpened = tempCurrLoc == currentLocation;
            //if in new location, set opening text to activate, otherwise don't
            typeOfCommand = "nocommand";
            //reset this variable
        }
        //end of first while loop

        //nothing that matters should be below this lol
    }
}

