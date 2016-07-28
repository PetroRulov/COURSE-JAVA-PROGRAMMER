package lesson8.serialization.dataio;


import java.io.*;

public class DataIO {

    public static void main(String[] args) throws IOException {

        File dir = new File("D:\\TEST\\DataIO");
        dir.mkdir();
        File file = new File(dir.getAbsolutePath() + File.separator  + "output.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeToFile(file);
        readFromFile(file);
    }

    private static void readFromFile (File file) throws IOException {

        try(
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        ){

            System.out.println(dis.readInt());
            System.out.println(dis.readFloat());
            System.out.println(dis.readChar());
        }

    }

    private static void writeToFile(File file) throws IOException {

        try(
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        ){
            dos.writeInt(10);
            dos.writeFloat(25.3f);
            dos.writeChar('a');
        }
    }

}
