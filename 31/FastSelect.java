/*
Dorothy Ng
APCS2 pd10
HW31 -- Fast Selection
2016-04-14
 */

public class FastSelect {

    //swap elements at two different positions
    public static void swap (int[] arr, int pos1, int pos2) {
	int tmp = arr[pos1];
	arr[pos1]=arr[pos2];
	arr[pos2]=tmp;
    }
    
    //partition the array around a pivot
    //return pos of pivot
    public static int partition (int[] arr, int left, int right, int pvtPos) {
	int pvtVal = arr[pvtPos];
	swap (arr, pvtPos, right);
	
	int savPos = left;
	for (int i = left; i < right; i++) {
	    if (arr[i] < pvtVal) {
		swap (arr, savPos, i);
		savPos++;
	    }
	}
	swap (arr, right, savPos);
	return savPos;
    }
    
    //search
    public static int FSel (int[] arr, int k, int lo, int hi) {
	if (lo >= hi) {
	    return arr[hi];
	}
	else {
	    int random = (int)((Math.random()*(hi-lo+1)))+lo;
	    int posV = partition(arr, lo, hi, random);
	    if (posV == k-1) {return arr[posV];}
	    else if (k-1<posV) {
		return FSel(arr, k, lo , posV-1);
	    }
	    else {
		return FSel(arr, k, posV+1, hi);
	    }
	}
    }

    public static void main (String[]args) {
	int [] test = {43,74,89,20,94,32};
	for (int i = 0; i < test.length; i++) {
	    System.out.print(test[i]+" ");
	}
	System.out.println();
	System.out.println(FSel(test, 1, 0, test.length-1));
	System.out.println(FSel(test, 2, 0, test.length-1));
	System.out.println(FSel(test, 3, 0, test.length-1));
	System.out.println(FSel(test, 4, 0, test.length-1));
	System.out.println(FSel(test, 5, 0, test.length-1));
	System.out.println(FSel(test, 6, 0, test.length-1));
    }
}
