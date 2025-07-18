import java.util.Scanner;
public class DoubleLinkedList {

    public static void main(String[] args) {
        class Node {
        public Node prev;
        public int value;
        public Node next;
        public Node(int value)
        {
            this.value=value;
        }
    
}
        class lists {
        public Node head;
        public int size=0;
        public void printelements()
        {
            Node ptr=head;
            System.out.print("[");
            while(ptr!=null)
            {
                if(ptr.next!=null)
                {
                    System.out.print(ptr.value+", ");
                    
                }
                else
                {
                    System.out.print(ptr.value);
                }
                ptr=ptr.next;
            }
            System.out.println("]");
        }
        public void printbool(boolean t)
        {
            if(t)
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }
        }
         public void psub(int ind1,int ind2,Node ptr1)
        {
            System.out.print("[");
           for(int j=ind1;j<=ind2;j++)
            {
                if(j==ind2)
                {
                    System.out.print(ptr1.value);
                }
                else
                {
                    System.out.print(ptr1.value+", ");
                    ptr1=ptr1.next;
                }
            }
           System.out.println("]");
           
        }
        public void printerror()
        {
            System.out.println("Error");
        }
        public void addtoindex(int index,int x)
        {
            if(index>size||index<0)
            {
                printerror();
            }
            else
            {
                size++;
            Node neew=new Node(x);
            if(index==0)
            {
                neew.next=head;
                neew.prev=null;
                head=neew;
            }
            else
            {
                int counter;
                Node ptr=head;
                ptr.prev=null;
                for(counter=0;counter<index-1;counter++)
                {
                    ptr.prev=ptr;
                    ptr=ptr.next;
                }
                neew.prev=ptr;
                neew.next=ptr.next;
                ptr.next=neew;
            } 
            printelements();
            }
        }
        public void isempty()
        {
            printbool(head==null);
        }
        public void add(int x)
        {
            Node neew=new Node(x);
            size++;
            if(head==null)
            {
                
                
                neew.next=head;
                neew.prev=null;
                head=neew;
            }
            else
            {
               Node ptr=head;
               while(ptr.next!=null)
               {
                    ptr.prev=ptr;
                    ptr=ptr.next;
               }
               neew.prev=ptr;
               neew.next=ptr.next;
               ptr.next=neew;  
            }
        }
        public void remove(int index)
        {
            if(index>(size-1)||index<0)
            {
                printerror();
            }
            else
            {
                if(0==index)
            {
                head=head.next;
                size--;
            }
            else
            {
             Node ptr2;
            Node ptr1=head;
            int counter;
            for(counter=0;counter<index-1;counter++)
            {
                ptr1=ptr1.next;
            }
            ptr2=ptr1.next;
            ptr1.next=ptr2.next;
            size--;
            }
                 printelements();
        }
            
            }
        public void contains(int value)
        {
            Node ptr=head;
            boolean f= false;
            while(ptr!=null)
            {
                if(ptr.value==value)
                {
                    f=true;
                    break;
                }
                else
                {
                    ptr=ptr.next;
                }
                    
            }
            printbool(f);
        }
        public void clear()
        {
            head=null;
            size=0;
            printelements();
        }
        public void Size()
        {
            System.out.println(size);
        }
        public void set(int index,int value)
        {
           if(index>(size-1)||index<0)
           {
               printerror();
           }
           else
           {
                Node ptr=head;
            int counter;
            for(counter=0;counter!=index;counter++)
                ptr=ptr.next;
            ptr.value=value;
            printelements();
           }
        }
        public void get(int index)
        {
           if(index>(size-1)||index<0)
           {
               printerror();
           }
           else
             {
                 Node ptr=head;
                 int counter;
                 for(counter=0;counter!=index;counter++)
                       ptr=ptr.next;
                 System.out.println(ptr.value);
             }
            
        }
        public void sublist(int index1,int index2)
        {
            if((index1>index2)||(index1>size-1)||(index2>size-1)||(index1<0)||(index2<0))
            {
                printerror();
            }
            else
            {
                Node ptr=head;
                int counter;
                for(counter=0;counter<index1;counter++)
                      ptr=ptr.next;
                psub(counter,index2,ptr);
            }
           
        }
}
         Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i=0,sum=0;
        lists n1=new lists();
        while(input.charAt(i)!=']')
        {
            
            if((input.charAt(i)!='[')&&(input.charAt(i)!=',')&&(input.charAt(i)!=' '))
            {
                int x=(int)input.charAt(i);
                x=x-48;
                sum=sum*10+x;
            }
            if((input.charAt(i)==',')||(input.charAt(i+1)==']')&&(input.charAt(i)!='['))
                 {
                      n1.add(sum);
                      sum=0;
                  }
            
            i++;
        }
        String operation=scanner.next();
        switch(operation)
        {
            case "add":
                n1.add(scanner.nextInt());
                n1.printelements();
                break;
            case "addToIndex":
                int x2,y2;
                y2=scanner.nextInt();
                x2=scanner.nextInt();
                n1.addtoindex(y2,x2);
                break;
            case "remove":
                n1.remove(scanner.nextInt());
                break;
            case "isEmpty":
                n1.isempty();
                break;
            case "clear":
                n1.clear();
                break;
            case "get":
                n1.get(scanner.nextInt());
                break;
            case "set":
                int x1,y1;
                y1=scanner.nextInt();
                x1=scanner.nextInt();
                n1.set(y1,x1);
                break;
            case "contains":
                n1.contains(scanner.nextInt());
                break;
            case "sublist":
                int y3,x3;
                y3=scanner.nextInt();
                x3=scanner.nextInt();
                
                n1.sublist(y3, x3);
                break;  
            case "size":
                n1.Size();
                break;
            default:
                n1.printerror();
        } 
        scanner.close();
      }
    }