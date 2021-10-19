import java.util.*;
public class Main {

    boolean isPlaying = true;
    boolean hasOpened = false;
    boolean overWorldMoveOk = true;
    boolean stillReadingInput = true;
    String XasString;
    String YasString;
    //public ALocation(int xCord, int yCord, String openingText, String helpText)
    ALocation loc1 = new ALocation(0,0,"open1","help1");
    ALocation loc2 = new ALocation(1,0,"open2","help2");
    ALocation loc3 = new ALocation(2,0,"open3","help3");
    ALocation loc4 = new ALocation(3,0,"open4","help4");
    //make a (fake, intuitive) 2d array of literally all the locations call it LOCATIONS
    ALocation currentLocation = loc1;
    ALocation tempCurrLoc = loc1;
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

        System.out.println("Welcome to my ripoff of the game Zork! This is " +
                "a text-based game....");




        //commands: look around, name inventory, switch inventory
        //yoo maybe there should be a command class.

        while (isPlaying) {
            tempCurrLoc = currentLocation;
            //store current location to check if player has moved to a different location
            if (!hasOpened) { System.out.println(currentLocation._openingText); }
            //if in new location, print the opening text of that location

            System.out.println("pls input x for testing movement");
            String str = sc.next();
            //scan.nextLine vs scan.next
            if (str.equals("x")) {
                pro.setX(pro.getX()+1);
            }
            // validate that the player is in bounds

            XasString = Integer.toString(pro.getX());
            YasString = Integer.toString(pro.getY());
            //debugging
            System.out.println("Xas string: " + XasString);
            System.out.println("Yas string: " + YasString);
            System.out.println(XasString + YasString);
            //end debugging
            switch (XasString + YasString) {
                case "00" -> currentLocation = loc1;
                case "10" -> currentLocation = loc2;
                case "20" -> currentLocation = loc3;
                case "30" -> currentLocation = loc4;
            }
            if (currentLocation == loc4) { isPlaying = false; }

            hasOpened = tempCurrLoc == currentLocation;
            //if in new location, set opening text to activate, otherwise don't
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

