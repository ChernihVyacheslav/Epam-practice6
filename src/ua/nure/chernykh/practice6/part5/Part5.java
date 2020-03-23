package ua.nure.chernykh.practice6.part5;

public class Part5 {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree();
        Integer[] arr = {3, 1, 2, 0, 5, 6};
        tree.add(arr);
        System.out.println(tree.add(4));
        System.out.println(tree.add(4));
        System.out.println(("~~~~~~~"));
        tree.print();
        System.out.println(("~~~~~~~"));
        System.out.println(tree.remove(5));
        System.out.println(tree.remove(5));
        System.out.println(("~~~~~~~"));
        tree.print();
    }
}
