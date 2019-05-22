package com.cs.meet.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import net.coobird.thumbnailator.Thumbnails;

public class FileUtil {

    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();


    /*
   生成存储图片的目录
    */
    public static void makedir(String target) {


        String realFilepath = PathUtil.getBasePath() + target;

        File file = new File(realFilepath);


        if (!file.exists()) {
            file.mkdirs();
        }

    }

    /*
   获取扩展名
    */
    public static String getextension(String filename) {
        String fileTyle = filename.substring(filename.lastIndexOf("."), filename.length());

        return fileTyle;

    }

    public static String getrealname() {
        int randomnumber = random.nextInt(9999) + 1000;
        String time = sf.format(new Date());


        return time + randomnumber;

    }


    public static void deleteFileAndPath(String path){
        File realpath = new File(path);
        if(realpath.exists()){
            if(realpath.isDirectory()) {//如果是目录
                File file[] = realpath.listFiles();
                for (int i = 0; i < file.length; i++) {
                    boolean a = file[i].delete();//删除目录
                    System.out.println(a);
                }
            }
            else {
                realpath.delete();//删除文件
            }
        }

    }
}
