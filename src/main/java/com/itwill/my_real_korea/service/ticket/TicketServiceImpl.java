package com.itwill.my_real_korea.service.ticket;

import com.itwill.my_real_korea.dao.ticket.TicketDao;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{


    private final TicketDao ticketDao;
    @Autowired
    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public int insertTicket(Ticket ticket) throws Exception {
        return ticketDao.insertTicket(ticket);
    }
    @Override
    public PageMakerDto<Ticket> selectAllTicket(int currentPage, String sortOrder) throws Exception {

        //ticket 전체 글 수
        int totTicketCount = ticketDao.selectAllTicketCount();
        //페이징
        PageMaker pageMaker = new PageMaker(totTicketCount, currentPage);
        List<Ticket> ticketList = ticketDao.selectAllTicket(pageMaker.getPageBegin(),pageMaker.getPageEnd(),sortOrder);

        return new PageMakerDto<Ticket>(ticketList, pageMaker, totTicketCount);
    }

    @Override
    public PageMakerDto<Ticket> selectByTicketAllSort(int currentPage, String keyword, int cityNo, String sortOrder) throws Exception {
        int totTicketCount = ticketDao.selectAllTicketCount(); // 전체 글
        PageMaker pageMaker = new PageMaker(totTicketCount, currentPage); // 현재 페이지
        List<Ticket> ticketSortList = ticketDao.selectByTicketAllSort // 필터 + 정렬
                                        (pageMaker.getPageBegin(), pageMaker.getPageEnd(),keyword, cityNo, sortOrder);

        return new PageMakerDto<Ticket>(ticketSortList,pageMaker,totTicketCount);
    }
    @Override
    public List<Ticket> selectByTicketNoCityWithImg(int tiNo) throws Exception {
        return ticketDao.selectByTicketNoCityWithImg(tiNo);
    }

    @Override
    public int updateTicket(Ticket ticket) throws Exception {
        return ticketDao.updateTicket(ticket);
    }

    @Override
    public int deleteTicket(int tiNo) throws Exception {
        return ticketDao.deleteTicket(tiNo);
    }

    @Override
    public int selectTicketCount() throws Exception {
        return ticketDao.selectAllTicketCount();
    }
    
	@Override
    public Ticket selectTicketNo(int tiNo) throws Exception{
    	return ticketDao.selectTicketNo(tiNo);
    }


}
