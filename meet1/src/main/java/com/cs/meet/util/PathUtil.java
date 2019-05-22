package com.cs.meet.util;

public class PathUtil {

    public static String seperator = System.getProperty("file.seperator");

    public static String getBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/pro/meet/";
        } else {
            basePath = "/Users/chenz/Desktop/JavaEE_4/meet/src/main/resources/static";

        }

        return basePath;
    }

    public static String getmeetfilePath(int uid) {

        String Path = "upload/File/item" + uid + "/";

        return Path;
    }




}
