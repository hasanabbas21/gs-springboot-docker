package hello;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {

        // return "** Hello Docker World - Message 02/16 - Kubernetes **";
    	
    	 InetAddress ip;
         String hostname = null;
         try {
             ip = InetAddress.getLocalHost();
             hostname = ip.getHostName();
             System.out.println("Your current IP address : " + ip);
             System.out.println("Your current Hostname : " + hostname);
  
         } catch (UnknownHostException e) {
  
             e.printStackTrace();
         }
    	
    	String out = "<html><body><h1 align=\"center\">Hello Everyone - have a nice day !!</h1>"
    			+ "<h2 align=\"center\">Who ran this request : " + hostname + " </h2></body></html>";
       
    	return out;
    }

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
