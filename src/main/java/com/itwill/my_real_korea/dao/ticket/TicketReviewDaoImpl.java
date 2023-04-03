package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.mapper.TicketReviewMapper;

@Repository
public class TicketReviewDaoImpl implements TicketReviewDao{

    private final TicketReviewMapper ticketReviewMapper;
    @Autowired
    public TicketReviewDaoImpl(TicketReviewMapper ticketReviewMapper ) {
            this.ticketReviewMapper = ticketReviewMapper;
    }
    @Override
    public int insertTicketReview(TicketReview ticketReview) {
        return ticketReviewMapper.insertTicketReview(ticketReview);
    }

    @Override
    public List<TicketReview> selectByTicketReview(int tiReviewNo) {
        return ticketReviewMapper.selectByTicketReview(tiReviewNo);
    }

    @Override
    public List<TicketReview> selectByTicketReviewUser(String userId) {
        return ticketReviewMapper.selectByTicketReviewUser(userId);
    }

    @Override
    public int updateTicketReview(TicketReview ticketReview) {
        return ticketReviewMapper.updateTicketReview(ticketReview);
    }

    @Override
    public int deleteTicketReview(int tiReviewNo) {
        return ticketReviewMapper.deleteTicketReview(tiReviewNo);
    }
}
