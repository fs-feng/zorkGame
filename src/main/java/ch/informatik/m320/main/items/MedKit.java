package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Player;

public class MedKit extends Item{

    public MedKit() {
        super("MedKit", 3);
    }

    @Override
    public void use(Player player, int index) {
        System.out.println(" +50HP | Used " + player.getInventory().removeItem(index).getName());
        heal(player.getHealth(), 50);

    }

    //heal function for the medkit, if health after healing > 100, then set health to 100
    private void heal(int health, int healing){
        health += healing;
        if(health>100){
            health = 100;
        }
    }

}
