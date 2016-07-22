package lesson8.archivation;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip implements Serializable {

    private String path;
    private File file;

    public UnZip(String path){
        this.path = path;
        unZipingData();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private void unZipingData() {
        byte[] buffer = new byte[1024];

        String dstDirectory = destinationDirectory(path);
        File dstDir = new File(dstDirectory);
        if (!dstDir.exists()) {
            dstDir.mkdir();
        }


        try(

                FileInputStream fis = new FileInputStream(path);
                ZipInputStream zis = new ZipInputStream(fis);

        ) {

            ZipEntry entry;
            while((entry = zis.getNextEntry()) != null){
                String nextFileName = entry.getName();
                System.out.println(nextFileName);
                System.out.println(dstDirectory + File.separator + nextFileName);
                File nextFile = new File(dstDirectory + File.separator + nextFileName);
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

    private String destinationDirectory(String srcZip) {

        return srcZip.substring(0, srcZip.lastIndexOf("."));

    }
}
