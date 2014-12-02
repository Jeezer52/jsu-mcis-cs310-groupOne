package edu.jsu.mcis;

/**
 *
 * @author Group One
 */
public class InvalidDataTypeException extends RuntimeException {
	private Argument arg;
	private String value;
	private String exceptionClassInfo;
	
    /**
     * This method checks for an invalid datatype exception.
     * @param arg a invalid datatype exception that is an argument.
     * @param value a invalid datatype exception that is an argument.  
     */
    public InvalidDataTypeException(Argument arg, String value) {
			this.value= value;
			this.arg=arg;
			setExceptionClassName();
	}
	
    /**
     * This method gets a value that is a string.
     * @return Returns the value. 
     */
    public String getValue() {
		return value;
	}
	
    /**
     * This method gets the argument type that is a string.
     * @return Returns the argument type. 
     */
    public String getType(){
		return arg.getType();
	}
	
    /**
     * This method gets a name that is a string.
     * @return Returns the argument name. 
     */
    public String getName(){
		return arg.getName();
	}
	
	public String toString() {
		String result= exceptionClassInfo + " argument " + arg.getName() + ": invalid " + arg.getType() + " value: " + value;
		return result;
	}
	
	private void setExceptionClassName(){
		exceptionClassInfo = this.getClass().getSimpleName();
	}
}

