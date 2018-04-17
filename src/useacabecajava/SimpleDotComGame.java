package useacabecajava;

public class SimpleDotComGame {

    public static void main(String[] args) {
        SimpleDotCom dotCom = new SimpleDotCom();
        int numOfGuess = 0;
        int randomPosition = (int) Math.random() * 5;
        int[] positions = {randomPosition, randomPosition + 1, randomPosition + 2};
        boolean isAlive = true;
        SimpleDotComHelper helper = new SimpleDotComHelper();
        String guess;
        String result;

        dotCom.setLocationCells(positions);

        while (isAlive){
            guess = helper.getUserInput("Insira um numero:");
            result = dotCom.checkYourself(guess);
            System.out.println(result);

            numOfGuess++;
            if (result.equals("kill")){
                isAlive = false;
            }
        }
        System.out.println("Foram usados " + numOfGuess + " palpites.");

    }
}
