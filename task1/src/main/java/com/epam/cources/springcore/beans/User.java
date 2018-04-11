package com.epam.cources.springcore.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User extends Item{
    public static enum Role {
        ADMIN, USER, NONE
    }

    private String name;
    private Role role;
    private String password;
    private String email;
    private LocalDate birthday;
    private Long tickets;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String roleName){
        setRole(roleName);
    }

    public void setRole(String roleName) {
        role = Role.NONE;

        if(roleName.equalsIgnoreCase(Role.ADMIN.toString())){
            role = Role.ADMIN;
        }

        if(roleName.equalsIgnoreCase(Role.USER.toString())){
            role = Role.USER;
        }
    }

    public boolean isRegistered(){
        return !this.role.equals(Role.NONE);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role.toString();
    }

    public static List<String> getListOfRoles() {
        return Arrays.asList(Role.values())
                .stream()
                .filter(r -> !r.equals(Role.NONE))
                .map(r -> r.toString())
                .collect(Collectors.toList());
    }

    public Long getTickets() {
        return tickets;
    }

    public void setTickets(Long tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }
}
