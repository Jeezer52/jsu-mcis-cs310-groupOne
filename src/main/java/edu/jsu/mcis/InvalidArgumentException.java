package edu.jsu.mcis;

/**
 *
 * @author Group One 
 */
public class InvalidArgumentException extends RuntimeException{
	//constructor a method that returns the value that is passed into the constructor
	private String argName;
	private String exceptionClassInfo;

    /**
     * This method strings an argument name if the argument exception
     * is invalid.
     * @param argName an argument name that is an invalid exception. 
     */
    public InvalidArgumentException(String argName){
		this.argName = argName;
	}
	
    /**
     * This method gets the value of argument name.
     * @return Returns argument name.
     */
    public String getValue(){
		return argName;
	}
	
	public String toString(){
		String result = exceptionClassInfo+" The specified argument: "+argName+" does not exist";
		return result;
	}
	
	private void setExceptionClassName(){
		exceptionClassInfo = this.getClass().getSimpleName();
	}
}