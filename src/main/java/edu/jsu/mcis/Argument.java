package edu.jsu.mcis;

import java.util.*;

/**
 *
 * @author Group One 
 */
public class Argument {

	private String name;
	private Object value;
	private String description;
	private DataType variables = DataType.STRING;
	private String shortName;
	
    /**
     * 
     */
    public enum DataType{

            /**
             * The datatype can be a string.
             */
            STRING,

            /**
             * The datatype can be an integer.
             */
            INT,

            /**
             * The datatype can be a float. 
             */
            FLOAT,

            /**
             * The datatype can be boolean. 
             */
            BOOLEAN;
		
            
		public String toString(){
			switch(this){
			case INT:
				return "int";
			case FLOAT:
				return "float";
			case BOOLEAN:
				return "boolean";
			default:
				return "String";
			}
		}
	}

    /**
     * This method initializes the values for a string argument.
     * @param argument a name or value that is a string. 
     */
	Argument(String argument){
		name = argument;
		value = "";
		variables = DataType.STRING;
	}
	/**
         * This method initializes the values for other datatype arguments 
         * other than string arguments. 
         * @param t is the type of datatype. 
         * @param argument is a string. 
         */
 	Argument(DataType t, String argument){
		this(argument);
		variables = t;
	}

    /**
     * This method gets the value of T. 
     * @param <T> the Value that is retrieved.
     * @return Returns T value.
     */
    public <T> T getValue(){
		return (T) value;
	}
	
    /**
     * This method gets the string name.
     * @return Returns string name.
     */
    public String getName(){
		return name;
	}

    /**
     * This method sets a description for s.
     * @param s a set description that is a string.
     */
    public void setDescription(String s){
		description = s;
	}

    /**
     * This method makes the description a string.
     * @return Returns the description. 
     */
    public String getDescription(){
		return description;
	}
	
    /**
     * This method makes getType a string.
     * @return Returns the variables that are strings.  
     */
    public String getType(){
		return variables.toString();
	}
	
    /**
     * This method makes a short name a string.
     * @return Returns the short name. 
     */
    public String getShortName(){
		return shortName;
	}
	
    /**
     * This method sets the short name as a string.
     * @param shortName a set name that is a sting. 
     */
    public void setShortName(String shortName){
		this.shortName = shortName;
	}
	
    /**
     * This method sets the value of v to a string.
     * @param v a value that can be an integer, a float, or a 
     * boolean.
     */
    public void setValue(String v){
		switch(variables){
		case INT:
			value = Integer.parseInt(v);
			break;
		case FLOAT:
			value = Float.parseFloat(v);
			break;
		case BOOLEAN:
			if(v.equals("true") || v.equals("false")){
				value = Boolean.parseBoolean(v);
			}
			else{
				throw new RuntimeException();
			}
			break;
		default:
			value = v;
		}
	}
}
