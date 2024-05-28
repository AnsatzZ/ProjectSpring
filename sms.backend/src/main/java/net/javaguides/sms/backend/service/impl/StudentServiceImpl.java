package net.javaguides.sms.backend.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.javaguides.sms.backend.dto.StudentDto;
import net.javaguides.sms.backend.entity.Student;
import net.javaguides.sms.backend.exception.ResourceNotFoundException;
import net.javaguides.sms.backend.mapper.StudentMapper;
import net.javaguides.sms.backend.repository.StudentRepository;
import net.javaguides.sms.backend.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent =studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Student does not exist with given id:" +studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student)->StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("Student does not exist with given id: "+studentId)
        );
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());


        Student updatedStudentObj = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("Student does not exist with given id: "+studentId)
        );

        studentRepository.deleteById(studentId);


    }
}
