package com.itwill.my_real_korea.service.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.ticket.TicketReserveDao;
import com.itwill.my_real_korea.dto.ticket.TicketReserve;

@Service
public class TicketReserveServiceImpl implements TicketReserveService{

	private final TicketReserveDao ticketReserveDao;
	
	@Autowired
	public TicketReserveServiceImpl(TicketReserveDao ticketReserveDao) {
		this.ticketReserveDao = ticketReserveDao;
	}
	
	
	@Override
	public int insertTicketReserve(TicketReserve ticketReserve) throws Exception {
		
		return ticketReserveDao.insertTicketReserve(ticketReserve);
	}

	@Override
	public List<TicketReserve> selectByTicketReserveUser(String userId) throws Exception {
		return ticketReserveDao.selectByTicketReserveUser(userId);
	}

	@Override
	public List<TicketReserve> selectByTicketReserveNo(int tiRsNo) throws Exception {
		return ticketReserveDao.selectByTicketReserveNo(tiRsNo);
	}

	@Override
	public int deleteTicketReserve(int tiRsNo) throws Exception {
		return ticketReserveDao.deleteTicketReserve(tiRsNo);
	}
}
