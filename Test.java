import java.util.*;

/**
 * Some tests to make sure the code is working properly.
 * 
 * @author Gabriel Razzouk
 * @version 1
 */
public class Test
{
    SinglyLinkedList<String> emptyList;
    SinglyLinkedList<String> nonEmptyList;
    ArrayList<String> list;
    ListIterator<String> li;
    ListIterator<String> li2;
    public Test(){
        list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        emptyList = new SinglyLinkedList<String>();
        nonEmptyList = new SinglyLinkedList<String>(list);
        nonEmptyList.add("e");
        li = nonEmptyList.listIterator(nonEmptyList.size());
        li.add("b.5");
        while (li.hasPrevious()){
            System.out.println(li.previous());
        }
        while (li.hasNext()){
            System.out.println(li.next());
        }
        li.add("f");
        li.add("g");
        while (li.hasPrevious()){
            System.out.println(li.previous());
        }
        li.add("1");
        li.add("2");
        li.add("3");
        while (li.hasPrevious()){
            System.out.println(li.previous());
        }
                while (li.hasNext()){
            System.out.println(li.next());
        }
                while (li.hasPrevious()){
            System.out.println(li.previous());
        }
        li2 = emptyList.listIterator(0);
        li2.add("3");
        li2.add("2");
        li2.add("1");
        ListIterator li3 = emptyList.listIterator(3);
        while (li3.hasPrevious()){
            System.out.println(li3.previous());
        }
    }
}
