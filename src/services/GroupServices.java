package services;

import model.Group;
import repository.GroupRepository;

public class GroupServices {

    public GroupRepository groupRepository;

    public GroupServices() {
        groupRepository = new GroupRepository();
    }

    public void addGroup(Group group) {
        groupRepository.addGroup(group);
    }

    public void deleteGroup(Group group) {
        groupRepository.deleteGroup(group);
    }

    public void setGroup(int pos, Group group) {
        groupRepository.setGroup(pos, group);
    }

    public void sortingGroupByYearOfGraduation(GroupServices groupServices) {
        System.out.println('\n' + "List of groups whose issue year is 2023 - 2024: ");
        groupServices.groupRepository.groups.stream()
                .filter(t -> t.getYearOfGraduation() >= 2023 && t.getYearOfGraduation() <= 2024)
                .forEach(t -> System.out.println("Group: " + t.getNameGroup() +
                        ". Year of graduation: " + t.getYearOfGraduation() + "."));
    }


}
