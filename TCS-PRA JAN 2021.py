class Employee:
     def __init__(self,eid,name,role):
          self.employeeId=eid
          self.employeeName=name
          self.agenInRole=role
          self.status="In Service"
          
class Organization:
     def __init__(self,employeeList):
          self.employeeList=employeeList
     
     def updateEmployeeStatus(self,noOfYears):
          for i in self.employeeList:
               if(i.agenInRole>noOfYears):
                    i.status="Retirement Due"
                    
     def countEmployees(self):
          l=[]
          count=0
          for i in self.employeeList:
               
               if(i.status=="Retirement Due"):
                    count+=1
                    l.append(i)
          return count
     
if __name__ =="__main__":
     n=int(input())
     li=[]
     for i in range(n):
          eid=int(input())
          name=input()
          agenInRole=int(input())
          li.append(Employee(eid,name,agenInRole))
     f=Organization(li)
     noOfYears=int(input())
     x=f.updateEmployeeStatus(noOfYears)
     y=f.countEmployees()
     if(y==0):
          print("NO Employee Updated.")
     else:
          print("count of employee updated",f)
     for i in li:
          print(i.employeeId,i.employeeName,i.status)
          
     
          
          
          

          
               
          