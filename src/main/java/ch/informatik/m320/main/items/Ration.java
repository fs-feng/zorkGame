package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;

public class Ration extends Item{
    public Ration() {
        super("Ration", 20);
    }

    @Override
    public boolean use(Player player, int index) {
        if (player.getCurrentRoom().getDescription().equals("Escape Pod")) {
            System.out.println("Used " + player.getInventory().removeItem(index).getName());
            return true;
        } else
            System.out.println("use it in the escape pod");
            return false;
    }
}
