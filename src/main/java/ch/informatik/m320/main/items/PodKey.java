package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;

public class PodKey extends Item{
    public PodKey() {
        super("ignite-key", 1);
    }

    @Override
    public boolean use(Player player, int index) {
        if (player.getCurrentRoom().getDescription().equals("Escape Pod")) {
            System.out.println("Used " + player.getInventory().removeItem(index).getName());
            return true;
        } else
            return false;
    }
}
