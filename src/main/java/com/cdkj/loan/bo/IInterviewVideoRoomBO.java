package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.InterviewVideoRoom;




public interface IInterviewVideoRoomBO extends IPaginableBO<InterviewVideoRoom> {


	public String saveInterviewVideoRoom(InterviewVideoRoom data);


	public int removeInterviewVideoRoom(String code);


	public int refreshInterviewVideoRoom(InterviewVideoRoom data);


	public List<InterviewVideoRoom> queryInterviewVideoRoomList(InterviewVideoRoom condition);


	public InterviewVideoRoom getInterviewVideoRoom(String code);


}