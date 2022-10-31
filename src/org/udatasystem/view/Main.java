package org.udatasystem.view;

import org.udatasystem.data.Student;
import org.udatasystem.data.Subject;
import org.udatasystem.data.University;
import org.udatasystem.persitance.DataInitializer;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University uni = DataInitializer.loadUniversity();
        System.out.println("Welcome to the University system");
        boolean flag = true;
        while (flag) {
            int choice = printMenu();
            switch (choice) {
                case 1:
                    listTeachers(uni);
                    break;
                case 2:
                    int index = listSubjects(uni, "Please, type a number to see the details");
                    subjectDetails(index, uni);
                    break;
                case 3:
                    createStudent(uni);
                    break;
                case 4:
                    createSubject(uni);
                    break;
                case 5:
                    listSubjectsOf(uni);
                    break;
                default:
                    flag = false;
                    break;
            }

        }


    }

    public static int printMenu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n----------------------------- Menu -----------------------------" +
                    "\n 1. List Teachers" +
                    "\n 2. List Subjects" +
                    "\n 3. Create Student" +
                    "\n 4. Create subject" +
                    "\n 5. List Subject of (Student)" +
                    "\n 6. Exit" +
                    "\n----------------------------------------------------------------");
            String input = scan.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 6) {
                    System.out.print("-------------------------- Invalid option -------------------------\nPlease, type a number between 1 to 6 to continue");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("-------------------------- Invalid choice --------------------------\n Just numbers are allowed. Please, type a number between 1 to 6 to continue");
            }


        }


    }

    public static void listTeachers(University uni) {
        System.out.println(uni.teachersToString());
    }

    public static int listSubjects(University uni, String message) {
        Scanner scan = new Scanner(System.in);
        System.out.println(uni.subjectsToString());
        System.out.println(message);
        while (true) {
            String input = scan.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > uni.getSubjectsList().size()) {
                    System.out.println("-------------------------- Invalid option -------------------------\nPlease, type a number between 1 to " + uni.getSubjectsList().size());
                    continue;
                }
                return choice - 1;
            } catch (NumberFormatException e) {
                System.out.println("-------------------------- Invalid choice --------------------------\n Just numbers are allowed. Please,  type a number between 1 to " + uni.getSubjectsList().size());
            }

        }

    }

    public static void subjectDetails(int index, University uni) {
        System.out.println(uni.subjectToString(index));
    }

    public static void createStudent(University uni) {
        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        System.out.println("-------------------------- Creating a student --------------------------");
        System.out.print("Id: ");
        int id = scanInt.nextInt();
        System.out.print("Full name: ");
        String fullName = scanString.nextLine();
        System.out.print("Age: ");
        int age = scanInt.nextInt();
        Student student = new Student(id, fullName, age);
        int index = listSubjects(uni, "Please, select the subject to enroll the student");
        uni.getSubjectsList().get(index).getStudentsList().add(student);
        System.out.println("Student: " + fullName + " has been enrolled to the subject: " + uni.getSubjectsList().get(index).getName());
    }

    public static void createSubject(University uni) {
        Subject subject = new Subject();
        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        System.out.print("Subject's name: ");
        String name = scanString.nextLine();
        System.out.print("Classroom: ");
        String classroom = scanString.nextLine();
        System.out.println("Select a teacher by number");
        listTeachers(uni);
        int choice = 0;
        while (true) {
            String input = scanString.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > uni.getTeachersList().size()) {
                    System.out.println("-------------------------- Invalid option -------------------------\nPlease, type a number between 1 to " + uni.getTeachersList().size());
                    continue;
                }
                choice -= 1;
                break;
            } catch (NumberFormatException e) {
                System.out.println("-------------------------- Invalid choice --------------------------\n Just numbers are allowed. Please,  type a number between 1 to " + uni.getTeachersList().size());
            }

        }
        System.out.println(uni.studentsToString());
        while (true) {
            System.out.print("-------------------------- Enter a new student --------------------------\nId: ");
            int id = scanInt.nextInt();
            Student student = uni.searchStudentById(id);
            if (student != null) {
                subject.getStudentsList().add(student);
            }
            System.out.print("Add another student? (y/n) ");
            String input = scanString.nextLine();
            if (!input.equals("y")) {
                break;
            }

        }
        subject.setName(name);
        subject.setClassroom(classroom);
        subject.setTeacher(uni.getTeachersList().get(choice));
        uni.getSubjectsList().add(subject);
        System.out.println("-------------------------- Subject created --------------------------");
        subjectDetails(uni.getSubjectsList().size()-1,uni);
    }

    public static void listSubjectsOf(University uni) {
        Scanner scanInt = new Scanner(System.in);
        System.out.println(uni.studentsToString());
        System.out.print("Id: ");
        int idStudent = scanInt.nextInt();
        List<Subject> subjects = uni.studentSubjects(idStudent);
        for (int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            System.out.println((i + 1) + ". Name: " + subject.getName() + "\tClassroom: " + subject.getClassroom());
        }

    }
}