package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dao.GroupRepository;
import com.koshkarov.student_group.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    public Group addNewGroup() {

        return null;
    }

}
