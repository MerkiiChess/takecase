package ru.merkii.takecase;

import commonlib.com.minnymin.command.CommandFramework;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import ru.den_abr.commonlib.CommonLib;
import ru.den_abr.commonlib.messages.MessageRegistry;
import ru.den_abr.commonlib.utility.UtilityMethods;
import ru.merkii.takecase.commands.TakeCommands;
import ru.merkii.takecase.configuration.DataCreate;
import ru.merkii.takecase.configuration.TakeConfiguration;

public final class TakeCase extends JavaPlugin {
    private static TakeCase instance;
    DataCreate dc = new DataCreate();

    @Override
    public void onEnable() {
        System.out.println(ChatColor.GOLD + "//////////////");
        System.out.println(ChatColor.GOLD + "//////////////");
        System.out.println(ChatColor.GOLD + "[TK] TakeCase 2.0 Enabled!");
        System.out.println(ChatColor.GOLD + "[TK] Author: Merkii");
        System.out.println(ChatColor.GOLD + "//////////////");
        System.out.println(ChatColor.GOLD + "//////////////");
        UtilityMethods.forciblyLoadAllClasses(this);
        final CommandFramework cf = CommonLib.commands(this);
        cf.registerCommands(new TakeCommands(this));
        MessageRegistry.addMessages("TakeCase", MessageRegistry.load(this, "messages.json", (TakeConfiguration.values())));
        dc.createData();
    }
    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "//////////////");
        System.out.println(ChatColor.RED + "//////////////");
        System.out.println(ChatColor.RED + "[TK] TakeCase 2.0 Disabled!");
        System.out.println(ChatColor.RED + "[TK] Author: Merkii");
        System.out.println(ChatColor.RED + "//////////////");
        System.out.println(ChatColor.RED + "//////////////");
    }
    public static TakeCase getInstance() {
        return TakeCase.instance;
    }
}
