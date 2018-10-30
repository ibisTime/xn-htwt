package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.InterviewVideo;

public interface IInterviewVideoBO extends IPaginableBO<InterviewVideo> {

    public int saveInterviewVideo(InterviewVideo data);

    public int removeInterviewVideo(int id);

    public void refreshInterviewVideo(InterviewVideo data);

    public List<InterviewVideo> queryInterviewVideoList(
            InterviewVideo condition);

    public InterviewVideo getInterviewVideo(int id);

    public InterviewVideo getInterviewVideoByRoomCode(String roomCode);

    public InterviewVideo getInterviewVideoByFileId(String fileId);

    public InterviewVideo getInterviewVideoByStreamId(String channelId);

}
