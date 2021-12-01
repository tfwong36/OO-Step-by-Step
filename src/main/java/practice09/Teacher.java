package practice09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Teacher  extends Person {
    private Klass klass;
    LinkedList<Klass> Classes = null;

    public Klass getKlass() {
        return klass;
    }

    public LinkedList<Klass> getClasses() {
        return Classes;
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

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.Classes = linkedList;
    }

    public String introduce() {
        if (Classes != null){
            String teachingClass = "";
            for (Klass klass : this.Classes) {
                teachingClass += klass.getNumber() + ", ";
            }
            teachingClass = teachingClass.substring(0, teachingClass.length() - 2); //remove last two ', '
            return super.introduce() + " I am a Teacher. I teach Class " + teachingClass + ".";
        }
        return this.klass != null ? super.introduce() + " I am a Teacher. I teach Class " + klass.getNumber() + "." : super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        boolean result = false;
        if (Classes != null) {
            List<Integer> teachingClass = new ArrayList<>();
            for (Klass klass : this.Classes) {
                teachingClass.add(klass.getNumber());
            }
            result = teachingClass.contains(student.getKlass().getNumber());
            if (result)
                return String.format("My name is %s. I am %d years old. I am a Teacher. I teach %s.", this.getName(), this.getAge(), student.getName());
            else
                return String.format("My name is %s. I am %d years old. I am a Teacher. I don't teach %s.", this.getName(), this.getAge(), student.getName());
        }
        if (student.getKlass().getNumber() == this.klass.getNumber())
            return String.format("My name is %s. I am %d years old. I am a Teacher. I teach %s.", this.getName(), this.getAge(), student.getName());
        else
            return String.format("My name is %s. I am %d years old. I am a Teacher. I don't teach %s.", this.getName(), this.getAge(), student.getName());
    }

    public boolean isTeaching(Student student){
        if (Classes != null) {
            List<Integer> teachingClass = new ArrayList<>();
            for (Klass klass : this.Classes) {
                teachingClass.add(klass.getNumber());
            }
            return teachingClass.contains(student.getKlass().getNumber());
        }
        return this.getKlass().getNumber() == student.getKlass().getNumber();
    }
}
