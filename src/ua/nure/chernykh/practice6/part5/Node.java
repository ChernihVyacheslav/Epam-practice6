package ua.nure.chernykh.practice6.part5;

public class Node<E extends Comparable<E>> {

    private static final String LINESEPARATOR = System.lineSeparator();
    private E element;
    private Node<E> parent;
    private Node<E> leftChild;
    private Node<E> rightChild;

    public Node(E element) {
        this.element = element;
    }

    public String printLeft() {
        return printLeft(1);
    }

    public String printRight() {
        return printRight(1);
    }

    private String printLeft(int depth) {
        if (getLeftChild() != null) {
            StringBuilder sb = new StringBuilder();
            if (leftChild.getLeftChild() != null) {
                sb.append(leftChild.printLeft(depth + 1));
            }
            for (int i = 0; i < depth; i++) {
                sb.append("  ");
            }
            sb.append(leftChild.getElement()).append(LINESEPARATOR);
            if (leftChild.getRightChild() != null) {
                sb.append(leftChild.printRight(depth + 1));
            }
            return sb.toString();
        }
        return "";
    }

    private String printRight(int depth) {
        if (getRightChild() != null) {
            StringBuilder sb = new StringBuilder();
            if (rightChild.getLeftChild() != null) {
                sb.append(rightChild.printLeft(depth + 1));
            }
            for (int i = 0; i < depth; i++) {
                sb.append("  ");
            }
            sb.append(rightChild.getElement()).append(LINESEPARATOR);
            if (rightChild.getRightChild() != null) {
                sb.append(rightChild.printRight(depth + 1));
            }
            return sb.toString();
        }
        return "";
    }

    public Node findNode(E el) {
        int comparison = el.compareTo(this.element);
        if (comparison == 0) {
            return this;
        } else if (comparison > 0 && getRightChild() != null) {
            return getRightChild().findNode(el);
        } else if (comparison < 0 && getLeftChild() != null) {
            return getLeftChild().findNode(el);
        }
        return null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }
}