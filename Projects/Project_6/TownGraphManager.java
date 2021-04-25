import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TownGraphManager implements TownGraphManagerInterface {
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        // TODO Auto-generated method stub
        return false;
    }

    public String getRoad(String town1, String town2) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean addTown(String v) {
        // TODO Auto-generated method stub
        return false;
    }

    public Town getTown(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean containsTown(String v) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean containsRoadConnection(String town1, String town2) {
        // TODO Auto-generated method stub
        return false;
    }

    public ArrayList<String> allRoads() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean deleteRoadConnection(String town1, String town2, String road) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean deleteTown(String v) {
        // TODO Auto-generated method stub
        return false;
    }

    public ArrayList<String> allTowns() {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<String> getPath(String town1, String town2) {
        // TODO Auto-generated method stub
        return null;
    }

    public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {
    }
}
