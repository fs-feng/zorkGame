package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;

public class MedKit extends Item{

    public MedKit() {
        super("Med-Kit", 3);
    }

    @Override
    public void use(Player player, int index) {
        System.out.println(" +50HP | Used " + player.getInventory().removeItem(index).getName());
        player.setHealth(50);
    }
}
