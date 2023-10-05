package ch.informatik.m320.main.items;

import ch.informatik.m320.main.entities.Enemy;
import ch.informatik.m320.main.entities.Player;

public class StunGun extends Item{
    private Enemy enemy;

    public StunGun(Enemy enemy) {
        super("StunGun", 2);
        this.enemy = enemy;
    }

    @Override
    public void use(Player player, int index) {
        if (enemy.getCurrentRoom() == player.getCurrentRoom())
            attack(player, index);
        else
            System.out.println("Used " + player.getInventory().removeItem(index).getName() + "and nothing happened");

    }

    private void attack(Player player, int index) {
        enemy.setHealth(enemy.getHealth() - 25);
        enemy.kill();
        System.out.println("Used " + player.getInventory().removeItem(index).getName() + "against Alien for 25 damage");

    }
}
