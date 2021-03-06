package lesson8.files.readandwritefiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Created by prulov on 02.07.2016.
 */
public class CopyFileDemo {

    public static void main(String[] args) throws IOException {

        File dir = new File("D:\\CopyFile\\");
        dir.mkdir();

        String fileName = File.separator + "Lorem.txt";

        File original = new File(dir.getAbsolutePath() + fileName);
        copyFile(original);

        File file = new File("D:\\CopyFile\\Petro.txt");
        copyFiles(file);

        copyFileWithBuffer(original);
        copyFileWithBuffer(file);


    }

    private static void copyFile(File file) throws IOException {

        String fileName = File.separator + "Lorem.txt";
        String copyName = File.separator + "CopyLorem.txt";
        File copy = new File(file.getParent() + copyName);

        try {
            copy.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader reader = new LegacyFileReader(file);
        FileWriter writer = new LegacyFileWriter(copy);
        ((LegacyFileWriter)writer).write(((LegacyFileReader)reader).read(file.getParent()  + fileName) + " @Copy",
                file.getParent() + copyName);
    }

    private static void copyFiles(File file) throws IOException {

        File copy = new File(file.getParent() + "/Copy" + file.getName());
        Files.copy(file.toPath(), copy.toPath());
    }

    private static void copyFileWithBuffer(File file) throws IOException {

        StringBuilder builder = new StringBuilder();
        InputStream in = Files.newInputStream(file.toPath());
        int i = 0;
        try (BufferedInputStream bis = new BufferedInputStream(in, 256)){

            while ((i = bis.read()) != -1){
                builder.append((char) i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        File copy = new File(file.getParent() + file.getName());
        OutputStream writer = Files.newOutputStream(copy.toPath(), StandardOpenOption.CREATE);
        try (BufferedOutputStream bos = new BufferedOutputStream(writer, 256)) {
            bos.write(builder.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
