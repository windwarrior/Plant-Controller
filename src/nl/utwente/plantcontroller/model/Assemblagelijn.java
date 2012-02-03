package nl.utwente.plantcontroller.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assemblagelijn {
    private List<Robot> robotList = new ArrayList<Robot>();
    
    public Assemblagelijn(Robot... robots){
        robotList = Arrays.asList(robots);
    }

    public List<Robot> getRobotList() {
        return robotList;
    }

    public void addRobot(Robot r) {
        robotList.add(r);
    }
}
