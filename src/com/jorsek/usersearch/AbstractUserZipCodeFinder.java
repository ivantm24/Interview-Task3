package com.jorsek.usersearch;

import java.io.File;
import java.util.List;

/**
 * Created by caseyjordan on 10/13/15.
 */
public abstract class AbstractUserZipCodeFinder {

  public abstract List<String> find(String startOfLastName);

  public abstract void loadData(File dataFile);

  public void runTests() {

    __findWithInstrumentation("");
    __findWithInstrumentation("A");
    __findWithInstrumentation("B");
    __findWithInstrumentation("Ba");
    __findWithInstrumentation("Jo");
    __findWithInstrumentation("Smi");
    __findWithInstrumentation("Bra");
    __findWithInstrumentation("P");
    __findWithInstrumentation("Perkins");
  }

  private void __findWithInstrumentation(String startsWith){
    long startTime = System.nanoTime();
    List startsWithA = find(startsWith);
    long endTime = System.nanoTime();

    long duration = (endTime - startTime)/1000000;
    System.out.println("Searching for names that start with '"+startsWith+"' returned " + startsWithA.size() + " results and took " + duration + "ms");
  }

}
