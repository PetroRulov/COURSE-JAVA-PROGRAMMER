import model.Converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by prulov on 05.12.2016.
 */
public class LaunchAnagram {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phrase = "";
        try {
            phrase = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Converter converter = new Converter(phrase);
        System.out.println(converter.anagramToString());
    }

}
