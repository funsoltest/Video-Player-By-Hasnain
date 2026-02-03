package utils;

import java.io.File;

public class AppStateUtils {

    private static final String FLAG = "first_run.flag";

    public static boolean isFirstRun() {
        File file = new File(FLAG);
        if (file.exists()) return false;
        try { file.createNewFile(); } catch (Exception ignored) {}
        return true;
    }
}

