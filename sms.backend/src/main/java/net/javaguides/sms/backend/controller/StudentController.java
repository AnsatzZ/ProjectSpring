package net.javaguides.sms.backend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.sms.backend.dto.StudentDto;
import net.javaguides.sms.backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private StudentService studentService;

    @PostMapping

    public ResponseEntity<StudentDto> createStudent(@RequestBody
                                                        StudentDto studentDto){
        StudentDto savedStudent =studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") long studentId){
        StudentDto studentDto =studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId,
                                                    @RequestBody StudentDto updatedStudent){
        StudentDto studentDto = studentService.updateStudent(studentId,updatedStudent);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        List<StudentDto> student =studentService.getAllStudent();
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully!.");

    }

}
