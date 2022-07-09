package com.omc.board;

import com.omc.board.model.Board;
import com.omc.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class BoardApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
	

	@RequestMapping("/")
	public String home(){
		return "hello world";
	}

	@Autowired
	private BoardRepository boardRepository;

	@Override
	public void run(String... args) throws Exception {
		Board board = new Board();
		LocalDateTime dateTimeNow = LocalDateTime.now();
		board.setTitle("test1");
		board.setBoardNum(1);
		board.setInsertTime(dateTimeNow);
		board.setContent("test123123");
		board.setAuthor("seok");
		boardRepository.save(board);

		Board board1 = new Board();
		LocalDateTime dateTimeNow1 = LocalDateTime.now();
		board1.setTitle("test2");
		board1.setBoardNum(2);
		board1.setInsertTime(dateTimeNow);
		board1.setContent("test22222");
		board1.setAuthor("do");
		boardRepository.save(board1);
	}
}
