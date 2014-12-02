package edu.jsu.mcis;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Group One
 */
public class ArgumentParser {

	private String programName ="";

    /**
     * This method list the positional argument as a string.
     */
    protected List<String> positionalArgList;

    /**
     * This method list the optional argument as a string. 
     */
    protected List<String> optionalArgList;

    /**
     * This method list arguments in a table. The argument values can 
     * be an integer, a float, a string, or boolean.
     */
    protected Hashtable<String,Argument> argumentTable;
	private boolean helpFlagExits;
	private boolean addedFlag;
	private int [] restrictedIntValues;
	private float [] restrictedFloatValues;
	private String [] restrictedStringValues;
	
    /**
     * This method places the optional arguments and positional arguments in 
     * an array list as a string, and this method places the argument table in 
     * a hash table. 
     */
    public ArgumentParser(){
		positionalArgList = new ArrayList<String>(5);
		optionalArgList = new ArrayList<String>(5);
		argumentTable = new Hashtable<String,Argument>(5);
		setProgramName();
		helpFlagExits = true;
	}
	
    /**
     * This method sets an argument name as a string and places the argument
     * name in the argument table as a positional argument. 
     * @param argumentName a positional argument that is a sting. 
     */
    public void addArgument(String argumentName){
		argumentTable.put(argumentName, new Argument(argumentName));
		positionalArgList.add(argumentName);
	}
	
    /**
     * This method adds an argument that checks the datatype and places the 
     * argument in an argument table as a positional argument.
     * @param type is a datatype argument.
     * @param argumentName a positional argument that is a string. 
     */
    public void addArgument(Argument.DataType type, String argumentName){
		argumentTable.put(argumentName, new Argument(type, argumentName));
		positionalArgList.add(argumentName);
	}

    /**
     * This method adds an argument that checks the argument to be a string.
     * @param argumentName an argument that is a string.
     * @param type is a datatype argument.
     */
    public void addArgument(String argumentName, Argument.DataType type){
		addArgument(type, argumentName);
	}
	
    /**
     * This method adds argument name to an argument table as an optional 
     * list. 
     * @param argumentName a name that is an optional argument.
     */
    public void addFlag(String argumentName){
		argumentTable.put(argumentName, new Argument(Argument.DataType.BOOLEAN, argumentName));
		optionalArgList.add(argumentName);
		getArgument(argumentName).setValue("false");
		addedFlag = true;
	}
	
    /**
     * This method gets the added flag.
     * @return Returns the added flag.
     */
    public boolean getAddedFlag(){
		return addedFlag;
	}
	
    /**
     * This method sets the integer values to be restricted.
     * @param argumentArray a set value that is an integer. 
     */
    public void setRestrictedIntValues(int [] argumentArray){
		restrictedIntValues = new int [argumentArray.length];
		
		for (int i = 0; i < argumentArray.length; i ++){
			restrictedIntValues[i] = argumentArray[i];
		}
		
	}
	
    /**
     * This method checks the restricted integer values.
     * @param a a restricted value that is an integer.
     * @return Returns the value is restricted.
     */
    public boolean checkRestrictedIntValues(int a){
		boolean isRestricted = false;
		
		for(int i = 0; i < restrictedIntValues.length; i ++){
			if(a == restrictedIntValues[i]){
				isRestricted = true;
				break;
			}
		}
		
		return isRestricted;
	}
	
    /**
     * This method sets the float values to restricted.
     * @param argumentArray a restricted value that is a float.
     */
    public void setRestrictedFloatValues(float [] argumentArray){
		restrictedFloatValues = new float [argumentArray.length];
		
		for (int i = 0; i < argumentArray.length; i ++){
			restrictedFloatValues[i] = argumentArray[i];
		}
		
	}
	
    /**
     * This method checks the restricted float values.
     * @param a a restricted value that is a float.
     * @return Returns the value is restricted. 
     */
    public boolean checkRestrictedFloatValues(float a){
		boolean isRestricted = false;
		
		for(int i = 0; i < restrictedFloatValues.length; i ++){
			if(a == restrictedFloatValues[i]){
				isRestricted = true;
				break;
			}
		}
		
		return isRestricted;
	}
	
    /**
     * This method sets the string values to restricted.
     * @param argumentArray a restricted value that is a string.
     */
    public void setRestrictedStringValues(String [] argumentArray){
		restrictedStringValues = new String [argumentArray.length];
		
		for (int i = 0; i < argumentArray.length; i ++){
			restrictedStringValues[i] = argumentArray[i];
		}
		
	}
	
    /**
     * This method checks the string values.
     * @param a a restricted value that is a string.
     * @return Returns the value is restricted. 
     */
    public boolean checkRestrictedStringValues(String a){
		boolean isRestricted = false;
		
		for(int i = 0; i < restrictedStringValues.length; i ++){
			if(a == restrictedStringValues[i]){
				isRestricted = true;
				break;
			}
		}
		
		return isRestricted;
	}

    /**
     * This method adds an optional argument that checks for argument name,
     * defaultVal, and the datatype. 
     * @param type is a datatype argument.
     * @param argumentName is a string.
     * @param defaultVal is a string. 
     */
    public void addOptionalArgument(Argument.DataType type, String argumentName, String defaultVal){
		argumentTable.put(argumentName, new Argument(type, argumentName));
		optionalArgList.add(argumentName);
		getArgument(argumentName).setValue(defaultVal);
	}
	
