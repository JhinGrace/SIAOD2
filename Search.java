import java.util.*;

public class Search {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Input array size: ");
        int n=in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i<n;i++) {
            arr.add((int) Math.round((Math.random()*2000)-1000));
        }
        Collections.sort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
        String s = in.nextLine();
        while (true) {
            System.out.println("\r\nWhat to do: \r\n1)Add new element\r\n2)Search for element\r\n3)Delete element\r\n4)Show array");
            s = in.nextLine();
            switch (s) {
                case "Add":
                    System.out.print("Enter a number:");
                    int n1 = in.nextInt();
                    Add(n1, arr);
                    s = in.nextLine();
                    break;
                case "Search":
                    System.out.print("Enter a number to search for:");
                    n = in.nextInt();
                    ArrayList<Integer> decoy = arr;
                    long start = System.currentTimeMillis();
                    System.out.println(Search(n,arr));
                    long finish = System.currentTimeMillis();
                    long time = finish-start;
                    System.out.println("Fibonacci search time: " + time);
                    start = System.currentTimeMillis();
                    decoy.indexOf(n);
                    finish = System.currentTimeMillis();
                    time = finish-start;
                    System.out.println("Standard search time: " + time);
                    s = in.nextLine();
                    break;
                case "Delete":
                    System.out.print("Enter a position to delete number from:");
                    n = in.nextInt();
                    Delete(n, arr);
                    s = in.nextLine();
                    break;
                case "Show":
                    for(int i : arr){
                    System.out.print(i+" ");
                }
                    break;
                default:
                    System.out.print("Unrecognized command.");
                    break;
            }
        }
    }
    public static String Search(int num,ArrayList arr) {
        int fib1=0,fib2=1,tmp;boolean gotcha=false;
        while (true) {
        while(num>(int)arr.get(fib2)) {
            tmp=fib2; fib2+=fib1; fib1=tmp;
            if (fib2>arr.size()) fib2=arr.size()-1;
        }
        for (int i=fib1;i<=fib2;i++) {
            if ((int)arr.get(i)==num)  {
                return("The number you searched for is at the position " + (i+1));
            }
        }
          return("There is no such number.");
        }
    }
    public static void Add(int num, ArrayList arr) {
    arr.add(num);
    Collections.sort(arr);
    }
    public static void Delete(int pos, ArrayList arr) {
    arr.remove(pos-1);
    Collections.sort(arr);
    }
}
