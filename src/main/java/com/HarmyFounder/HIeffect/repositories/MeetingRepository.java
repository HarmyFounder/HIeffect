package com.HarmyFounder.HIeffect.repositories;

import com.HarmyFounder.HIeffect.models.Meeting;
import com.HarmyFounder.HIeffect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    List<Meeting> findByTag(String tag);

    List<Meeting> findAllByAssign(User assign);

    List<Meeting> findByAuthor(User author);
}
