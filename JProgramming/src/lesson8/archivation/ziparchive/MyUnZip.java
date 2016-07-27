package lesson8.archivation.ziparchive;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by prulov on 27.07.2016.
 */
public class MyUnZip {
    private int buffer;
    private String path;
    private String archiveName;
    private String destPath;

    public MyUnZip(int buffer, String path, String destPath) {
        this.buffer = buffer;
        this.path = path;
        this.destPath = destPath;
        archiveName = path.substring(path.lastIndexOf("\\") + 1, path.length());;
        unZipData();
    }

    public void unZipData() {

        try {
            ZipInputStream zis =
                    new ZipInputStream(new BufferedInputStream(new FileInputStream(path), buffer));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                System.out.println(entry + " extracted");

                BufferedOutputStream bos =
                        new BufferedOutputStream(new FileOutputStream(destPath + entry), buffer);
                byte[] data = new byte[buffer];
                int count;
                while ((count = zis.read(data,0,buffer)) != -1){
                    bos.write(data, 0 , count);
                }
                bos.flush();
                bos.close();
            }
            zis.close();
            System.out.println();
            System.out.println("ZIP-archive " + archiveName + " was extracted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

