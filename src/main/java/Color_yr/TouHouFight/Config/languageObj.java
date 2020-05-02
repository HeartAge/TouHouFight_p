package Color_yr.TouHouFight.Config;

import java.util.List;

public class languageObj {
    private String unknownCommand;
    private List<String> HelpCommand;
    private String reloadCommand;

    public String getReloadCommand() {
        return reloadCommand;
    }

    public List<String> getHelpCommand() {
        return HelpCommand;
    }

    public String getUnknownCommand() {
        return unknownCommand;
    }
}
