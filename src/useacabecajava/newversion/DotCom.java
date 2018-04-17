package useacabecajava.newversion;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public String checkYourself(String userInput){
        String result = Result.MIST.toString();
        int index = locationCells.indexOf(userInput);

        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = Result.SINC.toString();
                System.out.println("Você afundou " + name);
            } else {
                result = Result.HIT.toString();
            }
        }
        return result;
    }

    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    public ArrayList<String> getLocationCells() {
        return locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
