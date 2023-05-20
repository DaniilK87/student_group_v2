package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;

import java.util.List;

public interface GroupService {
    List<GroupDto> getAllGroup();
    void addNewGroup(GroupDto groupDto);
    void deleteGroup(int groupId);
    GroupDto getGroupById(int groupId);
}
