package spectraUtil;

 
 
import java.util.Enumeration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
public class MySessionListener implements HttpSessionListener {
	 private static int activeSessions = 0;
	public void sessionCreated(HttpSessionEvent event) {
		activeSessions++;
		System.out.println("A new AAAAAAAAAAAAAAAAAAAAAAAAsession is created");
	
		   String queries = "";
		   Enumeration e = event.getSession().getAttributeNames();

		   if ( e.hasMoreElements() )
		   {
		       queries += "<h4>Recent Queries</h4><ul>";
		   }

		   while ( e.hasMoreElements() )
		   {
		       String name = (String) e.nextElement();
		       String value = (String) event.getSession().getAttribute(name);
		       System.out.println(value +" name= " + name );
		   }
		getActiveSessions();
	}
 
	public void sessionDestroyed(HttpSessionEvent event) {
		  if(activeSessions > 0)
		      activeSessions--;
		System.out.println("session is destroyed");
		getActiveSessions();
	}
public static int getActiveSessions() {
	System.out.println("activeSessions = "+activeSessions);
    return activeSessions;
 }
}
