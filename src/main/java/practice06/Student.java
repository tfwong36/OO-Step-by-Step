package practice06;

public class Student extends Person{
    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public String introduce(){
        return  super.introduce() + " I am a Student. I am at Class " + klass.getNumber() + ".";
    }
}
