package net.javaguides.sms.backend.repository;

import net.javaguides.sms.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public interface StudentRepository extends JpaRepository <Student,Long>{
}
