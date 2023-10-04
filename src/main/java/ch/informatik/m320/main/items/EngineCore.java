package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;

public class EngineCore extends Item{

    public EngineCore() {
        super("EngineCore", 8);
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
