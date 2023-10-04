package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;
import ch.informatik.m320.main.utils.WinChecker;

public class PodKey extends Item{
    private WinChecker winChecker;
    public PodKey() {
        super("ignite-key", 1);

        winChecker = WinChecker.getInstance();
    }

    @Override
    public void use(Player player, int index) {
        if (player.getCurrentRoom().getDescription().equals("Escape Pod")) {
            System.out.println("Used " + player.getInventory().removeItem(index).getName());

            winChecker.setPodKey(true);
        }
    }
}
