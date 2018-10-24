package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.InterviewVideoRoom;

//dao层 
public interface IInterviewVideoRoomDAO extends IBaseDAO<InterviewVideoRoom> {
    String NAMESPACE = IInterviewVideoRoomDAO.class.getName().concat(".");

    int update(InterviewVideoRoom data);
}
