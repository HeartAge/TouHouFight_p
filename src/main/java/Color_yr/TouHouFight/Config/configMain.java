package Color_yr.TouHouFight.Config;

import Color_yr.TouHouFight.TouHouFight;
import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class configMain {

    public configObj Config;   //主配置文件对象
    public languageObj lan;
    public saveTaskDo SaveTask;
    private File FileName;  //文件缓存

    public configMain() {
        SaveTask = new saveTaskDo();
        setConfig();
    }

    private void ConfigReload() {
        try {
            Gson json = new Gson();
            InputStreamReader reader = new InputStreamReader(new FileInputStream(FileName), StandardCharsets.UTF_8);
            BufferedReader bf = new BufferedReader(reader);
            Config = json.fromJson(bf, configObj.class);
            lan = Config.getLanguage();
            reader.close();
            bf.close();

        } catch (Exception arg0) {
            TouHouFight.log.warning("§d[TouHouFight]§c配置文件读取失败");
            arg0.printStackTrace();
        }
    }

    public void setConfig() {
        //读取文件初始化
        FileName = new File(TouHouFight.plugin.getDataFolder(), "config.json");
        if (!TouHouFight.plugin.getDataFolder().exists())
            TouHouFight.plugin.getDataFolder().mkdirs();
        if (!FileName.exists()) {
            try (InputStream in = TouHouFight.plugin.getResource("config.json")) {
                Files.copy(in, FileName.toPath());
            } catch (IOException e) {
                TouHouFight.log.warning("§d[TouHouFight]§c配置文件 config.json 创建失败：" + e);
            }
        }
        ConfigReload();
    }
}