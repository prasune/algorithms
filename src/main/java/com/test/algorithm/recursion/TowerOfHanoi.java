package com.test.algorithm.recursion;

public class TowerOfHanoi {

    public static void solve(int numOfDiscs, String srcTower, String destTower, String interTower) {
        if (numOfDiscs == 1) {
            System.out.println("Move disc1 from " + srcTower + " to " + destTower);
        } else {
            solve(numOfDiscs-1, srcTower, interTower, destTower);
            System.out.println("Move disc" + numOfDiscs + " from " + srcTower + " to " + destTower);
            solve(numOfDiscs-1, interTower, destTower, srcTower);
        }
    }

    public static void main(String[] args) {
        solve(3, "A", "B", "C");
    }
}
