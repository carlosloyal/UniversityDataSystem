package org.udatasystem.persitance;

import org.udatasystem.data.*;

// Capa de persistencia para cargar la informacion
public class DataInitializer {
    public static University loadUniversity(){
        University university = new University();
        loadTeachers(university);
        loadStudents(university);
        loadSubjects(university);
        return university;
    }
    private static void loadTeachers(University university) {
        PartTimeTeacher teacher1 = new PartTimeTeacher(5, "Carlos Leal", 1000000, 30);
        PartTimeTeacher teacher2 = new PartTimeTeacher(4, "Jaime Riaño", 2000000, 40);
        FullTimeTeacher teacher3 = new FullTimeTeacher(1, "Arturo Duarte", 4000000, 4);
        FullTimeTeacher teacher4 = new FullTimeTeacher(3, "Cristian Olarte", 5000000, 5);
        university.getTeachersList().add(teacher1);
        university.getTeachersList().add(teacher2);
        university.getTeachersList().add(teacher3);
        university.getTeachersList().add(teacher4);
    }

     private static void loadStudents(University university) {
         Student student1 = new Student( 10, "Alejandro Perez ", 15);
         Student student2 = new Student( 11, "Felipe Mujica", 18);
         Student student3 = new Student( 12, "Jhon sena", 19);
         Student student4 = new Student( 13, "Mario Duarte", 22);
         Student student5 = new Student( 14, "Carlos Torres", 40);
         Student student6 = new Student( 15, "Isabel correa", 35);
         university.getStudentsList().add(student1);
         university.getStudentsList().add(student2);
         university.getStudentsList().add(student3);
         university.getStudentsList().add(student4);
         university.getStudentsList().add(student5);
         university.getStudentsList().add(student6);
    }

     private static void loadSubjects  (University university){
         Subject subject1 = new Subject("Math","401", university.getStudentsList().subList(0,5), university.getTeachersList().get(0));
         Subject subject2 = new Subject("Chemistry","402", university.getStudentsList().subList(0,5), university.getTeachersList().get(1));
         Subject subject3 = new Subject("History","403", university.getStudentsList().subList(0,5), university.getTeachersList().get(3));// Sublist: subdividir una lista(0,0) lista de posiciones
         Subject subject4 = new Subject("Programming","404", university.getStudentsList().subList(0,5), university.getTeachersList().get(2));
         university.getSubjectsList().add(subject1);
         university.getSubjectsList().add(subject2);
         university.getSubjectsList().add(subject3);
         university.getSubjectsList().add(subject4);
     }
 }







































// cd Desktop
//cd GitHub
    //cd UniversityDataSystem
//git status
//git add -A
//git status
//git checkout -b  para cambiar de rama
// git commit -m "mensaje del commit entre comillas"
//git push

//  git push --set-upstream origin data / crea rama en repositorio remoto