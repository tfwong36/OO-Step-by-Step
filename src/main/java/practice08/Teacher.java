package practice08;

public class Teacher  extends Person {
    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public String introduce() {
        return this.klass != null ? super.introduce() + " I am a Teacher. I teach Class " + klass.getNumber() + "." : super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        if (student.getKlass().getNumber() == this.klass.getNumber())
            return String.format("My name is %s. I am %d years old. I am a Teacher. I teach %s.", this.getName(), this.getAge(), student.getName());
        else
            return String.format("My name is %s. I am %d years old. I am a Teacher. I don't teach %s.", this.getName(), this.getAge(), student.getName());
    }
}
