
import java.io.*;
import java.util.*;


public class Main {
	static Department[] deparray;
	static Region[] regarray;
	static  Employee[] emparray;
	public static void main(String[] args) throws FileNotFoundException {
		
		String splitBy = ","; 
		String line = "";
		deparray= new Department[10];
		for(int k=0;k<10;k++)
		deparray[k] = new Department();
		int i=0;
		// storing data of department in an object of type Department
		File file = new File("C:\\Users\\Veerendra\\eclipse-workspace\\EduBriteCodingExam\\src\\dept.csv");
			    Scanner sc = new Scanner(file);
			  
			    while (sc.hasNextLine()) {
			       line = sc.nextLine();
			       String[] dept = line.split(splitBy); 
			       deparray[i].set(dept[0],dept[1],dept[2]);			      
			       i = i+1;
			    } 
	    	// storing data of region in an object array
																												         
         regarray = new Region[3];
         for(int k=0;k<3;k++) 
          regarray[k] = new Region();
         
         i=0;
         File regionfile = new File("C:\\Users\\Veerendra\\eclipse-workspace\\EduBriteCodingExam\\src\\region.csv");
		 Scanner sc1 = new Scanner(regionfile);
          
		    while (sc1.hasNextLine()) {
			       line = sc1.nextLine();
			       String[] reg = line.split(splitBy);  
			       //System.out.print(i);
			       regarray[i].set(reg[0],reg[1]);
			       i = i+1;
			      
			    }
		    
		    // storimg data of employee in a class object
		   emparray = new Employee[15];
		   
		   for(int k=0;k<15;k++)
			emparray[k] = new Employee();
		   i=0;
		   File empfile = new File("C:\\Users\\Veerendra\\eclipse-workspace\\EduBriteCodingExam\\src\\emp.csv");
		    Scanner sc2 = new Scanner(empfile);
		    
		    while (sc2.hasNextLine()) {
//		    	  if(i==15)
//		    		  break;
			       line = sc2.nextLine();
			       String[] emp = line.split(splitBy);  
			       emparray[i].set(emp[0],emp[1],emp[2]);
			       i = i+1;
			    }
		    sc.close();
		    sc1.close();
		    sc2.close();
     	    Arrays.sort(emparray);
		    // running the query
		    // Print Emp count in each department
		    System.out.println("answer of question 1 --------------");
		 // print employee name, department name, region name	    
			  for(int len=0;len<emparray.length;len++)
			  {  
				String[] arr = getDeptAndRegion(emparray[len].deptid);
				System.out.println(emparray[len].name+" "+arr[0]+" "+arr[1]);  
			  }
			  
			  //answer of question 2
			  System.out.println(" answer of question 2  -------------");
		    Map<String ,Integer> map=new HashMap<String , Integer>();
		    for(int j=0;j<15;j++)
		    {
		    	if(!map.containsKey(emparray[j].deptid)) {
		    		map.put(emparray[j].deptid , 1 );
		    	}
		    	else
		    	{
		    		Integer x = map.get(emparray[j].deptid);
		    		x = x+1;
		    		map.put( emparray[j].deptid , x );	    		
		    	}
		    }
		    System.out.println(map);
		    //System.out.println(treeMap);
		    
	   
		    System.out.println(" answer of question 3 ------------");
		  for(int k=0;k<regarray.length;k++) {
		    System.out.println(regarray[k].regionname+"  "+EmpCountByRegion(regarray[k].regionid));
		  }
		  
		  System.out.println(" answer of question 4 ------------"); 
		 System.out.println(getDeptWithNoEmp());
		    
	}
	
	public static int EmpCountByRegion(String regId) {
		ArrayList<String> deptId = new ArrayList<String>(); 
		for(int i=0;i<deparray.length;i++)
		{
			if(regId.trim().equals(deparray[i].region.trim())) {
				deptId.add(deparray[i].id);
			}
		}
		int count = 0;
		for(int i=0;i<deptId.size();i++)
		{
			for(int j=0;j<emparray.length;j++)
			{
				if(deptId.get(i).trim().equals(emparray[j].deptid.trim()))
					count++;
			}
		}
		
		return count;
	}
	
	public static ArrayList<String> getDeptWithNoEmp() {
		ArrayList<String> deptName = new ArrayList<String>(); 
		for(int i=0;i<deparray.length;i++) {
			boolean count= false;
			for(int j=0;j<emparray.length;j++) {
				if(deparray[i].id.trim().equals(emparray[j].deptid.trim())) {
					count=true;
				}
			}
			if(!count) {
				deptName.add(deparray[i].name);
			}
		}
		return deptName;
		
	}
	
	
    public static String[] getDeptAndRegion(String dId)
    {	String[] arr= new String[2];
         String regId="";
         //System.out.println(dId);
    	for(int i=0;i<deparray.length;i++)
    	{
    		//System.out.println(deparray[i].id);
    		if(dId.trim().equals(deparray[i].id.trim()) )
    		{
    			arr[0]= deparray[i].name;
    			regId=deparray[i].region;	
    			break;
    		}
    	}
    	for(int i=0;i<regarray.length;i++)
    	{
    		if(regId.trim().equals(regarray[i].regionid.trim()))
    		{
    			arr[1]= regarray[i].regionname;
    		}
    	}
		return arr;
    	
    }

}
