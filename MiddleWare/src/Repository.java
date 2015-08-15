
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class Repository {
	
 
	    private ServerSocket serverSocket = null;
	    private Socket socket = null;
	    private ObjectInputStream inStream = null;
	    private ObjectOutputStream outputStream = null;
	    private String category;
	    
	    private Service serv = new Service();
	    private ListofServices results_list = new ListofServices();
	
	    public Repository() {
	
	    }
	    
	    public Service ReadServices(String filename){
	    	
	    	
	    	
	    	try {
	    		
	    		 
	    	      SAXParserFactory factory = SAXParserFactory.newInstance();
	    	      SAXParser saxParser = factory.newSAXParser();
	    	 
	    	      DefaultHandler handler = new DefaultHandler() {
	    	 
	    	        boolean S_ID = false;
	    	        boolean S_Name = false;
	    	        boolean Available = false;
	    	        boolean OS = false;
	    	        boolean CPU = false;
	    	        boolean Memory = false;
	    	        boolean ScreenSize = false;
	    	        boolean Language = false;
	    	        boolean Location = false;
	    	        boolean Fee = false;
	    	        boolean Display = false;
	    	        boolean Link = false;
	    	 
	    	        public void startElement(String uri, String localName,
	    	            String qName, Attributes attributes)
	    	            throws SAXException {
	    	 
	    	     //     System.out.println("Start Element :" + qName);
	    	 
	    	          if (qName.equalsIgnoreCase("ID")) {
	    	        	  S_ID = true;
	    	          }
	    	 
	    	          if (qName.equalsIgnoreCase("Name")) {
	    	        	  S_Name = true;
	    	          }
	    	 
	    	          if (qName.equalsIgnoreCase("Available")) {
	    	        	  Available = true;
	    	          }
	    	 
	    	          if (qName.equalsIgnoreCase("OS")) {
	    	        	  OS = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("CPU")) {
	    	        	  CPU = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("Memory")) {
	    	        	  Memory = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("ScreenSize")) {
	    	        	  ScreenSize = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("Language")) {
	    	        	  Language = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("Location")) {
	    	        	  Location = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("Fee")) {
	    	        	  Fee = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("Display")) {
	    	        	  Display = true;
	    	          }
	    	          if (qName.equalsIgnoreCase("Link")) {
	    	        	  Link = true;
	    	          }
	    	 
	    	        }
	    	 
	    	        public void endElement(String uri, String localName,
	    	                String qName)
	    	                throws SAXException {
	    	 
	    	     //         System.out.println("End Element :" + qName);
	    	 
	    	        }
	    	 
	    	        public void characters(char ch[], int start, int length)
	    	            throws SAXException {
	    	        	
	    	     //     System.out.println(new String(ch, start, length));
	    	        	 
	    	        	 
	    	          if (S_ID) {
	    	        	String str = new String(ch, start, length);
	    	        	int id = Integer.parseInt(str);
	    	        	serv.setID(id);
	    	//            System.out.println("IDDD : "+id );
	    	            S_ID = false;
	    	          }
	    	 
	    	          if (S_Name) {
	    	        	  String str = new String(ch, start, length);
	    	        	  serv.setName(str);
	    	//              System.out.println("Name : "  + str );
	    	              S_Name = false;
	    	           }
	    	 
	    	          if (Available) {
	    	        	  serv.setAvailable(new String(ch, start, length));
	    	          //    System.out.println("Available : " + serv.getAvailable());
	    	              Available = false;
	    	           }
	    	 
	    	          if (OS) {
	    	        	  serv.setMin_And_OS(new String(ch, start, length));
	    	          //    System.out.println("OS : "  + serv.getMin_And_OS());
	    	              OS = false;
	    	           }
	    	          
	    	          if (CPU) {
	    	        	  serv.setReq_CPU(Double.parseDouble(new String(ch, start, length)));
	    	          //    System.out.println("CPU : "+ serv.getReq_CPU());
	    	              CPU = false;
	    	           }
	    	          
	    	          if (Memory) {
	    	        	  serv.setReq_memory(Double.parseDouble(new String(ch, start, length)));
	    	          //    System.out.println("Memory : " + serv.getReq_memory() );
	    	              Memory = false;
	    	           }
	    	          
	    	          if (ScreenSize) {
	    	        	  serv.setScreen_Size(new String(ch, start, length));
	    	           //   System.out.println("ScreenSize : "  + serv.getScreen_Size());
	    	              ScreenSize = false;
	    	           }
	    	          
	    	          if (Language) {
	    	        	  serv.setLanguage(new String(ch, start, length));
	    	     //         System.out.println("Language : "   + serv.getLanguage());
	    	              Language = false;
	    	           }
	    	          
	    	          if (Location) {
	    	        	  serv.setLocation(new String(ch, start, length));
	    	    //          System.out.println("Location : "   + serv.getLocation());
	    	              Location = false;
	    	           }
	    	          
	    	          if (Fee) {
	    	        	  serv.setFee(new String(ch, start, length));
	    	         //     System.out.println("Fee : "  + serv.getFee());
	    	              Fee = false;
	    	           }
	    	          if (Display) {
	    	        	  serv.setDisplay(new String(ch, start, length));
	    	          //    System.out.println("Display : " + serv.getDisplay());
	    	              Display = false;
	    	           }
	    	          if (Link) {
	    	        	  serv.setLink(new String(ch, start, length));
	    	           //   System.out.println("Link : " + serv.getLink());
	    	              Link = false;
	    	           }
	    	 
	    	          
	    	        }
	    	 
	    	      };
	    	 
	    	      // TO CHANGE
	    	      
	    	      //List<String> filesnames
	    	
	    	      String pa= System.getProperty("user.dir");
	    	     
	    	      File file = new File(pa+"\\repository\\" +filename + ".xml");
	    	      InputStream inputStream= new FileInputStream(file);
	    	      Reader reader = new InputStreamReader(inputStream,"UTF-8");
	    	      
	    	      InputSource is = new InputSource(reader);
	    	      is.setEncoding("UTF-8");
	    	      
	    	      saxParser.parse(is, handler);
	    	      
	    	     // results_list.getList().add(serv);
	    	      
		    						
	    	      
	    	          	 
	    	    } catch (Exception e) {
	    	      e.printStackTrace();
	    	    }
			return serv;
		  
	    }
	    
	    public List<String> servicefiles(String categoryy){
	    	
	    		    	
	    	List<String> weatherfiles = new ArrayList<String>();
	    	List<String> videoretrievalfiles = new ArrayList<String>();
	    	
	    	weatherfiles.add("Service1");
	    	weatherfiles.add("Service2");
	    	weatherfiles.add("Service3");
	    	weatherfiles.add("Service4");
	    	weatherfiles.add("Service5");
	    	weatherfiles.add("Service6");
	    	weatherfiles.add("Service7");
	    	weatherfiles.add("Service8");
	    	weatherfiles.add("Service9");
	    	weatherfiles.add("Service10");
	    	weatherfiles.add("Service11");
	    	//weatherfiles.add("Service12");
	    	weatherfiles.add("Service13");
	    	
	    	
	    	
	    	
	    	if(categoryy.compareToIgnoreCase("weather")==0){
	    		return weatherfiles;
	    	}
	    	if(categoryy.compareToIgnoreCase("videoretrieval")==0){
	    		return videoretrievalfiles;
	    	}
	    	
	    	return null;
	    }
	    
	    
	    public String findcategory(String str){
	    	
	    	List<List<String>> list = new ArrayList<List<String>>();
	    	
	    	List<String> weather = new ArrayList<String>();
	    	weather.add("weather");
	    	weather.add("forecast");
	    	weather.add("meteorological");
	    	weather.add("meteo");
	    	weather.add("weatherforecast");
	    	
	    	List<String> video = new ArrayList<String>();
	    	video.add("find video");
	    	video.add("retrieve video");
	    	video.add("video retrieval");
	    	video.add("search video");
	    	video.add("return video");
	    	video.add("get video");
	    	
	    	list.add(weather);
	    	list.add(video);
	    	
	    	
	    		int ans = -1;
	    		Iterator<List<String>> it = list.iterator();
	    		int index = 0;
	    		while (it.hasNext()) {
	    		  List<String> ser = it.next();
	    		  Iterator<String> it2 = list.get(index).iterator();
	    		  while(it2.hasNext()){
	    			String temp = it2.next();  
	    			if(temp.compareToIgnoreCase(str)==0){
	    				ans = index;
	    				break;
	    				
	    			}
	    			
	    		  }
	    		  if(ans!=-1){
	    			  break;
	    		  }
	    		  index++;	    		  	    		  
	    		}
	    	
	    	if(index==0){
	    	this.category="Weather";
	    	return "Weather";
	    	}
	    	if(index==1){
	    	this.category="Videoretrieval";
	    	return "videoretrieval";
	    	}
	    	
			return "Error";
	    	
	    	
	    }
	    
	 	    
	
	    public void communicate() {
	    	
	    	
	    //	Service srv = new Service("Weather",1,"YES",1.0,0.5,1.0,"NO","NO","None","All","English","FREE","Graphic","None","US","ANY","http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL");
	    //	list.getList().add(srv);
	    		    	
	    	
	            try {
					serverSocket = new ServerSocket(4445);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
	            
	            while(true){
	    	        try {
	    	   	System.out.println("waiting...");
	            socket = serverSocket.accept();
	            System.out.println("Connected");
	            inStream = new ObjectInputStream(socket.getInputStream());
	
	            String categorey = (String) inStream.readObject();
	            System.out.println("Keyword received = " + categorey);
	            
	            
	            Iterator<String> it = servicefiles(findcategory(categorey)).iterator();
	            
	            ListofServices list = new ListofServices();
	      //    List<Service> result = new ArrayList<Service>();
	            	    		
		    	while (it.hasNext()) {
		    	   
		    	   String filename = it.next();
		    	   Service servv = new Service();
		    	   servv = ReadServices(filename);
		    	   System.out.println("Service: "+servv.getName());
		    	//   list.getList().add(servv);
		    	   outputStream = new ObjectOutputStream(socket.getOutputStream());
		           outputStream.writeObject(servv);		    	   
		    	//   list.printlist();
		    	 		    	   		    	   
		    	}
		    	Service ser = new Service();
		    	ser.setID(-1);
		    	ser.setAvailable(this.category);
		    	outputStream = new ObjectOutputStream(socket.getOutputStream());
		        outputStream.writeObject(ser);	
	              
	            
	            System.out.println("End of print in repository");
	        
	            
	        //    outputStream = new ObjectOutputStream(socket.getOutputStream());
	        //    outputStream.writeObject(list);
	            
	            
	            socket.close();

		        } catch (SocketException se) {
	            System.exit(0);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException cn) {
	            cn.printStackTrace();
	        }}
	    }
	
	    public static void main(String[] args) {
	        Repository server = new Repository();	        
	        server.communicate();
	    	
	     //	System.out.println(server.findcategory("retrieve video"));
	        
	    }
	}

	
	

