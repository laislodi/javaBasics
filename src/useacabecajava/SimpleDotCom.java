package useacabecajava;

public class SimpleDotCom {
    private int [] locationCells;
    private int numOfHits;

    public String checkYourself(String stringGuess){
        String result = "miss";
        int guess = Integer.parseInt(stringGuess);

        for (int cell : locationCells) {
            if (cell == guess) {
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "kill";
        }

        return result;
    }

    public void setLocationCells(int[] loc){
        locationCells = loc;
    }
}
