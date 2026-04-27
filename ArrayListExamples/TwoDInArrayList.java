package ArrayListExamples;

import java.util.ArrayList;

public class TwoDInArrayList {
    public static void main(String[] args) {
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // mainList.add(list);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3);
        // list2.add(4);
        // mainList.add(list2);

        // //print ArrayList<ArrayList<Integer>>
        // for (int i = 0; i < mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i); // giving list
        //     for (int j = 0; j < currList.size(); j++) {
        //         System.out.print(currList.get(j) + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println(mainList);

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // added elements in list1, list2, list3
        for (int i = 1; i <= 5; i++) {
            list1.add(i*1); // 1 2 3 4 5
            list2.add(i*2); // 2 4 6 8 10
            list3.add(i*3); // 3 6 9 12 15
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        list2.remove(3);
        list2.remove(2);

        System.out.println(mainList);

        // using for loop print mainlist
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> list = mainList.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}
