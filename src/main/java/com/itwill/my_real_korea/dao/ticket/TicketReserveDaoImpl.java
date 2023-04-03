package com.itwill.my_real_korea.dao.ticket;

import com.itwill.my_real_korea.dto.ticket.TicketReserve;
import com.itwill.my_real_korea.mapper.TicketReserveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketReserveDaoImpl implements TicketReserveDao {

    private final TicketReserveMapper ticketReserveMapper;
    @Autowired
    public TicketReserveDaoImpl(TicketReserveMapper ticketReserveMapper) {
    	this.ticketReserveMapper = ticketReserveMapper;
    }

	@Override
	public int insertTicketReserve(TicketReserve ticketReserve) throws Exception {
		return ticketReserveMapper.insertTicketReserve(ticketReserve);
	}

	@Override
	public List<TicketReserve> selectByTicketReserveUser(String userId) throws Exception {
		return ticketReserveMapper.selectByTicketReserveUser(userId);
	}

	@Override
	public List<TicketReserve> selectByTicketReserveNo(int tiRsNo) throws Exception {
		return ticketReserveMapper.selectByTicketReserveNo(tiRsNo);
	}

	@Override
	public int deleteTicketReserve(int tiRsNo) throws Exception {
		return ticketReserveMapper.deleteTicketReserve(tiRsNo);
	}

	@Override
	public TicketReserve selectTicketReserveTest(int tiRsNo) throws Exception {
		return null;
	}


}
