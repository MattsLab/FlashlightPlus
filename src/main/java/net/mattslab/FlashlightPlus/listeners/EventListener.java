package net.mattslab.FlashlightPlus.listeners;

import net.mattslab.FlashlightPlus.FlashlightPlus;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

/**
 * Made by FallenYouth
 */

public class EventListener implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = (Player) e.getPlayer();

        if (FlashlightPlus.getFlashLightToggle().contains(player.getName())) {
            FlashlightPlus.getFlashLightToggle().remove(player.getName());
            e.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack torch = player.getItemInHand();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) &&
                (torch.hasItemMeta()) &&
                (torch.getItemMeta().getDisplayName() != null) &&
                (torch.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "[" + ChatColor.WHITE + "Flashlight" + ChatColor.DARK_AQUA + "]"))) {
            FlashlightPlus.togglePlayer(player);
        }
    }

    @EventHandler
    public void onPlayerPlace(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack torch = player.getItemInHand();
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                (torch.hasItemMeta()) &&
                (torch.getItemMeta().getDisplayName() != null) &&
                (torch.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "[" + ChatColor.WHITE + "Flashlight" + ChatColor.DARK_AQUA + "]"))) {
            event.setCancelled(true);
        }
        
    }
}