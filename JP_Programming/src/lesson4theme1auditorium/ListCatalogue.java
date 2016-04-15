package lesson4theme1auditorium;

/**
 * Created by prulov on 02.04.2016.
 */
public class ListCatalogue {

    Auditorium b = new Auditorium();
    Student kom = new Student("Komarov", "A.");

    public ListCatalogue(Auditorium b){
        this.b = b;
    }


    // AL - ArrayList
    public void commandList(){

        b.getSts().add(new Student("Yefremova", "Antonina")); // to add new element at the end of AL
        b.getSts().add(7, new Student("Yefremova", "Antonina")); // to add new element at position 7 in AL
        b.getSts().set(12, new Student("Taldykin", "Yuriy")); // to add object in ALREADY EXISTING AL on 12 position
        b.getSts().remove(7); // to delete position 7 from AL
        b.getSts().remove(b.getSts().get(6)); // to remove position 6 (object) from AL
        b.getSts().get(10); // to receive an access to position 10 in AL
        b.getSts().toArray(); // reformat to regular array;
        b.getSts().contains(kom);// to check if object "kom" present in AL
        b.getSts().hashCode(); // to recieve hashCode of AL
        b.getSts().indexOf(kom); // to receive index of object "kom" in AL
        b.getSts().lastIndexOf(kom); // to receive index of last object "kom"  in AL
        b.getSts().clear(); // to clear AL
        b.getSts().size(); // to receive size(length) of AL
        b.getSts().subList(7, 10); // to receive part of AL from position 7 to position 10 (10 not included)

    }


}
