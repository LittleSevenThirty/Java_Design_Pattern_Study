package cn.edu.tjufe.zql;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class AdminTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(AdminTest.class);

    @Test
    public void test(){
        Admin admin = new Admin();
        ConfigOriginator configOriginator = new ConfigOriginator();
        configOriginator.setConfigFile(new ConfigFile("10000001","配置内容A=哈哈",new Date(),"钟奇林"));
        admin.appendMemento(configOriginator.saveMemento());    // 保存配置
        configOriginator.setConfigFile(new ConfigFile("10000002","配置内容B=呵呵",new Date(),"钟奇林"));
        admin.appendMemento(configOriginator.saveMemento());    // 保存配置
        configOriginator.setConfigFile(new ConfigFile("10000003","配置内容C=嘿嘿",new Date(),"钟奇林"));
        admin.appendMemento(configOriginator.saveMemento());    // 保存配置
        configOriginator.setConfigFile(new ConfigFile("10000004","配置内容D=嗨嗨",new Date(),"钟奇林"));
        admin.appendMemento(configOriginator.saveMemento());    // 保存配置

        // 历史配置（回滚）
        configOriginator.setConfiFileByMemento(admin.undoMemento());
        logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置（回滚）
        configOriginator.setConfiFileByMemento(admin.undoMemento());
        logger.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置（回滚）
        configOriginator.setConfiFileByMemento(admin.redoMemento());
        logger.info("历史配置(前进)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置（回滚）
        configOriginator.setConfiFileByMemento(admin.getMementoByVersion("10000002"));
        logger.info("历史配置(获取)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));
    }
}