package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 面签视频
* @author: CYunlai 
* @since: 2018-10-24 15:33:11
* @history:
*/
public class InterviewVideo extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private int id;

    // 房间编号
    private String roomCode;

    // 直播码
    private String streamId;

    // 视频编号
    private String fileId;

    // 点播视频的下载地址
    private String videoUrl;

    // 文件大小
    private String fileSize;

    // 开始时间
    private Date startTime;

    // 结束时间
    private Date endTime;

    // 文件格式
    private String fileFormat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }

}
