/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package polynomialsolver;

/**
 *
 * @author Safi
 */
import java.util.*;
public class Polynomialsolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         class Node {
        public int value;
        public Node next;
        public Node(int value)
        {
            this.value=value;
        }
        
    }
         class Nodes{
            public int cof;
            public int exp;
            public Nodes pointer;
            public Nodes(int cof,int exp)
            {
                this.cof=cof;
                this.exp=exp;
            }
        }
     class HEAD{
         Node head;
         Nodes Head;
         Node head_a;
         Node head_b;
         Node head_c;
         Node result;
         int size=0;
         int size_a;
         int size_b;
         int size_c;
         int size_r;
         boolean f=false;
         public void Break(String input,String y){
             int i=0,sum=0;
             while(input.charAt(i)!=']')
                {

                    if((input.charAt(i)!='[')&&(input.charAt(i)!=',')&&(input.charAt(i)!=' '))
                         {
                            int x=(int)input.charAt(i);
                            x=x-48;
                            if(x==-3)
                            {
                                f=true;
                            }
                            else
                            {
                                sum=sum*10+x;
                            }
                         }
                    if((input.charAt(i)==',')||(input.charAt(i+1)==']')&&(input.charAt(i)!='['))
                         {
                            if(f)
                            {
                                set(-1*sum);
                                f=false;
                            }
                            else
                            {
                                set(sum);
                            }
                            size++;
                            sum=0;
                         }
                          i++;
                }
            Selection(y);
            Dimension(y,size);
         }
         public void set(int x)
        {
            if(head==null)
            {
                Node neew=new Node(x);
                neew.next=head;
                head=neew;
            }
            else
            {
               Node neew=new Node(x);
               Node ptr=head;
               while(ptr.next!=null)
                   ptr=ptr.next;
               neew.next=ptr.next;
               ptr.next=neew;  
            }
            
        }
         public void setmult(int cof,int exp)
        {
            if(Head==null)
            {
                Nodes order=new Nodes(cof,exp);
                order.pointer=Head;
                Head=order;
            }
            else
            {
                boolean check=true;
                Nodes ptr=Head;
                Nodes helper=Head;
                do
                {
                    if(ptr.exp==exp)
                    {
                        ptr.cof=ptr.cof+cof;
                        check=false;
                        break;
                    }
                    helper=ptr;
                    ptr=ptr.pointer;
                }while(ptr!=null);
                if(check)
                {
                    Nodes order=new Nodes(cof,exp);
                    order.pointer=helper.pointer;
                    helper.pointer=order;
                }
            }
}
         public boolean mult(String x,String y)
        {
            Node ptr1,ptr2;
            int counter1=(dimension(x));
            int counter2=(dimension(y));
            if(counter1==0||counter2==0)
            {
                return true;
            }
            if(counter1>=counter2)
            {
                 ptr1=selection(x);
                 ptr2=selection(y);
            }
            else
            {
                int temp=counter2;
                counter2=counter1;
                counter1=temp;
                 ptr1=selection(y);
                 ptr2=selection(x);
            }
            Node pot=ptr2;
            //Dimension("R",(counter1+counter2-1));
            for(int i=counter1-1;i>=0;i--)
            {
                for(int j=counter2-1;j>=0;j--)
                {
                    int cof=((ptr1.value)*(ptr2.value));
                    int exp=i+j;
                    setmult(cof,exp);
                    ptr2=ptr2.next;
                }
                ptr1=ptr1.next;
                ptr2=pot;
            }
            print();
            return false;
        }
         public int dimension(String x)
         {
             switch(x)
             {
                 case "A":
                     return size_a;
                 case "B":
                     return size_b;
                 case "C":
                     return size_c;
                 case "R":
                     return size_r;
                 default:
                     return 0;
             }
         }
         public void Dimension(String x,int s)
         {
             switch(x)
             {
                 case "A":
                     size_a=s;
                     size=0;
                     break;
                 case "B":
                     size_b=s;
                     size=0;
                     break;
                 case "C":
                     size_c=s;
                     size=0;
                     break;
                 case "R":
                     size_r=s;
                     break;
                 default:
                     break;
             }
         }
         public Node selection(String selector)
         {
             switch(selector)
             {
                 case "A":
                  return head_a;
                 case "B":
                  return head_b;
                 case "C":
                  return head_c;
                  case "R":
                  return result;
                 default:
                     printerror();
                     return null;
             }
         }
         public void Selection(String selector)
         {
             switch(selector)
             {
                 case "A":
                  head_a=head;
                  head=null;
                  break;
                 case "B":
                  head_b=head;
                  head=null;
                  break;
                 case "C":
                  head_c=head;
                  head=null;
                  break;
                 case "R":
                     result=head;
                     head=null;
                     break;
                 default:
                     printerror();
                    break;
             }
         }
         public void print()
         {
             Nodes ptr=Head;
             boolean start=true;
             while(ptr!=null)
             {
                 if(start)
                 {
                     
                     if(ptr.cof==1)
                     { 
                         if(ptr.exp!=1&&ptr.exp!=0)
                         {
                             System.out.print("x^"+ptr.exp);
                         }
                         else if(ptr.exp==1)
                         {
                             System.out.print("x");
                         }
                         else
{
                             System.out.print(ptr.cof);
                         }
                     }
                     else if(ptr.cof!=1&&ptr.cof!=0)
                     {
                         if(ptr.exp==1)
                         {
                             System.out.print(ptr.cof+"x");
                         }
                         else if(ptr.exp!=0)
                         {
                             System.out.print(ptr.cof+"x^"+ptr.exp);
                         }
                         else
                         {
                             System.out.print(ptr.cof);
                         }
                     }
                     start=false;
                 }
                 else
                 {
                    if(ptr.cof==1)
                    {
                        if(ptr.exp!=1&&ptr.exp!=0)
                         {
                             System.out.print("x^"+ptr.exp);
                         }
                        else if(ptr.exp==1)
                         {
                             System.out.print("+x");
                         }
                        else
                        {
                            System.out.print("+"+ptr.cof);
                        }
                    }
                    else if(ptr.cof>0)
                    {
                        if(ptr.exp!=1&&ptr.exp!=0)
                         {
                             System.out.print("+"+ptr.cof+"x^"+ptr.exp);
                         }
                        else if(ptr.exp==1)
                         {
                             System.out.print("+"+ptr.cof+"x");
                         }
                        else
                        {
                            System.out.print("+"+ptr.cof);
                        }
                    }
                    else if(ptr.cof<0)
                    {
                        if(ptr.exp!=1&&ptr.exp!=0)
                         {
                             System.out.print(ptr.cof+"x^"+ptr.exp);
                         }
                        else if(ptr.exp==1)
                         {
                             System.out.print(ptr.cof+"x");
                         }
                        else
                        {
                            System.out.print(ptr.cof);
                        }
                    }
                 }
                 ptr=ptr.pointer;
             }
             System.out.print("\n");
         }
       /*  public void print(Node pot)
         {
             Node ptr=pot;
             boolean starts=true;
             int dimen=dimension("R");
             
         }*/
         public void print(String selector)
         {
             boolean starts=true;
             int dimen=dimension(selector);
             Node ptr=selection(selector);
            /* while(ptr!=null)
             {
                 if(starts)
                 {
                     if(ptr.value==1)
                     {
                         
                     }
                     else if(ptr.value==0)
                     {
                         
                     }
                     else
                     {
                         
                     }
                 }*/
            if(dimen==0)
            {
                clear(selector);
                
            }
            else
            {
                for(dimen=dimen-1;dimen>=0;dimen--)
            {
                if(starts)
                 {
                     if(ptr.value==1)
                     {
                         if(dimen==1)
                         {
                             System.out.print("x");
                             starts=false;
                         }
                         else if(dimen==0)
                         {
                             System.out.print(ptr.value);
                             starts=false;
                         }
                         else
                         {
                             System.out.print("x^"+dimen);
                             starts=false;
                         }
                     }
                     else if(ptr.value==0)
                     {
                         System.out.print(ptr.value);
                         starts=false;
                     }
                     else
                     {
                         if(dimen==1)
                         {
                             System.out.print(ptr.value+"x");
                             starts=false;
                         }
                         else if(dimen==0)
                         {
                             System.out.print(ptr.value);
                             starts=false;
                         }
                         else
                         {
                             System.out.print(ptr.value+"x^"+dimen);
                             starts=false;
                         }
                     }
                  }
                else
                {
                    if(ptr.value==1)
                     {
                         if(dimen==1)
                         {
                             System.out.print("+x");
                         }
                         else if(dimen==0)
                         {
                             System.out.print("+"+ptr.value);
                         }
                         else
                         {
                             System.out.print("+x^"+dimen);
                         }
                     }
                     else if(ptr.value==0)
                     {
                        
                     }
                     else
                     {
                         if(dimen==1)
                         {
                             if(ptr.value<0)
                             {
                                 System.out.print(ptr.value+"x");
                             }
                             else
                             {
                                 System.out.print("+"+ptr.value+"x");
                             }
                             
                         }
                         else if(dimen==0)
                         {
                              if(ptr.value<0)
                             {
                                 System.out.print(ptr.value);
                             }
                             else
                             {
                                 System.out.print("+"+ptr.value);
                             }
                         }
                         else
                         {
                             if(ptr.value<0)
                             {
                                 System.out.print(ptr.value+"x^"+dimen);
                             }
                             else
                             {
                                 System.out.print("+"+ptr.value+"x^"+dimen);
                             }
                             
                         }
                     }
                }
                 ptr=ptr.next;
         }
            System.out.print("\n");
            }
         }
         public void printerror()
         {
             System.out.println("Error");
         }
         public boolean clear(String selector)
         {
             if(dimension(selector)==0)
             {
                 return true;
             }
             switch(selector)
             {
                 case "A":
                     head_a=null;
                     size_a=0;
                     break;
                 case "B":
                     head_b=null;
                     size_b=0;
                     break;
                case "C":
                     head_c=null;
                     size_c=0;
                     break;
                 default:
                     printerror();
                     break;
             }
            System.out.println("[]");
            return false;
         }
         public boolean add(String x,String y)
         {
             if(dimension(x)==0||dimension(y)==0)
             {
                 return true;
             }
             int counter=0;
             Node ptr1=selection(x);
             Node ptr2=selection(y);
             int dim1=dimension(x)-1;
             int dim2=dimension(y)-1;
             while(ptr1!=null||ptr2!=null)
             {
                 if(ptr1==null)
                 {
                     set(ptr2.value);
                     dim2--;
                     counter++;
                     ptr2=ptr2.next;
                 }
                 else if(ptr2==null)
                 {
                     set(ptr1.value);
                     dim1--;
                     counter++;
                     ptr1=ptr1.next;
                 }
                 else
                 {
                     if(dim1==dim2)
                     {
                         set(ptr1.value+ptr2.value);
                         dim1--;
                         dim2--;
                         counter++;
                         ptr1=ptr1.next;
                         ptr2=ptr2.next;
                     }
                     else if(dim1>dim2)
                     {
                         set(ptr1.value);
                         dim1--;
                         ptr1=ptr1.next;
                         counter++;
                     }
                     else
                     {
                         set(ptr2.value);
                         dim2--;
                         ptr2=ptr2.next;
                         counter++;
                     }
                 }
                 
             }
             Selection("R");
             Dimension("R",counter);
             print("R"); 
             return false;
         }
        public boolean sub(String x,String y)
         {
             int counter=0;
             Node ptr1=selection(x);
             Node ptr2=selection(y);
             if(dimension(x)==0||dimension(y)==0)
             {
                 return true;
             }
             int dim1=dimension(x)-1;
             int dim2=dimension(y)-1;
             while(ptr1!=null||ptr2!=null)
             {
                 if(ptr1==null)
                 {
                     set(-1*(ptr2.value));
                     dim2--;
                     counter++;
                     ptr2=ptr2.next;
                 }
                 else if(ptr2==null)
                 {
                     set(ptr1.value);
                     dim1--;
                     counter++;
                     ptr1=ptr1.next;
                 }
                 else
                 {
                     if(dim1==dim2)
                     {
                         set(ptr1.value-ptr2.value);
                         dim1--;
                         dim2--;
                         counter++;
                         ptr1=ptr1.next;
                         ptr2=ptr2.next;
                     }
                     else if(dim1>dim2)
                     {
                         set(ptr1.value);
                         dim1--;
                         ptr1=ptr1.next;
                         counter++;
                     }
                     else
                     {
                         set(-1*(ptr2.value));
                         dim2--;
                         ptr2=ptr2.next;
                         counter++;
                     }
                 }
                 
             }
             Selection("R");
             Dimension("R",counter);
             print("R");
             return false;
         }
        public boolean eval(String selector,int m)
        {
            int rs=dimension(selector);
            if(rs==0)
            {
                return true;
            }
            int counter; 
            int sum=0;
            Node ptr=selection(selector);
            for(counter=rs-1;counter>=1;counter--)
            {
                int k=pow(m,counter);
                sum=sum+(ptr.value*k);
                ptr=ptr.next;
            }
            sum=sum+ptr.value;
            System.out.println(sum);
            return false;
        }
        public int pow(int x,int y)
        {
            int mul=1;
            while(y>0)
            {
                mul=mul*x;
                y--;
            }
            return mul;
        }
     }
     //                Staring of Code
              boolean Flag=false;  
              String input,selector,operation;
              Scanner scanner=new Scanner(System.in);
              operation=scanner.nextLine();
              selector=scanner.nextLine();
              input=scanner.nextLine();
              HEAD n1=new HEAD();
              if(!Flag)
              {
                  if(operation.equals("set"))
                  {
                      n1.Break(input,selector);
                      Flag=true;
                  }
                  else
                  {
                      n1.printerror();
                  }
              }
              
                  try{
                        while(Flag)
                                     {
                                  String p1,p2;
                                  switch(scanner.nextLine())
                                    {
                                  case "print":
                                      p1=scanner.nextLine();
                                      if((p1.equals("A"))||(p1.equals("B"))||((p1.equals("C"))))
                                      {
                                          
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      n1.print(p1);
                                      break;
                                    case "clear":
                                       p1=scanner.nextLine();
                                       if((p1.equals("A"))||(p1.equals("B"))||((p1.equals("C"))))
                                      {
                                          
                                      }
                                       else
                                      {
                                          throw new Exception();
                                      }
                                      boolean T=n1.clear(p1);
                                      if(T)
                                      {
                                          throw new Exception();
                                      }
                                      break;
                                  case "set":
                                       p1=scanner.nextLine();
                                     if((p1.equals("A"))||(p1.equals("B"))||((p1.equals("C"))))
                                      {
                                          
                                      }
                                     else
                                      {
                                          throw new Exception();
                                      }
                                      n1.Break(scanner.nextLine(),p1);
                                      break;
                                  case "add":
                                      p1=scanner.nextLine();
                                      if((p1.equals("A"))||(p1.equals("B"))||((p1.equals("C"))))
                                      {
                                          
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      p2=scanner.nextLine();
                                      if((p2.equals("A"))||(p2.equals("B"))||((p2.equals("C"))))
                                      {
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      boolean h=n1.add(p1,p2);
                                      if(h)
                                      {
                                        throw new Exception();
                                      }
                                      break;
                                  case "sub":
                                      p1=scanner.nextLine();
                                      if((p1.equals("A"))||(p1.equals("B"))||((p1.equals("C"))))
                                      {
                                          
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      p2=scanner.nextLine();
                                      if((p2.equals("A"))||(p2.equals("B"))||(p2.equals("C")))
                                      {
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      boolean w=n1.sub(p1,p2);
                                      if(w)
                                      {
                                        throw new Exception();
                                      }
                                      break;
                                  case "eval":
                                      p1=scanner.nextLine();
                                      if((p1.equals("A"))||(p1.equals("B"))||((p1.equals("C"))))
                                      {
                                          
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      int evaluator=scanner.nextInt();
                                      boolean U=n1.eval(p1, evaluator);
                                      if(U)
                                      {
                                        throw new Exception();
                                      }
                                      break;
                                  case "":
                                      break;
                                  case "mult":
                                      p1=scanner.nextLine();
                                      if((p1.equals("A"))||(p1.equals("B"))||((p1.equals("C"))))
                                      {
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      p2=scanner.nextLine();
                                      if((p2.equals("A"))||(p2.equals("B"))||((p2.equals("C"))))
                                      {
                                          
                                      }
                                      else
                                      {
                                          throw new Exception();
                                      }
                                      boolean x=n1.mult(p1,p2);
                                      if(x)
                                      {
                                        throw new Exception();
                                      }
                                      break;
                                  default:
                                      throw new Exception();
                                  }
              }         
                      }catch(NoSuchElementException x){}
                  catch(Exception e){
                          System.out.print("Error");
                      }
                               
              
                                }
  }
    