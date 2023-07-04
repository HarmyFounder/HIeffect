package com.HarmyFounder.HIeffect.controllers;

import com.HarmyFounder.HIeffect.models.Meeting;
import com.HarmyFounder.HIeffect.models.User;
import com.HarmyFounder.HIeffect.services.MailSendService;
import com.HarmyFounder.HIeffect.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MailSendService mailSendService;

    @GetMapping("/")
    public List<Meeting> getAllMeetings() {
        return meetingService.getAll();
    }

    @GetMapping("/{id}")
    public Meeting getCertainMeeting(@PathVariable("id") Meeting meeting) {
        return meeting;
    }

    @PostMapping("/create")
    public Meeting createMeeting(@RequestBody Meeting meeting, @RequestParam int hour, @RequestParam int minute, @AuthenticationPrincipal User user)
            throws MessagingException {
        mailSendService.sendMessageNotification(user, hour, minute);
        return meetingService.create(meeting);
    }

    @PutMapping("/{id}/edit")
    public Meeting updateMeeting(@PathVariable("id") Meeting meetingToBeUpdated, @RequestBody Meeting updatedMeeting) {
        return meetingService.update(meetingToBeUpdated, updatedMeeting);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable("id") Meeting meeting) {
        meetingService.delete(meeting);
    }

    @PostMapping("/findByTag")
    public List<Meeting> getByTag(@RequestParam String filter) {
        return meetingService.getByTag(filter);
    }

    @PostMapping("/findByAssigned/{id}")
    public List<Meeting> getByAssigned(@PathVariable("id") User assigned) {
        return meetingService.getByAssigned(assigned);
    }

    @PostMapping("/findByAuthor/{id}")
    public List<Meeting> getByAuthor(@PathVariable("id") User author) {
        return meetingService.getByAuthor(author);
    }


}
