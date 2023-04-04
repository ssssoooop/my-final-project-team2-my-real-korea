package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dao.freeboard.FreeBoardDao;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardListPageMakerDto;
import com.itwill.my_real_korea.util.PageMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
    private FreeBoardDao freeBoardDao;

    @Autowired
    public FreeBoardServiceImpl(FreeBoardDao freeBoardDao) {
        this.freeBoardDao = freeBoardDao;
    }

    @Override
    public int insertBoard(FreeBoard freeBoard) throws Exception {
        return freeBoardDao.insertBoard(freeBoard);
    }

    @Override
    public FreeBoard selectByNo(int fBoNo) throws Exception {
        		freeBoardDao.increaseReadCount(fBoNo);
        return freeBoardDao.selectByNo(fBoNo);
    }

    @Override
    public int updateFreeBoard(FreeBoard freeBoard) throws Exception {
        return freeBoardDao.updateBoard(freeBoard);
    }

    @Override
    public int deleteFreeBoard(int no) throws Exception {
        return freeBoardDao.deleteBoard(no);
    }
    //조회수 증가
    @Override
    public int increaseReadCount(int no) throws Exception {
        return freeBoardDao.increaseReadCount(no);
    }
    //자유게시판 게시글 수
    @Override
    public int selectFreeBoardCount() throws Exception {
        return freeBoardDao.selectFreeBoardCount();
    }
    //키워드로 검색시 게시글수 조회
    @Override
    public int selectSearchCount(String keyword) throws Exception {
        return freeBoardDao.selectSearchCount(keyword);
    }
    //자유게시판 최신순 정렬
    @Override
    public FreeBoardListPageMakerDto selectAllOrderByFBoNoDesc(int currentPage) throws Exception {
        int totalRecordCount = freeBoardDao.selectFreeBoardCount();

        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);

        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByFBoNoDesc(pageMaker.getPageBegin(), pageMaker.getPageEnd());

        FreeBoardListPageMakerDto pageMakerBoardList = new FreeBoardListPageMakerDto();

        pageMakerBoardList.setItemList(freeBoardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }
    //자유게시판 오래된순 정렬
    @Override
    public FreeBoardListPageMakerDto selectAllOrderByFBoNoAsc(int currentPage) throws Exception {
        int totalRecordCount = freeBoardDao.selectFreeBoardCount();

        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);

        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByFBoNoAsc(pageMaker.getPageBegin(), pageMaker.getPageEnd());

        FreeBoardListPageMakerDto pageMakerBoardList = new FreeBoardListPageMakerDto();

        pageMakerBoardList.setItemList(freeBoardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }
    //자유게시판 조회수 정렬
    @Override
    public FreeBoardListPageMakerDto selectAllOrderByReadCountDesc(int currentPage) throws Exception {
        int totalRecordCount = freeBoardDao.selectFreeBoardCount();

        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);

        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByReadCountDesc(pageMaker.getPageBegin(), pageMaker.getPageEnd());
        FreeBoardListPageMakerDto pageMakerBoardList = new FreeBoardListPageMakerDto();
        pageMakerBoardList.setItemList(freeBoardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }

    //자유게시판 타이틀 14글자 제한
    @Override
    public String getTitleString(FreeBoard freeBoard) throws Exception {
        StringBuilder title = new StringBuilder(128);
        String t = freeBoard.getFBoTitle();
        if (t.length() > 15) {
            t = String.format("%s...", t.substring(0, 15));
        }
        title.append(t.replace(" ", "&nbsp;"));
        return title.toString();
    }

    //자유게시판 키워드 검색으로 게시글 리스트 보기
    @Override
    public FreeBoardListPageMakerDto selectSearchFreeBoardList(int currentPage, String keyword) throws Exception {
        int totalRecordCount = freeBoardDao.selectSearchCount(keyword);
        // paging 계산 (PageMaker)
        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
        // 게시글 데이터 얻기
        List<FreeBoard> freeboardList = freeBoardDao.selectSearchFreeBoardList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), keyword);
        FreeBoardListPageMakerDto pageMakerBoardList = new FreeBoardListPageMakerDto();
        pageMakerBoardList.setItemList(freeboardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }
}
