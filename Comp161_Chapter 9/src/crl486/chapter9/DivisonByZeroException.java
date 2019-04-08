/**
 * 
 */
package crl486.chapter9;

/**
 * @author crl486
 *
 */
public class DivisonByZeroException extends Exception {
	
	public DivisonByZeroException(){
		super("DivisionByZeroException");
	}
	
	
	public DivisonByZeroException(String message){
		super("DivisionByZeroException: " + message);
	}

}
