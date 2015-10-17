package com.jorsek.usersearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ivantactukmercado on 10/16/15.
 */
public class Node {
    private HashMap<Character,Node> child;
    private List<String> ZipCodes;

    /**
     * zipCodes and lastNames have to be sorted by last name and their indexes have to match
     * @param zipCodes
     * @param lastNames
     */
    public Node(List<String> zipCodes, List<String> lastNames){
        this.ZipCodes=zipCodes;
        child=new HashMap<>();

        createChilds(0,0,lastNames.size(),lastNames,zipCodes);
    }

    /**
     * Creates a new Node that only contains the subList of ZipCodes that are between listStart and listEnd
     * @param zipCodes
     * @param lastNames
     * @param charIndex
     * @param listStart
     * @param listEnd
     */
    private Node(List<String> zipCodes, List<String> lastNames, int charIndex,int listStart, int listEnd){
        this.ZipCodes=zipCodes.subList(listStart,listEnd);
        child=new HashMap<>();
        createChilds(charIndex,listStart,listEnd,lastNames,zipCodes);
    }

    /**
     * Finds all ZipCodes of all the last names that starts with startsWith
     * @param startsWith
     * @return
     */
    public List<String> find(String startsWith){
        if (startsWith.equals("")) return ZipCodes;
        return find(startsWith,0);
    }

    /**
     * Finds the ZipCodes of all last names that starts with the string startWith
     * and only look for the characters in the string startWith from charIndex until the end of the string startWith.
     * @param startsWith
     * @param charIndex
     * @return
     */
    public List<String> find(String startsWith, int charIndex){
        if (startsWith.length()==charIndex) return ZipCodes;
        if (child.containsKey(startsWith.charAt(charIndex))){

            return child.get(startsWith.charAt(charIndex)).find(startsWith,charIndex+1);
        }
        return new ArrayList<>();
    }

    /**
     * Creates the childs of each node according to their last name
     * @param charIndex
     * @param listStart
     * @param listEnd
     * @param lastNames
     * @param zipCodes
     */
    private void createChilds(int charIndex,int listStart,int listEnd,List<String> lastNames,List<String> zipCodes){
        if (lastNames.get(listStart).length()<=charIndex) return;
        if (listEnd> lastNames.size()) return;
        Character currentChar=lastNames.get(listStart).charAt(charIndex);
        for (int i = listStart; i < listEnd; i++) {
            if (lastNames.get(i).length()<=charIndex || lastNames.get(i).charAt(charIndex)!=currentChar
                    || i==listEnd-1){
                if (i==listEnd-1) i++;
                child.put(currentChar, new Node(zipCodes,lastNames, charIndex+1,listStart,i));
                if(i==listEnd) break;
                currentChar=lastNames.get(i).charAt(charIndex);
                listStart=i;
            }
        }
    }

}
