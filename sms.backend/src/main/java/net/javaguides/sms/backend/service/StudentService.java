package net.javaguides.sms.backend.service;

import net.javaguides.sms.backend.dto.StudentDto;

import java.util.List;
public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);


    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudent();


    StudentDto updateStudent(Long studentId,StudentDto updatedStudent);

    void deleteStudent(Long studentId);




}
