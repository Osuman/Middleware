import java.io.Serializable;


public class Service implements Serializable{
	
	private String Name;
	private int ID;	
	private String Link;
	private String Available;
		
	private String min_And_OS;
	private double req_CPU ;
	private double req_memory ;
	private String need_camera; //
	private String need_ft_camera; //
	private String Screen_Size;	
	
	private String location;
	private String language;
	private String fee;    
	private String display;
	private String date="None";   //
	
	//context related attributes
	private String service_location;
	private String connection;
	
	
	
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAvailable() {
		return Available;
	}
	public void setAvailable(String available) {
		Available = available;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getService_location() {
		return service_location;
	}
	public void setService_location(String service_location) {
		this.service_location = service_location;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMin_And_OS() {
		return min_And_OS;
	}
	public void setMin_And_OS(String min_And_OS) {
		this.min_And_OS = min_And_OS;
	}
	public double getReq_CPU() {
		return req_CPU;
	}
	public void setReq_CPU(double req_CPU) {
		this.req_CPU = req_CPU;
	}
	public double getReq_memory() {
		return req_memory;
	}
	public void setReq_memory(double req_memory) {
		this.req_memory = req_memory;
	}
	public String getNeed_camera() {
		return need_camera;
	}
	public void setNeed_camera(String need_camera) {
		this.need_camera = need_camera;
	}
	public String getNeed_ft_camera() {
		return need_ft_camera;
	}
	public void setNeed_ft_camera(String need_ft_camera) {
		this.need_ft_camera = need_ft_camera;
	}
	public String getScreen_Size() {
		return Screen_Size;
	}
	public void setScreen_Size(String screen_Size) {
		Screen_Size = screen_Size;
	}
	
	
	public Service(String name, int ID, String Available, String min_And_OS, double req_CPU,
			double req_memory, String need_camera, String need_ft_camera,
			String screen_Size, String location, String language, String fee,
			String display, String date, String service_location,
			String connection,String link) {
	//	super();
		Name = name;
		this.ID = ID;
		this.Available=Available;
		this.min_And_OS = min_And_OS;
		this.req_CPU = req_CPU;
		this.req_memory = req_memory;
		this.need_camera = need_camera;
		this.need_ft_camera = need_ft_camera;
		Screen_Size = screen_Size;
		this.location = location;
		this.language = language;
		this.fee = fee;
		this.display = display;
		this.date = date;
		this.service_location = service_location;
		this.connection = connection;
		this.Link=link;
	}

	
	public Service() {
		// TODO Auto-generated constructor stub
	}
	
}
