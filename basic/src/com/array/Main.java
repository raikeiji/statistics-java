package com.array;

import java.util.Arrays;

class Statistics {

    int[] data = {};

    Statistics() {
        this.data = null;

    }

    public Statistics(int[] data) {
        this.data = data;
    }

    public int getMin() {
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (min > data[i]) {
                min = data[i];
            }
        }
        return min;
    }

    public int getMax() {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (max < data[i]) {
                max = data[i];
            }
        }
        return max;
    }

    public int getAverage() {
        // if (data == null) return null;

        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        // the bad thing is average value has to be Integer

        int average = sum / data.length;
        return average;
    }

    // Sort function

    public int[] sortArray() {
        int temp;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[j - 1] > data[j]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }

        return data;
    }

    public int[] sortArray2() {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                int tmp = 0;
                if (data[i] > data[j]) {
                    tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
        return data;
    }

    // median function

    public double getMedian(){
        double median;
        int[] sortedValue = sortArray();

        if (sortedValue.length % 2 == 1) {
            median = sortedValue[data.length / 2];
        }else{
            median = ((double) (sortedValue[sortedValue.length / 2] + sortedValue[(sortedValue.length / 2) - 1])) / 2;
        }
        return median;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] data = { 4, 5, 2, 6, 7 };

        Statistics stat = new Statistics(data);

        System.out.println("Count the data\t\t : " + data.length);
        System.out.println("Mini value\t\t : " + stat.getMin());
        System.out.println("Maxi value\t\t : " + stat.getMax());
        System.out.println("Average value\t\t : " + stat.getAverage()); // Integer Value

        System.out.println("sort data\t\t : " + Arrays.toString(stat.sortArray()));

        System.out.println("sort data version 2 \t\t : " + Arrays.toString(stat.sortArray2()));

        System.out.println("Median\t\t : "+ stat.getMedian());
    }
}
