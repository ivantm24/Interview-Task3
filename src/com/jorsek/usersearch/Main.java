package com.jorsek.usersearch;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        File file = new File("dataFile.csv");

        /* NO NEED TO MODIFY ANYTHING PAST HERE */
        AbstractUserZipCodeFinder zipCodeFinder = new UserZipCodeFinder();
        zipCodeFinder.loadData(file);
        zipCodeFinder.runTests();

    }

}
