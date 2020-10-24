package org.hibernate.example.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employees {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "employees_projects",
            joinColumns = {
                    @JoinColumn(name = "employee_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "project_id")
            }
    )
    Set < Projects > projects = new HashSet <> ();


    public Employees() {
        super();
    }

    public Employees(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employees(String firstName, String lastName, Set < Projects > projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.projects = projects;
    }


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set < Projects > getProjects() {
        return projects;
    }

    public void setProjects(Set < Projects > projects) {
        this.projects = projects;
    }
}