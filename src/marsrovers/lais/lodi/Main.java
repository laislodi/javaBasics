package marsrovers.lais.lodi;

public class Main {

    public static void main(String[] args) {
        String input = "5 5\n"
                + "1 2 N\n"
                + "LMLMLMLMM\n"
                + "3 3 E\n"
                +"MMRMMRMRRM";

        int xSize = 5;
        int ySize = 5;

        int roverXpos = 1;
        int roverYpos = 2;
        String roverDir = "N";
        int roverAng = calculaAngulo(roverDir);
        String roverComm = "LMLMLMLMM";

        int rover2Xpos = 3;
        int rover2Ypos = 3;
        String rover2Dir = "E";
        int rover2Ang = calculaAngulo(rover2Dir);
        String rover2Comm = "MMRMMRMRRM";

        // starts here

        Rover[][] plateaou = new Rover[xSize + 1][ySize + 1];
        Rover rover1 = new Rover(roverXpos, roverYpos, roverAng);
        Rover rover2 = new Rover(rover2Xpos, rover2Ypos, rover2Ang);
        plateaou[roverXpos][roverYpos] = rover1;
        plateaou[rover2Xpos][rover2Ypos] = rover2;

        rover1.move(plateaou, roverComm);
        rover2.move(plateaou, rover2Comm);

        System.out.println(rover1.getX() + " " + rover1.getY() + " " + rover1.obtemDirecao(rover1.getAngle()));
        System.out.println(rover2.getX() + " " + rover2.getY() + " " + rover2.obtemDirecao(rover2.getAngle()));
    }

    private static int calculaAngulo(String roverDir) {
        switch (roverDir){
            case "E":
                return 0;
            case "N":
                return 90;
            case "W":
                return 180;
            default:
                return 270;
        }
    }
}
