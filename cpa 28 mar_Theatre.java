/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
class Theatre{
    public int theatreId;
    public String theatreName;
    public int seatCapacity;
    public double ticketRate;
    public double theatreRating;
    public boolean balconyAvailable;
    Theatre()
    {
        this.theatreId=0;
        this.theatreName="";
        this.seatCapacity=0;
        this.ticketRate=0.0;
        this.theatreRating=0.0;
        this.balconyAvailable=false;
    }
}

     class MyClass {
    public static void main(String[] args)
    {
      Scanner sc=new Scanner(System.in);
      Theatre t[]=new Theatre[4];
      for(int i=0;i<t.length;i++)
      {
          Theatre x=new Theatre();
          x.theatreId=sc.nextInt();
         // System.out.println(x.theatreId);
          sc.nextLine();
          x.theatreName=sc.nextLine();
          x.seatCapacity=sc.nextInt();
         // sc.nextLine();
          x.ticketRate=sc.nextDouble();
          x.theatreRating=sc.nextDouble();
          x.balconyAvailable=sc.nextBoolean();
          t[i]=x;
          
      }
      //sc.nextLine();
      int newId=sc.nextInt();
      int capacity=sc.nextInt();
      String str=findTheatreCategory(t,newId);
      if(str==null)
      {
          System.out.println("There is no Theatre with the given Theatre ID");
      }
      else{
          System.out.println(str);
      }
     Theatre s[]=searchTheatreByCapacity(t,capacity);
     if(s==null)
     {
         System.out.println("Only low capacity theatres available");
     }
     else{
         for(int i=0;i<s.length;i++)
         {
             if(s[i]!=null)
         System.out.println(s[i].theatreId);
         }
     }
     
    }
    public static String findTheatreCategory(Theatre t[],int newId)
    {
        for(int i=0;i<t.length;i++)
        {
          if((t[i].theatreId)==(newId))
          {
              if(t[i].balconyAvailable==true && t[i].theatreRating>4)
              {
                  return "Ultra Premium";
              }
              else if(t[i].balconyAvailable==true && (t[i].theatreRating>=3)&&((t[i].theatreRating)<=4))
              {
                  return "Premium";
              }
              else 
              {
                  return "Normal";
              }
          }
        }
        return null;
    }
    public static Theatre[] searchTheatreByCapacity(Theatre t[],int capacity)
    {
        Theatre arr[]=new Theatre[4];
        int j=0;
           for(int i=0;i<t.length;i++)
           {
               if(t[i].seatCapacity>capacity)
               {
                   arr[j]=t[i];
                   j++;
               }
           }
           for(int i=0;i<j;i++)
           {
               for(int k=i+1;k<j;k++)
               {
                   if(arr[i].ticketRate<arr[k].ticketRate)
                   {
                   Theatre temp=arr[k];
                   arr[k]=arr[i];
                   arr[i]=temp;
                   }
               }
           }
           if(j==0)
           return null;
           
           return arr;
    }
}