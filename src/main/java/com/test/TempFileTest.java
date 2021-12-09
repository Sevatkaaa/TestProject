package com.test;

import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFileTest {
    public static void main(String[] args) throws IOException {
        String guid = "123-123-123-123";
        String home = System.getProperty("user.home");
        System.out.println(home);
        File tempDir = new File(home + "/fileUpload");
//        if (!tempDir.exists()) {
            tempDir.mkdir();
//        }
        File tempFileDir = new File(home + "/fileUpload/" + guid);
//        if (!tempFileDir.exists()) {
            tempFileDir.mkdir();
//        }
//        tempFileDir.delete();
        String fileName = tempFileDir.getAbsolutePath() + "/" + "test.txt";
        File file = new File(fileName);
        file.createNewFile();
        File[] files = tempFileDir.listFiles();
        System.out.println(files[0].getName());
        System.out.println(files[1].getName());
    }


}
