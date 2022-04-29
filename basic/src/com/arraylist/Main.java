package com.arraylist;

import java.util.ArrayList;

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

    // Sort function

    public ArrayList<Integer> sortArrayList() {
        int temp;

        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = data.size() - 1; j > i; j--) {
                if (data.get(j-1) > data.get(j)) {
                    temp = data.get(j);
                    
                    // data.get(j) = data.get(j-1);
                    // data.get(j-1) = temp;

                    data.get(j).equals(data.get(j-1));
                    data.get(j-1).equals(temp);
                }
            }
        }

        return data;
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(14);
        arrlist.add(7);
        arrlist.add(39);
        arrlist.add(40);

        Statistika data = new Statistika(arrlist);

        System.out.println("Get Minimize\t : " + data.getMin());
        System.out.println("Get Maximize\t : " + data.getMax());
        System.out.println("Get Average\t : " + data.getAverage());
        System.out.println("Sort Arraylist\t : " + data.sortArrayList());
    }
}
