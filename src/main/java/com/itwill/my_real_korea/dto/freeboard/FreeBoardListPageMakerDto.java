package com.itwill.my_real_korea.dto.freeboard;

import java.util.List;
import com.itwill.my_real_korea.util.PageMaker;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreeBoardListPageMakerDto {
	private List<FreeBoard> itemList;
	private PageMaker pageMaker;
}
