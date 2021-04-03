/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
	Scanner sc=new Scanner(System.in);
	Employee e[]=new Employee[4];
	for(int i=0;i<e.length;i++)
	{
	    Employee x=new Employee();
	    x.employeeId=sc.nextInt();
	    sc.nextLine();
	    x.name=sc.nextLine();
	    x.branch=sc.nextLine();
	    x.rating=sc.nextDouble();
	    x.companyTransport=sc.nextBoolean();
	    e[i]=x;
	}
	sc.nextLine();
	String newBranch=sc.nextLine();
	int count=findCountOfEmployeesUsingCompTransport(e,newBranch);
	if(count>0)
	System.out.println(count);
	else
	System.out.println("No such Employees");
	Employee ans=findEmployeeWithSecondHighestRating(e);
	if(ans==null)
	System.out.println("All Employees using company transport");
	else
	{
	System.out.println(ans.employeeId);
	System.out.println(ans.name);
	}
	}
	public static int findCountOfEmployeesUsingCompTransport(Employee e[],String newBranch)
	{
	   int count=0;
	   for(int i=0;i<e.length;i++)
	   {
	       if((e[i].branch).equals(newBranch))
	       {
	           if(e[i].companyTransport)
	           count++;
	       }
	   }
	   return count;
	    
	}
	public static Employee findEmployeeWithSecondHighestRating(Employee e[])
	{
	    Employee secondHighestObject=null;
	  double firstHighest=-1;
	  double secondHighest=-1;
	   for(int i=0;i<e.length;i++)
	   {
	      if(e[i].companyTransport==false)
	      {
	          if(e[i].rating>firstHighest)
	          firstHighest=e[i].rating;
	      }
	   }
	   for(int i=0;i<e.length;i++)
	   {
	     if(e[i].companyTransport==false)
	      {
	          if(e[i].rating>secondHighest && e[i].rating!=firstHighest)
	          {
	          secondHighest=e[i].rating;
	          secondHighestObject=e[i];
	          }
	      }  
	   }
	   return secondHighestObject;
	}
}
class Employee{
    public int employeeId;
    public String name;
    public String branch;
    public double rating;
    public boolean companyTransport;
    Employee()
    {
        this.employeeId=0;
        this.name="";
        this.branch="";
        this.rating=0;
        this.companyTransport=false;
    }
}
