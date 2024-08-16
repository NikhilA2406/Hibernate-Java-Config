package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.userinfo;

public class LaunchStandardApp {

	public static void main(String[] args) 
	{
		Configuration config=null;
		SessionFactory sessionfactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		config=new Configuration();
		
		config.configure();
		config.addAnnotatedClass(userinfo.class);
//		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//		config.setProperty("hibernate.connection.password", "Nikhil#24");
//		config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/userregistraioninfo");
//		config.setProperty("hibernate.connection.username", "root");
//		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		config.setProperty("hibernate.hbn2ddl.auto", "update");
//		config.setProperty("hibernate.show_sql", "true");
//		config.setProperty("hibernate.format_sql", "true");
//		config.setProperty("hibernate.use_sql_comments", "true");
		
		sessionfactory=config.buildSessionFactory();
		
		session=sessionfactory.openSession();
		
		
		userinfo user=new userinfo();
		user.setUid(8);
		user.setUname("Priyanka");
		user.setUcity("Kolkata");
		try 
		{
			transaction=session.beginTransaction();
			session.persist(user);
			flag=true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			session.close();
			sessionfactory.close();
		}


	}

}
