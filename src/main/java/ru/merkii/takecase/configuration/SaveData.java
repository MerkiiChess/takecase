package ru.merkii.takecase.configuration;

import ru.merkii.takecase.TakeCase;

import java.io.File;
import java.io.IOException;

public class SaveData extends DataCreate {
    public void saveData() {
        try {
            data.save(new File(TakeCase.getInstance().getDataFolder(), "data.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
