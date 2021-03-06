/*
Dorothy Ng
APCS2 pd10
HW21 -- Stack: What is It Good For?
2016-03-30
*/

/*****************************************************
 * skeleton for class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
	Latkes tmp = new Latkes(s.length());
	String retStr = "";
	for (int i=0;i<s.length();i++){
	    tmp.push(s.substring(i,i+1));
	}
	for (int i=0;i<s.length();i++){
	    retStr += tmp.pop();
	}
	return retStr;
    }//end flip()
    
    
    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    {
	if (s.equals("")) return true;
	String[] tmp = new String[s.length()];
	for (int i=0;i<s.length();i++){
	    tmp[i]=s.substring(i,i+1);
	}
	for (int i=0;i<s.length();){
	    if (matching(s,tmp,tmp[i])){tmp[i]="";}
	    else {return false;}
	}
	return true;
    }//end allMatched()
    
    public static boolean matching(String s, String[] tmp, String tar){
	int ctr=0;
	String get="";
	if (tar.equals("(")) get=")";
	else if (tar.equals("{")) get="}";
	else if (tar.equals("[")) get="]";
	if (get!=""){
	    for (int k=s.indexOf(tar);k<s.length();k++){
		if (tmp[k].equals(tar)) ctr++;
		else if (tmp[k].equals(get)){
		    if (ctr>0) ctr--;
		    else tmp[k]="";
		}
	    }
	    return true;
	}
	return false;
    }

    //main method to test
    public static void main( String[] args ) { 
	
	
	System.out.println(flip("stressed"));
	System.out.println(allMatched( "({}[()])" )); //true
	System.out.println(allMatched( "([)]" ) ); //false
	System.out.println(allMatched( "(){([])}" ) ); //true
	System.out.println(allMatched( "](){([])}" ) ); //false
	System.out.println(allMatched( "(){([])}(" ) ); //false
	System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v        
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }
    
}//end class LatKtS