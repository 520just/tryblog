package com.jian.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentId;
    private boolean adminMessage;

    //回复
    private List<Message> replayMessage = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isAdminMessage() {
        return adminMessage;
    }

    public void setAdminMessage(boolean adminMessage) {
        this.adminMessage = adminMessage;
    }

    public List<Message> getReplayMessage() {
        return replayMessage;
    }

    public void setReplayMessage(List<Message> replayMessage) {
        this.replayMessage = replayMessage;
    }

    public Message getParentMessage() {
        return parentMessage;
    }

    public void setParentMessage(Message parentMessage) {
        this.parentMessage = parentMessage;
    }

    public String getParentNickname() {
        return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", parentId=" + parentId +
                ", adminMessage=" + adminMessage +
                ", replayMessage=" + replayMessage +
                ", parentMessage=" + parentMessage +
                ", parentNickname='" + parentNickname + '\'' +
                '}';
    }
}
