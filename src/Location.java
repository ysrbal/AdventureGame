import java.util.Random;
import java.util.Scanner;

public abstract class Location {
    protected Scanner scan = new Scanner(System.in);
    protected Random random = new Random();
    private Player player;
    private String locName;
    private int locIDNumber;

    public Location(Player player, int locIDNumber, String locName) {
        this.player = player;
        this.locIDNumber = locIDNumber;
        this.locName = locName;

    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getLocIDNumber() {
        return this.locIDNumber;
    }

    public void setLocIDNumber(int locIDNumber) {
        this.locIDNumber = locIDNumber;
    }

    public String getLocName() {
        return this.locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public abstract boolean onLocation();
}
