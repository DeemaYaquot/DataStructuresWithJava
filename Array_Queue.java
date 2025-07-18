import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {
  public void enqueue(int item);
  public Object dequeue();
  public boolean isEmpty();
  public int size();
}

public class Solution implements IQueue {
    
    
                  private static final int Capacity = 1000;
                  private int[] queue;
                  private int r;

                  public Solution() {
                      this.queue = new int[Capacity];
                      this.r = -1;
                  }
                  public void ArrayToQueue(int[] arr) {
                        for (int i = arr.length-1; i >= 0; i--) {
                            enqueue(arr[i]);
                        }
                  }
                  public Object dequeue(){
                      if(isEmpty()) {
                          return "Error";
                      }    
                      Object temp = queue[r];
                      r--;
                      return temp;
                  }
                  public void enqueue(int item){
                      if(r<Capacity-1){
                          r++;
                          for (int i = r; i >=1 ; i--) {
                                queue[i]=queue[i-1];
                          }
                          queue[0] = item;
                      }
                      else System.out.println("Error");
                  }
                  public boolean isEmpty(){
                      if (r==-1)
                          return true;
                      return false;
                  }
                  public int size(){
                    return (r+1);
                  }

    public static void main(String[] args) {
                 Scanner scanner = new Scanner(System.in);
                 String sin = scanner.nextLine().replaceAll("\\[|\\]", "");
                 String[] s = sin.split(", ");;
                 int[] arr = new int[s.length];
                 if (s.length == 1 && s[0].isEmpty())
                     arr = new int[]{};
                 else {
                     for(int i = 0; i < s.length; ++i)
                      arr[i] = Integer.parseInt(s[i]);
                 }
                 if (arr.length>1000){
                     System.out.println("Error");
                 }
                 Solution Queue =new Solution();
                 Queue.ArrayToQueue(arr);
                 String operation=scanner.next();
                 int z;
                 Object Z;
                 switch(operation){
                     case  "enqueue":
                         z=scanner.nextInt();
                         Queue.enqueue(z);
                         break;
                     case  "isEmpty":
                         if(Queue.isEmpty())
                             System.out.println("True");
                         else 
                             System.out.println("False");
                         break;
                     case  "size":
                         z=Queue.size();
                         System.out.println(z);
                         break;
                     default:
                         if(operation.equals("dequeue")){}
                         else
                            System.out.println("Error");
                 }
                 if(operation.equals("dequeue")){
                     if(Queue.dequeue().equals("Error")){
                         System.out.println("Error");
                     }
                     else{
                         int x=Queue.size();
                         System.out.print("[");
                         Object [] array = new Object[x];
                         for(int i = 0; i < x; ++i) {
                            array[i] = Queue.dequeue();
                         }
                         for(int i = x-1; i >= 0; --i) {
                         System.out.print(array[i]);
                         if(i != 0)
                            System.out.print(", ");
                         }
                         System.out.print("]");
                     }
                 }
                 if(operation.equals("enqueue")){
                         int x=Queue.size();
                         System.out.print("[");
                         Object [] array = new Object[x];
                         for(int i = 0; i < x; ++i) {
                            array[i] = Queue.dequeue();
                         }
                         for(int i = x-1; i >= 0; --i) {
                         System.out.print(array[i]);
                         if(i != 0)
                            System.out.print(", ");
                         }
                         System.out.print("]");
                 }
                scanner.close();
             }
        
    }