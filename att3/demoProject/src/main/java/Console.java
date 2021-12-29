import mySet.entry.MyEntryMulti;
import mySet.set.MyHashMultiSet;
import mySet.set.MyHashSet;

import java.util.Scanner;

public class Console {

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean state = true;
        boolean check = true;
        while (state) {
            System.out.println("Select a class: HashSet, HashMultiSet. To terminate the program, enter 'end'.");
            String str1 = sc.nextLine();
            if (str1.equals("HashSet") || str1.equals("hashSet") || str1.equals("hashset")) {
                System.out.println("Select the data type: String, Integer");
                String str2 = sc.nextLine();
                if (str2.equals("end")) {
                    state = false;
                } else if (str2.equals("String") || str2.equals("string")) {
                    check = true;
                    MyHashSet<String> myHashSet = new MyHashSet<>();
                    while (check) {
                        System.out.println("Select an action: add, remove, size, contains, clear");
                        String action = sc.nextLine();
                        switch (action) {
                            case "end": {
                                check = false;
                                break;
                            }
                            case "add": {
                                System.out.println("Enter all values (separated by a space)");
                                String values = sc.nextLine();
                                String[] val = values.split(" ");
                                for (String s : val) {
                                    myHashSet.add(s);
                                }
                                myHashSet.display();
                                System.out.println();
                                break;
                            }
                            case "remove": {
                                System.out.println("Enter an value");
                                String res = sc.nextLine();
                                myHashSet.remove(res);
                                myHashSet.display();
                                System.out.println();
                                break;
                            }
                            case "size": {
                                System.out.println(myHashSet.size());
                                break;
                            }
                            case "contains": {
                                System.out.println("Enter the value to check");
                                String res = sc.nextLine();
                                System.out.println(myHashSet.contains(res));
                                break;
                            }
                            case "clear": {
                                System.out.println("before clear");
                                myHashSet.display();
                                myHashSet.clear();
                                System.out.println();
                                System.out.println("after clear");
                                myHashSet.display();
                                System.out.println();
                                break;
                            }
                        }

                    }
                }
                else if (str2.equals("Integer") || str2.equals("integer")) {
                    check = true;
                    MyHashSet<Integer> myHashSet = new MyHashSet<>();
                    while (check) {
                        System.out.println("Select an action: add, remove, size, contains, clear");
                        String action = sc.nextLine();
                        switch (action) {
                            case "end": {
                                check = false;
                                break;
                            }
                            case "add": {
                                System.out.println("Enter all values (separated by a space)");
                                String values = sc.nextLine();
                                String[] val = values.split(" ");
                                for (int i = 0; i < val.length; i++) {
                                    myHashSet.add(Integer.parseInt(val[i]));
                                }
                                myHashSet.display();
                                System.out.println();
                                break;
                            }
                            case "remove": {
                                System.out.println("Enter an value");
                                String res = sc.nextLine();
                                myHashSet.remove(Integer.parseInt(res));
                                myHashSet.display();
                                System.out.println();
                                break;
                            }
                            case "size": {
                                System.out.println(myHashSet.size());
                                break;
                            }
                            case "contains": {
                                System.out.println("Enter the value to check");
                                String res = sc.nextLine();
                                System.out.println(myHashSet.contains(Integer.parseInt(res)));
                                break;
                            }
                            case "clear": {
                                System.out.println("before clear");
                                myHashSet.display();
                                myHashSet.clear();
                                System.out.println();
                                System.out.println("after clear");
                                myHashSet.display();
                                System.out.println();
                                break;
                            }
                        }

                    }
                }
            } else if (str1.equals("end")) {
                state = false;
                System.exit(0);
            } else if (str1.equals("HashMultiSet") || str1.equals("hashMultiSet") || str1.equals("hashmultiset")) {
                System.out.println("Select the data type: String, Integer");
                String str2 = sc.nextLine();
                if (str2.equals("end")) {
                    state = false;
                } else if (str2.equals("String") || str2.equals("string")) {
                    check = true;
                    MyHashMultiSet<String> myHashMultiSet = new MyHashMultiSet<>();
                    while (check) {
                        System.out.println("Select an action: add, remove, size, contains, clear");
                        String action = sc.nextLine();
                        switch (action) {
                            case "end": {
                                check = false;
                                break;
                            }
                            case "add": {
                                System.out.println("Enter all values (separated by a space)");
                                String values = sc.nextLine();
                                String[] val = values.split(" ");
                                for (String s : val) {
                                    myHashMultiSet.add(s);
                                }
                                for (MyEntryMulti<String> entryMulti : myHashMultiSet.getIteratorByValueAndCount()) {
                                    System.out.println("value:" + entryMulti.getKey() + "-" +
                                            "count: " + entryMulti.getValue() + " ");
                                }
                                break;
                            }
                            case "remove": {
                                System.out.println("Enter an value");
                                String res = sc.nextLine();
                                myHashMultiSet.remove(res);
                                for (MyEntryMulti<String> entryMulti : myHashMultiSet.getIteratorByValueAndCount()) {
                                    System.out.println("value:" + entryMulti.getKey() + "-" +
                                            "count: " + entryMulti.getValue() + " ");
                                }
                                System.out.println();
                                break;
                            }
                            case "size": {
                                System.out.println(myHashMultiSet.size());
                                break;
                            }
                            case "contains": {
                                System.out.println("Enter the value to check");
                                String res = sc.nextLine();
                                System.out.println(myHashMultiSet.contains(res));
                                break;
                            }
                            case "clear": {
                                System.out.println("before clear");
                                for (MyEntryMulti<String> entryMulti : myHashMultiSet.getIteratorByValueAndCount()) {
                                    System.out.println("value:" + entryMulti.getKey() + "-" +
                                            "count: " + entryMulti.getValue() + " ");
                                }
                                myHashMultiSet.clear();
                                System.out.println();
                                System.out.println("after clear");
                                for (MyEntryMulti<String> entryMulti : myHashMultiSet.getIteratorByValueAndCount()) {
                                    System.out.println("value:" + entryMulti.getKey() + "-" +
                                            "count: " + entryMulti.getValue() + " ");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
