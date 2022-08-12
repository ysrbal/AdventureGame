public abstract class Location {
    private Player player;
    private String locName;
    private String locIDNumber;

    public Location(Player player, String locIDNumber, String locName) {
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

    public String getLocIDNumber() {
        return this.locIDNumber;
    }

    public void setLocIDNumber(String locIDNumber) {
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
