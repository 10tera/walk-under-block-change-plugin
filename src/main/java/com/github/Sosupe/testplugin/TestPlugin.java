package com.github.Sosupe.testplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		//プラグイン有効化時の処理
		getLogger().info("有効化されました");
		getServer().getPluginManager().registerEvents(this,this);
	}
	
	@Override
	public void onDisable() {
		//プラグイン無効化時の処理
		getLogger().info("無効化されました");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("test")) { 
			// プレイヤーが /basic を実行すると、この部分の処理が実行されます...
			if(!(sender instanceof Player)) {
				sender.sendMessage("ゲーム内から実行してください");
			}
			else {
				Player player=(Player) sender;
				sender.sendMessage("テスト");
				
			}
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerloguin(PlayerJoinEvent e) {
		e.getPlayer().sendMessage("ログインありがとう");
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Location loc=e.getPlayer().getLocation();
		loc.setY(loc.getY()-1);
		if(loc.getBlock().getType().equals(Material.AIR)) {
			
		}
		else {
			Block b=loc.getBlock();
			b.setType(Material.STONE);
		}
	}
	
}
