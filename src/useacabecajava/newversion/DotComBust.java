package useacabecajava.newversion;

import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComs = new ArrayList<DotCom>();
    private int numOfGuesses;

    public void setUpGame(){
        DotCom pets = new DotCom();
        DotCom askMe = new DotCom();
        DotCom go2 = new DotCom();

        pets.setName("Pets.com");
        askMe.setName("AskMe.com");
        go2.setName("Go2.com");

        dotComs.add(pets);
        dotComs.add(askMe);
        dotComs.add(go2);

        System.out.println("Seu objetivo é eliminar três dot coms.");
        System.out.println("Pets.com, AskMe.com e Go2.com");
        System.out.println("Tente eliminar todas com o menor número de palpites.");

        for (DotCom dot : dotComs) {
            dot.setLocationCells(helper.placeDotCom(dotComs.size()));
        }
    }

    public void startPlaying(){
        String guess;
        while (!dotComs.isEmpty()){
            guess = helper.getUserInput("Insira um palpite");
            checkUserGuess(guess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = Result.MIST.toString();
        for (DotCom dot : dotComs) {
            result = dot.checkYourself(userGuess);
            if (result.equals(Result.HIT.toString())){
                break;
            }
            if (result.equals(Result.SINC.toString())){
                dotComs.remove(dot);
                break;
            }
        }
        System.out.println(result);
    }

    public void finishGame(){
        System.out.println("Todas as dot coms foram eliminadas! Parabéns!");
        if (numOfGuesses < 18) {
            System.out.println("Você só usou " + numOfGuesses + " palpites.");
        } else {
            System.out.println("Demorou demais.");
        }

    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
