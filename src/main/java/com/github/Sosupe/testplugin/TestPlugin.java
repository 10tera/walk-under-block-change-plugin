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
		//�v���O�C���L�������̏���
		getLogger().info("�L��������܂���");
		getServer().getPluginManager().registerEvents(this,this);
	}
	
	@Override
	public void onDisable() {
		//�v���O�C�����������̏���
		getLogger().info("����������܂���");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("test")) { 
			// �v���C���[�� /basic �����s����ƁA���̕����̏��������s����܂�...
			if(!(sender instanceof Player)) {
				sender.sendMessage("�Q�[����������s���Ă�������");
			}
			else {
				Player player=(Player) sender;
				sender.sendMessage("�e�X�g");
				
			}
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerloguin(PlayerJoinEvent e) {
		e.getPlayer().sendMessage("���O�C�����肪�Ƃ�");
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
