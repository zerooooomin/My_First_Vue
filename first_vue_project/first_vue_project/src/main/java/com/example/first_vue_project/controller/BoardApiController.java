package com.example.first_vue_project.controller;


import com.example.first_vue_project.Entity.BoardEntity;
import com.example.first_vue_project.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173/")
@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping
    public ResponseEntity<List<BoardEntity>> getAllBoards() {
        List<BoardEntity> boards = boardRepository.findAll();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardEntity> getBoardById(@PathVariable int id) {
        Optional<BoardEntity> board = boardRepository.findById(id);
        if (board.isPresent()) {
            return ResponseEntity.ok(board.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BoardEntity> createBoard(@RequestBody BoardEntity board) {
        BoardEntity newBoard = boardRepository.save(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBoard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BoardEntity> deleteBoardById(@PathVariable int id) {
        Optional<BoardEntity> board = boardRepository.findById(id);
        if (board.isPresent()) {
            boardRepository.delete(board.get());
            return ResponseEntity.ok(board.get());
        }
        return ResponseEntity.notFound().build();
    }

}
