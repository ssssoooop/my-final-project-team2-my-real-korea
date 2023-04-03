
package com.itwill.my_real_korea.mapper;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface FreeBoardMapper {

 public int insertBoard(FreeBoard freeBoard) ;

 FreeBoard selectByNo(int fBoNo) ;

 List<FreeBoard> selectAllOrderByFBoNoDesc (Map<String, Object> pageMap) ;

 List<FreeBoard> selectAllOrderByFBoNoAsc (Map<String, Object> pageMap) ;

 List<FreeBoard> selectAllOrderByReadCountDesc (Map<String, Object> pageMap) ;

 int updateBoard(FreeBoard freeBoard) ;

 int deleteBoard(int no) ;

 int increaseReadCount(int no);
 /*
  * 공지사항 게시글 총 개수 조회
  */
 int selectFreeBoardCount() throws Exception;

 /*
  * 검색된 게시글 총 개수 조회
  */
 int selectSearchCount(String keyword) throws Exception;

 /*
  * 공지사항 게시판 title 키워드로 검색
  */
 List<FreeBoard> selectSearchFreeBoardList(Map<String, Object> keywordPageMap) throws Exception;
}
