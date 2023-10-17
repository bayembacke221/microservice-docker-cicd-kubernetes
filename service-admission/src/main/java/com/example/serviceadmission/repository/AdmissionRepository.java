package com.example.serviceadmission.repository;

import com.example.serviceadmission.model.Admis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admis, String> {

}
