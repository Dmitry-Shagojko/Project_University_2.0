package repository;

import model.Group;

import java.util.ArrayList;

public class GroupRepository {
    public ArrayList<Group> groups;

    public GroupRepository() {
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void deleteGroup(Group group) {
        groups.remove(group);
    }

    public void setGroup(int pos, Group group) {
        groups.set(pos, group);
    }
}
