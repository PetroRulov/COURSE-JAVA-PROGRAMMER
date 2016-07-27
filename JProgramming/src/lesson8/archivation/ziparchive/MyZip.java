package lesson8.archivation.ziparchive;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by prulov on 27.07.2016.
 */
public class MyZip {
    private int buffer;
    private String path;
    private String archiveName;
    private String destPath;

    public MyZip(int buffer, String path, String destPath) {
        this.buffer = buffer;
        this.path = path;
        archiveName = path.substring(path.lastIndexOf("\\") + 1, path.length()) + ".zip";
        this.destPath = destPath;
        zipData();
    }

    private void zipData() {
        File file = new File(destPath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(destPath), buffer));
            byte[] data = new byte[buffer];
            File f = new File(path + ".");
            String files[] = f.list();

            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i] + " added in ZIP-archive!");
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + File.separator + files[i]), buffer);
                ZipEntry entry = new ZipEntry(files[i]);
                zos.putNextEntry(entry);
                int count;
                while ((count = bis.read(data, 0, buffer)) != -1) {
                    zos.write(data, 0, count);
                }
                bis.close();
            }
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Zip-archive " + archiveName + " was created successfully!");
    }
}