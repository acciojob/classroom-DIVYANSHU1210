package com.driver;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    StudentRepository student_repository = new StudentRepository();
    public void addStudent(Student student){
        student_repository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        student_repository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        student_repository.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String name){
        return student_repository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name){
        return student_repository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return student_repository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents(){
        return student_repository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        student_repository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        student_repository.deleteAllTeachers();
    }
}
