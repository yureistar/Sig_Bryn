/*
Dorothy Ng
APCS2 pd10
HW34 -- An Optimized Version of This is Java’s Built-in Sort Mechanism
2016-04-19
 */

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * 	Partition around the pivot.
 * 	Partition within unsorted areas.
 * 	Continue to partition until area of consideration only has one element.
 *
 * 2a. Worst pivot choice and associated runtime: 
 * 	Choosing the left/rightmost element
 * 	O(n^2)
 *
 * 2b. Best pivot choice and associated runtime:
 *	Choosing the middle element
 * 	O(n log n)
 * 
 * 3. Approach to handling duplicate values in array:
 *	Treat them as less than the pivot.
 *****************************************************/

public class QuickSort {

   //--------------v  HELPER METHODS  v--------------
   //swap values at indices x, y in array o
   public static void swap( int x, int y, int[] o ) {
      int tmp = o[x];
      o[x] = o[y];
      o[y] = tmp;
   }

   //print input array 
   public static void printArr( int[] a ) {
      for ( int o : a )
         System.out.print( o + " " );
      System.out.println();
   }

   //shuffle elements of input array
   public static void shuffle( int[] d ) {
      int tmp;
      int swapPos;
      for( int i = 0; i < d.length; i++ ) {
         tmp = d[i];
         swapPos = i + (int)( (d.length - i) * Math.random() );
         swap( i, swapPos, d );
      }
   }

   //return int array of size s, with each element fr range [0,maxVal)
   public static int[] buildArray( int s, int maxVal ) {
      int[] retArr = new int[s];
      for( int i = 0; i < retArr.length; i++ )
         retArr[i] = (int)( maxVal * Math.random() );
      return retArr;
   }
   //--------------^  HELPER METHODS  ^--------------



   /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
   public static void qsort( int[] d ) { 
      partition(d, 0, d.length-1);
   }

   //partition the array around a pivot
   //return pos of pivot
   public static void partition (int[] arr, int left, int right) {
      if ((right - left) <= 0) return;	

      int pvtPos = ((right - left) / 2) + left;
      int pvtVal = arr[pvtPos];
      swap (pvtPos, right, arr);

      int savPos = left;
      for (int i = left; i < right; i++) {
         if (arr[i] < pvtVal) {
            swap (savPos, i, arr);
            savPos++;
         }
      }
      swap (right, savPos, arr);

      partition(arr, left, savPos-1);
      partition(arr, savPos+1, right);
   }


   //main method for testing
   public static void main( String[] args ) {

      //get-it-up-and-running, static test case:
      int [] arr1 = {7,1,5,12,3};
      System.out.println("\narr1 init'd to: " );
      printArr(arr1);

      qsort( arr1 );	
      System.out.println("arr1 after qsort: " );
      printArr(arr1);
      
      // randomly-generated arrays of n distinct vals
      int[] arrN = new int[10];
      for( int i = 0; i < arrN.length; i++ )
         arrN[i] = i;

      System.out.println("\narrN init'd to: " );
      printArr(arrN);

      shuffle(arrN);
      System.out.println("arrN post-shuffle: " );
      printArr(arrN);

      qsort( arrN );
      System.out.println("arrN after sort: " );
      printArr(arrN);
      /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      

      
	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );

	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   }//end main

}//end class QuickSort
