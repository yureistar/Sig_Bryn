/***********************
Will implement a stack using ArrayList
 **********************/

import java.util.ArrayList;

public class ALStack<T> implements Stack<T>{
    
    private ArrayList<T> _stack;
    private int _size;
    
    public ALStack(){
	_stack = new ArrayList<T> (42);
	_size = 0;
    }
    
    public ALStack(int size){
	_stack = new ArrayList<T> (size);
	_size = 0;
    }
    
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty(){
	return _size == 0;
    }

    //Return top element of stack without popping it.
    public T peek(){
	return _stack.get(_size-1);
    }
    
    //Pop and return top element of stack.
    public T pop(){
	T tmp = this.peek();
	_stack.set(_size-1,null);
	_size++;
	return tmp;
    }

    //Push an element onto top of this stack.
    public void push( T x ){
	if ( _size == _stack.size() ) {
	    ArrayList<T> temp = new ArrayList( _stack.size() * 2 );
	    for( int i = 0; i < _stack.size(); i++ ) {
		temp.set(i, _stack.get(i));
	    }
	    _stack = temp;
	}
	_stack.set(_size,x);
	_size++;
    }
}