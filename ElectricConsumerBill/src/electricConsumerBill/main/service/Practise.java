package electricConsumerBill.main.service;

import java.util.*; //this will import all


public class Practise { //class name

	public static void main(String[] args) { //main method taken from java.lang package which is default package (No need to import)

		Map<String, Integer> variable = new HashMap<>(); //Creating Hash map with key - String & value - Integer using type safe 
	
		variable.put( "RoyKuntal",30000); //key need to be unique 
		variable.put( "AkhilPillamgolla",25000); //key can be repeated again and again 
		variable.put("sahil", 26000); //we can retrieve data using key faster
		variable.put("prasanth", 27000); //put means adding data to the hashmap
		
//		int maxValue = (Collections.max(variable.values()));    //this code only give max value 
//	System.out.println(maxValue);
	

		
		int maximumSalary = Integer.MIN_VALUE;  // Giving int maxSalary Variable to  wrapper(LANGPKG) with Min_Value 
		String maxEmployeeName = " ";          //creating a variable with string dataType
		
	for (String string : variable.keySet()) { //using enhanced for loop for passing the variable with KEYSET() 
		
		System.out.println("Print  Value : " + variable.get(string));     //printing only Values
		System.out.println("Print Key : " +string);                       //Printing Only keys
		System.out.println("Print Values with keys : " + variable.get(string)+ " "+ string);  //Printing Values associated with keys
		System.out.println("----------------------------------------------------");
		
		Integer employeeSalary = variable.get(string) ;  // created a int variable(employeeSalary) with values assigned
		
		if (employeeSalary > maximumSalary) { //Condition to check maxSalary 
			maximumSalary = employeeSalary;   //max salary is given to this variable 
			maxEmployeeName = string;         //person associated with max salary we will get
		}		
	}
	
	System.out.println("----------------------------------------------------");
	
	System.out.println("The Max salary is Given Below : ");

	StringBuffer var = new StringBuffer();
	var.append("max salary in hashmap is ").append(maximumSalary);// printing maximumSalary Variable
	var.append("\n").append("max salary Employee is ").append(maxEmployeeName); //Printing person allocated with max salary 
	// "\n" for next line
	// append means adding of string data or concatenation  

	System.out.println(var);  //printing the var(Output Variable)

	}

}
