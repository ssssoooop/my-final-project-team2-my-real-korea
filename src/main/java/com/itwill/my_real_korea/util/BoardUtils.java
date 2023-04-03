package com.itwill.my_real_korea.util;

import java.util.Iterator;

import com.itwill.my_real_korea.dto.notice.Notice;


public class BoardUtils {
	/*
	 * \r\n 을 html의 <br>로 convert한다
	 */
	public static String convertHtmlBr(String comment) {
		if (comment == null) {
			return "";
		}
		int length = comment.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			String tmp = comment.substring(i, i+1);
			if ("\r".compareTo(tmp) == 0) {
				tmp = comment.substring(++i, i+1);
				if ("\n".compareTo(tmp) == 0) {
					buffer.append("<br>\r");
				}else {
					buffer.append("\r");
				}
			}buffer.append(tmp);
		}
		return buffer.toString();
	}
	/*
	 * 게시글, 답글의 title 출력 설정
	 */
	public String getTitleString(Notice notice) {
		StringBuilder title = new StringBuilder(128);
		String t = notice.getNTitle();
		if (t.length() > 15) {
			t = String.format("%s...", t.substring(0, 15));
		}
	
		title.append(t.replace(" ", "&nbsp;"));
		return title.toString();
	}
	
}
