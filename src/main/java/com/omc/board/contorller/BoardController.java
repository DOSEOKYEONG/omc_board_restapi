package com.omc.board.contorller;

import com.omc.board.exception.ResourceNotFoundException;
import com.omc.board.model.Board;
import com.omc.board.repository.BoardRepository;
import com.omc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping
    public List<Board> getAllBoardlist(){
        return boardRepository.findAll();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board){
        return boardRepository.save(board);
    }

    @GetMapping("{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("해당 게시글이 존재하지않습니다. id: " + id));

        return ResponseEntity.ok(board);
    }

    @PutMapping("{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable long id,@RequestBody Board boardDetails){
        Board updateBoard = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 게시글이 존재하지않습니다. id: " + id));

        updateBoard.setTitle(boardDetails.getTitle());
        updateBoard.setBoardNum(boardDetails.getBoardNum());
        updateBoard.setAuthor(boardDetails.getAuthor());
        updateBoard.setContent(boardDetails.getContent());
        updateBoard.setUpdateTime(boardDetails.getUpdateTime());

        boardRepository.save(updateBoard);

        return ResponseEntity.ok(updateBoard);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBoard(@PathVariable long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 게시글이 존재하지않습니다. id: " + id));

        boardRepository.delete(board);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
