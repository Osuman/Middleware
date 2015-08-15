import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListofServices implements Serializable {
	
	private String category;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Service> getList() {
		return list;
	}
	public void setList(List<Service> list) {
		this.list = list;
	}	
	
	List<Service> list = new ArrayList<Service>() ;
	
	void populatelist() throws ClassNotFoundException{
		
			
		
	/*	
		Service srv = new Service("Weather",1,"YES",1.0,0.5,1.0,"NO","NO","None","All","English","FREE","Graphic","None","US","ANY","http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL");		
		list.add(srv);
		
		srv = new Service("GlobalWeather",2,"YES",1.2,1.5,1.0,"NO","NO","None","All","English","FREE","Text","None","ALL","ANY","http://www.webservicex.net/globalweather.asmx?WSDL");
		list.add(srv);
		
		srv = new Service("Wunderground",3,"YES",1.0,2.0,1.3,"NO","NO","None","All","English","Paying","Graphic","None","ALL","ANY","http://www.wunderground.com/");
		list.add(srv);
		
		srv = new Service("YahooWeather",4,"YES",1.2,1.4,1.3,"NO","NO","None","All","All","Paying","Graphic","None","ALL","ANY","https://weather.yahoo.com/");
		list.add(srv);
		
		srv = new Service("Accuweather",5,"YES",2.0,1.7,1.0,"NO","NO","None","All","All","Paying","Graphic","None","ALL","Fast","http://www.accuweather.com/en/ma/morocco-weather");
		list.add(srv);
		
		srv = new Service("World Weather Online",7,"YES",3.5,1.2,1.5,"NO","NO","None","All","All","Free","Graphic","None","ALL","ANY","http://www.worldweatheronline.com/");
		list.add(srv);
		
		srv = new Service("Open Weather Map",8,"YES",3.0,1.4,1.8,"NO","NO","None","All","All","Free","Graphic","None","ALL","ANY","http://openweathermap.org/");
		list.add(srv);
		
		srv = new Service("Meteorologisk institutt",9,"YES",2.0,1.2,1.2,"NO","NO","None","All","Norwegian","Free","Graphic","None","ALL","ANY","http://www.yr.no/");
		list.add(srv);
		
		srv = new Service("Simple Geo",10,"NO",3.0,1.4,1.8,"NO","NO","None","All","English","Free","Graphic","None","ALL","ANY","https://simplegeo.com/");
		list.add(srv);
		
		srv = new Service("Weather",11,"YES",2.0,1.9,0.8,"NO","NO","None","All","English","Free","Graphic","None","US","ANY","http://www.weather.gov/");
		list.add(srv);
		
		srv = new Service("Aeris Weather",12,"YES",4.0,1.0,1.6,"NO","NO","None","All","English","Free","Graphic","None","US","ANY","http://wx.aerisweather.com/");
		list.add(srv);
		*/
		
	}
	
	public void printlist(){

Iterator<Service> it = list.iterator();
while (it.hasNext()) {
  Service ser = it.next();
  
  System.out.println(ser.getName());
  
}
	}
	
	public void printlist2(List<QuestionFilter> list2){
				
Iterator<QuestionFilter> it = list2.iterator();
while (it.hasNext()) {
	QuestionFilter ser = it.next();
  
  System.out.println(ser.getID());
  
}
	}	
		
	public void removebyid(int id){
		
		Iterator<Service> it = list.iterator();
		while (it.hasNext()) {
		  Service ser = it.next();
		  if(ser.getID()==id){
			it.remove();  
		  }		  
		  
		}
		
	}
	
	public Service remturnbyid(int id){
		
		Service serv = null;
		
		Iterator<Service> it = list.iterator();
		while (it.hasNext()) {
		  Service ser = it.next();
		  if(ser.getID()==id){
			return ser;  
		  }		  
		  
		}
		
		return serv;
		
	}
	
	
	public int remturnbyserv(Service servi){
		
		//Service serv = null;
		
		Iterator<Service> it = list.iterator();
		while (it.hasNext()) {
		  Service ser = it.next();
		  if(ser==servi){
			return ser.getID();  
		  }		  
		  
		}
		
		return 0;
		
	}
	
	
	
	
	 public static void main(String[] args)
	    {
		 
		 PreselectionUnit pres = new PreselectionUnit();
		 ListofServices list = new ListofServices();
		 
		 ListofServices listofmatch = new ListofServices();
		 
		 ProfileManager profile = new ProfileManager();
		 List<QuestionFilter> qlist = new ArrayList<QuestionFilter>();
		 MatchingUnit mtch = new MatchingUnit();
		 ResponseAdapter adapt = new ResponseAdapter();
		 String response="";
		 
		 //list.setCategory("Weather");
		
	//	 list.printlist();
	//	 profile.retrieveprofile();
		 
		 list.setList(pres.Preselection(list, profile));
	//	 qlist = mtch.selectQ(list.getList());
		 		 		 		 
		 list.printlist();
		 
		 list.printlist2(qlist);
		 
	//	 listofmatch = mtch.generatetree(list);
		 
		 listofmatch.printlist();
		 
		 response=adapt.generateresponse(listofmatch);
		 System.out.println("response is:"+response);
		 
	    }	
	 
	
}
