package com.cdkj.loan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.bo.IInterviewVideoBO;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.InterviewVideo;

@Controller
public class interviewVideoController {
    // private static Logger logger = Logger.getLogger(MobileReportDemo.class);

    @Autowired
    private IInterviewVideoBO interviewVideoBO;

    @RequestMapping(value = "/interviewVideo", method = RequestMethod.POST)
    public void doClockIn(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("===========回调面签视频方法开始执行============");

        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while ((str = br.readLine()) != null) {
            wholeStr += str;
        }
        JSONObject json = JSONObject.parseObject(wholeStr);
        System.out.println(json.toJSONString());

        Integer eventType = json.getInteger("event_type");

        String videoUrl = json.getString("video_url");
        String fileSize = json.getString("file_size");
        String startTime = json.getString("start_time");
        String endTime = json.getString("end_time");
        String fileId = json.getString("file_id");
        String fileFormat = json.getString("file_format");

        // System.out.println("event_type:" + eventType);
        // System.out.println("stream_id:" + streamId);
        // System.out.println("video_url:" + videoUrl);
        // System.out.println("file_size:" + fileSize);
        // System.out.println("start_time:" + startTime);
        // System.out.println("end_time:" + endTime);
        // System.out.println("file_id:" + fileId);
        // System.out.println("file_format:" + fileFormat);

        String streamId = json.getString("stream_id");

        String string = json.getString("stream_param");
        String[] split = string.split("&");
        String groupid = split[6];
        // System.out.println("groupid--->" + groupid);
        String roomcode = groupid.substring(8);
        System.out.println("roomcode--->" + roomcode);

        if (eventType == 1) {
            InterviewVideo video = interviewVideoBO
                .getInterviewVideoByStreamId(streamId);
            // System.out.println("video:" + video);
            if (video == null) {
                InterviewVideo interviewVideo = new InterviewVideo();
                interviewVideo.setRoomCode(roomcode);
                interviewVideo.setStreamId(streamId);
                interviewVideoBO.saveInterviewVideo(interviewVideo);
            }
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.append("{\"code\":0}");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (eventType == 100) {
            System.out.println("=====进入判断=====");
            InterviewVideo data = interviewVideoBO
                .getInterviewVideoByStreamId(streamId);
            // System.out.println("video:" + video);
            data.setRoomCode(roomcode);
            data.setStreamId(streamId);
            data.setVideoUrl(videoUrl);
            data.setFileSize(fileSize);
            data.setStartTime(DateUtil.unixToTime(startTime));
            data.setEndTime(DateUtil.unixToTime(endTime));
            data.setFileId(fileId);
            data.setFileFormat(fileFormat);
            // interviewVideoBO.re(data);
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.append("{\"code\":0}");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("===========回调面签视频方法结束============");
    }
}
