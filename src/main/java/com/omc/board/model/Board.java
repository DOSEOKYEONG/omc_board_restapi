package com.omc.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board")
public class Board {

    /** 번호 (PK) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 게시판분류 */
    @Column(name = "board_num")
    private int boardNum;

    /** 제목 */
    @Column(name = "title")
    private String title;

    /** 내용 */
    @Column(name = "content")
    private String content;

    /** 작성자 */
    @Column(name = "author")
    private String author;

    /** 조회 수 */
    @Column(name = "view_cnt")
    private int viewCnt;

    /** 추천 수 */
    @Column(name = "recommend")
    private int recommend;

    /** 등록일 */
    @Column(name = "insert_time")
    private LocalDateTime insertTime;

    /** 수정일 */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
}
