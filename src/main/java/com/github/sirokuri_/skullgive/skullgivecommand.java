package com.github.sirokuri_.skullgive;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class skullgivecommand implements CommandExecutor {

    private final skullgive plugin;

    public skullgivecommand(skullgive skullgive) {
        this.plugin = skullgive;
    }

    @SuppressWarnings({"deprecation"})
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("skullgive")) {
            if (sender.hasPermission("Skullgive.permission.skullgive")) {
                if (args.length == 0) {
                    sender.sendMessage("コマンドを正しく入力してください");
                    return true;
                }else{
                    Player player = Bukkit.getPlayer(args[0]);
                    if (player == null || !player.isOnline()) {
                        sender.sendMessage("指定されたプレイヤーはオンラインではありません");
                        return true;
                    }
                    ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                    SkullMeta skull = (SkullMeta) item.getItemMeta();
                    skull.setDisplayName(player.getName());
                    skull.setOwner(player.getName());
                    item.setItemMeta(skull);
                    Inventory inventory = p.getInventory();
                    int emptyslot = inventory.firstEmpty();
                    if (emptyslot == -1){
                        p.sendMessage("インベントリを空にしてください");
                        return true;
                    }else{
                        inventory.addItem(item);
                        p.sendMessage("対象の頭を付与しました");
                    }
                }
            }
            return true;
        }
        return true;
    }
}
