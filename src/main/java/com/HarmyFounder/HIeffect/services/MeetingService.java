package com.HarmyFounder.HIeffect.services;

import com.HarmyFounder.HIeffect.models.Meeting;
import com.HarmyFounder.HIeffect.models.User;
import com.HarmyFounder.HIeffect.repositories.MeetingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> getAll(){
        return meetingRepository.findAll();
    }

    public Meeting create(Meeting meeting){
        meeting.setCreationDate(LocalDateTime.now());
        return meetingRepository.save(meeting);
    }

    public Meeting update(Meeting meetingToBeUpdated, Meeting updatedMeeting){
        BeanUtils.copyProperties(updatedMeeting,meetingToBeUpdated,"id");
        return meetingRepository.save(meetingToBeUpdated);
    }

    public void delete(Meeting meeting){
        meetingRepository.delete(meeting);
    }

    public List<Meeting> getByTag(String filter){
        if(filter != null && !filter.isEmpty()){
            return meetingRepository.findByTag(filter);
        } else {
            return meetingRepository.findAll();
        }
    }

    public List<Meeting> getByAssigned(User user){
        return meetingRepository.findAllByAssign(user);
    }

    public List<Meeting> getByAuthor(User user){
        return meetingRepository.findByAuthor(user);
    }

}
