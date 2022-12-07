import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;   
import java.util.ArrayList;
import java.io.*;

public class project {
    //print command
    public static void print2Dlist(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int u = 0; u < list.get(i).size(); u++) {
                System.out.print(list.get(i).get(u) + "  ");
            }
            System.out.println("");
        }
    }
    
    //move the numbers to the right
    public static void goRight(ArrayList<ArrayList<Integer>> arr, int row, int col) {
        int dif = 3 - col;
        for (int i = 0; i < dif; i++) {
            if (arr.get(row).get(col+i+1) == 0) {
                int temp = arr.get(row).get(col+i+1);
                arr.get(row).set(col+i+1, arr.get(row).get(col+i)+temp);
                arr.get(row).set(col+i, 0);
            } else {
                break;
            }
        }
    }

    //adding numbers in a rightward manner
    public static void SumRight(ArrayList<ArrayList<Integer>> arr, int row) {
        for (int i = arr.get(row).size() - 1; i > 0; i--) {
            if (arr.get(row).get(i) == arr.get(row).get(i-1)) {
                int temp = arr.get(row).get(i-1);
                arr.get(row).set(i, arr.get(row).get(i)+temp);
                arr.get(row).set(i-1, 0);
            } 
        }
    }

    //move number to the left
    public static void goLeft(ArrayList<ArrayList<Integer>> arr, int row, int col) {
        int dif = col;
        for (int i = 0; i < dif; i++) {
            if (arr.get(row).get(col-i-1) == 0) {
                int temp = arr.get(row).get(col-i-1);
                arr.get(row).set(col-i-1, arr.get(row).get(col-i)+temp);
                arr.get(row).set(col-i, 0);
            } else {
                break;
            }
        }
    }

    //adding numbers in a leftward manner
    public static void SumLeft(ArrayList<ArrayList<Integer>> arr, int row) {
        for (int i = 0; i < arr.get(row).size()-1; i++) {
            if (arr.get(row).get(i) == arr.get(row).get(i+1)) {
                int temp = arr.get(row).get(i);
                arr.get(row).set(i, arr.get(row).get(i+1)+temp);
                arr.get(row).set(i+1, 0);
            } 
        }
    }

    //move numbers upward
    public static void goUp(ArrayList<ArrayList<Integer>> arr, int row, int col) {
        int dif = row;
        for (int i = 0; i < dif; i++) {
            if (arr.get(row-i-1).get(col) == 0) {
                int temp = arr.get(row-i-1).get(col);
                arr.get(row-i-1).set(col, arr.get(row-i).get(col)+temp);
                arr.get(row-i).set(col, 0);
            } else {
                break;
            }
        }
    }

    //adding numbers in an upward manner
    public static void SumUp(ArrayList<ArrayList<Integer>> arr, int col) {
        for (int i = 1; i < 4; i++) {
            if (arr.get(i-1).get(col) == arr.get(i).get(col)) {
                int temp = arr.get(i-1).get(col);
                arr.get(i-1).set(col, arr.get(i).get(col)+temp);
                arr.get(i).set(col, 0);
            } 
        }
    }

    //move number downward
    public static void goDown(ArrayList<ArrayList<Integer>> arr, int row, int col) {
        int dif = 3-row;
        for (int i = 0; i < dif; i++) {
            if (arr.get(row+i+1).get(col) == 0) {
                int temp = arr.get(row+i+1).get(col);
                arr.get(row+i+1).set(col, arr.get(row+i).get(col)+temp);
                arr.get(row+i).set(col, 0);
            } else {
                break;
            }
        }
    }

    //adding numbers in a downward manner
    public static void SumDown(ArrayList<ArrayList<Integer>> arr, int col) {
        for (int i = 2; i >= 0; i--) {
            if (arr.get(i+1).get(col) == arr.get(i).get(col)) {
                int temp = arr.get(i+1).get(col);
                arr.get(i+1).set(col, arr.get(i).get(col)+temp);
                arr.get(i).set(col, 0);
            } 
        }
    }

    //check if an ArrayList is filled with numbers beside 0 or not
    public static boolean filled(ArrayList<ArrayList<Integer>> arr) {
        int spaceRemaining = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int u = 0; u < arr.get(i).size(); u++) {
                if (arr.get(i).get(u) == 0) {
                    spaceRemaining++;
                }
            }
        }
        if (spaceRemaining == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //check to see if a move is valid or not by compare an array before and after a move
    public static boolean isValidMove(ArrayList<ArrayList<Integer>> arr, ArrayList<ArrayList<Integer>> temp) {
        for (int i = 0; i < arr.size(); i++) {
            for (int u = 0; u < arr.get(i).size(); u++) {
                if (arr.get(i).get(u) != temp.get(i).get(u)) {
                    return true;
                }
            }
        }
        return false;
    }

    //runningSum which is a combination of moving to a certain direction and adding numbers in a certain direction
    public static ArrayList<ArrayList<Integer>> runningSum2Dlist(ArrayList<ArrayList<Integer>> list, int dir) {
        //sum-run to the left
        if (dir == 1) {
            for (int i = 0; i < list.size() ; i++) {
                for (int u = 0; u < list.get(i).size() ; u++) {
                    goLeft(list, i, u);
                }
                SumLeft(list, i);
                for (int u = 0; u < list.get(i).size() ; u++) {
                    goLeft(list, i, u);
                }
            }
        }
        //sum-run to the right
        else if (dir == 2) {
            for (int i = 0; i < list.size() ; i++) {
                for (int u = list.get(i).size()-1; u >= 0; u--) {
                    goRight(list, i, u);                
                }
                SumRight(list, i);
                for (int u = list.get(i).size()-1; u >= 0; u--) {
                    goRight(list, i, u);                
                }
            }
        }
        //sum-run to up
        else if (dir == 3) {
            for (int u = 0; u < 4; u++) {
                for (int i = 0; i < list.size(); i++) {
                    goUp(list, i, u);
                }
                SumUp(list, u);
                for (int i = 0; i < list.size(); i++) {
                    goUp(list, i, u);
                }
            }
        }
        //sum-run to below
        else if (dir == 4) {
            for (int u = 3; u >= 0; u--) {
                for (int i = list.size()-1; i >= 0; i--) {
                    goDown(list, i, u);
                }
                SumDown(list, u);
                for (int i = list.size()-1; i >= 0; i--) {
                    goDown(list, i, u);
                }
            }
        } 
        return list;
    }

    //restart the game by setting everything to 0
    public static void restart(ArrayList<ArrayList<Integer>> arr) {
        for (int i = 0 ; i < arr.size(); i++) {
            for (int u = 0; u < arr.get(i).size(); u++) {
                arr.get(i).set(u,0);
            }
        }    
    }

    //generate 2 or 4 in a random empty square
    public static void generate(ArrayList<ArrayList<Integer>> arr) {
        int a = (int)Math.floor((Math.random()*4 - 0.001) + 0.001);
        int b = (int)Math.floor((Math.random()*4- 0.001) + 0.001);

        while (arr.get(a).get(b) != 0) {
            a = (int)Math.floor((Math.random()*4 - 0.001) + 0.001);
            b = (int)Math.floor((Math.random()*4 - 0.001) + 0.001);
        }

        double chance = Math.random();
        if(chance > 0.8) {
            arr.get(a).set(b, 4);
        } else {
            arr.get(a).set(b, 2);
        }
    }

    //return the highest number of an ArrayList
    public static int highestNum(ArrayList<ArrayList<Integer>> arr) {
        int highest = 0;
        for (int i = 0 ; i < arr.size(); i++) {
            for (int u = 0; u < arr.get(i).size(); u++) {
                if ( highest <= arr.get(i).get(u)) {
                    highest = arr.get(i).get(u);
                }
            }
        }
        return highest;
    } 

    public static void main(String[] args) {
        //setting up ArrayList
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(0);
        arr1.add(0);
        arr1.add(0);
        arr1.add(0);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        arr2.add(0);
        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        arr3.add(0);
        arr3.add(0);
        arr3.add(0);
        arr3.add(0);
        ArrayList<Integer> arr4 = new ArrayList<Integer>();
        arr4.add(0);
        arr4.add(0);
        arr4.add(0);
        arr4.add(0);                     
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
        arrList.add(arr1);
        arrList.add(arr2);
        arrList.add(arr3);
        arrList.add(arr4);

        int i = 0; //variable that control the while loop
        int score = 0; //score/valid moves
        int move = 0; //moves in general both valid and invalid
        int spaceBetween = 1; //space between each prints

        //first print
        System.out.println("Current score/Counts of valid move: " + score);
        System.out.println("Counts of move: " + move);
        System.out.println("Current highest number: " + highestNum(arrList));
        generate(arrList);
        generate(arrList);
        System.out.println("Current highest number: " + highestNum(arrList));
        print2Dlist(arrList);
        Scanner scnr = new Scanner(System.in);

        while (i != 1) {
            //Scanner
            String command = scnr.nextLine();

            //deep copy arrL into a new list without the same reference
            //Creating a new ArrayList  
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> c = new ArrayList<Integer>();
            ArrayList<Integer> d = new ArrayList<Integer>();

            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);

            //copying over without copying the reference using add()
            for (int m = 0; m < arrList.size(); m++) {
                for (int u = 0; u < arrList.get(m).size(); u++) {
                    list.get(m).add((arrList.get(m).get(u)));
                }
            }
            
            //taking in commands
            if (command.equals("q")) {
                System.out.println("Are you sure? (if yes, press 'q'. If not, enter 'no')");
                String confirmation = scnr.nextLine();
                if (confirmation.equals("q")) {
                    i = 1;
                    break;
                } 
            }
            if (command.equals("r")) {
                System.out.println("Are you sure? (if yes, press 'r'. If not, enter 'no')");
                String confirmation = scnr.nextLine();
                if (confirmation.equals("r")) {
                    restart(arrList);
                    generate(arrList);
                    print2Dlist(arrList);
                    score = 0;
                }
            }

            if(command.equals("d")) {
                runningSum2Dlist(arrList, 2);
                if(!isValidMove(arrList, list)) {
                    System.out.println("Invalid move");
                    if(filled(arrList)) {
                        i = 1;
                        System.out.println("Game over");
                    }
                } else {
                    generate(arrList);
                    score++;
                }
            }
            if(command.equals("a")) {
                runningSum2Dlist(arrList, 1);
                if(!isValidMove(arrList, list)) {
                    System.out.println("Invalid move");
                    if(filled(arrList)) {
                        i = 1;
                        System.out.println("Game over");
                    }
                } 
                else {
                    generate(arrList);
                    score++;
                }
            }
            if(command.equals("w")) {
                runningSum2Dlist(arrList, 3);
                if(!isValidMove(arrList, list)) {
                    System.out.println("Invalid move");
                    if(filled(arrList)) {
                        i = 1;
                        System.out.println("Game over");
                    }
                }
                else {
                    generate(arrList);
                    score++;
                }
            }
            if(command.equals("s")) {
                runningSum2Dlist(arrList, 4);
                if(!isValidMove(arrList, list)) {
                    System.out.println("Invalid move");
                    if(filled(arrList)) {
                        i = 1;
                        System.out.println("Game over");
                    }
                } 
                else {
                    generate(arrList);
                    score++;
                }
            }

            //creating space between each prints
            for (int u = 1; u <= spaceBetween; u++) {
                System.out.println();
            }
            move++;
            //printing information
            System.out.println("Current score/Counts of valid move: " + score);
            System.out.println("Counts of move: " + move);
            System.out.println("Current highest number: " + highestNum(arrList));
            //winning condition
            if (highestNum(arrList)==2048){
                System.out.println("Congrat, you won with " + score + " valid moves/score and " + move + " moves total");
            } 
            //print ArrayList
            print2Dlist(arrList);
        }
    }
}
