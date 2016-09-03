package lesson8.zconsolidation.listbasedonfile;

import java.io.*;
import java.util.Iterator;

/**
 * Created by prulov on 25.08.2016.
 */
public class FileSimpleList implements SimpleList, Serializable, Iterable {

    private File file;

    public FileSimpleList(){
        file = new File("FileSimpleList.txt");
    }

    @Override
    public void add(Object object) {
        writeToFile(object);
    }

    @Override
    public boolean contains(Object object) {
        String[] arrFromFile = readFromFile();
        for (String str : arrFromFile){
            if (str.equalsIgnoreCase(object.toString())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(Object object) {
        removeFromFile(object);
    }


    @Override
    public int size() {
        String[] arrFromFile = readFromFile();
        int size = 0;
        for (String str: arrFromFile){
            if (!str.equals("")){
                size++;
            }
        }
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleListIterator();
    }


    private void writeToFile(Object object) {
        try (
                FileOutputStream fos = new FileOutputStream(file, true);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter writer = new BufferedWriter(osw);
        ){
            String arrFromFile[] = readFromFile();
            boolean hasEmpty = false;
            for (int i = 0; i < arrFromFile.length; i++) {
                if (arrFromFile[i].equals("")){
                    arrFromFile[i] = object.toString();
                    hasEmpty = true;
                    break;
                }
            }
            if (!hasEmpty){
                writer.write(object.toString() + "\n");
            } else {
                fos.getChannel().truncate(0);
                for (int i = 0; i < arrFromFile.length; i++) {
                    writer.write(arrFromFile[i] + "\n");
                }
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String[] readFromFile(){
        StringBuilder builder = new StringBuilder();
        try (
                InputStream inStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(inStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
        ){
            String str;
            while ((str = reader.readLine()) != null){
                builder = builder.append(str);
                builder = builder.append("\n\r");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString().split("\n\r");
    }

    private void removeFromFile(Object object) {
        try (
                FileOutputStream outputStream = new FileOutputStream(file, true);
                OutputStreamWriter osw = new OutputStreamWriter(outputStream);
                BufferedWriter writer = new BufferedWriter(osw);
        ){
            String[] arrFromFile = readFromFile();
            int objPosition = getObjectPosition(object, arrFromFile);
            System.out.println(objPosition);
            if (objPosition != -1){
                arrFromFile[objPosition] = "";
                outputStream.getChannel().truncate(0);
                for (int i = 0; i < arrFromFile.length; i++) {
                    writer.write(arrFromFile[i] + "\n");
                }
            } else {
                System.out.println("There isn't such object");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getObjectPosition(Object object, String[] arr){
        String[] arrFromFile = arr;
        for (int i = 0; i < arrFromFile.length; i++) {
            if (arrFromFile[i].equalsIgnoreCase(object.toString())){
                return i;
            }
        }
        return -1;
    }

    private class SimpleListIterator implements Iterator {
        String arrFromFile[] = readFromFile();
        private int curr;

        public SimpleListIterator(){
            curr = 0;
        }

        @Override
        public boolean hasNext() {
            if (arrFromFile[curr + 1] != null){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (curr == 0 && arrFromFile[0] != null){
                return arrFromFile[0];
            } else if (hasNext()){
                curr++;
                return arrFromFile[curr];
            }
            return null;
        }
    }
}