    /**
     * This method adds an optional argument that contains argument name, 
     * datatype, and a default value. 
     * @param argumentName is a string.
     * @param type is a datatype argument. 
     * @param defaultVal is a string. 
     */
    public void addOptionalArgument(String argumentName, Argument.DataType type, String defaultVal){
		addOptionalArgument(type, argumentName, defaultVal);
	}
	
    /**
     * This method gets a positional argument that is an integer.
     * @return Returns the size of the positional argument list. 
     */
    public int getNumPosArguments(){
		return positionalArgList.size();
	}
	
    /**
     * This method gets an optional argument that is an integer. 
     * @return Returns the size of the optional argument list. 
     */
    public int getNumOptArguments(){
		return optionalArgList.size();
	}
	
    /**
     * This method gets an argument that is an integer. 
     * @return Returns positional arguments and optional arguments.
     */
    public int getNumArguments(){
		return getNumPosArguments()+getNumOptArguments();
	}
	
    /**
     * This method sets the help flag to exit. 
     * @param h a set boolean flag.
     */
    public void setHelpFlagExits(boolean h) {
		helpFlagExits = h;
	}
	
    /**
     * This method parses a string. 
     * @param s a parse that is a string. 
     */
    public void parse(String s){
		Scanner scan = new Scanner(s);
		String nextVal = "";
		boolean loop = true;
		int i = 0;
		boolean helpCalled = false;
		while(loop){
			if(scan.hasNext()){
				nextVal = scan.next();
				if(nextVal.equals("-h")||nextVal.equals("--help")){
					loop=false;
					System.out.println(getUsage());
					if(helpFlagExits) {
						System.exit(0);
					}
					else{
						helpCalled = true;
					}
				}
			
				else if(nextVal.contains("--")){
					String argName = nextVal.substring(2);
					if(getArgument(argName).getType().equals("boolean")){
						getArgument(argName).setValue("true");
					}
					else{
						getArgument(argName).setValue(scan.next());
					}
				}	
				else if(nextVal.contains("-")){
					String shortName = nextVal.substring(1);
					if(getArgumentByShortName(shortName).getType().equals("boolean")){
						getArgumentByShortName(shortName).setValue("true");
					}
					else{
						getArgumentByShortName(shortName).setValue(scan.next());
					}
				}
				else if(getNumPosArguments()>i){
					try{
						argumentTable.get(positionalArgList.get(i)).setValue(nextVal);	
					}
					catch(Exception e){
						throw new InvalidDataTypeException(argumentTable.get(positionalArgList.get(i)),nextVal);
					}
				i++;
				}else {
					String a = nextVal;
					while(scan.hasNext()){
						a=a+" "+scan.next();
					}
						throw new TooManyArgumentsException(a);
				}
			}
			else loop = false;
		}
		if(i<getNumPosArguments()&&!helpCalled){
			String missingArg=argumentTable.get(positionalArgList.get(i)).getName();
			for(i=i+1;i<getNumPosArguments();i++){
				missingArg=missingArg+" "+argumentTable.get(positionalArgList.get(i)).getName();
			}
			throw new TooFewArgumentsException(missingArg);
		}
	}
	
    /**
     * This method gets an argument that is a string. 
     * @param argName an argument that is being retrieved.
     * @return Returns an argument name.
     */
    public Argument getArgument(String argName){
		if(argumentTable.containsKey(argName)){
			return argumentTable.get(argName);
		}
		else{	
			throw new InvalidArgumentException(argName);
		}
	}
	
    /**
     * This method gets an argument by a short name.
     * @param shortName a name that is being retrieved. 
     * @return Returns a short name.
     */
    public Argument getArgumentByShortName(String shortName){
		for(int i = 0; i < getNumOptArguments(); i ++){
			if(shortName.equals(getArgument(optionalArgList.get(i)).getShortName()))
				return getArgument(optionalArgList.get(i));
		}
		throw new InvalidArgumentException(shortName);
	}
	
	String getUsage(){
		String positionalArguments = "";
		for(int i=0;i<getNumPosArguments();i++){
			positionalArguments=positionalArguments+" " + argumentTable.get(positionalArgList.get(i)).getName();
		}
		
		String s = programName.toString() + positionalArguments + "\n";
		
		for(int i=0;i<getNumPosArguments();i++){
			s=s+"\n "+argumentTable.get(positionalArgList.get(i)).getName()+": ";
			if(argumentTable.get(positionalArgList.get(i)).getDescription()!=null){
				s=s+" "+argumentTable.get(positionalArgList.get(i)).getDescription()+".";
			}
		}
		if(getNumOptArguments() != 0){
			for(int i = 0;i < getNumOptArguments();i++){
				s = s+"\n --"+argumentTable.get(optionalArgList.get(i)).getName()+": ";
				if(argumentTable.get(optionalArgList.get(i)).getDescription() != null){
					s = s+" "+argumentTable.get(optionalArgList.get(i)).getDescription() +".";
				}
			}
		}
		return s;
	}
	
    /**
     * This method loads XML files.
     * @param path the path to the XML file.
     */
    public void loadXML(String path){
		LoadXML loader = new LoadXML(path);
		positionalArgList=loader.getPosArgs();
		optionalArgList=loader.getOptArgs();
		argumentTable=loader.getArgs();
	}
	
	private void setProgramName(){
		programName = Thread.currentThread().getStackTrace()[3].getClassName();
	}
}
