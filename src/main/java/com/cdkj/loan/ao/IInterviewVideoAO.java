package com.cdkj.loan.ao;

public interface IInterviewVideoAO {

    // 录制视频
    Object recordVideo(String roomId, String realTimeRecord);

    // 录制视频
    Object endRecordVideo(String roomId, String taskId);

    // 混流
    Object mixedFlow(String outputId, String inputId, String imageLayer);
}
