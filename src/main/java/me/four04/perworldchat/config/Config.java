package me.four04.perworldchat.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Config extends ConfigProvider {

    public static Data data = new Data();

    public static class Data {
        public boolean autoDetectEnabled;
        public List<LinkedWorld> linkedWorlds = new ArrayList<>();
    }

    public Config(JavaPlugin plugin) {
        super(plugin, File.separator, "config.yml");
    }

    @Override
    public void load() {
        ConfigurationSection settings = this.yaml.getConfigurationSection("settings");
        if (settings != null) {
            data.autoDetectEnabled = settings.getBoolean("auto-detect-alt-dimensions");
        }

        ConfigurationSection links = this.yaml.getConfigurationSection("links");
        if (links != null) {
            for (String key : links.getKeys(false)) {
                data.linkedWorlds.add(new LinkedWorld(links.getStringList(key)));
            }
        }
    }
}
