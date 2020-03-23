package ua.nure.chernykh.practice6.part3;

import java.util.ArrayList;

public class Parking {

    private ArrayList<Boolean> parkingSlots;

    public Parking(int amountOfParkingPlaces) {
        parkingSlots = new ArrayList<>();
        for (int i = 0; i < amountOfParkingPlaces; i++) {
            parkingSlots.add(false);
        }
    }

    public boolean arrive(int k) {
        if (k < 0 || k >= parkingSlots.size()) {
            throw new IllegalArgumentException();
        } else if (parkingSlots.contains(false)) {
            if (!parkingSlots.get(k)) {
                parkingSlots.set(k, true);
                return true;
            } else {
                if (k + 1 < parkingSlots.size()) {
                    return arrive(k + 1);
                } else {
                    return arrive(0);
                }
            }
        }
        return false;
    }

    public boolean depart(int k) {
        if (k < 0 || k >= parkingSlots.size()) {
            throw new IllegalArgumentException();
        } else {
            if (parkingSlots.get(k)) {
                parkingSlots.set(k, false);
                return true;
            }
        }
        return false;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (boolean b : parkingSlots) {
            if (b) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        System.out.println(sb);
    }
}
