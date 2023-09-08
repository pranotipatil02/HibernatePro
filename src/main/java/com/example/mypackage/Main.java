package com.example.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			// Create

			Student student = new Student("John", "Doe", "john@example.com");
			Student student1 = new Student("Johni", "kumar", "Johni@example.com");
			Student student2 = new Student("Rohan", "Mishra", "Rohan@example.com");
			Student student3 = new Student("Sonal", "Sha", "Sonal@example.com");
			Transaction transaction = session.beginTransaction();

			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);

			Student retrievedStudent1 = session.get(Student.class, 1);
			Student retrievedStudent2 = session.get(Student.class, 2);

			retrievedStudent1.setFirstName("Karan");
			session.update(retrievedStudent1);

			session.delete(retrievedStudent1);
			session.delete(retrievedStudent2);
			transaction.commit();
		} finally {
			sessionFactory.close();
		}
	}
}
