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
        List<String> studentlist = new ArrayList<>();
        if (classroom.containsKey(teacher))
            studentlist = classroom.get(teacher);
        if (!studentlist.contains(student))
            studentlist.add(student);
        classroom.put(teacher, studentlist);
//        if(classroom.containsKey(teacher)){
//            List<String> oldlist = classroom.get(teacher);
//            oldlist.add(student);
//            classroom.put(teacher, oldlist);
//        }
//        else{
//            List<String> newlist = new ArrayList<>();
//            newlist.add(student);
//            classroom.put(teacher, newlist);
//        }
    }

    public Student getStudentByName(String name){
        return Students.get(name);
//        if(Students.containsKey(name)) return Students.get(name);
//        return null;
    }

    public Teacher getTeacherByName(String name){
        return Teachers.get(name);
//        if(Teachers.containsKey(name)) return Teachers.get(name);
//        return null;
    }

    public List<String> getStudentsByTeacherName(String name){
        List<String> studentlist = new ArrayList<>();
        if(classroom.containsKey(name))studentlist =  classroom.get(name);
        return studentlist;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(Students.keySet());
    }

    public void deleteTeacherByName(String teacher){
        List<String> pairlist = new ArrayList<>();
        if (classroom.containsKey(teacher)) {
            pairlist = classroom.get(teacher);
            for (String st : pairlist) {
                Students.remove(st);
            }
            classroom.remove(teacher);
        }
        Teachers.remove(teacher);
//        if(classroom.containsKey(name)){
//            classroom.remove(name);
//        }
    }
    public void deleteAllTeachers(){
        for (String teacher : classroom.keySet()) {
            List<String> pairlist = classroom.get(teacher);
            for (String st : pairlist) {
                if (Students.containsKey(st))
                    Students.remove(st);
            }
        }
        Teachers.clear();
        classroom.clear();
    }
}
