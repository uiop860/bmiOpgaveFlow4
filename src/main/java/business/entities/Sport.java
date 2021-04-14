package business.entities;

public class Sport {

    private int sportID;
    private int name;

    public Sport(int sportID, int name) {
        this.sportID = sportID;
        this.name = name;
    }

    public int getSportID() {
        return sportID;
    }

    public int getName() {
        return name;
    }
}
