package com.diploma.services;

import com.diploma.entities.Certificate;
import com.diploma.entities.Student;
import com.diploma.entities.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CertificateService {

    public Certificate expeditCertificate(Student student) {
        double average = calculateAverage(student.getSubjects());
        String message = "Bien.";
        if(average >= 9) message = "Exelente papa!!!";
        return new Certificate(message, average, student);
    }

    public double calculateAverage(ArrayList<Subject> subjects) {
        double total = 0.0;
        for(Subject subject : subjects) {
            total += subject.getScore();
        }
        return total / subjects.size();
    }
}
