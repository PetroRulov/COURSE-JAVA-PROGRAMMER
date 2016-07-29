package lesson8.archivation.ziparchive;

import java.io.File;

public class ZipLauncher {

    public static void main(String[] args) {

        int buffer = 1024;
        String path = "D:\\TEST\\ZippingOneDir\\DirForZip";

        String lastName = path.substring(path.lastIndexOf("\\") + 1, path.length());
        String firstDir = path.substring(0, path.lastIndexOf("\\"));
        String destPath = firstDir + File.separator + lastName + ".zip";

        new MyZip(buffer, path, destPath);
        System.out.println();

        path = destPath;
        destPath = firstDir + File.separator + "";

        new MyUnZip(buffer, path, destPath);

    }
}
