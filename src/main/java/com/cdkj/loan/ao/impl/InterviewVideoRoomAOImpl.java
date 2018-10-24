package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IInterviewVideoRoomAO;
import com.cdkj.loan.bo.IInterviewVideoRoomBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InterviewVideoRoom;
import com.cdkj.loan.dto.req.XN632950Req;

@Service
public class InterviewVideoRoomAOImpl implements IInterviewVideoRoomAO {

    @Autowired
    private IInterviewVideoRoomBO interviewVideoRoomBO;

    @Override
    @Transactional
    public String addInterviewVideoRoom(XN632950Req req) {
        InterviewVideoRoom data = new InterviewVideoRoom();
        data.setCreateDatetime(new Date());
        return interviewVideoRoomBO.saveInterviewVideoRoom(data);
    }

    @Override
    public int editInterviewVideoRoom(InterviewVideoRoom data) {
        return interviewVideoRoomBO.refreshInterviewVideoRoom(data);
    }

    @Override
    public int dropInterviewVideoRoom(String code) {
        return interviewVideoRoomBO.removeInterviewVideoRoom(code);
    }

    @Override
    public Paginable<InterviewVideoRoom> queryInterviewVideoRoomPage(int start,
            int limit, InterviewVideoRoom condition) {
        return interviewVideoRoomBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<InterviewVideoRoom> queryInterviewVideoRoomList(
            InterviewVideoRoom condition) {
        return interviewVideoRoomBO.queryInterviewVideoRoomList(condition);
    }

    @Override
    public InterviewVideoRoom getInterviewVideoRoom(String code) {
        return interviewVideoRoomBO.getInterviewVideoRoom(code);
    }
}
