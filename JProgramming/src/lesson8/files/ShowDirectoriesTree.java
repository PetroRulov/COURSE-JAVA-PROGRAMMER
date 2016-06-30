package lesson8.files;

import java.io.File;

/**
 * Created by prulov on 30.06.2016.
 */
public class ShowDirectoriesTree {

    public static void main(String[] args) {


        String str = System.clearProperty("user.dir");
        System.out.println(str + ":");
        
        str = "C://Users//prulo//IdeaProjects//";
        
        showDirTree(str);
    }

    private static void showDirTree(String dirName) {

        File dir = new File(dirName);

        File files[] = dir.listFiles();
        for(File file : files){
            System.out.println(file.getName());
        }
    }
}



