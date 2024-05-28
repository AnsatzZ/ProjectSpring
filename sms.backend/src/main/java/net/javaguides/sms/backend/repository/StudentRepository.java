package net.javaguides.sms.backend.repository;

import net.javaguides.sms.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student,Long>{
}
