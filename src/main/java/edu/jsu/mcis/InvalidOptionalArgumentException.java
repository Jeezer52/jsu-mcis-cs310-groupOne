package edu.jsu.mcis;

/*
Note: this class should either be renamed or merged with InvalidArgumentException, depending on its function
*/

/**
 *
 * @author Group One
 */


public class InvalidOptionalArgumentException extends RuntimeException{

	private String invalidOptionalArgument;
	private String exceptionClassInfo;
	
    /**
     * This is method that checks for an invalid optional argument exception.
     * @param s an invalid optional argument.
     */
    public InvalidOptionalArgumentException(String s){
		invalidOptionalArgument = s;
		setExceptionClassName();
	}
	
    /**
     * This method gets an in valid optional argument that is a string.
     * @return Returns an invalid optional argument. 
     */
    public String getInvalidOptionalArgument(){
		return invalidOptionalArgument;
	}
	
	private void setExceptionClassName(){
		exceptionClassInfo = this.getClass().getSimpleName();
	}
	
	public String toString(){
		return exceptionClassInfo + " not a valid optional argument: " + invalidOptionalArgument;
	}
}