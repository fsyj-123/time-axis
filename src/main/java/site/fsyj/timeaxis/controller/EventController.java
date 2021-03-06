package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.fsyj.timeaxis.dto.EventDto;
import site.fsyj.timeaxis.entity.Event;
import site.fsyj.timeaxis.service.EventService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author fsyj on 2022/5/22
 */
@Slf4j
@Api("事件管理模块")
@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private EventService eventServiceImpl;

    @ApiOperation("添加事件")
    @PostMapping(value = "/add")
    public ResponseEntity<String> createEvent(@RequestBody EventDto newEvent, HttpServletRequest request) {
        String userid = (String) request.getAttribute("userId");
        Event event = new Event();
        event.setName(newEvent.getName());
        event.setTeacher(newEvent.getTeacher());
        event.setTime(newEvent.getTime());
        event.setMajor(newEvent.getMajor());
        event.setOwner(Integer.valueOf(userid));
        eventServiceImpl.insert(event);
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation("查询所有的事件")
    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents(HttpServletRequest request) {
        String userid = (String) request.getAttribute("userId");
        List<Event> events = eventServiceImpl.selectAll(userid);
        return ResponseEntity.ok(events);
    }

    @ApiOperation("删除事件")
    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable String eventId, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        eventServiceImpl.deleteByPrimaryKey(Integer.valueOf(eventId), userId);
        return ResponseEntity.ok("删除成功");
    }
}
