package com.example.first_vue_project.Repository;

import com.example.first_vue_project.Entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface BoardRepository  extends JpaRepository<BoardEntity, Integer> {
}
