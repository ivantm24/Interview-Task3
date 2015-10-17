package com.jorsek.usersearch;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by caseyjordan on 10/13/15.
 */
public class UserZipCodeFinder extends AbstractUserZipCodeFinder {

    Node root=null;

    /**
     * This method takes the first N chars of the last name as a string to search for,
     * and returns the zip codes that match
     *
     * IE "Smi" (To search for last names starting with Smi, such as Smith, Smie, Smitty)
     * @param nFirstCharsOfLastName
     * @return
     */
    @Override
    public List<String> find(String nFirstCharsOfLastName) {
        if (root!=null){
           return root.find(nFirstCharsOfLastName);
        }
        return  new ArrayList<>();
    }

    /**
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
        List<String> lines, lastNames,zipCodes;
        int maxLastNameLen=0;
        String [] tmp;

        lastNames=new ArrayList<>();
        zipCodes=new ArrayList<>();

        try {
            lines= Files.readAllLines(dataFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Collections.sort(lines);

        for (String line:lines) {
            tmp=line.split(",");
            if (tmp.length<2 || Objects.equals(tmp[0], "") || Objects.equals(tmp[1],"")) {
                continue;
            }
            lastNames.add(tmp[0]);
            if (tmp[0].length()>maxLastNameLen){
                maxLastNameLen=tmp[0].length();
            }
            zipCodes.add(tmp[1]);
        }
        if (lastNames.size()<=0) return;

        root=new Node(zipCodes,lastNames);

    }
}
