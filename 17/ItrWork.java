/*Dorothy Ng
APCS2 pd10
HW17 -- Iteratorator
2016-03-21
*/
/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork {

    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) { 
	for (Integer item:L){
	    if (item.equals(key)) return true;
	}
	return false;
    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) { 
	Iterator<Integer> list = L.iterator();
	while (list.hasNext()){
	    if (list.next().equals(key)) return true;
	}
	return false;
    }

    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) {
	List<Integer> odd = new ArrayList<Integer>();
	for (Integer item:L){
	    if (item%2==1) odd.add(item);
	}
	return odd;
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) { 
	Iterator<Integer> list = L.iterator();
	List<Integer> odd = new ArrayList<Integer>();
	while (list.hasNext()){
	    Integer num = list.next();
	    if (num%2==1) odd.add(num);
	}
	return odd;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) { 
	Iterator<Integer> list = L.iterator();
	while (list.hasNext()){
	    if ((list.next()%2)==0) list.remove();
	}
    }


    public static void main( String [] args ) {

	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...

	// a) using a FOREACH loop
	for (Integer num:L){
	    System.out.print(num+" ");
	}
	System.out.println();
	// b) explicitly using an iterator
	Iterator<Integer> list = L.iterator();
	while (list.hasNext()){
	    System.out.print(list.next()+" ");
	}
	System.out.println();

	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);

	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);
	/*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class ItrWork
