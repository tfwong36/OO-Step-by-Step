package practice10;

public class Student extends Person{
    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public String introduce(){
        if (this.klass.getLeader() != null && super.getName().equals(this.klass.getLeader().getName()))
            return super.introduce() + String.format(" I am a Student. I am Leader of Class %d.", klass.getNumber());
        return super.introduce() + String.format(" I am a Student. I am at Class %d.", klass.getNumber());
    }
}
