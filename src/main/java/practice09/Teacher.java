package practice09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Teacher  extends Person {
    //#todo remove unused klass, and related methods
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
            String teachingClass = "";
            //#todo replace by stream api
            for (Klass klass : this.Classes) {
                teachingClass += klass.getNumber() + ", ";
            }
            teachingClass = teachingClass.substring(0, teachingClass.length() - 2); //remove last two ', '
            return super.introduce() + outputString + teachingClass + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        boolean result = false;
        String outputString = super.introduce() + " I am a Teacher.";
        if (Classes != null) {
            if (this.isTeaching(student))
                return String.format(outputString + " I teach %s.", student.getName());
        }
        return String.format(outputString + " I don't teach %s.", student.getName());
    }

    public boolean isTeaching(Student student){
        if (Classes != null) {
            //#todo replace by stream api
            List<Integer> teachingClass = new ArrayList<>();
            for (Klass klass : this.Classes) {
                teachingClass.add(klass.getNumber());
            }
            return teachingClass.contains(student.getKlass().getNumber());
        }
        return false;
    }
}
