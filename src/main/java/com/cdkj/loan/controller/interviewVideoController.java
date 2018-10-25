package com.cdkj.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
        System.out.println("===========回调面签视频方法开始执行============");

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
        System.out.println("event_type:" + eventType[0]);
        System.out.println("stream_id:" + streamId[0]);
        System.out.println("video_url:" + videoUrl[0]);
        System.out.println("file_size:" + fileSize[0]);
        System.out.println("start_time:" + startTime[0]);
        System.out.println("end_time:" + endTime[0]);
        System.out.println("file_id:" + fileId[0]);
        System.out.println("file_format:" + fileFormat[0]);

        System.out.println("token:" + token[0]);

        if ("100".equals(eventType[0])) {
            InterviewVideo video = interviewVideoBO
                .getInterviewVideoByFileId(fileId[0]);
            System.out.println("video:" + video);
            if (video == null) {
                InterviewVideo interviewVideo = new InterviewVideo();
                interviewVideo.setRoomCode(streamId[0]);
                interviewVideo.setVideoUrl(videoUrl[0]);
                interviewVideo.setFileSize(fileSize[0]);
                interviewVideo.setStartTime(DateUtil.strToDate(startTime[0],
                    DateUtil.DATA_TIME_PATTERN_1));
                interviewVideo.setEndTime(DateUtil.strToDate(endTime[0],
                    DateUtil.DATA_TIME_PATTERN_1));
                interviewVideo.setFileId(fileId[0]);
                interviewVideo.setFileFormat(fileFormat[0]);
                interviewVideoBO.saveInterviewVideo(interviewVideo);
                System.out.println("执行了保存方法！");
            }
            System.out.println("videoUrl:" + videoUrl[0]);
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.append("0");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("===========回调面签视频方法结束============");
    }
}
