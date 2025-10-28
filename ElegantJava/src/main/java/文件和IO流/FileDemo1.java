package main.java.文件和IO流;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\zxc\\Desktop\\处理");
        System.out.println(getDirSize(0,file));

    }

    static long getDirSize(long sum,File file) {
        for (File listFile : file.listFiles()) {
            if (listFile.isFile()) {
                sum+=listFile.length();
            }else{
                sum+=getDirSize(0,listFile);
            }
        }
        return sum;
    }
}
