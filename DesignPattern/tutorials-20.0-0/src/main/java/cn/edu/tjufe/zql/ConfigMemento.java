package cn.edu.tjufe.zql;


/**
 *
 * @authro 钟奇林
 * @description 备忘录类
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public class ConfigMemento {
    private ConfigFile configFile;

    public ConfigMemento(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }
}
