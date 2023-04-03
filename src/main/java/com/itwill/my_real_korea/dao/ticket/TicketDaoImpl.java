package com.itwill.my_real_korea.dao.ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.mapper.TicketMapper;

@Repository
public class TicketDaoImpl implements TicketDao{
	
	private final TicketMapper ticketMapper;
	
	@Autowired
	public TicketDaoImpl(TicketMapper ticketMapper) {
		this.ticketMapper = ticketMapper;
	}

	//티켓생성
	@Override
	public int insertTicket(Ticket ticket) throws Exception {
		return ticketMapper.insertTicket(ticket);
	}
	//상품 상세보기 - 지역 + 사진
	@Override
	public List<Ticket> selectByTicketNoCityWithImg(int tiNo) throws Exception {
		return ticketMapper.selectByTicketNoCityWithImg(tiNo);
	}
	
	// 전체 목록 + 정렬 - 페이징
	@Override
	public List<Ticket> selectAllTicket(int pageStart, int pageEnd, String sortOrder) throws Exception {
		Map<String, Object> ticketPageMap = new HashMap<>();
		ticketPageMap.put("pageStart", pageStart);
		ticketPageMap.put("pageEnd",pageEnd);
		ticketPageMap.put("sortOrder",sortOrder);
		return ticketMapper.selectAllTicket(ticketPageMap);
	}

	// 키워드, 지역, 가격 + 전체 LIST - 페이징 처리
	@Override
	public List<Ticket> selectByTicketAllSort(int pageStart, int pageEnd,
											  String keyword,
											  int cityNo, String sortOrder) throws Exception {
		
		Map<String, Object> selectMap = new HashMap<>();
		selectMap.put("pageStart",pageStart);
		selectMap.put("pageEnd",pageEnd);
		selectMap.put("keyword", keyword);
		selectMap.put("cityNo", cityNo);
		selectMap.put("sortOrder",sortOrder);

		return ticketMapper.selectByTicketAllSort(selectMap);
	}

	

	//티켓 수정
	@Override
	public int updateTicket(Ticket ticket) throws Exception {
		return ticketMapper.updateTicket(ticket);
	}
	//티켓 삭제
	@Override
	public int deleteTicket(int tiNo) throws Exception {
		return ticketMapper.deleteTicket(tiNo);
	}
	
	//티켓 글 조회
	@Override
	public int selectAllTicketCount() throws Exception {
		return ticketMapper.selectAllTicketCount();
	}

	@Override
	public Ticket selectTicketNo(int tiNo) {
		return ticketMapper.selectTicketNo(tiNo);
	}


}


/*****
 *
 *    //@Override
 *    public List<Ticket> selectByTicketCity(int pageStart, int pageEnd, int cityNo) throws Exception {
 * 		return ticketMapper.selectByTicketCity(cityNo);
 *    }
 *
  //@Override
         public List<Ticket> selectAllTicket(int pageStart, int pageEnd) throws Exception {

  		Map<String, Object> ticketpageMap = new HashMap<>();
  		ticketpageMap.put("pageStart", pageStart);
  		ticketpageMap.put("pageEnd",pageEnd);
  		return ticketMapper.selectAllTicket(ticketpageMap);
     }
 *  상품 키워드로 검색
 * 	public List<Ticket> selectByKeywordTicket(int pageStart, int pageEnd, String keyword) throws Exception{
 * 		Map<String, Object> ticketKeywordPageMap = new HashMap<>();
 * 		ticketKeywordPageMap.put("pageStart", pageStart);
 * 		ticketKeywordPageMap.put("pageEnd",pageEnd);
 * 		ticketKeywordPageMap.put("keyword", keyword);
 *
 * 		return ticketMapper.selectByKeywordTicket(ticketKeywordPageMap);
 *    }
 *
 * 	 상품 가격 순으로 검색
 *   // @Override
 *    public List<Ticket> selectByTicketPrice(int pageStart, int pageEnd, String sortOrder) throws Exception {
 * 		// 가격 낮은 순 : asc 가격 높은 순 : desc
 * 		Map<String, Object> ticketPriceSortMap = new HashMap<>();
 * 		ticketPriceSortMap.put("pageStart", pageStart);
 * 		ticketPriceSortMap.put("pageEnd", pageEnd);
 * 		ticketPriceSortMap.put("sortOrder", sortOrder);
 * 		return ticketMapper.selectByTicketPrice(ticketPriceSortMap);
 *    }
 */