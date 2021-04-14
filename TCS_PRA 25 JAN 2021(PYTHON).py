class Container:
     def __init__(self,i,l,b,h,s):
          self.idi=i
          self.length=l
          self.breadth=b
          self.height=h
          self.status=s
     
     def getVolume(self):
          self.volume=self.length*self.breadth*self.height
          return self.volume
     
class PackagingCompany:
     def __init__(self,c):
          self.containerList=c
          
     def findContainersToPack(self,vol):
          for i in self.containerList:
               r=i.getVolume()
               if(i.status.lower()=="available" and r>=vol):
                    i.status="Used"
          return self.containerList
if __name__ == "__main__":
     n = int(input())
     k=[]
     for j in range(n):
           i=int(input())
           l=int(input())
           b=int(input())
           h=int(input())
           s="Available"
           k.append(Container(i,l,b,h,s))
     pack = PackagingCompany(k)
     vol = int(input())
     print("container Details:")
     res= pack.findContainersToPack(vol)
     for i in res:
          print(i.idi,i.length*i.breadth*i.height,i.status)
     
          

               
