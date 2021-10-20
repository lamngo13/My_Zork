import java.util.*;
public class Main {

    boolean isPlaying = true;
    boolean hasOpened = false;
    boolean overWorldMoveOk = true;
    boolean stillReadingInput = true;
    //types of commands
    String typeOfCommand = "nocommand";
    String XasString;
    String YasString;
    //public ALocation(int xCord, int yCord, String openingText, String helpText)
    //TODO make this below a separate function and just call it, because it's wayy too crowded
    // public void makeLocations{ below }
    ALocation loc0 = new ALocation(0,0,"open0","help0");
    ALocation loc1 = new ALocation(0,1,"open1","help1");
    ALocation loc2 = new ALocation(0,2,"open2","help2");
    ALocation loc3 = new ALocation(1,0,"open3","help3");
    ALocation loc4 = new ALocation(1,1,"open4","help4");
    ALocation loc5 = new ALocation(1,2,"open5","help5");
    ALocation loc6 = new ALocation(2,0,"open6","help6");
    ALocation loc7 = new ALocation(2,1,"open7","help7");
    ALocation loc8 = new ALocation(2,2,"open8","help8");

    ALocation currentLocation = loc0;
    ALocation tempCurrLoc = loc0;
    Scanner sc= new Scanner(System.in);
    Player pro = new APlayer();

    public static void main(String[] args) {
        Main runner = new Main();
        runner.run(args);

        }


        //make command methods
    // NORTH
    public void run(String[] args) {

        //make instances of classes

        //maybe make an input class that has methods for each player input

        System.out.println("Welcome to my ripoff of the game Zork! This is a text-based game....");
        //System.out.println("this is a list of possible commands: right (moves you right), " +
                //"left (moves you left), down (moves you down), up (moves you up)...addmorehere");
        System.out.println(" ");
        System.out.println("Your current coordinates are (0,0) also btw only positive numbers allowed");



        //commands: look around, name inventory, switch inventory
        //yoo maybe there should be a command class.

        while (isPlaying) {
            //start debug
            System.out.println("tempCurrLoc: " + tempCurrLoc._helpText);
            System.out.println("currentLocation: " + currentLocation._helpText);
            System.out.println("val of hasOpened: " + hasOpened );
            //end debug
            tempCurrLoc = currentLocation;
            //store current location to check if player has moved to a different location
            if (!hasOpened) { System.out.println("opening text for current location: " + currentLocation._openingText); }
            //if in new location, print the opening text of that location

            System.out.println("pls input (right/left/up/down) for testing");
            String str = sc.next();
            //scan.nextLine vs scan.next
            switch (str) {
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
                //end of case overworld movement
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

            //start debug
            //System.out.println("tempCurrLoc: " + tempCurrLoc._helpText);
            //System.out.println("currentLocation: " + currentLocation._helpText);
            //System.out.println("val of hasOpened: " + hasOpened);
            //System.out.println("end");
            //System.out.println("");
            //end debug
            //hasOpened = (!(tempCurrLoc == currentLocation));
            hasOpened = tempCurrLoc == currentLocation;
            //System.out.println("VAL OF hasopened: " + hasOpened);
            //if in new location, set opening text to activate, otherwise don't
            typeOfCommand = "nocommand";
            //reset this variable
        }
        //end of first while loop

        //nothing that matters should be below this lol
    }
    //SOUTH
    //EAST
    //WEST
    //LOOKAROUND
    //HELP
    //INVENTORY
    //PICKUP
    //ATTACK
    //EQUIP
    //EAT
    //tell player that some commands require an object
    //ie (EAT APPLE)
    //STATS
    //RENAME
    // HELP RENAME
    //explains how each command works with examples
    public void inNorth() {
        pro.setX(pro.getX()+1);
    }

    }

