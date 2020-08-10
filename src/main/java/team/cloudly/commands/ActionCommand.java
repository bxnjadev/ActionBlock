package team.cloudly.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.cloudly.ActionClass;

public class ActionCommand implements CommandExecutor {

    private ActionClass plugin;
    public ActionCommand(ActionClass plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.DARK_RED + "You can't to execute this command in console");
            return true;
        }
        Player player = (Player)sender;

        if(!player.hasPermission("actionblock.use")){
            player.sendMessage("No tienes permisos");
            return true;
        }

        if(args.length == 0){

            return true;
        }

        return false;
    }
}
