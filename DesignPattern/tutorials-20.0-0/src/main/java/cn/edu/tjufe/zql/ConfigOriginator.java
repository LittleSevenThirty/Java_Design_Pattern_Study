package cn.edu.tjufe.zql;


/**
 *
 * @authro 钟奇林
 * @description 记录者类 记录者类除了对ConfigFile配置类增加了获取和设置方法外，还增加了保存saveMemento()、获取getMemento(ConfigMemento memento)
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public class ConfigOriginator {
    private ConfigFile configFile;  // 配置文件

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigMemento saveMemento(){
        return new ConfigMemento(this.configFile);
    }

    public void setConfiFileByMemento(ConfigMemento memento){
        this.configFile=memento.getConfigFile();
    }
}
