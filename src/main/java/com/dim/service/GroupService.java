package com.dim.service;

import com.dim.entity.group.Group;
import com.dim.repository.GroupRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class GroupService {
    @Inject
    GroupRepository groupRepository;

    @Transactional
    public List<Group> getGroups(){
        return this.groupRepository.findAll().stream().toList();
    }

    @Transactional
    public Group getGroupById(Long id){
        return this.groupRepository.findById(id);
    }

    @Transactional
    public Group createGroup(Group group){
        this.groupRepository.persist(group);
        return group;
    }

    @Transactional
    public Group updateGroup(Long id, Group groupData){
        Group group = this.groupRepository.findById(id);
        if(group != null){
            group.setName(groupData.getName());
            group.setPeriodeAL(groupData.getPeriodeAL());
            group.setTrancheAge(groupData.getTrancheAge());
            this.groupRepository.persist(group);
        }
        return group;
    }

    @Transactional
    public void deleteGroup(Long id){
        Group group = this.groupRepository.findById(id);
        if(group != null){
            this.groupRepository.delete(group);
        }
    }
}
