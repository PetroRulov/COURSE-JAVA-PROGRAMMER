package lesson4.theme5.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Created by prulov on 09.04.2016.
 */
public class Stack {

    private int counter;
    private LinkedList data = new LinkedList();

    public Stack(){}

    public void push(Object obj){

        data.addLast(obj);
    }

    public Object pop(){

        if(!data.isEmpty()){
            Object obj = data.getFirst();
            data.removeFirst();
            return obj;
        } else {
            throw new EmptyStackException();
        }
    }

    public Object peek(){

        if(!data.isEmpty()){
            return data.getFirst();
        } else {
            throw new EmptyStackException();
        }
    }

    public void printStack(){

        for(Object obj : data){
            System.out.println(obj.toString());
        }
    }


}
