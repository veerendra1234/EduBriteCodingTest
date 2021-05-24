
public class Employee implements Comparable<Employee> {
	
	String id;
	String name;
	String deptid;
	
	public void set(String id , String name , String deptid)
	{
		this.deptid=deptid;
		this.name=name.trim();
		this.id=id;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}


}
