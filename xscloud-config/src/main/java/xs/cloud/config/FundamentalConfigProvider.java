package xs.cloud.config;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FundamentalConfigProvider {
    private static final String CONFIG_PATH="config.path";
    public static final String FILE_PREFIX = "file:";
    public static final String CLASSPATH_PREFIX = "classpath:";
    public static final String DEFAULT_CONFIG_PATH = "classpath:testapplication.properties";
    private static final Logger log = Logger
            .getLogger(FundamentalConfigProvider.class);

    private static Properties prop = null;

    public static Properties getProp() {
        if (prop == null) {
            init();
        }
        return prop;
    }

    private static void init() {
        //已经初始化，则直接返回
        if (FundamentalConfigProvider.prop != null
                && FundamentalConfigProvider.prop.size() > 0) {
            return;
        }
        String configPathStr = System.getProperty(CONFIG_PATH);
        if (configPathStr == null) {
            log.info("can't load config from:System.getProperty(Constants.CONFIG_PATH)");
            configPathStr = System.getenv(CONFIG_PATH);
            log.info("can't load config from:System.getenv(Constants.CONFIG_PATH)");
            if (configPathStr == null) {
                log.error("config.path is null，now we use default config.if the environment is not dev,please check you startup param: -Dconfig.path=xxx");
                configPathStr = DEFAULT_CONFIG_PATH;
            }
        }
        log.info("config.path:" + configPathStr);

        prop = new Properties();

        String[] configPathArray = configPathStr.split(";");
        for(String configPath:configPathArray){
            doInit(configPath);
        }

    }

    private static void doInit(String configPath) {
        if (configPath.startsWith(FILE_PREFIX)) {
            iniWithDir(new File(configPath.substring(FILE_PREFIX.length())));
        } else if (configPath.startsWith(CLASSPATH_PREFIX)) {
            configPath = configPath
                    .substring(CLASSPATH_PREFIX.length());
            try (
                    InputStream inputStream = FundamentalConfigProvider.class
                    .getResourceAsStream(configPath)
                ) {
                prop.load(inputStream);
            } catch (Exception e) {

            }
        }else{
            iniWithDir(new File(configPath));
        }

    }
    private static void iniWithDir(File file){
        if(file==null) return;
        if(file.isDirectory()){
            for(File f:file.listFiles()){
                iniWithDir(f);
            }
        }else if (file.isFile()&&file.getName().endsWith(".properties")){
            try {
                prop.load(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
