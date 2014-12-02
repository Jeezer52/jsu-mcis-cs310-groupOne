package edu.jsu.mcis;

/**
 *
 * @author Group One 
 */
public class XMLException extends RuntimeException{
	private String fileName;
	private String message;
	private String exceptionClassInfo;
	
    /**
     * This method is an XML exception.
     * @param fileName an XML exception and the name of the file.
     * @param message an XML exception and strings the message.
     */
    public XMLException(String fileName, String message){
		this.fileName=fileName;
		this.message=message;
	}
	
    /**
     * This method gets a file name that is a string.
     * @return Returns a file name.
     */
    public String getFile(){
		return fileName;
	}
    
	/**
         * This method gets a message that is a string. 
         * @return Returns a message.
         */
	public String getMessage(){
		return message;
	}
	
        /**
         * This method returns the message.
         * @return Returns the message.
         */
	public String toString(){
		
		return exceptionClassInfo + "An error has occured: " + message;
		
	}
	
	private void setExceptionClassName(){
		exceptionClassInfo = this.getClass().getSimpleName();
	}
}