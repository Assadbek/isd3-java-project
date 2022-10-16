package com.example.findtutor.register;

import com.example.findtutor.model.DefaultSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultSubjectRepository extends JpaRepository<DefaultSubject, String> {
}
