package lesson8.archivation;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip implements Serializable {

    private String path;
    private String destPath;
    private File data;
    private File zipedData;

    public Zip(String path, String destPath){
        this.path = path;
        this.destPath = destPath;
        data = new File(path);
        zipedData = new File(destPath);
        zipingData();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }

    public File getZipedData() {
        return zipedData;
    }

    public void setZipedData(File zipedData) {
        this.zipedData = zipedData;
    }

    private void zipingData(){
        File files[] = zipedData.listFiles();
        try(
                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(data.getPath() + ".zip"));
                FileInputStream fis = new FileInputStream(data);
        ){
            for (File file: files) {
                ZipEntry zipEntry = new ZipEntry(file.getPath());
                zos.putNextEntry(zipEntry);
                byte [] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                zos.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
