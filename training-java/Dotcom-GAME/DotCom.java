/**
 * DotCom
 */
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class DotCom {
    
    //declare and initialize the variables    
    private int numOfGuesses = 0;
    private GameHelper helper = new GameHelper();
    private ArrayList<SimpleDotCom> dotcom = new ArrayList<SimpleDotCom>();
    
    private void setUpGame(){
        SimpleDotCom one = new SimpleDotCom();
        SimpleDotCom two = new SimpleDotCom();
        SimpleDotCom three = new SimpleDotCom();

        dotcom.add(one);
        dotcom.add(two);
        dotcom.add(three);
        one.setName("China");
        two.setName("Korea");
        three.setName("North Korea");
        
        System.out.println("Your goal is to delete all these nations out of the world map!!!");
        System.out.println("China, Korea, North Korea");
        for (SimpleDotCom dotcomElement : dotcom){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotcomElement.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while (!dotcom.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "miss";

        for (SimpleDotCom dotcomElement : dotcom){
            result = dotcomElement.checkYourself(userGuess);
            if (result.equals("hit")){
                break;
            }
            if (result.equals("kill")){
                dotcom.remove(dotcomElement);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        if (numOfGuesses < 18){
            System.out.println("Bravo");
        }
        else {
            System.out.println("Took you long enough");
        }
    }

    public static void main(String[] args) {
        DotCom game = new DotCom();
        game.setUpGame();
        game.startPlaying();
        game.finishGame();
    }
}

class GameHelper{
    private int gridLength = 7;
    private int gridSize = 49;

    public String getUserInput(String str){
        Scanner in = new Scanner(System.in);
        System.out.print(str);
        String guess = in.nextLine();
        return guess;
    }

    public ArrayList<String> placeDotCom(int n){

    }
}

class SimpleDotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public void setName(String s){
        name = s;
    }

    public String checkYourself(String stringGuess){
        int index = locationCells.indexOf(stringGuess);
        String result = "miss";
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
            }
            else {
                result = "hit";
            }
        }
        System.out.println(result);
        return result;
    }
}
