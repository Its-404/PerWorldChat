package me.four04.perworldchat.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConfigProvider {
    public JavaPlugin plugin;
    String resourceName;

    public File file;
    public YamlConfiguration yaml;

    /**
     * @param plugin The main plugin class.
     * @param path The file path in which the resource will be saved.
     * @param resourceName The name of the resource. ex: "config.yml"
     */
    public ConfigProvider(JavaPlugin plugin, String path, String resourceName) {
        this.plugin = plugin;
        this.resourceName = resourceName;

        file = new File(plugin.getDataFolder() + path, resourceName);
        if (!file.exists()) {
            this.saveResource(this.plugin, file, resourceName);
        }
        yaml = YamlConfiguration.loadConfiguration(file);
        load();
    }

    /**
     * Saves a resource to a specific file.
     * @param plugin The main plugin class.
     * @param file The file where the resource will be saved.
     * @param resourceName The name of the resource. ex: "config.yml"
     */
    private void saveResource(JavaPlugin plugin, File file, String resourceName) {

        List<File> folders = new ArrayList<>();
        String[] paths = file.getAbsolutePath().replace(resourceName, "").split(File.pathSeparator);
        for (String path : paths) {
            folders.add(new File(String.valueOf(Paths.get(path))));
        }
        for (File folder : folders) {
            if (!folder.exists() && folder.mkdirs())
                plugin.getLogger().info("ConfigProvider created a new folder called '" + folder.getName() + "'.");
        }

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = plugin.getResource(resourceName);
            outputStream = new FileOutputStream(file);

            int read;
            byte[] bytes = new byte[1024];

            if (inputStream != null) {
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Overridable method used to load yml config.
    public void load() {

    }
}
