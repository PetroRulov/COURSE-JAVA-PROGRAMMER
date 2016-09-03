package lesson8.zconsolidation.listbasedonfile;

import java.util.Arrays;

/**
 * Created by prulov on 25.08.2016.
 */
public class FSLLauncher {

    public static void main(String[] args) {
        FileSimpleList fileSimpleList = new FileSimpleList();
//        fileSimpleList.add("asd");
//        fileSimpleList.add(1234);

        System.out.println(fileSimpleList.contains("asd1"));


        // fileSimpleList.add(5532);
        // fileSimpleList.add(2);
        //fileSimpleList.remove(1234);
        System.out.println(fileSimpleList.size());
        System.out.println(Arrays.toString(fileSimpleList.readFromFile()));
    }
}
