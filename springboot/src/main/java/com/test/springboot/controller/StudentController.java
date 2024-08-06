package com.test.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.springboot.entity.Student;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student();
        student.setId(1);
        student.setFirstName("hamoo");
        student.setLastName("Jo");
        return ResponseEntity.ok().header("custom-header", "hamoo").body(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "hamoo", "Jo"));
        students.add(new Student(2, "bamoo", "Ko"));
        return students;

    }

    // {id} -> @PathVariable 
    // http://localhost:8080/students/1/hammoo/Jo 
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(
        @PathVariable("id") int id,
        @PathVariable("first-name") String fisrtName,
        @PathVariable("last-name") String lastName
        )
        {
        Student student = new Student(id, fisrtName, lastName);
        return ResponseEntity.ok(student);
        }
    
    @GetMapping("qurey")
    public ResponseEntity<Student> studentRequestVarable (
        @RequestParam int id,
        @RequestParam String fisrtName,
        @RequestParam String lastName
    )
    {
        Student student = new Student(id, fisrtName, lastName);
        return ResponseEntity.ok(student);
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
            System.out.println(student.getId()+","+student.getFirstName()+","+student.getLastName());
            return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println("Delete : " + studentId);
        return ResponseEntity.ok("student deleted");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getId()+","+student.getFirstName()+","+student.getLastName());
        return ResponseEntity.ok(student);
    }    
}


