package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cdkj.loan.ao.IInterviewVideoRoomAO;
import com.cdkj.loan.bo.IInterviewVideoBO;
import com.cdkj.loan.bo.IInterviewVideoRoomBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OkHttpUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.InterviewVideo;
import com.cdkj.loan.domain.InterviewVideoRoom;
import com.cdkj.loan.dto.req.XN632950Req;
import com.cdkj.loan.dto.req.XN632951Req;

@Service
public class InterviewVideoRoomAOImpl implements IInterviewVideoRoomAO {

    @Autowired
    private IInterviewVideoRoomBO interviewVideoRoomBO;

    @Autowired
    private IInterviewVideoBO interviewVideoBO;

    @Override
    @Transactional
    public String addInterviewVideoRoom(XN632950Req req) {
        InterviewVideoRoom data = new InterviewVideoRoom();
        data.setCreateDatetime(new Date());
        return interviewVideoRoomBO.saveInterviewVideoRoom(data);
    }

    @Override
    public int editInterviewVideoRoom(InterviewVideoRoom data) {
        return interviewVideoRoomBO.refreshInterviewVideoRoom(data);
    }

    @Override
    public int dropInterviewVideoRoom(String code) {
        return interviewVideoRoomBO.removeInterviewVideoRoom(code);
    }

    @Override
    public Paginable<InterviewVideoRoom> queryInterviewVideoRoomPage(int start,
            int limit, InterviewVideoRoom condition) {
        return interviewVideoRoomBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<InterviewVideoRoom> queryInterviewVideoRoomList(
            InterviewVideoRoom condition) {
        return interviewVideoRoomBO.queryInterviewVideoRoomList(condition);
    }

    @Override
    public InterviewVideoRoom getInterviewVideoRoom(String code) {
        return interviewVideoRoomBO.getInterviewVideoRoom(code);
    }

    @Override
    public Object hlInterviewVideo(XN632951Req req) {
        InterviewVideo condition = new InterviewVideo();
        condition.setRoomCode(req.getRoomId());
        List<InterviewVideo> videoList = interviewVideoBO
            .queryInterviewVideoList(condition);

        JSONArray inputList = new JSONArray();
        // 背景画面
        JSONObject jobl = new JSONObject();
        jobl.put("image_layer", "1");
        JSONObject job = new JSONObject();
        job.put("input_stream_id", videoList.get(0).getFileId());
        job.put("layout_params", jobl);
        inputList.add(job);
        int i = 1;
        for (int j = 1; j < videoList.size(); j++) {
            // 小画面
            JSONObject jox = new JSONObject();
            jox.put("input_stream_id", videoList.get(j).getFileId());
            JSONObject joxl = new JSONObject();
            joxl.put("image_layer", i + 1);
            joxl.put("image_width", "160");
            joxl.put("image_height", "240");
            joxl.put("location_x", "380");
            joxl.put("location_y", "630");
            jox.put("layout_params", joxl);
            inputList.add(jox);
        }

        JSONObject para = new JSONObject();
        para.put("app_id", "1257046543");
        para.put("interface", "start_mix_stream_advanced");
        para.put("mix_stream_session_id", req.getRoomId());
        para.put("output_stream_id", videoList.get(0).getFileId());
        para.put("output_stream_type", "0");
        para.put("output_stream_bitrate", "1500");
        para.put("input_stream_list", inputList);
        JSONObject interFace = new JSONObject();
        interFace.put("interfaceName", "Mix_StreamV2");
        interFace.put("para", para);

        JSONObject jo = new JSONObject();
        String time = Long.toString(new Date().getTime() / 1000);
        jo.put("timestamp", time);
        String HL = OrderNoGenerater.generate("HL");
        jo.put("eventId", HL);
        jo.put("interface", interFace);

        String string = OkHttpUtils.doAccessHTTPPostJson(
            "http://fcgi.video.qcloud.com/common_access", jo.toString());
        InterviewVideoRoom videoRoom = interviewVideoRoomBO
            .getInterviewVideoRoom(req.getRoomId());
        videoRoom.setHlUrl(string);
        interviewVideoRoomBO.refreshInterviewVideoRoom(videoRoom);
        return string;
    }

}
