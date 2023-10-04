package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;

public class PowerCable extends Item{
    public PowerCable() {
        super("Power-Cable", 1);
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
