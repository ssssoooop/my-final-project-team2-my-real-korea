package com.itwill.my_real_korea.service.chat;

import java.util.List;

import com.itwill.my_real_korea.dto.chat.ChatMsg;
import com.itwill.my_real_korea.dto.chat.ChatRoom;

public interface ChatService {

	/*
	 * chatRoom
	 */
	
	// 채팅방 목록 보기 
	List<ChatRoom> selectAll(String userId);
	
	// 채팅방 목록 선택 기능 (roomNo로 채팅방 1개 보기)
	ChatRoom selectCheckByRoomNo(int roomNo);
	
	// from_id, to_id로 채팅방 번호 찾기
	int chatRoomNoSearchById(String fromId, String toId);
	
	// 채팅 생성 중복 체크
	boolean duplicateCheck(String fromId, String toId);
	
	// 채팅방 생성 
	int insertChatRoom(ChatRoom chatRoom);
	
	// 채팅방 삭제 
	int deleteChatRoom(int roomNo);
	
	// 1개의 채팅방 안 읽은 메세지 수
	int countNotReadInChatRoom(int roomNo, String userId);	
	
	/*
	 * chatMsg
	 */
	// 채팅방 1개의 전체 대화보기 
	List<ChatMsg> selectByRoomNo(int roomNo);
	
	// 채팅 메세지 1개 보기 
	ChatMsg selectByMsgNo(int msgNo);
	
	// 채팅방 1개의 읽지 않은 메세지 보기
	List<ChatMsg> selectNotReadMsg(int roomNo, String userId);
	
	// 채팅방 1개의 읽지 않은 메세지 수 
	int countNotReadMsg(int roomNo, String userId);
	
	// 읽지 않은 메세지 전체 보기
	List<ChatMsg> selectAllNotReadMsg(String userId);
	
	// 읽지 않은 메세지 총 개수 
	int countAllNotReadMsg(String userId);
	
	// 메세지 읽음으로 변경 
	int updateReadMsg(int roomNo, String userId);
	
	// 채팅 메세지 1개 삭제 
	int deleteChatMsg(int msgNo);
	
	// 채팅 메세지 삭제 시 메세지 대체 
	int updateDeletedMsg(int msgNo);
	
	// 채팅 메세지 생성 
	int insertChatMsg(ChatMsg chatMsg);

	
}
