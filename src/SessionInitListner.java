import java.io.File;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Dao.AbstractDao;
import Dao.SetupDao;

/**
 * Application Lifecycle Listener implementation class SessionInitListner
 * 
 */
public class SessionInitListner implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SessionInitListner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		SetupDao setup = new SetupDao();
		if (dbExists()) {
			setup.createSchema();
			setup.addTestData();
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	private boolean dbExists() {
		 return new File(System.getProperty("user.home") + "/data/kpaaro/db.script").exists();
	}
}
