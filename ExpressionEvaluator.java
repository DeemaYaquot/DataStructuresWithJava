import java.io.*;
import java.util.*;

class SingleLinkedList {
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
    }

    public void add(int index, Object data) {
        Node New = new Node(data);
        if (head == null && index == 0) {
            head = New;
            tail = New;
        } else if (index < 0 || index > size || (head == null && index != 0)) {
            System.out.println("Error");
            System.exit(0);
        } else if (index == 0 && head != null) {
            New.next = head;
            head = New;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            New.next = current.next;
            current.next = New;
        }
        size++;
    }

    public Object get(int index) {
        if (index < size && index >= 0 && head != null) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        } else {
            System.out.println("Error");
            System.exit(0);
        }
        return 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void remove(int index) {
        Node current = head;
        if (index == 0 && head != null) {
            head = current.next;
        } else if (index < size && head != null && index > 0) {
            Node temp = null;
            for (int i = 0; i < index; i++) {
                temp = current;
                current = current.next;
            }
            temp.next = current.next;
        } else {
            System.out.print("Error");
            System.exit(0);
        }
        size--;
    }

    public int size() {
        return size;
    }
}

interface IStack {
    public Object pop();

    public Object peek();

    public void push(Object element);

    public boolean isEmpty();

    public int size();
}

class Stack implements IStack {
    public static SingleLinkedList Stack = new SingleLinkedList();

    public Object pop() {
        Object temp = Stack.get(0);
        int index = 0;
        Stack.remove(index);

        return temp;
    }

    public Object peek() {
        if (Stack.isEmpty()) {
            System.out.println("Error");
            System.exit(0);
        }
        return Stack.get(0);
    }

    public void push(Object element) {
        int index = 0;
        Stack.add(index, element);
    }

    public boolean isEmpty() {
        return Stack.isEmpty();
    }

    public int size() {
        return Stack.size();
    }
}

interface IExpressionEvaluator {
    public String infixToPostfix(String infix);

    public int evaluate(String postfix);
}

public class ExpressionEvaluator implements IExpressionEvaluator {
    public static Stack St = new Stack();
    public static int a;
    public static int b;
    public static int c;

    public String infixToPostfix(String infix) {
        char value;
        String postfix = "";
        for (int i = 0; i < infix.length(); i++) {
            value = infix.charAt(i);
            if (value == 'a' || value == 'b' || value == 'c') {
                postfix = postfix + value;
            } else if (value == '(') {
                St.push(value);
            } else if (value == ')') {
                while (!(St.isEmpty()) && (char) St.peek() != '(') {
                    postfix = postfix + St.pop();
                }
                St.pop();
            } else {
                while ((!(St.isEmpty())) && ((char) St.peek() != '(') && (prec(value) <= prec((char) St.peek()))) {
                    postfix = postfix + St.pop();
                }
                St.push(value);
            }
        }
        while (!(St.isEmpty())) {
            postfix = postfix + St.pop();
        }
        return postfix;
    }

    public int evaluate(String postfix) {
        Stack val = new Stack();
        char value;
        for (int i = 0; i < postfix.length(); i++) {
            value = postfix.charAt(i);
            if (value == 'a' || value == 'b' || value == 'c') {
                switch (value) {
                    case 'a':
                        val.push(a);
                        break;
                    case 'b':
                        val.push(b);
                        break;
                    case 'c':
                        val.push(c);
                        break;
                }
            } else {
                boolean temp = false;
                if (val.size() == 1) {
                    temp = true;
                }
                int val1 = (int) val.pop();
                int val2 = 0;
                if (temp == false)
                    val2 = (int) val.pop();

                switch (value) {
                    case '+':
                        val.push(val2 + val1);
                        break;
                    case '-':
                        if (temp)
                            val.push((-1 * val1));
                        else
                            val.push(val2 - val1);
                        break;
                    case '/':
                        val.push(val2 / val1);
                        break;
                    case '*':
                        val.push(val2 * val1);
                        break;
                    case '^':
                        double x = Math.pow(val2, val1);
                        val.push((int) x);
                        break;
                }
            }
        }
        return (int) val.pop();
    }

    static int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/')
            return 2;
        if (x == '^')
            return 3;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExpressionEvaluator express = new ExpressionEvaluator();
        Stack brackets = new Stack();
        String expression = input.next();
        String aaa = "input.nextLine()";
        aaa = input.next();
        String bbb = "input.nextLine()";
        bbb = input.next();
        String ccc = "input.nextLine()";
        ccc = input.next();
        String aa = aaa.substring(2);
        String bb = bbb.substring(2);
        String cc = ccc.substring(2);
        a = Integer.parseInt(aa);
        b = Integer.parseInt(bb);
        c = Integer.parseInt(cc);
        if (expression.charAt(0) == '*' || expression.charAt(0) == '/' || expression.charAt(0) == '^') {
            System.out.println("Error");
            System.exit(0);
        }
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '-' && expression.charAt(i + 1) == '-') {
                expression = expression.substring(0, i) + "+" + expression.substring(i + 2);
            }
        }
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '^' && expression.charAt(i + 1) == '+') {
                expression = expression.substring(0, i + 1) + expression.substring(i + 2);
            }
        }
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) != 'a' && expression.charAt(i) != 'b' && expression.charAt(i) != 'c'
                    && expression.charAt(i) != '(' && expression.charAt(i) != ')'
                    && expression.charAt(i + 1) != 'a' && expression.charAt(i + 1) != 'b'
                    && expression.charAt(i + 1) != 'c' && expression.charAt(i + 1) != '('
                    && expression.charAt(i + 1) != ')') {
                System.out.println("Error");
                System.exit(0);
            }
        }
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != 'a' && expression.charAt(i) != 'b' && expression.charAt(i) != 'c'
                    && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*'
                    && expression.charAt(i) != '/' && expression.charAt(i) != '^'
                    && expression.charAt(i) != '(' && expression.charAt(i) != ')') {
                System.out.println("Error");
                System.exit(0);
            }
        }
        char bracket = '(';
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                brackets.push(bracket);
            } else if (expression.charAt(i) == ')') {
                brackets.pop();
            }
        }
        if (!(brackets.isEmpty())) {
            System.out.println("Error");
            System.exit(0);
        }
        if (expression.charAt(0) == '+') {
            expression = expression.substring(1, expression.length());
        }
        if (expression.charAt(expression.length() - 1) != 'a' && expression.charAt(expression.length() - 1) != 'b'
                && expression.charAt(expression.length() - 1) != 'c'
                && expression.charAt(expression.length() - 1) != ')') {
            System.out.println("Error");
            System.exit(0);
        }
        String postfix = express.infixToPostfix(expression);
        int result = express.evaluate(postfix);
        System.out.println(postfix);
        System.out.println(result);
    }
}
