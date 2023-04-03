package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.chat.ChatMsg;
import com.itwill.my_real_korea.dto.chat.ChatRoom;
import com.itwill.my_real_korea.dto.notice.Notice;
import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.chat.ChatService;

import ch.qos.logback.core.joran.conditional.IfAction;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class ChatRestController {

	@Autowired
	private ChatService chatService;
	
	/*
	 * chatRoom
	 */
	
	// 채팅방 목록 보기 
	@LoginCheck
	@ApiOperation(value = "채팅방 리스트")
	@GetMapping(value = "/chatroom", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatroom_list(@RequestParam(required = true) String userId) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatRoom> data = new ArrayList<>();
		try {
			// userId로 채팅방 리스트 찾기, 성공시 code 1
			data = chatService.selectAll(userId);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	// 채팅방 목록 선택 기능 (roomNo로 채팅방 1개 보기)
	@LoginCheck
	@ApiOperation(value = "채팅방 상세보기")
	@ApiImplicitParam(name = "roomNo", value = "채팅방 번호")
	@GetMapping(value = "/chatroom/{roomNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatroom_detail(@PathVariable(value = "roomNo") int roomNo,
												HttpSession session ) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatRoom> data = new ArrayList<>();

		try {
			// roomNo로 채팅방 1개 찾기, 성공시 code 1
			ChatRoom chatRoom = chatService.selectCheckByRoomNo(roomNo);
			// 요청한 userId : session에서 찾기
			String userId = (String)session.getAttribute("sUserId");
			if (chatRoom != null) {
				// 읽지 않은 메세지가 있다면, 메세지 읽음으로 변경
				int notReadMsg = chatService.countNotReadMsg(roomNo, userId);
				if(notReadMsg != 0) {
					chatService.updateReadMsg(roomNo, userId);
				}
				code = 1;
				data.add(chatRoom);
			} else {
				// 실패 시 code 2
				code = 2;
				msg = "해당 채팅방이 존재하지 않습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 에러 발생 시 code 3
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);

		return resultMap;
	}
	
	// 채팅방 생성 
	@LoginCheck
	@ApiOperation(value = "채팅방 생성")
	@PostMapping(value = "/chatroom", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatroom_create_action(@RequestBody ChatRoom chatRoom,
														HttpSession session){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatRoom> data = new ArrayList<>();
		
		// 채팅방 생성 요청하는 유저
		String fromId = (String)session.getAttribute("sUserId");
		// 채팅방 생성의 toId 로 설정된 유저
		String toId = chatRoom.getToId();
		// fromId와 toId가 동일한 채팅방 중복 확인
		boolean isDuplicate = chatService.duplicateCheck(fromId, toId);
		
		try {
			// 채팅방 중복 시 code 2
			if (isDuplicate) {
				code = 2;
				msg = "채팅방이 이미 존재합니다.";
			} else {
				// 채팅방 생성, 성공시 code 1
				chatService.insertChatRoom(chatRoom);
				code = 1;
				msg = "성공";
				// 채팅방 생성 후 그 채팅방 찾아서 데이터에 붙여줌
				chatRoom = chatService.selectCheckByRoomNo(chatRoom.getRoomNo());
				data.add(chatRoom);
			}
		} catch (Exception e) {
			// 실패 시 code 3
			e.printStackTrace();
			code = 3;
			msg = "채팅방 생성 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	
	// 채팅방 삭제 
	@LoginCheck
	@ApiOperation(value = "채팅방 삭제")
	@ApiImplicitParam(name = "roomNo", value = "채팅방 번호")
	@DeleteMapping(value = "/chatroom/{roomNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatroom_delete_action(@PathVariable(value="roomNo") int roomNo) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatRoom> data = new ArrayList<>();
		try {
			// roomNo로 채팅방 삭제, 성공시 code 1
			int rowCount = chatService.deleteChatRoom(roomNo);
			if (rowCount != 0) {
				code = 1;
				msg = "성공";
			} else {
				// 실패시 code 2
				code = 2;
				msg = "채팅방 삭제 실패";
				// 삭제 실패한 roomNo 데이터에 붙여줌
				ChatRoom failChatRoom = chatService.selectCheckByRoomNo(roomNo);
				data.add(failChatRoom);
			}
		} catch (Exception e) {
			// 에러시 code 3
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의바랍니다.";
			
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	
	/*
	 * chatMsg
	 */
	// 채팅방 1개의 전체 대화보기 
	@LoginCheck
	@ApiOperation(value = "채팅방 1개의 메세지 리스트")
	@GetMapping(value = "/chatmsg", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatmsg_list(@RequestParam(required = true) int roomNo) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatMsg> data = new ArrayList<>();
		try {
			// roomNo로 채팅방 1개의 메세지 리스트 찾기, 성공시 code 1
			data = chatService.selectByRoomNo(roomNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}

	// 채팅 메세지 1개 보기 
	@LoginCheck
	@ApiOperation(value = "채팅메세지 1개 상세보기")
	@ApiImplicitParam(name = "msgNo", value = "채팅메세지 번호")
	@GetMapping(value = "/chatmsg/{msgNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatmsg_detail(@PathVariable(value = "msgNo") int msgNo, HttpSession session) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatMsg> data = new ArrayList<>();

		try {
			// msgNo로 채팅메세지 1개 찾기, 성공시 code 1
			ChatMsg chatMsg = chatService.selectByMsgNo(msgNo);
			// 요청한 userId : session에서 찾기
			String userId = (String) session.getAttribute("sUserId");
			if (chatMsg != null) {
				// 읽지 않은 메세지가 있다면, 메세지 읽음으로 변경
				int notReadMsg = chatService.countNotReadMsg(chatMsg.getRoomNo(), userId);
				if (notReadMsg != 0) {
					chatService.updateReadMsg(chatMsg.getRoomNo(), userId);
				}
				code = 1;
				data.add(chatMsg);
			} else {
				// 실패 시 code 2
				code = 2;
				msg = "해당 채팅메세지가 존재하지 않습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 에러 발생 시 code 3
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);

		return resultMap;
	}
	
	// 채팅방 1개의 읽지 않은 메세지 리스트 보기
	@LoginCheck
	@ApiOperation(value = "채팅방 1개의 읽지 않은 메세지 리스트")
	@GetMapping(value = "/chatmsg-not-read", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatmsg_not_read_list(@RequestParam(required = true) int roomNo,
													@RequestParam(required = true) String userId) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatMsg> data = new ArrayList<>();
		try {
			// roomNo, userId로 채팅방 1개의 읽지 않은 메세지 리스트 찾기, 성공시 code 1
			data = chatService.selectNotReadMsg(roomNo, userId);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}

	// 읽지 않은 메세지 전체 보기
	@LoginCheck
	@ApiOperation(value = "읽지 않은 메세지 전체 리스트")
	@GetMapping(value = "/chatmsg-all-not-read", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatmsg_all_not_read_list(@RequestParam(required = true) String userId) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatMsg> data = new ArrayList<>();
		try {
			// userId로 읽지 않은 메세지 전체 리스트 찾기, 성공시 code 1
			data = chatService.selectAllNotReadMsg(userId);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	// 채팅 메세지 1개 삭제 
	@LoginCheck
	@ApiOperation(value = "채팅메세지 삭제")
	@ApiImplicitParam(name = "msgNo", value = "채팅메세지 번호")
	@DeleteMapping(value = "/chatmsg/{msgNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatmsg_delete_action(@PathVariable(value="msgNo") int msgNo,
													HttpSession session) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatMsg> data = new ArrayList<>();
		try {
			// 삭제 요청한 userId : session에서 찾기
			String userId = (String) session.getAttribute("sUserId");
			// 해당 채팅메세지를 전송했던 userId 찾기
			ChatMsg chatMsg = chatService.selectByMsgNo(msgNo);
			String chatMsgUserId = chatMsg.getUserId();
			
			// 채팅메세지 전송한 userId = 삭제 요청한 userId 라면 메세지 삭제 시도
			if (userId.equals(chatMsgUserId)) {
				// msgNo로 채팅메세지 삭제, 성공시 code 1
				int rowCount = chatService.deleteChatMsg(msgNo);
				if (rowCount != 0) {
					code = 1;
					msg = "성공";
				} else {
					// 실패시 code 2
					code = 2;
					msg = "채팅메세지 삭제 실패";
					// 삭제 실패한 roomNo 데이터에 붙여줌
					ChatMsg failChatMsg = chatService.selectByMsgNo(msgNo);
					data.add(failChatMsg);
				}
			} else {
				// 다른 userId가 삭제 요청할 경우 code 3
				code = 3;
				msg = "메세지 삭제가 불가능합니다.";
			}
		} catch (Exception e) {
			// 에러시 code 4
			e.printStackTrace();
			code = 4;
			msg = "관리자에게 문의바랍니다.";
			
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	// 채팅 메세지 생성 
	@LoginCheck
	@ApiOperation(value = "채팅메세지 생성")
	@PostMapping(value = "/chatmsg", produces = "application/json;charset=UTF-8")
	public Map<String, Object> chatmsg_create_action(@RequestBody ChatMsg chatMsg){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<ChatMsg> data = new ArrayList<>();
		
		try {
			// 채팅 메세지 생성 , 성공시 code 1
			chatService.insertChatMsg(chatMsg);
			code = 1;
			msg = "성공";
			// 채팅 메세지 생성 후 그 채팅방 찾아서 데이터에 붙여줌
			chatMsg = chatService.selectByMsgNo(chatMsg.getMsgNo());
			data.add(chatMsg);
		} catch (Exception e) {
			// 실패 시 code 2
			e.printStackTrace();
			code = 2;
			msg = "채팅 메세지 생성 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	
	
	
	
	
}
