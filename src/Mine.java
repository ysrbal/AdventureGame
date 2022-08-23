import java.util.Random;

public class Mine extends BattleLoc {
    static Random random = new Random();

    public Mine(Player player) {

        super(player, 6, "Mine", new Snake(random.nextInt(3) + 4), 5, "Random Item");

    }

}

