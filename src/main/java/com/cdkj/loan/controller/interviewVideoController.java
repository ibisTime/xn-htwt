package com.cdkj.loan.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdkj.loan.bo.IInterviewVideoBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.InterviewVideo;

@Controller
public class interviewVideoController {
    // private static Logger logger = Logger.getLogger(MobileReportDemo.class);

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private IInterviewVideoBO interviewVideoBO;

    @RequestMapping(value = "/interviewVideo", method = RequestMethod.POST)
    public void doClockIn(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("===========回调方法开始执行============");

        Map<Object, Object> map = request.getParameterMap();

        String[] token = (String[]) map.get("token");
        String[] eventType = (String[]) map.get("event_type");
        String[] streamId = (String[]) map.get("stream_id");
        String[] videoUrl = (String[]) map.get("video_url");
        String[] fileSize = (String[]) map.get("file_size");
        String[] startTime = (String[]) map.get("start_time");
        String[] endTime = (String[]) map.get("end_time");
        String[] fileId = (String[]) map.get("file_id");
        String[] fileFormat = (String[]) map.get("file_format");

        System.out.println("token:" + token[0]);
        // System.out.println("bizType:" + bizType[0]);
        // System.out.println("uid:" + uid[0]);

        if ("100".equals(eventType[0])) {
            InterviewVideo interviewVideo = new InterviewVideo();
            interviewVideo.setRoomCode(streamId[0]);
            interviewVideo.setVideoUrl(videoUrl[0]);
            interviewVideo.setFileSize(fileSize[0]);
            interviewVideo.setStartTime(
                DateUtil.strToDate(startTime[0], DateUtil.DATA_TIME_PATTERN_1));
            interviewVideo.setEndTime(
                DateUtil.strToDate(endTime[0], DateUtil.DATA_TIME_PATTERN_1));
            interviewVideo.setFileId(fileId[0]);
            interviewVideo.setFileFormat(fileFormat[0]);
            interviewVideoBO.saveInterviewVideo(interviewVideo);
            System.out.println("videoUrl:" + videoUrl[0]);
        }
        System.out.println("===========回调方法结束============");
    }
}
