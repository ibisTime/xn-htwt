package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IInterviewVideoRoomBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IInterviewVideoRoomDAO;
import com.cdkj.loan.domain.InterviewVideoRoom;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class InterviewVideoRoomBOImpl extends
        PaginableBOImpl<InterviewVideoRoom> implements IInterviewVideoRoomBO {

    @Autowired
    private IInterviewVideoRoomDAO interviewVideoRoomDAO;

    public String saveInterviewVideoRoom(InterviewVideoRoom data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.random7();
            data.setCode(code);
            interviewVideoRoomDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeInterviewVideoRoom(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            InterviewVideoRoom data = new InterviewVideoRoom();
            data.setCode(code);
            count = interviewVideoRoomDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshInterviewVideoRoom(InterviewVideoRoom data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = interviewVideoRoomDAO.update(data);
        }
        return count;
    }

    @Override
    public List<InterviewVideoRoom> queryInterviewVideoRoomList(
            InterviewVideoRoom condition) {
        return interviewVideoRoomDAO.selectList(condition);
    }

    @Override
    public InterviewVideoRoom getInterviewVideoRoom(String code) {
        InterviewVideoRoom data = null;
        if (StringUtils.isNotBlank(code)) {
            InterviewVideoRoom condition = new InterviewVideoRoom();
            condition.setCode(code);
            data = interviewVideoRoomDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "房间id不存在！");
            }
        }
        return data;
    }
}
