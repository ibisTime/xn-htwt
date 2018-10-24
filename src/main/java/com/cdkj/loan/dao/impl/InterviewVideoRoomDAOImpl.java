package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IInterviewVideoRoomDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.InterviewVideoRoom;

@Repository("interviewVideoRoomDAOImpl")
public class InterviewVideoRoomDAOImpl extends AMybatisTemplate
        implements IInterviewVideoRoomDAO {

    @Override
    public int insert(InterviewVideoRoom data) {
        return super.insert(NAMESPACE.concat("insert_interviewVideoRoom"),
            data);
    }

    @Override
    public int delete(InterviewVideoRoom data) {
        return super.delete(NAMESPACE.concat("delete_interviewVideoRoom"),
            data);
    }

    @Override
    public int update(InterviewVideoRoom data) {
        return super.update(NAMESPACE.concat("update_interviewVideoRoom"),
            data);
    }

    @Override
    public InterviewVideoRoom select(InterviewVideoRoom condition) {
        return super.select(NAMESPACE.concat("select_interviewVideoRoom"),
            condition, InterviewVideoRoom.class);
    }

    @Override
    public long selectTotalCount(InterviewVideoRoom condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_interviewVideoRoom_count"), condition);
    }

    @Override
    public List<InterviewVideoRoom> selectList(InterviewVideoRoom condition) {
        return super.selectList(NAMESPACE.concat("select_interviewVideoRoom"),
            condition, InterviewVideoRoom.class);
    }

    @Override
    public List<InterviewVideoRoom> selectList(InterviewVideoRoom condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_interviewVideoRoom"),
            start, count, condition, InterviewVideoRoom.class);
    }

}
