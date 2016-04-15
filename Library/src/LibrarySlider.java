import java.util.Scanner;
public class LibrarySlider {

    private String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    private int start = 0;
    public Book[][] booksByName;
    private Book[][] booksByAuthor;
    private static Book[][] booksByGenre;

    public LibrarySlider() {

        booksByName = new Book[35][];
        fillCatalogue(booksByName);
        booksByAuthor = new Book[35][];
        fillCatalogue(booksByAuthor);
        booksByGenre = new Book[7][];
        fillCatalogue(booksByGenre);

        createBooks();
    }

    public void printBookArr(Book[] book) {

        for (int i = 0; i < book.length; i++) {
            if (book[i] != null) {
                System.out.print("\n");
                book[i].bookInfoShow();
            }
        }
    }

    public static int getTitle(Book[] ctlg) {
        int indexTitle = 0;
        for (int i = 0; i < ctlg.length; i++) {
            if (ctlg[i] == null) {
                indexTitle = i;
                break;
            }
        }
        return indexTitle;
    }

    /**-finding-by-BOOKNAME-*/

    public String findNumByName(String name) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter book's name:");
        name = scan.nextLine();
        int pos = alph.indexOf(name.charAt(0));
        String result = "";
        int index = -1;
        int i = 0;
        if (pos == -1) {
            result = "!!!Position is absent. Please, enter correct name and try again...";
        } else {
            int title = getTitle(booksByName[pos]);
            for (; i < title; i++) {
                if (booksByName[pos][i].getName().equals(name)) {
                    index = i;
                    result = "Catalogue # " + index + "-" + booksByName[pos][index].getLIndx();
                    break;
                }
            }
        }
        return result;
    }

    public void printArrFindByName(String name) {

        name = getString(name);
        int pos = findPos(name);
        if (pos == -1) {
            System.out.println("!!!Position is absent. Please, enter correct name and try again...");
        } else {
            Book[] newArr = getNewBookArr(name);
            printBookArr(newArr);
        }
    }

    private String getString(String name) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter name:");
        name = scan.nextLine();
        return name;
    }

    private int findPos(String name) {

        int pos = alph.indexOf(name.charAt(0));
        return pos;
    }

    private Book[] getNewBookArr(String name) {

        int pos = findPos(name);
        int title = getTitle(booksByName[pos]);
        int nBNQ = getBookNameQuant(booksByName[pos], name);
        Book[] newArr = new Book[nBNQ];
        int j = 0;
        for (int g = 0; g < title; g++) {
            if (booksByName[pos][g].getName().equals(name)) {
                newArr[j] = booksByName[pos][g];
                j++;
            }
        }
        return newArr;
    }

    private int getBookNameQuant(Book[] ctlg, String str) {

        int title = getTitle(ctlg);
        int counter = 0;
        for (int i = 0; i < title; i++) {
            if (str.equals(ctlg[i].getName())) {
                counter += 1;
            }
        }
        return counter;
    }

    /**-finding-by-AUTHOR-*/

    public String findNumByAuthor(String name) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter author's name:");
        name = scan.nextLine();
        int pos = alph.indexOf(name.charAt(0));
        String result = "";
        int index = -1;
        int i = 0;
        if (pos == -1) {
            result = "!!!Position is absent. Please, enter correct author and try again...";
        } else {
            int title = getTitle(booksByAuthor[pos]);
            for (; i < title; i++) {
                if (booksByAuthor[pos][i].getAuth().equals(name)) {
                    index = i;
                    result = "Catalogue # " + index + "-" + booksByAuthor[pos][index].getLIndx();
                    break;
                }
            }
        }
        return result;
    }

    public void printArrFindByAuthor(String name) {

        name = getString(name);
        int pos = findPos(name);
        if (pos == -1) {
            System.out.println("!!!Position is absent. Please, enter correct name and try again...");
        } else {
            Book[] newArr = getNewAuthorArr(name);
            printBookArr(newArr);
        }
    }

    public Book[] getNewAuthorArr(String name) {

        int pos = findPos(name);
        int title = getTitle(booksByAuthor[pos]);
        int nQ = getAuthorQuant(booksByAuthor[pos], name);
        Book[] newArr = new Book[nQ];
        //int title = getTitle(booksByAuthor[pos]);
        int j = 0;
        for (int g = 0; g < title; g++) {
            if (booksByAuthor[pos][g].getAuth().equals(name)) {
                newArr[j] = booksByAuthor[pos][g];
                j++;
            }
        }
        return newArr;
    }

    public static int getAuthorQuant(Book[] ctlg, String str) {

        int title = getTitle(ctlg);
        int counter = 0;
        for (int i = 0; i < title; i++) {
            if (str.equals(ctlg[i].getAuth())) {
                counter += 1;
            }
        }
        return counter;
    }


    /**-finding-by-GENRE-*/

    public Book[] findByGenre(Genre genre) {
        return booksByGenre[genre.getId()];

    }

    public void display5BooksByGenre(Genre genre) {

        int count = 0;
        int i = start;
        for (; i < booksByGenre[genre.getId()].length; i++){
            booksByGenre[genre.getId()][i].bookInfoShow();
            count++;
            if (count == 5) {
                break;
            }
            start = i + 2;
        }
        System.out.println();
    }


    /**- LIBRARY-CREATION-*/

    private void fillCatalogue(Book[][] ctlg) {

        for (int i = 0; i < ctlg.length; i++) {
            ctlg[i] = new Book[40];
        }
    }

    private void addToLibrary(Book book) {

        int pos = alph.indexOf(book.getName().charAt(0));
        addToCatalogue(booksByName[pos], book);

        pos = alph.indexOf(book.getAuth().charAt(0));
        addToCatalogue(booksByAuthor[pos], book);

        addToCatalogue(booksByGenre[book.getGenre().getId()], book);
    }

    private void addToCatalogue(Book[] catalogue, Book book){

        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] == null) {
                catalogue[i] = book;
                return;
            }
        }
    }

    private void createBooks() {

        Book b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Wordsvort W.");
        b.setName("To the beatiful");
        b.setLIndx(0.0);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Homer");
        b.setName("Iliad");
        b.setLIndx(0.01);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Homer");
        b.setName("Odissey");
        b.setLIndx(0.02);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Aeschylus");
        b.setName("Prometheus chained");
        b.setLIndx(0.03);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Sophocles");
        b.setName("Antigona");
        b.setLIndx(0.04);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Virgil");
        b.setName("Aeneid");
        b.setLIndx(0.05);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Horace");
        b.setName("To Melpomene");
        b.setLIndx(0.06);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Ovid");
        b.setName("Metamorphoses");
        b.setLIndx(0.07);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Dante");
        b.setName("Divine comedy");
        b.setLIndx(0.08);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Bokachcho Jh.");
        b.setName("Dekameron");
        b.setLIndx(0.09);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Cervantes");
        b.setName("Don Quixote");
        b.setLIndx(0.1);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Shakespeare W.");
        b.setName("Hamlet");
        b.setLIndx(0.11);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Shakespeare W.");
        b.setName("Romeo and Juliette");
        b.setLIndx(0.12);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Calderon P.");
        b.setName("Life is a Dream");
        b.setLIndx(0.13);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Molier");
        b.setName("Tradesman - Noble");
        b.setLIndx(0.14);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Stendal");
        b.setName("Red and black");
        b.setLIndx(0.15);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Pushkin A.");
        b.setName("Gypsies");
        b.setLIndx(0.16);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Voltaire");
        b.setName("Simpleton");
        b.setLIndx(0.17);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Goethe J.V.");
        b.setName("Faust");
        b.setLIndx(0.18);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Gogol N.V.");
        b.setName("Overcoat");
        b.setLIndx(0.19);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Tolstoy L.");
        b.setName("War and Peace");
        b.setLIndx(0.2);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Voltaire");
        b.setName("Candide");
        b.setLIndx(0.21);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Poe E.A.");
        b.setName("Selected stories");
        b.setLIndx(0.22);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Schiller F.");
        b.setName("Wilhelm Tell");
        b.setLIndx(0.23);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Gogol N.V.");
        b.setName("Audotor. Dead Souls");
        b.setLIndx(0.24);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Griboyedov F.");
        b.setName("Woe from Wit");
        b.setLIndx(0.25);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Hugo");
        b.setName("Disadvantaged");
        b.setLIndx(0.26);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("George Sand");
        b.setName("Consuello");
        b.setLIndx(0.27);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Onore de Balzak");
        b.setName("Gobsek");
        b.setLIndx(0.28);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Dickens Ch.");
        b.setName("Oliver Twist");
        b.setLIndx(0.29);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Tolstoy L.");
        b.setName("Anna Karenina");
        b.setLIndx(0.3);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Rembo A.");
        b.setName("Feeling. Drunk Ship");
        b.setLIndx(0.31);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Zola E.");
        b.setName("Rougon's Career");
        b.setLIndx(0.32);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Wilde O.");
        b.setName("The picture of Dorian Gray");
        b.setLIndx(0.33);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Guy de Maupassant");
        b.setName("Moonlight. Donut");
        b.setLIndx(0.34);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Chekhov A.");
        b.setName("Person in the case. Rothschild's Fiddle");
        b.setLIndx(0.35);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FICTION);
        b.setAuth("Turgenev I.");
        b.setName("Asya");
        b.setLIndx(0.36);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Tolkien J.R.R.");
        b.setName("Hobbit");
        b.setLIndx(1.0);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("George R.R. Martin");
        b.setName("A Game of Thrones");
        b.setLIndx(1.01);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Rothfus P.");
        b.setName("The Name of the Wind");
        b.setLIndx(1.02);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Abercrombie J.");
        b.setName("The Blade itself");
        b.setLIndx(1.03);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Ireman M.D.");
        b.setName("The Axe and the Throne");
        b.setLIndx(1.04);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Tolkien J.R.R.");
        b.setName("Lord of the Rings");
        b.setLIndx(1.05);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Grossman L.");
        b.setName("The Magicians");
        b.setLIndx(1.06);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Pratchett D.");
        b.setName("Discworld");
        b.setLIndx(1.07);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Lynch Sc.");
        b.setName("Lies of the Locke Lamora ");
        b.setLIndx(1.08);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Sanderson B.");
        b.setName("The Way of the Kings");
        b.setLIndx(1.09);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Hob R.");
        b.setName("Assasin's Apprentice");
        b.setLIndx(1.1);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Erikson St.");
        b.setName("Gardens ot the Moon");
        b.setLIndx(1.11);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Gaiman N.");
        b.setName("American Gods");
        b.setLIndx(1.12);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Le Guin Ursulla K.");
        b.setName("A Wizzard of Earthsea");
        b.setLIndx(1.13);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Clarke S.");
        b.setName("Jonathan Strange and Mr. Norrell");
        b.setLIndx(1.14);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Cook Gl.");
        b.setName("The Black Company");
        b.setLIndx(1.15);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Stover M.V.");
        b.setName("Heroes Die");
        b.setLIndx(1.16);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Kibbee K.");
        b.setName("Delvin's Door");
        b.setLIndx(1.17);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Lawrence M.");
        b.setName("The Prince of Thorns");
        b.setLIndx(1.18);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.FANTASY);
        b.setAuth("Key G.G.");
        b.setName("Under Heaven");
        b.setLIndx(1.19);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Pushkin A.");
        b.setName("Evgeniy Onegin");
        b.setLIndx(2.0);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Pushkin A.");
        b.setName("Ruslan and Lyudmila");
        b.setLIndx(2.01);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Pushkin A.");
        b.setName("Caucasus Prisoner");
        b.setLIndx(2.02);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Karpenko-Karyi I.");
        b.setName("Hundred Thousand");
        b.setLIndx(2.03);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Kotlyarevskyi I.");
        b.setName("Aeneid");
        b.setLIndx(2.04);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Nazaruck O.");
        b.setName("Roxolana");
        b.setLIndx(2.05);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Omar Khayyam");
        b.setName("Poetry");
        b.setLIndx(2.06);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Petrarka F.");
        b.setName("The Book of the Songs");
        b.setLIndx(2.07);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Pushkin A.");
        b.setName("Poltava");
        b.setLIndx(2.08);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Franko I.");
        b.setName("Sistine Madonna. Anthem");
        b.setLIndx(2.09);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Lermontov M.");
        b.setName("Mtzyri");
        b.setLIndx(2.1);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Pushkin A.");
        b.setName("Bronze Horseman");
        b.setLIndx(2.11);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Goethe J.V.");
        b.setName("Selected Poetry");
        b.setLIndx(2.12);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Karpenko-Karyi I.");
        b.setName("The Master");
        b.setLIndx(2.13);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Lermontov A.");
        b.setName("Demon. Masquerade");
        b.setLIndx(2.14);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Myrnyi Panas");
        b.setName("Is roaring Oxen as a manger full?");
        b.setLIndx(2.15);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Shevchenko T.");
        b.setName("Kobzar");
        b.setLIndx(2.16);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Shevchenko T.");
        b.setName("Gaydamaki");
        b.setLIndx(2.17);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Shevchenko T.");
        b.setName("Caucasus");
        b.setLIndx(2.18);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Shevchenko T.");
        b.setName("Heretic");
        b.setLIndx(2.19);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Shevchenko T.");
        b.setName("Kateryna");
        b.setLIndx(2.2);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Shevchenko T.");
        b.setName("Zapovit");
        b.setLIndx(2.21);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Shevchenko T.");
        b.setName("Selected works");
        b.setLIndx(2.22);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Undefined");
        b.setName("The Song about Rolland");
        b.setLIndx(2.23);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.POETRY);
        b.setAuth("Báyron G.N.H.");
        b.setName("Mazeppa");
        b.setLIndx(2.24);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Eckel B.");
        b.setName("Thinking in JAVA");
        b.setLIndx(3.0);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Horstmann S. Cay,  Cornell G.");
        b.setName("Core Java");
        b.setLIndx(3.01);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Nouton P., Shildt G.");
        b.setName("JAVA 2, 9th edition");
        b.setLIndx(3.02);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Fain Y.");
        b.setName("JAVA Programming for children");
        b.setLIndx(3.03);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Fain Y.");
        b.setName("JAVA Programming");
        b.setLIndx(3.04);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Jarman T.");
        b.setName("The Algorithm");
        b.setLIndx(3.05);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Collins W.");
        b.setName("Computer One");
        b.setLIndx(3.06);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Cantrell Ch.");
        b.setName("Brainbox");
        b.setLIndx(3.07);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Roszak Th.");
        b.setName("Bugs");
        b.setLIndx(3.08);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Knuth D.");
        b.setName("The Art of Computer Programming");
        b.setLIndx(3.09);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Gabriel Richard P.");
        b.setName("Patterns of Software");
        b.setLIndx(3.1);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Weinberg Gerald M.");
        b.setName("The Psychology of Computer Programming");
        b.setLIndx(3.11);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Kernighan Brian W. , Pike R.");
        b.setName("The Practice of Programming");
        b.setLIndx(3.12);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Goldsmith A., Wu T.");
        b.setName("Who Controls the Internet? Illusions of Borderless World");
        b.setLIndx(3.13);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COMPUTERS);
        b.setAuth("Levy St.");
        b.setName("Hackers: Heroes of the Computer Revolution");
        b.setLIndx(3.14);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Cooker A.");
        b.setName("Cook Book # 1");
        b.setLIndx(4.0);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Povar B.");
        b.setName("Povarennaya Book");
        b.setLIndx(4.01);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Chief Cook");
        b.setName("Chief-cook");
        b.setLIndx(4.02);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Cock D.");
        b.setName("Cooking a Cocks");
        b.setLIndx(4.03);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Cook E.R.");
        b.setName("The best Cook-Book in the World");
        b.setLIndx(4.04);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Radushniy F.");
        b.setName("Welcomer");
        b.setLIndx(4.05);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Vkusnov G.");
        b.setName("Russian dishes recipes");
        b.setLIndx(4.06);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Yamiyamin H.");
        b.setName("Chukchi cusine");
        b.setLIndx(4.07);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Tastininny I.");
        b.setName("Italian cusine");
        b.setLIndx(4.08);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Chief K.");
        b.setName("Cooking a quick");
        b.setLIndx(4.09);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Cooker A.");
        b.setName("Cook Book # 2");
        b.setLIndx(4.1);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Cooker A.");
        b.setName("Cook Book # 3");
        b.setLIndx(4.11);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Nyam L.M..");
        b.setName("Vietnamese cusine");
        b.setLIndx(4.12);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Foodoff N.O.");
        b.setName("The Cooker");
        b.setLIndx(4.13);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Rulov P.Q.");
        b.setName("The Book about tasty and healthy food");
        b.setLIndx(4.14);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Hood R.");
        b.setName("Cooking for poors");
        b.setLIndx(4.15);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Cooker S.T.");
        b.setName("Cook-Book");
        b.setLIndx(4.16);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Cooker U.");
        b.setName("Cook Book 1");
        b.setLIndx(4.17);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Vaaldschnepps V.");
        b.setName("Cooking a Wildfowl");
        b.setLIndx(4.18);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.COOKBOOKS);
        b.setAuth("Xi Yon Zet");
        b.setName("120 Chinese Receipes");
        b.setLIndx(4.19);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Zet");
        b.setName("The Story of the past years");
        b.setLIndx(5.0);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Undefined");
        b.setName("The Lay");
        b.setLIndx(5.01);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Gombrich E.H.");
        b.setName("A little History of the World");
        b.setLIndx(5.02);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Zinn H.");
        b.setName("A people's history of the United States");
        b.setLIndx(5.03);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Wolf H.");
        b.setName("The Nuns of Sant'Ambrogio");
        b.setLIndx(5.04);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Meyer G.J.");
        b.setName("The Tudors");
        b.setLIndx(5.05);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Mann Charles C.");
        b.setName("1491: New Revelations of the Americas Before Columbus");
        b.setLIndx(5.06);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Weatherford J.");
        b.setName("The Secret History of the Mongol Queens");
        b.setLIndx(5.07);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Ansary T.");
        b.setName("Games Without Rules: The Often-Interrupted History of Afghanistan");
        b.setLIndx(5.08);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Arendt H.");
        b.setName("Eichmann in Jerusalem: A Report on the Banality of Evil");
        b.setLIndx(5.09);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Tuchman B.W.");
        b.setName("The March of Folly: From Troy to Vietnam");
        b.setLIndx(5.1);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Sacco J.");
        b.setName("Palestine");
        b.setLIndx(5.11);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Holland T.");
        b.setName("Persian Fire");
        b.setLIndx(5.12);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Suvorov V.");
        b.setName("Icebreaker");
        b.setLIndx(5.13);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("McCullough D.");
        b.setName("John Adams");
        b.setLIndx(5.14);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.HISTORY);
        b.setAuth("Tuchman B.W.");
        b.setName("The Guns of August");
        b.setLIndx(5.15);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Undefined");
        b.setName("Holy Bible: King James Version");
        b.setLIndx(6.0);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Darwin Ch.");
        b.setName("The Origin of Species");
        b.setLIndx(6.01);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Undefined");
        b.setName("The Quran");
        b.setLIndx(6.02);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Marx K.");
        b.setName("The Communist Manifesto");
        b.setLIndx(6.03);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Shakespeare W.");
        b.setName("The Complete Works");
        b.setLIndx(6.04);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Plato");
        b.setName("The Republic");
        b.setLIndx(6.05);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Orwell G.");
        b.setName("1984");
        b.setLIndx(6.06);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Machiavelli N.");
        b.setName("The Prince");
        b.setLIndx(6.07);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Tzu S.");
        b.setName("The Art of War");
        b.setLIndx(6.08);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Frank A.");
        b.setName("The Diary of a Young Girl");
        b.setLIndx(6.09);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Lee H.");
        b.setName("To Kill a Mockingbird ");
        b.setLIndx(6.1);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Smith A.");
        b.setName("The Wealth of Nations");
        b.setLIndx(6.11);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Orwell G.");
        b.setName("Animal Farm");
        b.setLIndx(6.12);
        addToLibrary(b);

        b = new Book();
        b.setGenre(Genre.INDEFINITE);
        b.setAuth("Hitler A.");
        b.setName("Mein Kampf");
        b.setLIndx(6.13);
        addToLibrary(b);

    }
}




