package practice10;

import java.util.*;

public class Klass {
    private int number;
    private Student leader;
    private final List<Student> members= new ArrayList<>();
    private Teacher teacher;

    public Klass(int number) {
        this.number = number;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student getLeader() {
        return leader;
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getMembers() {
        return members;
    }

    public String getDisplayName(){
        return "Class " + this.number;
    }

    public void assignLeader(Student student){
        if (!members.contains(student))
            System.out.printf("It is not one of us.\n");
        else{
            this.leader = student;
            if (this.getTeacher() != null)
                this.getTeacher().printStudentBecomeLeader(student, this.getNumber());
        }
    }

    public void appendMember(Student student){
        if (!members.contains(student)){
            members.add(student);
            if (this.getTeacher() != null)
                this.getTeacher().printStudentJoin(student, this.getNumber());
        }
    }

    public boolean isIn(Student student){
        for (Student member : this.members) {
            if (member.getId() == student.getId())
                return true;
        }
        return false;
    }
}
