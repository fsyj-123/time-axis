package site.fsyj.timeaxis.service;

import site.fsyj.timeaxis.dto.EventDto;
import site.fsyj.timeaxis.entity.Event;

import java.util.List;

public interface EventService {


    int deleteByPrimaryKey(Integer id, String userid);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

    List<Event> selectAll(String userid);

    int deleteByPrimaryKey(Integer id);

    void addGroupEvent(String userid, String groupid, EventDto groupEvent);
}
