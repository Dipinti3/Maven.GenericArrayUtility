package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T extends Object> {
    T[] array;
    public ArrayUtility(T[] input) {
        this.array=input;
    }

    public Integer countDuplicatesInMerge(T[] mergeArray, T value) {
        List<T>newList=new ArrayList<T>(Arrays.asList(array));
        int occurrences=0;
        for (T element : mergeArray) {
            newList.add(element);
        }
        for (T element : newList) {
            if(element.equals(value))
                occurrences++;
        }
        return occurrences;
    }

    public T getMostCommonFromMerge(T[] merge) {
        int mostCommonElementOccurrence=0;
        T mostCommonElement=null;
        List<T>newList=new ArrayList<T>(Arrays.asList(merge));
        for (T element : merge) {
            newList.add(element);
        }
        for (T element : newList) {
            int occurrence=getNumberOfOccurrences(element);
            if(mostCommonElementOccurrence<occurrence){
                mostCommonElement=element;
                mostCommonElementOccurrence=occurrence;
            }
        }
        return mostCommonElement;
    }

    public int getNumberOfOccurrences(T value) {
        int occurrence=0;
        List<T>newList=new ArrayList<T>(Arrays.asList(array));
        for (T element : newList) {
            if(element.equals(value))
                occurrence++;
        }
        return occurrence;
    }

    public T[] removeValue(T remove) {
        int occurrences=getNumberOfOccurrences(remove);
        T[] newArray = Arrays.copyOf(array, array.length-occurrences);
        for (int i = 0,j=0; i < array.length; i++) {
            if(array[i]!=remove){
                newArray[j]=array[i];
                j++;
            }
        }
        return newArray;
    }
}
