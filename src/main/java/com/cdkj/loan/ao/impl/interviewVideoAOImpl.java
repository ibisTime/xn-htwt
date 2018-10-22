package com.cdkj.loan.ao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IInterviewVideoAO;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.creditCommon.HttpClient;

@Service
public class interviewVideoAOImpl implements IInterviewVideoAO {

    @Override
    public Object recordVideo(String roomId, String realTimeRecord) {
        HttpClient httpClient = new HttpClient();
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam.add(new BasicNameValuePair("appid", "1257046543"));
        reqParam.add(new BasicNameValuePair("interface", "Live_Tape_Start"));
        String time = Long.toString(new Date().getTime());
        reqParam.add(new BasicNameValuePair("t", time));
        reqParam.add(new BasicNameValuePair("sign",
            MD5Util.md5("152d1d67ad2dda121dc4ad95bc05b269" + time)));
        reqParam.add(new BasicNameValuePair("Param.s.channel_id", roomId));
        reqParam.add(new BasicNameValuePair("Param.s.start_time",
            new Date().toString()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 5);
        String format = sdf.format(nowTime.getTime());
        reqParam.add(new BasicNameValuePair("Param.s.end_time", format));
        reqParam.add(
            new BasicNameValuePair("Param.n.task_sub_type", realTimeRecord));

        String doPost = httpClient
            .doPost("http://fcgi.video.qcloud.com/common_access", reqParam);
        return doPost;

    }

    @Override
    public Object endRecordVideo(String roomId, String taskId) {
        HttpClient httpClient = new HttpClient();
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        reqParam.add(new BasicNameValuePair("appid", "1257046543"));
        reqParam.add(new BasicNameValuePair("interface", "Live_Tape_Start"));
        String time = Long.toString(new Date().getTime());
        reqParam.add(new BasicNameValuePair("t", time));
        reqParam.add(new BasicNameValuePair("sign",
            MD5Util.md5("152d1d67ad2dda121dc4ad95bc05b269" + time)));
        reqParam.add(new BasicNameValuePair("Param.s.channel_id", roomId));
        reqParam.add(new BasicNameValuePair("Param.n.task_id", taskId));

        String doPost = httpClient
            .doPost("http://fcgi.video.qcloud.com/common_access", reqParam);
        return doPost;
    }

    @Override
    public Object mixedFlow(String outputId, String inputId,
            String imageLayer) {
        HttpClient httpClient = new HttpClient();
        List<BasicNameValuePair> reqParam = new ArrayList<BasicNameValuePair>();
        String time = Long.toString(new Date().getTime());
        reqParam.add(new BasicNameValuePair("timestamp", time));// 当前时间
        String eventId = OrderNoGenerater.generate("E");
        reqParam.add(new BasicNameValuePair("eventId", eventId));// 标识一次网络请求
        reqParam.add(new BasicNameValuePair("interfaceName", "Mix_StreamV2"));// 接口标识
        reqParam.add(new BasicNameValuePair("appid", "1257046543"));// 直播APPID
        reqParam.add(new BasicNameValuePair("interface",
            "mix_streamv2.start_mix_stream_advanced"));// 混流接口名称或：mix_streamv2.cancel_mix_stream
        String mixedFlow = OrderNoGenerater.generate("HL");
        reqParam
            .add(new BasicNameValuePair("mix_stream_session_id", mixedFlow));// 一次混流操作标识
        reqParam.add(new BasicNameValuePair("output_stream_id", outputId));// 输出流ID
        reqParam.add(new BasicNameValuePair("input_stream_id", inputId));// 输入源ID
        reqParam.add(new BasicNameValuePair("image_layer", imageLayer));// 图层标识号
        String doPost = httpClient
            .doPost("http://fcgi.video.qcloud.com/common_access", reqParam);
        return doPost;
    }

}
