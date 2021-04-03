/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Doctor{
    public int doctorId;
    public String doctorName;
    public double doctorFee;
    public boolean sundayAvailable;
    public String department;
    Doctor()
    {
        this.doctorId=0;
        this.doctorName="";
        this.doctorFee=0;
        this.sundayAvailable=false;
        this.department="";
    }
}
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc=new Scanner(System.in);
	Doctor d[]=new Doctor[4];
	
	  for(int i=0;i<d.length;i++)
	  {
	      Doctor x=new Doctor();
	      x.doctorId=sc.nextInt();
	        sc.nextLine();
	      x.doctorName=sc.nextLine();
	      x.doctorFee=sc.nextDouble();
	      x.sundayAvailable=sc.nextBoolean();sc.nextLine();
	      x.department=sc.nextLine();
	      d[i]=x;
	  }
	
	  String newDepartment=sc.nextLine();
	 double ans1=findTotalFeeByDepartment(d,newDepartment);
	  if(ans1>0)
	  {
	      System.out.println(ans1);
	  }
	  else
	  System.out.println("Department not found");
	  Doctor ans2[]=searchDoctorByAvailability(d);
	  if(ans2==null)
	  System.out.println("No doctor available on sunday");
	  else
	  {
	      for(int i=0;i<ans2.length;i++)
	      {
	          if(ans2[i]!=null)
	          System.out.println(ans2[i].doctorId);
	      }
	  }
	}
	public static double findTotalFeeByDepartment(Doctor d[],String newDepartment)
	{
	    double fees=0;
	     for(int i=0;i<d.length;i++)
	     {
	         if((d[i].department).equalsIgnoreCase(newDepartment))
	         {
	             fees=d[i].doctorFee;
	         }
	     }
	     return fees;
	}
	public static Doctor[] searchDoctorByAvailability(Doctor d[])
	{
	  Doctor arr[]=new Doctor[4];
	  int k=0;
	  for(int i=0;i<arr.length;i++)
	  {
        if(d[i].sundayAvailable)
        {
            arr[k]=d[i];
            k++;
        }
	  }
	  for(int i=0;i<k;i++)
	  {
	      for(int j=i+1;j<k;j++)
	      {
	          if(arr[j].doctorId<arr[i].doctorId)
	          {
	              Doctor temp=arr[j];
	              arr[j]=arr[i];
	              arr[i]=temp;
	          }
	      }
	  }
	  if(k==0)
	  return null;
	  return arr;
	}
}
