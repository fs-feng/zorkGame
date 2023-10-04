package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;
import ch.informatik.m320.main.utils.WinChecker;

public class NavModule extends Item {
    WinChecker winChecker;

    public NavModule() {
        super("NavModule", 5);

        winChecker = WinChecker.getInstance();
    }

    @Override
    public boolean use(Player player, int index) {
        if (player.getCurrentRoom().getDescription().equals("Escape Pod")) {
            System.out.println("Used " + player.getInventory().removeItem(index).getName());
            winChecker.setNavModul(true);
        }
        return true;

    }
}
