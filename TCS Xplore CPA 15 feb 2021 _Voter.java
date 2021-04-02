

import java.util.*;
import java.lang.*;
import java.io.*;


 class Voter{
    public int voterId;
    public String voterName;
    public int voterAge;
    public boolean isVoteCasted;
    public String constituency;
    Voter()
    {
        this.voterId=0;
        this.voterName="";
        this.voterAge=0;
        this.isVoteCasted=false;
        this.constituency="";
        
    }
 }
 class MyClass {
     public static void main(String[] args)
     {
        Scanner sc=new Scanner(System.in);
        Voter v[]=new Voter[4];
        for(int i=0;i<v.length;i++)
        {
            Voter x=new Voter();
            x.voterId=sc.nextInt();
            sc.nextLine();
            x.voterName=sc.nextLine();
            x.voterAge=sc.nextInt();
            x.isVoteCasted=sc.nextBoolean();
            sc.nextLine();
            x.constituency=sc.nextLine();
            //System.out.println(x.constituency);
            v[i]=x;
        }
        String consti=sc.nextLine();
        //System.out.println(consti);
        int ans1=findTotalvotesCastedByConstituency(v,consti);
        if(ans1==0)
        {
        System.out.println("No votes casted");
        }
        else
        {
        System.out.println(ans1);
        }
        
        Voter ans[]=searchVoterByAge(v);
        if(ans==null)
        System.out.println("No such Voters");
        else 
        {
          for(int i=0;i<ans.length;i++)  
          {
            if(ans[i]!=null)  
          
        System.out.println(ans[i].voterId);
          }
        }
     }
     public static int findTotalvotesCastedByConstituency(Voter v[],String consti)
     {
         int count=0;
         for(int i=0;i<v.length;i++)
         {
           if((v[i].constituency).equals(consti))
             {
             //System.out.println(count);
                 if(v[i].isVoteCasted)
                 {
                 count+=1;
                 }
             }
         }
         
         
         return count;
         
     }
     public static Voter[] searchVoterByAge(Voter v[])
     {
         Voter arr[] =new Voter[4];
         int k=0;
         for(int i=0;i<v.length;i++)
         
         {
             if(v[i].voterAge<30)
             {
                 arr[k]=v[i];
                 k++;
                 
             }
         }
     
         for(int i=0;i<k;i++)
         {
             for(int j=i+1;j<k;j++)
             {
                 if(arr[j].voterId<arr[i].voterId)
                 {
                     Voter temp=arr[i];
                     arr[i]=arr[j];
                     arr[j]=temp;
                 }
             }
             
         }
         if(k==0)
         return null;
         
         return arr;
     }
 }