package com.core;

class Statistics{

    int[] data = {};

    Statistics(){
        this.data = null;
    }

    public Statistics(int[] data){
        this.data = data;
    }

    public int getMin(){
        int min = data[0];
        for (int i = 1; i<data.length; i++){
            if (min > data[i]){
                min = data[i];
            }
        }
        return min;
    }

    public int getMax(){
        int min = data[0];
        for (int i = 1; i<data.length; i++){
            if (min < data[i]){
                min = data[i];
            }
        }
        return min;
    }

    public int getAverage(){
        // if (data == null) return null;
        
        int sum = 0;	
        for (int i = 0; i<data.length; i++){
            sum += data[0];
        }

        // the bad thing is average value has to be Integer
        
        int average = sum/data.length;
        return average;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] data = {4,5,2,6,7};

        Statistics stat = new Statistics(data);

        System.out.println("Count the data\t\t : " + data.length);
        System.out.println("Mini value\t\t : " + stat.getMin()); 
        System.out.println("Maxi value\t\t : " + stat.getMax()); 
        System.out.println("Average value\t\t : "+stat.getAverage()); // Integer Value
    }
}
