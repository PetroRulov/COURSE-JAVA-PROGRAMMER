package lesson8.files;

import java.io.File;

/**
 * Created by prulov on 30.06.2016.
 */
public class PathToFile {

    public static void main(String[] args) {

        File file = new File("test.txt");

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.clearProperty("user.dir"));
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        for(File f : File.listRoots()){
            System.out.println(f.getAbsolutePath());
        }

        System.out.println();
        System.out.println("getFilePath() = " + getFilePath());
    }

    private static String getFilePath() {

        String path = "C://Users//prulo//IdeaProjects//JProgramming//src//lesson8//files//";
        path.replace("/", File.separator);
        File thisFile = new File(path, PathToFile.class.getSimpleName() + ".java");

        return  thisFile.getAbsolutePath();
    }



}
