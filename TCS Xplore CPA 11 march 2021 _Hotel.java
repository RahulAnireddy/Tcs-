/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Hotel
{
    public int regNo;
    public String hotelName;
    public String roomType;
    public int price;
    public boolean wifiFacility;
    Hotel()
    {
        this.regNo=0;
        this.hotelName="";
        this.roomType="";
        this.price=0;
        this.wifiFacility=false;
    }
}
class MyClass
{
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       Hotel h[]=new Hotel[4];
       for(int i=0;i<h.length;i++)
       {
           Hotel x=new Hotel();
           x.regNo=sc.nextInt();
           sc.nextLine();
           x.hotelName=sc.nextLine();
           x.roomType=sc.nextLine();
           x.price=sc.nextInt();
           x.wifiFacility=sc.nextBoolean();
           h[i]=x;
       }
       sc.nextLine();
       String givenRoomType=sc.nextLine();
       double avgprice=findAveragePriceForGivenType(h,givenRoomType);
       if(avgprice>0)
       {
           System.out.println(avgprice);
       }
       else
       {
          System.out.println("No such Hotel"); 
       }
       Hotel r=findHotelWithSecondHighestPrice(h);
       if(r!=null)
       {
       System.out.println(r.hotelName);
       System.out.println(r.price);
       }
       else
       System.out.println("No wifi available");
       
    }
    public static double findAveragePriceForGivenType(Hotel[] h,String givenRoomType)
    {
        double count=0;
        double sum=0;
        double avg=0;
      for(int i=0;i<h.length;i++)
      {
          if((h[i].roomType).equalsIgnoreCase(givenRoomType))
          {
              if(h[i].wifiFacility)
              {
                  count++;
                  sum+=h[i].price;
              }
          }
      }
      if(count==0)
      return avg;
      avg=sum/count;
      return avg;
    
    }
    public static Hotel findHotelWithSecondHighestPrice(Hotel[] h)
    {
        Hotel secondhighestobject=null;
        int firstHighest=-1;
        int secondHighest=-1;
        for(int i=0;i<h.length;i++)
        {
            if(h[i].price>firstHighest && h[i].wifiFacility==true)
            firstHighest=h[i].price;
        }
        for(int i=0;i<h.length;i++)
        {
            if(h[i].price>secondHighest && h[i].wifiFacility==true && h[i].price!=firstHighest)
            {
            
            secondHighest=h[i].price;
            secondhighestobject=h[i];
            }
        }
   return secondhighestobject;
    }
}
