package ua.nure.chernykh.practice6.part3;

public class Part3 {

    public static void main(String[] args) {
        Parking parking = new Parking(4);
        parking.print();
        System.out.println(parking.arrive(2));
        parking.print();
        System.out.println(parking.arrive(3));
        parking.print();
        System.out.println(parking.arrive(2));
        parking.print();
        System.out.println(parking.arrive(2));
        parking.print();
        System.out.println(parking.arrive(2));
        parking.print();
        System.out.println(parking.depart(1));
        parking.print();
        System.out.println(parking.depart(1));
        parking.print();
    }
}
