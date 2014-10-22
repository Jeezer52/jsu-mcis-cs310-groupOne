package edu.jsu.mcis;

import java.util.*;

@SuppressWarnings("unchecked")
public class ArgumentValues{
	private String argument;
	private Object value;
	private String description;
	private DataType variables = DataType.STRING;

	public ArgumentValues(String arg){
		argument = arg;
		value = "";
	}
	
	public ArgumentValues(String arg, String desc){
		this(arg);
		setDescription(desc);
	}
	
	public ArgumentValues(DataType t, String arg){
		this(arg);
		variables = t;
	}
	
	public ArgumentValues(DataType t, String arg, String desc){
		this(t,arg);
		setDescription(desc);
	}

	public <T extends Object> T getValue(){
		return (T) value;
	}
	
	public String getName(){
		return argument;
	}
	
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
	
	public void setDescription(String s){
		description = s;
	}

	public String getDescription(){
		return description;
	}
	
	public String getType(){
		switch(variables){
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