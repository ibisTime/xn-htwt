package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InterviewVideo;
import com.cdkj.loan.dto.req.XN632953Req;

@Component
public interface IInterviewVideoAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void addInterviewVideo(InterviewVideo data);

    public int dropInterviewVideo(int id);

    public Paginable<InterviewVideo> queryInterviewVideoPage(int start,
            int limit, InterviewVideo condition);

    public List<InterviewVideo> queryInterviewVideoList(
            InterviewVideo condition);

    public InterviewVideo getInterviewVideo(int id);

    public Object foundRoomTotal(XN632953Req req);
}
