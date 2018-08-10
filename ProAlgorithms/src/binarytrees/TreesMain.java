package binarytrees;

import binarytrees.searchtrees.SBTNode;
import binarytrees.searchtrees.SearchBinTree;

public class TreesMain {

    public static void main(String[] args) {

        Data one = new Data(1, "One");
        Data two = new Data(2, "Two");
        Data three = new Data(3, "Three");
        Data four = new Data(4, "Four");
        Data five = new Data(5, "Five");
        Data six = new Data(6, "Six");
        Data seven = new Data(7, "Seven");
        Data eight = new Data(8, "Eight");
        Data nine = new Data(9, "Nine");
        Data ten = new Data(10, "Ten");
        Data eleven = new Data(11, "Eleven");

        SearchBinTree theTree = new SearchBinTree();
        theTree.insert(nine);
        theTree.insert(one);
        theTree.insert(three);
        theTree.insert(six);
        theTree.insert(two);
        theTree.insert(eleven);
        theTree.insert(eight);
        theTree.insert(ten);
        theTree.insert(seven);
        theTree.insert(four);
        theTree.insert(five);

        theTree.symDisplay();
        System.out.println();

        SBTNode result = theTree.find(5);
        System.out.println(result.toString());

        System.out.println("Minimum key = " + theTree.getMin().toString());
        System.out.println("Maximum key = " + theTree.getMax().toString());

        theTree.delete(5);
        theTree.symDisplay();
    }
}
