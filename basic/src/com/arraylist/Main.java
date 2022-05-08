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

    // modus function
    // source : http://blog-algoritma-programmer.blogspot.com/2016/02/source-code-program-menghitung-modus_18.html

    // public int getModus(){

    //     int HModus=0,i;
    //     int Freks_Modus;
    //     int KandidatModus;
    //     int FrekKandidatModus;
    //     boolean MasihSama;

    //     // pengurutan data

    //     for (int j = 0; j < data.size() - 1; j++) {
    //         for (int j2 = j + 1; j2 < data.size(); j2++) {
    //             if (data.get(j) < data.get(j2)) {
    //                 int temp = data.get(j);
    //                 data.get(j).equals(data.get(j2));
    //                 data.get(j2).equals(temp);
    //             } 
    //         }
    //     }

    //     Freks_Modus = 0;
    //     i = 0;

    //     while(i < data.size()){
    //         KandidatModus = data.get(i);
    //         FrekKandidatModus = 1;
    //         i++;
    //         MasihSama = true;

    //         while(MasihSama && i < data.size()){
    //             if(data.get(i).equals(KandidatModus)){
    //                 FrekKandidatModus = FrekKandidatModus + 1;
    //                 MasihSama = true;
    //             }
    //             else{
    //                 MasihSama = false;
    //             }
    //         }
    //         if(FrekKandidatModus > KandidatModus){
    //             HModus = KandidatModus;
    //             Freks_Modus = FrekKandidatModus;
    //         }
            
    //     }
    //     return HModus; 
    // }

    // source : http://rutinitasinformatika.blogspot.com/2012/12/mencari-modus-pada-java.html

    // public int getModus(){

    //     ArrayList<Integer> frequencyTable = new ArrayList<>(data.size());
        
    //     for (int i = 0; i < data.size(); i++) {
    //         frequencyTable.get(i).equals(0);
    //     }

    //     int[] tampung = {};
    //     for (int i = 0; i < data.size(); i++) {
    //         frequencyTable.get(data.get(i)) = tampung;
    //         tampung++;   
    //     }

    //     int modusValue = 0;

    //     for (int i = 0; i < data.size(); i++){
    //         for (frequencyTable.get(i).compareTo(modusValue)) {
    //             modusValue = i;
    //         }
    //     }
    //     return 1;
    // }

    // another trial 
    
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

        // Stream<Integer> stream;

        for (int i = 0; i < data.size(); i++) {
            if (b.get(i) == m)
                // outputHasil.get(i) = String.valueOf(data.get(i));
                outputHasil.get(i).valueOf(data.get(i));
                // stream = Stream.of(data.get(i));
        }
        //



        ArrayList<String> modus2 = new ArrayList<String>();

        // Arraylist<Integer> getArrayListFromStm = getArrayListFromStream(stream);
        // Menghapus nilai "null" pada array outputHasil

        // modus = Arrays.stream(outputHasil).filter(Objects::nonNull).toArray(String[]::new);

        modus2 = Stream.of(outputHasil).collect(Collectors.toCollection(ArrayList::new));

         
        // modus.equals(Arrays.stream(outputHasil).filter(Objects::nonNull).toArray(String[]::new));

        // modus.equals(ArrayList.getarr);
        // Memberikan "," pada masing-masing angka
        // return String.join(getArrayListFromStm);

        return String.join(", ", modus2);
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
        
        // get Modus

        // System.out.println("Get Modus\t : " + data.getModus());
    }
}
