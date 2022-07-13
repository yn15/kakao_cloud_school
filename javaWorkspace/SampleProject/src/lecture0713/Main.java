package lecture0713;

class Human {
	
}

interface MyInterface {
	
}

interface Animal {
	int weight = 10;
	public static final int age = 20;
	
	public void printName();
	public abstract void printAge();
}


class MyClass extends Human implements Animal, MyInterface{
	@Override
	public void printName() {

		
	}

	@Override
	public void printAge() {

		
	}
}

public class Main implements Animal{

	@Override
	public void printName() {

		
	}

	@Override
	public void printAge() {

		
	}
	
}
