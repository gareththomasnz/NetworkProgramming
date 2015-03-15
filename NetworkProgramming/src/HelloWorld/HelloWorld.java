package HelloWorld;

public class HelloWorld {
	
	private int age = 2;
	//public String name = "";
	
	public static void main(String[] args)
	{
		
		for (String name: args) {
            System.out.println("HelloWorld:" + name);
		}
            
		HelloWorld test = new HelloWorld();
		
		int returnValue = test.calculateAge(15);
		
		System.out.println(returnValue);
	}

	public HelloWorld()
	{
		System.out.println("HelloWorld constructor");
	}
	
	public int calculateAge(int addYears)
	{
		return age = doSomeMoreStuff(age , addYears);
	}
	
	public int doSomeMoreStuff(int nAge, int addYears)
	{
		return (nAge + addYears);
	}
}