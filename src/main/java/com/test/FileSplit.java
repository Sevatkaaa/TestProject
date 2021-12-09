package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class FileSplit {
    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/sov/Desktop/qooco/test/a1vvv23afve-28584036372067253411.jpg");
//        byte[] originalFileBytes = FileUtils.readFileToByteArray(file);
//        int len = 0;
//        len = checkFile("flaa.jpg", originalFileBytes, len);
//        len = checkFile("flab.jpg", originalFileBytes, len);
//        len = checkFile("flac.jpg", originalFileBytes, len);
//        len = checkFile("flad.jpg", originalFileBytes, len);
//        len = checkFile("flae.jpg", originalFileBytes, len);
//        len = checkFile("flaf.jpg", originalFileBytes, len);
//        len = checkFile("flag.jpg", originalFileBytes, len);
//        len = checkFile("flah.jpg", originalFileBytes, len);
//        len = checkFile("flai.jpg", originalFileBytes, len);
//        len = checkFile("flaj.jpg", originalFileBytes, len);
//        byte[] file1Bytes = FileUtils.readFileToByteArray(file1);
//        byte[] file2Bytes = FileUtils.readFileToByteArray(file2);
//        byte[] file3Bytes = FileUtils.readFileToByteArray(file3);
//        int length1 = file1Bytes.length;
//        int length2 = file2Bytes.length;
//        int length3 = file3Bytes.length;
//        for (int i = 0; i < length1; i++) {
//            if (file1Bytes[i] != originalFileBytes[i]) {
//                System.out.println(i);
//            }
//        }
//        for (int i = length1; i < length1 + length2; i++) {
//            if (file2Bytes[i - length1] != originalFileBytes[i]) {
//                System.out.println(i);
//            }
//        }
//        for (int i = length1 + length2; i < length1 + length2 + length3; i++) {
//            if (file3Bytes[i - length1 - length2] != originalFileBytes[i]) {
//                System.out.println(i);
//            }
//        }
//        String name = "";
//        checkFile(name, originalFileBytes, length1);
//        File newFile = new File("/Users/sov/Desktop/qooco/result.jpg");
//        newFile.createNewFile();
//        Path path = newFile.toPath();
//        Files.write(path, file1Bytes, StandardOpenOption.APPEND);
//        Files.write(path, file2Bytes, StandardOpenOption.APPEND);
//        Files.write(path, file3Bytes, StandardOpenOption.APPEND);

//        List<String> names = new ArrayList<>();
//        names.add("flaa.jpg");
//        names.add("flab.jpg");
//        names.add("flac.jpg");
//        names.add("flad.jpg");
//        names.add("flae.jpg");
//        names.add("flaf.jpg");
//        names.add("flag.jpg");
//        names.add("flah.jpg");
//        names.add("flai.jpg");
//        names.add("flaj.jpg");
//        collectFiles(names);

        compareTwoFiles("/Users/sov/Desktop/qooco/test/flower/flowers.jpg", "/Users/sov/Desktop/qooco/test/flower/10_chuncks_pixels.jpeg");
//        compareTwoFiles("flai.jpg", "/Users/sov/fileUpload/a1vvv23afve-3/9.jpg");
//        compareTwoFiles("flaj.jpg", "/Users/sov/fileUpload/a1vvv23afve-3/10.jpg");
    }

    private static void collectFiles(List<String> files) throws IOException {
        File newFile = new File("/Users/sov/Desktop/qooco/test/result.jpg");
        newFile.createNewFile();
        Path path = newFile.toPath();
        files.stream().forEach(f -> {
            try {
                File file = new File("/Users/sov/Desktop/qooco/test/" + f);
                byte[] fileBytes = FileUtils.readFileToByteArray(file);
                Files.write(path, fileBytes, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static int checkFile(String name, byte[] file, int length) throws IOException {
        File checkFile = new File("/Users/sov/Desktop/qooco/test/" + name);
        byte[] fileBytes = FileUtils.readFileToByteArray(checkFile);
        for (int i = length; i < length + fileBytes.length; i++) {
            if (fileBytes[i - length] != file[i]) {
                System.out.println(i);
                break;
            }
        }
        return length + fileBytes.length;
    }

    private static void compareTwoFiles(String name1, String name2) throws IOException {
        File file1 = new File(name1);
        File file2 = new File(name2);

        byte[] file1Bytes = FileUtils.readFileToByteArray(file1);
        byte[] file2Bytes = FileUtils.readFileToByteArray(file2);

        for (int i = 500000 - 1; i < file1Bytes.length; i++) {
            if (file1Bytes[i] != file2Bytes[i]) {
                System.out.println("First dif in " + i);
                break;
            }
        }
    }
}
