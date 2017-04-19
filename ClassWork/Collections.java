public class Collections{

	public static void main(String[] args){
	
		Integer[] array; 	//Array of integer reffrences.
		ArrayList<Integers> list; 	//Array of interger reffrences as well.

		//Stacks are a linear data structure. Analogy to plates in a cupboard. 
		//can only remove from one end of the stack.
		
		//push ->  insert
		//pop -> remove

		Stack<Integer> stack; //stack is a ref to a stack of Int Reffrences
		
		/*	//Randomize to an AStack or RStack
			Stack<Integer> stack = Math.random() < 0.5 ? new AStack<Integer>():
													    new RStack<Integer>();
		*/

	for (int i = 0; i < 10; i++){
		stack[i] = i;
	}

	}

}

interface Stack<E> { 

	//E is the type of the object reffrences being held
	//E is a generic type
	//By convention, E is an element Type

	//void push<E>{ 	
//	}

	void push(E data);
	E pop();	

}

class AStack<E> implements Stack <E>{
//implent with array

	public E pop(){
		return null;
	}

	private void push(E data){
	
	}

	public void push(E data){
		
	}

	//private Object[] stack = new E[10]; False
	private Object[] stack = new Object[10];
}

class RStack<E> implements Stack <E>{
//implenent with linked list method

	private class Node<T>{	//class within class	

	//Vector arrows b/c generic type
	//By convention, T is a type

		private Node(T data){
			this.data = data;
		}

		private T data;
		private Node<T> next;

	}

	private Node<E> head;
}

/*Generics:

	**Code may be incomplete, but he's basically just creating linked lists**
		
	*Recall Python Exams:
		-list with lists, strings, etc. Kinda Obnoxious, yeah?
		-Poor Implementation.
		-Lists should be used like they are in Java.
		-Starting in Java 1.5, Arrays were no longer heterogenous. 
	
	*Creating Collections:
		-Almost all the time, they are Homogeneous.
		-Can be implemented in different ways.
		-Abstractions.
		-Hide details.

	*ADT (Abstract Data Type):
		-Organized collection of info + set of operations to manage data.
	
	*Static data vs Dynamic
		-Static is unchanging. 
		-Dynamic changes, such as its size during runtime.
			-ArrayList class can be used.

	*Linked List
		-We know what object refs are.
			-Ex, Student Object
		-Linked Lists can point on object to another.
			-Student point another student
		-This is done with intermediate Nodes, so that the Student objects don't have to store the information themselves

	*Stacks!
		-litterally just like in Magic.
		-Poping removes from stack, Pushing adds to top.
			-Popping is like a spell being countered, pushing is like casting an instant.

*/




