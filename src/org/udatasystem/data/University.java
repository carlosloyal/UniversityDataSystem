package org.udatasystem.data;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> studentsList; // como listar
    private List<Subject> subjectsList;
    private List<Teacher> teachersList;

    public University() {
        this.studentsList = new ArrayList<Student>();
        this.subjectsList = new ArrayList<Subject>();
        this.teachersList = new ArrayList<Teacher>();
    }

    public String teachersToString() {
        String text = "----------------------------- Teachers -----------------------------";
        for (int i = 0; i < this.teachersList.size(); i++) {
            Teacher teacher = this.teachersList.get(i);
            text += "\n" + (i+1) + ". Id: " + teacher.getTeacherId() + "\tName: " + teacher.getFullName() + "\tSarary: " + teacher.getSalary();
            if (teacher instanceof FullTimeTeacher) {
                text += "\tExp. years: " + ((FullTimeTeacher) teacher).getExperienceYears();
            } else {
                text += "\tHours/Week: " + ((PartTimeTeacher) teacher).getHoursWeek();
            }
        }
        text += "\n--------------------------------------------------------------------";
        return text;

    }

    public String subjectsToString() {
        String text = "-------------------------- Subjects --------------------------\n";
        for (int i = 0; i < this.subjectsList.size(); i++) {
            Subject subject = this.subjectsList.get(i);
            text += (i + 1) +". Subject' name: " + subject.getName() + " Classroom: " + subject.getClassroom() + "\n";
        }
        text += "--------------------------------------------------------------";
        return text;
    }

    public String studentsToString () {
        String text = "-------------------------- Students --------------------------\n";
        for (int i = 0; i < this.studentsList.size(); i++) {
            Student student = this.studentsList.get(i);
            text += "Id: " + student.getStudentId() + "\tFull name: " + student.getFullName() + "\tAge: " + student.getAge() + "\n" ;
        }
        text += "--------------------------------------------------------------";
        return text;

    }

    public String subjectToString(int index) {
        Subject subject = this.subjectsList.get(index);
        String students = "";
        for (int i = 0; i < subject.getStudentsList().size(); i++) {
            students += "\n" + (i+1) + ". id: " + subject.getStudentsList().get(i).getStudentId() + "\tName: " +
                    subject.getStudentsList().get(i).getFullName() ;
        }
        return "--------------------------" +subject.getName() + "--------------------------" +
                "\nClassroom: " + subject.getClassroom() +
                "\nTeacher id: "+ subject.getTeacher().getTeacherId() + "\tTeacher Name: " + subject.getTeacher().getFullName() +
                "\nStudents:" + students;
    }

    public Student searchStudentById(int id) {
        for (int i = 0; i < this.studentsList.size(); i++) {
            if (this.studentsList.get(i).getStudentId() == id) {
                return this.studentsList.get(i);
            }
        }
        return null;
    }

    public List<Subject> studentSubjects(int id) {
        Student student = searchStudentById(id);
        if (student == null) {
            return null;
        }
        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < this.subjectsList.size(); i++) {
            Subject subject = this.subjectsList.get(i);
            if (subject.getStudentsList().contains(student)) {
                subjects.add(subject);
            }
        }
        return subjects;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(List<Subject> subjectsList) {
        this.subjectsList = subjectsList;
    }

    public List<Teacher> getTeachersList() {
        return teachersList;
    }

    public void setTeachersList(List<Teacher> teachersList) {
        this.teachersList = teachersList;
    }
}
