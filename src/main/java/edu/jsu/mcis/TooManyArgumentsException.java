package edu.jsu.mcis;

/**
 *
 * @author Group One 
 */
public class TooManyArgumentsException extends RuntimeException {
	
	private String unexpectedArgument;
	private String exceptionClassInfo;
	
    /**
     * This method checks for too many argument exceptions.
     * @param s the unexpected number of arguments in the exception. 
     */
    public TooManyArgumentsException(String s) {
			unexpectedArgument = s;
			setExceptionClassName();
	}

    /**
     * This method gets the unexpected argument that is a string.
     * @return Returns the unexpected argument.
     */
    public String getUnexpectedArgument() {
		return unexpectedArgument;
	}

	public String toString() {
		return exceptionClassInfo + " Unrecognised arguments: " + unexpectedArgument;
	}
		
	private void setExceptionClassName(){
		exceptionClassInfo = this.getClass().getSimpleName();
	}
}