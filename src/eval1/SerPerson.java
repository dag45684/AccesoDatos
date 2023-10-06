package eval1;

import java.io.Serializable;

public class SerPerson implements Serializable{
	
	String name;
	int age;
	
	public SerPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "SerPerson [name=" + name + ", age=" + age + "]";
	}

}
