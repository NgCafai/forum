package com.wujiahui.forum.dao;

import com.wujiahui.forum.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by NgCafai on 2019/8/9 14:40.
 */
@Mapper
public interface MessageMapper {

    // 查询当前用户的会话列表,针对每个会话只返回一条最新的私信.
    List<Message> selectConversations(int userId, int offset, int limit);

    // 查询当前用户的会话数量
    int selectConversationCount(int userId);

    // 查询某个会话所包含的所有私信
    List<Message> selectMessages(String conversationId, int offset, int limit);

    // 查询某个会话包含的私信的数量
    int selectMessageCount(String conversationId);

    // 查询未读私信的数量
    int selectUnreadMessageCount(int userId, String conversationId);

    // 插入新的消息
    int insertMessage(Message message);

    // 修改消息的状态
    int updateStatus(List<Integer> ids, int status);
}