package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {
    HashMap<String, Student> Students =new HashMap<>();
    HashMap<String, Teacher> Teachers =new HashMap<>();
    HashMap<String, List<String>> classroom = new HashMap<>();

    public void addStudent(Student student){
        Students.put(student.getName() , student);
    }

    public void addTeacher(Teacher teacher){
        Teachers.put(teacher.getName() , teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        if(classroom.containsKey(teacher)){
            List<String> oldlist = classroom.get(teacher);
            oldlist.add(student);
            classroom.put(teacher, oldlist);
        }
        else{
            List<String> newlist = new ArrayList<>();
            newlist.add(student);
            classroom.put(teacher, newlist);
        }
    }

    public Student getStudentByName(String name){
        if(Students.containsKey(name)) return Students.get(name);
        return null;
    }

    public Teacher getTeacherByName(String name){
        if(Teachers.containsKey(name)) return Teachers.get(name);
        return null;
    }

    public List<String> getStudentsByTeacherName(String name){
        if(classroom.containsKey(name))return classroom.get(name);
        return new ArrayList<>();
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(Students.keySet());
    }

    public boolean deleteTeacherByName(String name){
        if(classroom.containsKey(name)){
            classroom.remove(name);
            return true;
        }
        return false;
    }
    public void deleteAllTeachers(){
        classroom.clear();
        Students.clear();
        Teachers.clear();
    }
}
