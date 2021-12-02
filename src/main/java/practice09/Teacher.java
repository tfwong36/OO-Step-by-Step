package practice09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher  extends Person {
    LinkedList<Klass> Classes = null;

    public LinkedList<Klass> getClasses() {
        return Classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> linkedList) {
        super(id, name, age);
        this.Classes = linkedList;
    }

    public String introduce() {
        String outputString = " I am a Teacher. I teach Class ";
        if (Classes != null){
            String teachingClass = Classes.stream().map(e -> String.valueOf(e.getNumber())).collect(Collectors.joining(", "));
            return super.introduce() + outputString + teachingClass + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        String outputString = super.introduce() + " I am a Teacher.";
        if (Classes != null && this.isTeaching(student))
                return String.format(outputString + " I teach %s.", student.getName());
        return String.format(outputString + " I don't teach %s.", student.getName());
    }

    public boolean isTeaching(Student student){
        return Classes != null && Classes.stream().anyMatch(x -> x.getNumber() == student.getKlass().getNumber());
    }
}
