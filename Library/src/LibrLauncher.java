public class LibrLauncher {

    public static void main(String[] args) {

        LibrarySlider libr = new LibrarySlider();

        System.out.println(libr.findNumByName("Roxolana"));
        libr.printArrFindByName("Roxolana");
        System.out.println(libr.findNumByAuthor("Pushkin A."));
        libr.printArrFindByAuthor("Pushkin A.");
        libr.display5BooksByGenre(Genre.HISTORY);
        libr.display5BooksByGenre(Genre.HISTORY);
        libr.display5BooksByGenre(Genre.HISTORY);

        for (Book book : libr.findByGenre(Genre.HISTORY)) {
            if (book != null) {
                System.out.println(book.getLIndx());
            }
        }
    }
}
