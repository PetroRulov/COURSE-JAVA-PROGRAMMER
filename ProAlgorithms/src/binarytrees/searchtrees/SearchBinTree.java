package binarytrees.searchtrees;

import binarytrees.Data;

public class SearchBinTree {

    private SBTNode root;

    public SBTNode getRoot() {
        return root;
    }

    public SBTNode find(int key) {
        SBTNode current = root; // Начать с корневого узла
        while(current.getDataKey() != key) // Пока не найдено совпадение
        {
            if(key < current.getDataKey()) // Двигаться налево?
                current = current.leftChild;
            else
                current = current.rightChild; // Или направо?
            if(current == null) // Если потомка нет,
                return null; // поиск завершился неудачей
        }
        return current; // Элемент найден
    }

    public void insert(Data data)
    {
        SBTNode newNode = new SBTNode(); // Создание нового узла
        newNode.setData(data);
        if (root == null) { // Корневой узел не существует
            root = newNode;
        } else {// Корневой узел занят
            SBTNode current = root; // Начать с корневого узла
            SBTNode parent;
            while(true) // (Внутренний выход из цикла)
            {
                parent = current;
                if(data.getId() < current.getDataKey()) // Двигаться налево?
                {
                    current = current.leftChild;
                    if(current == null) // Если достигнут конец цепочки
                    { // вставить слева
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {// Или направо?
                    current = current.rightChild;
                    if(current == null) // Если достигнут конец цепочки,
                    { // вставить справа
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void symByPass(SBTNode node) {
        if(node != null)
        {
            symByPass(node.getLeftChild());
            System.out.print(node.getData().toString() + ", ");
            symByPass(node.getRightChild());
        }
    }

    public void symDisplay() {
        symByPass(root);
    }

//    Узлы дерева в процессе обхода посещаются последовательно,
//    В дереве двоичного поиска этот порядок соответствует порядку возрастания ключей.


    public SBTNode getMin() // Возвращает узел с минимальным ключом
    {
        SBTNode current, last = null;
        current = root; // Обход начинается с корневого узла
        while(current != null) // и продолжается до низа
        {
            last = current; // Сохранение узла
            current = current.leftChild; // Переход к левому потомку
        }
        return last;
    }

    public SBTNode getMax() // Возвращает узел с минимальным ключом
    {
        SBTNode current, last = null;
        current = root; // Обход начинается с корневого узла
        while(current != null) // и продолжается до низа
        {
            last = current; // Сохранение узла
            current = current.rightChild; // Переход к левому потомку
        }
        return last;
    }

    public boolean delete(int key)
    {
        SBTNode current = root;
        SBTNode parent = root;
        boolean isLeftChild = true;
        while(current.getDataKey() != key) // Поиск узла
        {
            parent = current;
            if(key < current.getDataKey()) // Двигаться налево?
            {
                isLeftChild = true;
                current = current.leftChild;
            }
            else // Или направо?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null) // Конец цепочки
                return false; // Узел не найден
        }
        // Удаляемый узел найден
        if (current.leftChild == null && current.rightChild==null) { // Если узел не имеет потомков, он просто удаляется.
            if(current == root) // Если узел является корневым,
                root = null; // дерево очищается
            else if(isLeftChild)
                parent.leftChild = null; // Узел отсоединяется
            else // от родителя
                parent.rightChild = null;
        } else if(current.rightChild==null) { // Если нет правого потомка, узел заменяется левым поддеревом
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild) // Левый потомок родителя
                parent.leftChild = current.leftChild;
            else // Правый потомок родителя
                parent.rightChild = current.leftChild;
        } else if(current.leftChild==null) { // Если нет левого потомка, узел заменяется правым поддеревом
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild) // Левый потомок родителя
                parent.leftChild = current.rightChild;
            else // Правый потомок родителя
                parent.rightChild = current.rightChild;
        } else { // Два потомка, узел заменяется преемником
            SBTNode successor = getSuccessor(current); // Поиск преемника для удаляемого узла (current)
            if (current == root) { // Родитель current связывается с посредником
                root = successor;
            } else if (isLeftChild){
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild; // Преемник связывается с левым потомком current
        }
        return true;
    }

    private SBTNode getSuccessor(SBTNode delNode) {
        SBTNode successorParent = delNode;
        SBTNode successor = delNode;
        SBTNode current = delNode.rightChild; // Переход к правому потомку
        while(current != null) { // Пока остаются левые потомки
            successorParent = successor;
            successor = current;
            current = current.leftChild; // Переход к левому потомку
        }

        if(successor != delNode.rightChild) { // Если преемник не являетсяправым потомком, создать связи между узлами
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
