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

    public int getModus(){

        int HModus=0,i,FrekModus,KandidatModus,FrekKandidatModus;
        boolean MasihSama;

        // pengurutan data

        for (int j = 0; j < data.size() - 1; j++) {
            for (int j2 = j + 1; j2 < data.size(); j2++) {
                if (data.get(j) < data.get(j2)) {
                    int temp = data.get(j);
                    data.get(j).equals(data.get(j2));
                    data.get(j2).equals(temp);
                } 
            }
        }

        FrekModus = 0;
        i = 0;

        while(i < data.size()){
            KandidatModus = data.get(i);
            FrekKandidatModus = 1;
            i++;
            MasihSama = true;

            while(MasihSama && i < data.size()){
                if(data.get(i) == KandidatModus){
                    FrekKandidatModus = FrekKandidatModus + 1;
                    MasihSama = true;
                }
                else{
                    MasihSama = false;
                }
            }
            if(FrekKandidatModus > KandidatModus){
                HModus = KandidatModus;
                FrekModus = FrekKandidatModus;
            }
            
        }
        return HModus; 
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

        System.out.println("Get Modus\t : " );
    }
}
