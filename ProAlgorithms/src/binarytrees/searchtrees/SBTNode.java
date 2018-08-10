package binarytrees.searchtrees;

import binarytrees.Data;

public class SBTNode {

    private Data data;
    SBTNode leftChild;
    SBTNode rightChild;

    public int getDataKey() {
        return data.getId();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public SBTNode getLeftChild() {
        return leftChild;
    }

    public SBTNode getRightChild() {
        return rightChild;
    }

    public String toString(){
        return data.toString();
    }
}
