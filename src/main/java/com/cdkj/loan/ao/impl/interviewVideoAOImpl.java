package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IInterviewVideoAO;
import com.cdkj.loan.bo.IInterviewVideoBO;
import com.cdkj.loan.bo.IInterviewVideoRoomBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.domain.InterviewVideo;
import com.cdkj.loan.domain.InterviewVideoRoom;
import com.cdkj.loan.dto.req.XN632953Req;

@Service
public class interviewVideoAOImpl implements IInterviewVideoAO {

    @Autowired
    private IInterviewVideoBO interviewVideoBO;

    @Autowired
    private IInterviewVideoRoomBO interviewVedioRoomBO;

    @Override
    public void addInterviewVideo(InterviewVideo data) {
        interviewVideoBO.saveInterviewVideo(data);
    }

    @Override
    public int dropInterviewVideo(int id) {
        return interviewVideoBO.removeInterviewVideo(id);
    }

    @Override
    public Paginable<InterviewVideo> queryInterviewVideoPage(int start,
            int limit, InterviewVideo condition) {
        if (StringUtils.isNotBlank(condition.getBizCode())) {
            InterviewVideoRoom roomCondition = new InterviewVideoRoom();
            roomCondition.setBudgetCode(condition.getBizCode());
            List<InterviewVideoRoom> rooms = interviewVedioRoomBO
                .queryInterviewVideoRoomList(roomCondition);
            List<String> roomCodeList = new ArrayList<String>();
            for (InterviewVideoRoom room : rooms) {
                roomCodeList.add(room.getCode());
            }
            condition.setRoomCodeList(roomCodeList);
        }
        return interviewVideoBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<InterviewVideo> queryInterviewVideoList(InterviewVideo condition) {
        return interviewVideoBO.queryInterviewVideoList(condition);
    }

    @Override
    public InterviewVideo getInterviewVideo(int id) {
        return interviewVideoBO.getInterviewVideo(id);
    }

    @Override
    public Object foundRoomTotal(XN632953Req req) {
        InterviewVideo interviewVideo = new InterviewVideo();
        interviewVideo.setRoomCode(req.getRoomId());

        long i = interviewVideoBO.getTotalCount(interviewVideo);

        String bizId = "32810_"
                + MD5Util
                    .md5(req.getRoomId() + "_" + req.getUserId() + "_main");
        List<InterviewVideo> videoList = interviewVideoBO
            .queryInterviewVideoList(interviewVideo);
        if (CollectionUtils.isNotEmpty(videoList)) {
            for (InterviewVideo Video : videoList) {
                if (bizId.equals(Video.getStreamId())) {
                    i -= 1;
                }
            }
        }
        return i;
    }
}
