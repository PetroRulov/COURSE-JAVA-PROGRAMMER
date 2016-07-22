package lesson8.archivation;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Launcher {

    public static void main(String[] args) {
        File dir = new File("D:\\CopyFile\\");
        dir.mkdir();

        String fileName = File.separator + "Stock.txt";
        File original = new File(dir.getAbsolutePath() + fileName);

        new Zip(original.getAbsolutePath(), original.getParent());

        //new UnZip(original.getAbsolutePath());

        byte[] buffer = new byte[1024];
        String destDir = "D:\\CopyFile\\Stock\\";
        File dstDir = new File(destDir);
        if (!dstDir.exists()) {
            dstDir.mkdir();
        }

        try(
                FileInputStream fis = new FileInputStream(dir.getAbsolutePath() + fileName);
                ZipInputStream zis = new ZipInputStream(fis);
        ) {

            ZipEntry entry;
            while((entry = zis.getNextEntry()) != null){
                String nextFileName = entry.getName();
                System.out.println(nextFileName);
                System.out.println(destDir + File.separator + nextFileName);
                File nextFile = new File(destDir + File.separator + nextFileName);
                if (entry.isDirectory()) {
                    nextFile.mkdir();
                } else {
                    new File(nextFile.getParent()+ File.separator +"/Copy"+ nextFileName);

                    try (FileOutputStream fos = new FileOutputStream(nextFile);
                         OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
                    ) {

                        outputStreamWriter.write(nextFileName);
                        int length;
                        while((length = zis.read(buffer)) > 0) {

                            fos.write(buffer, 0, length);
                        }
                    }
                }
            }
            zis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

