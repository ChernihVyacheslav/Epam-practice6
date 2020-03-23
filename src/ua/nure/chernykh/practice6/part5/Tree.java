package ua.nure.chernykh.practice6.part5;

public class Tree<E extends Comparable<E>> {

    private static final String LINESEPARATOR = System.lineSeparator();
    private Node<E> root;

    // добавляет элемент в контейнер
    // если в контейнере есть элемент равный по compareTo добавляемому,
    // то добавления не происходит и метод возвращает false
    // в противном случае элемент попадает в контейнер и метод возвращает true
    // первый добавляемый элемент становится корнем дерева
    // автобалансировки в дереве нет
    public boolean add(E element) {
        if (element != null) {
            if (root == null) {
                root = new Node<>(element);
                return true;
            }
            Node<E> treeNode = root;
            while (true) {
                int comparison = element.compareTo(treeNode.getElement());
                if (comparison == 0) {
                    return false;
                } else if (comparison > 0) {
                    //add to the right
                    if (treeNode.getRightChild() != null) {
                        treeNode = treeNode.getRightChild();
                    } else {
                        treeNode.setRightChild(new Node<>(element));
                        treeNode.getRightChild().setParent(treeNode);
                        return true;
                    }
                } else {
                    //add to the left
                    if (treeNode.getLeftChild() != null) {
                        treeNode = treeNode.getLeftChild();
                    } else {
                        treeNode.setLeftChild(new Node<>(element));
                        treeNode.getLeftChild().setParent(treeNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // добавляет все элементы из массива в контейнер (вызов в цикле метода add, см. выше)
    public void add(E[] elements) {
        for (E el : elements) {
            add(el);
        }
    }

    // удаляет элемент из контейнера
    // если удаляемого элемента в контейнере нет, то возвращает false
    // в противном случае удаляет элемент и возвращает true
    // ВАЖНО! при удалении элемента дерево не должно потерять свойства бинарного дерева поиска
    public boolean remove(E element) {
        if (root != null && element != null) {
            Node<E> treeNode = root.findNode(element);
            if (treeNode == null) {
                return false;
            }
            if (treeNode.getLeftChild() == null && treeNode.getRightChild() == null) {
                replaceNode(treeNode, null);
            } else if (treeNode.getLeftChild() != null && treeNode.getRightChild() == null) {
                replaceNode(treeNode, treeNode.getLeftChild());
            } else if (treeNode.getLeftChild() == null && treeNode.getRightChild() != null) {
                replaceNode(treeNode, treeNode.getRightChild());
            } else {
                Node<E> tempNode = treeNode.getRightChild();
                while (tempNode.getLeftChild() != null) {
                    tempNode = tempNode.getLeftChild();
                }
                treeNode.setElement(tempNode.getElement());
                replaceNode(tempNode, tempNode.getRightChild());
            }
            return true;
        }
        return false;
    }

    private void replaceNode(Node<E> treeNode, Node<E> newNode) {
        Node<E> parentNode = treeNode.getParent();
        if (parentNode.getLeftChild() != null && parentNode.getLeftChild().equals(treeNode)) {
            parentNode.setLeftChild(newNode);
            if (newNode != null) {
                parentNode.getLeftChild().setParent(parentNode);
            }
        } else if (parentNode.getRightChild() != null && parentNode.getRightChild().equals(treeNode)) {
            parentNode.setRightChild(newNode);
            if (newNode != null) {
                parentNode.getRightChild().setParent(parentNode);
            }
        }
    }

    // распечатывает дерево, так чтобы было видно его древовидную структуру, см. ниже пример
    public void print() {
        if (root != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.printLeft());
            sb.append(root.getElement()).append(LINESEPARATOR);
            sb.append(root.printRight());
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }

}