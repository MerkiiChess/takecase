package ru.merkii.takecase.configuration;

import ru.den_abr.commonlib.messages.EnumBasedMessageKey;
import ru.den_abr.commonlib.messages.MessageKey;

public enum TakeConfiguration implements EnumBasedMessageKey {
    ERROR_ALREDY(new String[] { "&4&l[!] Вы уже получали кейс с валютой! "}),
    INFO_SUCCES(new String[] { "&a&l[!] Вы успешно получили кейс с валютой" });
    private Object def;
    private TakeConfiguration(final String[] def) {
        this.def = MessageKey.convertDefault(def);
    }
    public Object getDefault() {
        return this.def;
    }
}
