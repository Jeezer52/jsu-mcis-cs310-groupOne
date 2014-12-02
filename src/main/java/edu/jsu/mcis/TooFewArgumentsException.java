package edu.jsu.mcis;

/**
 *
 * @author Group One 
 */
public class TooFewArgumentsException extends RuntimeException {
	
	private String expectedArgument;
	private String exceptionClassInfo;
	
    /**
     * This method checks for fewer argument exceptions.
     * @param s the expected number of arguments in the exception.
     */
    public TooFewArgumentsException(String s) {
			expectedArgument= s;
			setExceptionClassName();
	}

    /**
     * This method gets the missing argument name that is a string.
     * @return Returns the expected argument. 
     */
    public String getMissingArgumentName() {
		return expectedArgument;
	}
	public String toString() {
		return exceptionClassInfo + " The following arguments are required: " + expectedArgument;
	}
	
	private void setExceptionClassName(){
		exceptionClassInfo = this.getClass().getSimpleName();
	}
}
