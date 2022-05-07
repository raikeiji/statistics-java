package com.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.*;
import java.util.*;


class Statistika{

    ArrayList<Integer> data = new ArrayList<Integer>();

    Statistika(){
        this.data = null;
    }

    Statistika(ArrayList<Integer> data){
        this.data = data;
    }

    public int getMin(){
        // int min = data[0];
        // for (int i = 1; i<data.size(); i++){
        //     if (min > data[i]){
        //         min = data[i];
        //     }
        // }
        // return min;

        int min = data.get(0);
        for (int i = 1; i<data.size(); i++){
            if (min > data.get(i)){
                min = data.get(i);
            }
        }
        return min;
      
    }

    public int getMax(){
        int max = data.get(0);
        for (int i = 1; i<data.size(); i++){
            if (max < data.get(i)){
                max = data.get(i);
            }
        }
        return max;
    }

    public int getAverage(){
        int sum = 0;	
        for (int i = 0; i<data.size(); i++){
            sum += data.get(i);
        }

        // the bad thing is average value has to be Integer
        
        int average = sum/data.size();
        return average;
        
    }

    public double getMedian() {
       double median;
       Collections.sort(data);;

        if (data.size() % 2 == 1) {
            // median = sortedValue[data.size() / 2];
            median = data.get(data.size() / 2);
        } else {
            // median = ((double) (sortedValue[sortedValue.length / 2] + sortedValue[(sortedValue.length / 2) - 1])) / 2;
            median = ((double) (data.get(data.size() / 2) + data.get(data.size() / 2) - 1)) / 2;
        }
        return median;
    }


     // Function to get ArrayList from Stream
     public static <T> ArrayList<T>
     getArrayListFromStream(Stream<T> stream)
     {
   
         // Convert the Stream to ArrayList
         ArrayList<T>
             arrayList = stream
                             .collect(Collectors
                             .toCollection(ArrayList::new));
   
         // Return the ArrayList
         return arrayList;
     }

    // modus function

    public String getModus() {
        int c;
        // int[] b = new int[data.size()];

        ArrayList<Integer> b = new ArrayList<Integer>(data.size());

        // Pencarian data untuk menentukan modus
        for (int i = 0; i < data.size(); i++) {
            c = 1;

            if (data.get(i) == -1)
                // b.get(i) = 0;
                b.get(i).valueOf(0);
            else {
                for (int j = i + 1; j < data.size(); j++) {
                    if (data.get(i) == data.get(j)) {
                        c++;
                        // data.get(j) = -1;
                        data.get(j).valueOf(-1);
                    }
                }

                // b.get(i) = c;
                b.get(i).valueOf(c);
            }
        }

        int m = b.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (b.get(i) >= m)
                m = b.get(i);
        }

        // String[] outputHasil = new String[data.size()];

        ArrayList<String> outputHasil = new ArrayList<String>(data.size());

        Stream<String> stream;

        for (int i = 0; i < data.size(); i++) {
            if (b.get(i) == m)
                // outputHasil.get(i) = String.valueOf(data.get(i));
                outputHasil.get(i).valueOf(data.get(i));
                stream = Stream.of(data.get(i));
        }
        //

        

        // ArrayList<String> modus = new ArrayList<String>();

        ArrayList<Integer> getArrayListFromStm = getArrayListFromStream(stream);
        // Menghapus nilai "null" pada array outputHasil

        // modus = Arrays.stream(outputHasil).filter(Objects::nonNull).toArray(String[]::new);

        // modus.equals(Arrays.stream(outputHasil).filter(Objects::nonNull).toArray(String[]::new));

        // modus.equals(ArrayList.getarr);

        // int[] getlistallofit = getArrayListFromStm.stream(outputHasil).filter(Objects::nonNull).toArray(int[]::new);
        String[] getlistallofit = getArrayListFromStm.stream(outputHasil).filter(Objects::nonNull).toArray(int[]::new);
        
        // Memberikan "," pada masing-masing angka
        // return String.join(", ", getlistallofit);

        return getlistallofit;
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(14);
        arrlist.add(7);
        arrlist.add(39);
        arrlist.add(40);
        arrlist.add(45);
        arrlist.add(39);

        Statistika data = new Statistika(arrlist);

        System.out.println("Get Minimize\t : " + data.getMin());
        System.out.println("Get Maximize\t : " + data.getMax());
        System.out.println("Get Average\t : " + data.getAverage());
        
        // sort arraylist by using Collections class 
        Collections.sort(arrlist);
        System.out.println("Sort arraylist\t : " + arrlist);

        // get Median

        System.out.println("Get Median\t : " + data.getMedian());
    }
}
