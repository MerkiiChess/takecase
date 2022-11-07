package ru.merkii.takecase.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.merkii.takecase.TakeCase;

import java.io.File;
import java.io.IOException;

public class DataCreate {
    FileConfiguration data;
    public void createData() {
        File dataFile = new File(TakeCase.getInstance().getDataFolder(), "data.yml");
        if(!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        data = YamlConfiguration.loadConfiguration(dataFile);
    }
    public FileConfiguration data() {
        return data;
    }
}
