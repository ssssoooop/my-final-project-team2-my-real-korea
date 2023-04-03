package com.itwill.my_real_korea.service.ticket;

import com.itwill.my_real_korea.dao.ticket.TicketImgDao;
import com.itwill.my_real_korea.dto.ticket.TicketImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketImgServiceImpl implements TicketImgService{

    private final TicketImgDao ticketImgDao;

    @Autowired
    public TicketImgServiceImpl(TicketImgDao ticketImgDao) {
        this.ticketImgDao = ticketImgDao;
    }

    @Override
    public int insertTicketImg(TicketImg ticketImg) throws Exception {
        return ticketImgDao.insertTicketImg(ticketImg);
    }

    @Override
    public List<TicketImg> selectTicketImgList(int tiNo) {
        return ticketImgDao.selectTicketImgList(tiNo);
    }

    @Override
    public int updateTicketImg(TicketImg ticketImg) {
        return ticketImgDao.updateTicketImg(ticketImg);
    }

    @Override
    public int deleteTicketImg(int tiImgNo) {
        return ticketImgDao.deleteTicketImg(tiImgNo);
    }
}
