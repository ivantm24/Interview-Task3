package com.jorsek.usersearch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caseyjordan on 10/13/15.
 */
public class UserZipCodeFinder extends AbstractUserZipCodeFinder {

  /**
   * TODO: Implement this method
   * This method takes the first N chars of the last name as a string to search for,
   * and returns the zip codes that match
   *
   * IE "Smi" (To search for last names starting with Smi, such as Smith, Smie, Smitty)
   * @param nFirstCharsOfLastName
   * @return
   */
  @Override
  public List<String> find(String nFirstCharsOfLastName) {
    List<String> zipCodesToReturn = new ArrayList();

    // TODO

    return zipCodesToReturn;
  }

  /**
   * TODO: Implement this method
   * The datafile is a CSV of Lastname, Zipcode.
   * Use this method to parse the incoming file, and
   * put it into any data structure you need to support the
   * find() method.
   *
   * NOTE: Data my contain duplicate last names and zip codes.
   *
   * @param dataFile
   */
  @Override
  public void loadData(File dataFile) {
    // TODO
  }
}
