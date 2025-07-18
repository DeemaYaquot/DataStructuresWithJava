import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
  public Object pop();
  public Object peek();
  public void push(int element);
  public boolean isEmpty();
  public int size();
}

public class Solution implements IStack {
                  private static final int Capacity = 1000;
                  private int[] stack;
                  private int top;

                  public Solution() {
                      this.stack = new int[Capacity];
                      this.top = -1;
                  }
                  public void ArrayToStack(int[] arr) {
                        for (int i = arr.length-1; i >= 0; i--) {
                            push(arr[i]);
                        }
                  }
                  public Object pop(){
                      if(isEmpty()) 
                          return "Error";
                      Object temp = stack[0];
                      for (int i = 0; i < stack.length - 1; i++) {
                      stack[i] = stack[i + 1];
                      }
                      top--;
                      return temp;
                  }
                  public Object peek(){
                      if(isEmpty()) 
                          return "Error";
                      return stack[0];
                  }
                  public void push(int element){
                      if(top<Capacity-1){
                          top++;
                          for (int i = top; i >=1 ; i--) {
                                stack[i]=stack[i-1];
                          }
                          stack[0] = element;
                      }
                      else System.out.println("Error");
                  }
                  public boolean isEmpty(){
                      if (top==-1)
                          return true;
                      return false;
                  }
                  public int size(){
                    return (top+1);
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
                 Solution Stack =new Solution();
                 Stack.ArrayToStack(arr);
                 String operation=scanner.next();
                 int z;
                 Object Z;
                 switch(operation){
                     case  "pop":
                         Z=Stack.pop();
                         break;
                     case  "peek":
                         Z=Stack.peek();
                         System.out.println(Z);
                         break;
                     case  "push":
                         z=scanner.nextInt();
                         Stack.push(z);
                         break;
                     case  "isEmpty":
                         if(Stack.isEmpty())
                             System.out.println("True");
                         else 
                             System.out.println("False");
                         break;
                     case  "size":
                         z=Stack.size();
                         System.out.println(z);
                         break;
                     default:
                         System.out.println("Error");
                 }
                 if(operation.equals("push")||operation.equals("pop")){
                     System.out.print("[");
                     int x=Stack.size();
                     for(int i = 0; i < x; ++i) {
                       System.out.print(Stack.pop());
                         if(i != x-1)
                           System.out.print(", ");
                     }
                     System.out.print("]");
                 }
                scanner.close();
             }
}