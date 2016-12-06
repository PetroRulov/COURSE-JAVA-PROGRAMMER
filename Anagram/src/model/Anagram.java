package model;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by prulov on 06.12.2016.
 */
public class Anagram {

    private List<String> anagramma = new ArrayList<>();

    public Anagram(List<String> anagramma){
        this.anagramma = anagramma;
    }

    public List<String> getAnagramma() {
        return anagramma;
    }
}
