package com.developer.studentManagementPortal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {

    HashMap<String, Student> hm = new HashMap<>();

    // here Student student is used to pass the class Student with variable name student
    //localhost:8080/add
    @PostMapping("/add")
    String addStudent(@RequestBody() Student student) {
        hm.put(student.getName(), student);
        return " New Student data added Successfully";
    }

    // localhost:8080/get?name=name    here name(after =) is the variable name whose data we want to show
    @GetMapping("/get")
    Student getStudent(@RequestParam("name") String name) {
        return hm.get(name);
    }


    // in case of path variable we use {id} to get the extra details after / like in this case after / we use name
    //localhost:8080/delete/name   here name is the variable which we want to delete
    @DeleteMapping("/delete/{name}")
    String deleteStudent(@PathVariable("name") String name) {
        hm.remove(name);
        return "Student data deleted Successfully";
    }


    //  In this we pass the student class so that not facing any difficulty to solve it.
    // localhost:8080/update1?age=age   age(after =) is the ager which we want to update
    @PutMapping("/update1")
    String updateStudent1(@RequestBody() Student student, @RequestParam("age") int age) {
        hm.replace(student.getName(), new Student(student.getName(), age, student.getBranch(), student.getAdmnNo()));
        return "Student details updated successfully";
    }


    //  in this we pass the parameter name to get the value from the hashmap
    //  and then firstly we put the get the whole thing outside the hashmap and then after updating we replace it accordingly
    // localhost:8080/update2?name=name&age=age
    @PutMapping("/update2")
    String updateStudent2(@RequestParam("name") String name, @RequestParam("age") int age) {
        Student s = hm.get(name);
        s.setAge(age);
        hm.replace(name, s);     // hm.put(name, s);
        return "Student details updated successfully";
    }

    // in this we pass the parameter name to get the value from the hashmap,
    // and then we directly update the value in the hashmap using setAge(age)
    // localhost:8080/update3?name=name&age=age
    @PutMapping("/update3")
    String updateStudent3(@RequestParam("name") String name, @RequestParam("age") int age) {
        hm.get(name).setAge(age);
        return "Student details updated successfully";
    }
}