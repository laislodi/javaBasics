package marsrovers.lais.lodi;

public class Rover {

    private int x;
    private int y;
    private int angle;

    public Rover(int x, int y, int angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void move(Rover[][] plateau, String roverComm) {
        for (char comm : roverComm.toCharArray()) {
            if (comm == 'L'){
                turn(plateau,'L');
            }else if (comm == 'R'){
                turn(plateau, 'R');
            }else if (comm == 'M'){
                move(plateau);
            }
        }
    }

    private void turn(Rover[][] plateau, char direction) {
        if (direction == 'L'){
            setAngle(getAngle() + 90);
        }else{
            setAngle(getAngle() - 90);
        }
    }

    private void move(Rover[][] plateau) {
        plateau[x][y] = null;
        int newAngle = getAngle() % 360;
        if (newAngle < 0){
            newAngle+=360;
        }
        switch (newAngle){
            case 90: // North
                this.y++;
                break;
            case 270: // South
                this.y--;
                break;
            case 0: // Est
                this.x++;
                break;
            case 180: // West
                this.x--;
                break;
        }
        plateau[x][y] = this;
    }

    public String obtemDirecao(int angle) {
        while (angle < 0){
            angle += 360;
        }
        while (angle >= 360){
            angle -= 360;
        }
        switch (angle){
            case 0:
                return "E";
            case 90:
                return "N";
            case 180:
                return "W";
            default:
                return "W";
        }
    }
}
