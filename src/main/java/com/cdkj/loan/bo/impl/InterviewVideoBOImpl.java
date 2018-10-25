package com.cdkj.loan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IInterviewVideoBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.IInterviewVideoDAO;
import com.cdkj.loan.domain.InterviewVideo;
import com.cdkj.loan.exception.BizException;

@Component
public class InterviewVideoBOImpl extends PaginableBOImpl<InterviewVideo>
        implements IInterviewVideoBO {

    @Autowired
    private IInterviewVideoDAO interviewVideoDAO;

    public void saveInterviewVideo(InterviewVideo data) {
        interviewVideoDAO.insert(data);
    }

    @Override
    public int removeInterviewVideo(int id) {
        int count = 0;
        if (id != 0) {
            InterviewVideo data = new InterviewVideo();
            data.setId(id);
            count = interviewVideoDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<InterviewVideo> queryInterviewVideoList(
            InterviewVideo condition) {
        return interviewVideoDAO.selectList(condition);
    }

    @Override
    public InterviewVideo getInterviewVideo(int id) {
        InterviewVideo data = null;
        if (id != 0) {
            InterviewVideo condition = new InterviewVideo();
            condition.setId(id);
            data = interviewVideoDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "面签视频id不存在！");
            }
        }
        return data;
    }

    @Override
    public InterviewVideo getInterviewVideoByRoomCode(String roomCode) {
        InterviewVideo condition = new InterviewVideo();
        condition.setRoomCode(roomCode);
        return interviewVideoDAO.select(condition);
    }

    @Override
    public InterviewVideo getInterviewVideoByFileId(String fileId) {
        InterviewVideo condition = new InterviewVideo();
        condition.setFileId(fileId);
        return interviewVideoDAO.select(condition);
    }
}
