package github.wy.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author wangye
 * @Email wangye.wy@outlook.com
 * @CreateTime: 2022-10-18  19:20
 * @Version: 1.0.0
 * @Description: 配置文件工具类
 */
@Slf4j
public class PropertiesFileUtil {

    private PropertiesFileUtil(){

    }

    public static Properties readPropertiesFile(String fileName){
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        String rpcConfigPath = "";
        if(url != null){
            rpcConfigPath = url.getPath() + fileName;
        }
        Properties properties = null;
        try(InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream(rpcConfigPath), StandardCharsets.UTF_8)){
            properties = new Properties();
            properties.load(inputStreamReader);
        }catch (IOException e){
            log.error("occur exception when read properties file [{}]", fileName);
        }
        return properties;
    }
}
