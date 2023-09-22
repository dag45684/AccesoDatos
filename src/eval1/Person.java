package eval1;

public class Person {
    int age;

    public Person(){};

    void setAge(int n) throws PersonException{
        if(n < 0 || n > 100) throw new PersonException("You stupid?");
        this.age = n;
    }

}
