package Color_yr.TouHouFight.Config;

import java.io.File;

public class saveTaskObj {
    private final Object saveobj;
    private final File file;

    public saveTaskObj(Object saveobj, File file) {
        this.saveobj = saveobj;
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public Object getSaveobj() {
        return saveobj;
    }
}
