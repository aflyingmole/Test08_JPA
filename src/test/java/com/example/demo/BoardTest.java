package com.example.demo;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.Myuser;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MyUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Rollback(value = false)
public class BoardTest {
    @Autowired private BoardRepository br;
    @Autowired private MyUserRepository mr;

    @Test
    void save(){
        Optional<Myuser> mu = mr.findById("hello2");
        if (!mu.isEmpty()) {
            Myuser myuser = mu.get();
            br.save(new Board(0L, myuser, "test...","hi", null));
        }


    }
    @Test
    void listAll(){
        List<Board> list = br.findAll();
        list.forEach(board->{
            System.out.println("글번호" + board.getNum());
            System.out.println("작성자" + board.getUser().getUsername());
            System.out.println("글번호" + board.getTitle());
            System.out.println("글번호" + board.getContent());
            System.out.println("글번호" + board.getRegdate());
        });
    }
    @Test
    void list3(){
        List<BoardDto> list = br.list3();
        list.forEach(board->{
            System.out.println(board);
        });
    }

}
