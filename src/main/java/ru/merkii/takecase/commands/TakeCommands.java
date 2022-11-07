package ru.merkii.takecase.commands;

import commonlib.com.minnymin.command.Command;
import commonlib.com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.merkii.takecase.TakeCase;
import ru.merkii.takecase.configuration.DataCreate;
import ru.merkii.takecase.configuration.SaveData;
import ru.merkii.takecase.configuration.TakeConfiguration;
import java.util.ArrayList;
import java.util.List;

public class TakeCommands {
    private TakeCase plugin;
    DataCreate dc = new DataCreate();
    SaveData sd = new SaveData();
    public TakeCommands(final TakeCase plugin) {
        this.plugin = plugin;
    }
    @Command(name = "takecase", permission = "takecase.use", noPerm = "&4Нет прав!", inGameOnly = true)
    public void takeCase(final CommandArgs args) {
        Player p = args.getPlayer();
        List<String> users;
        if(dc.data().contains("players")) {
            users = dc.data().getStringList("players");
        } else {
            users = new ArrayList<>();
        }
        if(!users.contains(p.getName())) {
            users.add(p.getName());
            dc.data().set("players", users);
            sd.saveData();
            args.sendMessage(TakeConfiguration.INFO_SUCCES);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), this.plugin.getConfig().getString("command").replaceAll("%player%", p.getName()));
        } else {
            args.sendMessage(TakeConfiguration.ERROR_ALREDY);
        }
    }
}