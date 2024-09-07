package com.loyalistcollege.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loyalistcollege.com.example.WikimediaEntity;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaEntity, Long> {

}
