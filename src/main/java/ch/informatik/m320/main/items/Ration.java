package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;
import ch.informatik.m320.main.utils.WinChecker;

public class Ration extends Item{
    private WinChecker winChecker;
    public Ration() {
        super("Ration", 5);

        winChecker = WinChecker.getInstance();
    }

    @Override
    public void use(Player player, int index) {
        if (player.getCurrentRoom().getDescription().equals("Escape Pod")) {
            System.out.println("Used " + player.getInventory().removeItem(index).getName());

            winChecker.setRation(true);
        }
    }
}
