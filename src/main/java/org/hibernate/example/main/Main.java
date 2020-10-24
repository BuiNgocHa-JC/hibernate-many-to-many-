package org.hibernate.example.main;

import org.hibernate.Session;
import org.hibernate.example.model.Employees;
import org.hibernate.example.model.Projects;
import org.hibernate.example.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employees employees = new Employees("Tony","Stark");
        Projects projects = new Projects("Reactor");

        Projects projects1 = new Projects("Avenger");

        employees.getProjects().add(projects);
        employees.getProjects().add(projects1);

        projects.getEmployees().add(employees);
        projects1.getEmployees().add(employees);

        session.save(employees);

        session.getTransaction().commit();
        HibernateUtil.shutDown();
    }
}
