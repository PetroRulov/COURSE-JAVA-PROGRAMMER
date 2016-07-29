package lesson8.archivation;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip implements Serializable {

    private int buffer = 1024;

    private String path;
    private File dest;


    public UnZip(String path, File dest){
        this.path = path;
        this.dest = dest;
        unZipingData();
    }

    private void unZipingData() {

        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path), buffer);
                ZipInputStream zis = new ZipInputStream(bis)

                ){
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                System.out.println("Extracting: " + entry.getName());

                try(BufferedOutputStream bos =
                            new BufferedOutputStream(new FileOutputStream(dest), buffer)){

                    byte[] data = new byte[buffer];
                    int count;
                    while ((count = zis.read(data, 0, buffer)) != -1){
                        bos.write(data, 0 , count);
                    }
                    bos.flush();
                    bos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            zis.close();
            System.out.println(" - Extract Zip archive was  done. - ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
