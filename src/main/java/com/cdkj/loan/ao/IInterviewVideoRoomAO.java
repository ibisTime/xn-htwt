package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InterviewVideoRoom;
import com.cdkj.loan.dto.req.XN632950Req;
import com.cdkj.loan.dto.req.XN632951Req;
import com.cdkj.loan.dto.req.XN632952Req;
import com.cdkj.loan.dto.req.XN632954Req;
import com.cdkj.loan.dto.req.XN632955Req;

@Component
public interface IInterviewVideoRoomAO {
    static final String DEFAULT_ORDER_COLUMN = "create_datetime";

    public String addInterviewVideoRoom(XN632950Req req);

    public int dropInterviewVideoRoom(String code);

    public int editInterviewVideoRoom(InterviewVideoRoom data);

    public Paginable<InterviewVideoRoom> queryInterviewVideoRoomPage(int start,
            int limit, InterviewVideoRoom condition);

    public List<InterviewVideoRoom> queryInterviewVideoRoomList(
            InterviewVideoRoom condition);

    public InterviewVideoRoom getInterviewVideoRoom(String code);

    // 混流
    public Object hlInterviewVideo(XN632951Req req);

    // 查询录制文件
    public Object foundHlVideo(XN632952Req req);

    // 面签视频：查询房间业务是否有房间
    public Object foundRoomByBudgetOder(XN632954Req req);

    // 销毁房间
    public void destroyRoom(XN632955Req req);

}
