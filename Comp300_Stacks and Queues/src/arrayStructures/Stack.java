/**
 * 
 */
package arrayStructures;

/**
 * @author crl486
 *this is an abstract data type, all someone needs to write the code
 */
public interface Stack<Item> extends Iterable<Item>{

	Item peek();              //shows value of top 
	void push(Item item);     //adds an item to top of the stack
	Item pop();               //takes top item off
	public boolean isEmpty(); //checks to see if stack is empty
	//constant time versus linear time, goal to get as close to constant as possible
	//
}
