package Project;
import javax.swing.JPanel;

public class notePanel extends JPanel {
	
	private String name,time,detail;
	private MonthType type;
	private int year, cp,hr,min,hp,nof=0;
	
	notePanel(){
	
		this.time = "0:0"; //เวลารวม
		this.name = "-----";
		this.type = MonthType.January;
		this.year = 0; //ปี
		this.hr = 0; //ชั่วโมง
		this.min =0; //นาที
		this.cp = 0; //วัน
		this.hp = 0; //แจ้งล่วงหน้า
		this.nof = 0; //แจ้งล่วงหน้า
		this.detail = "ENTER DETAIL.";
	}
	notePanel(String time, String name, MonthType type, int year, int cp,int hr ,int min) {
		this.time = time;
		this.name = name;
		this.type = type;
		this.year = year;
		this.hr = hr;
		this.min = min;
		this.cp = cp;
	}
	
	notePanel(MonthType type, int year, int cp,int hr ,int min) {
		this.type = type;
		this.year = year;
		this.hr = hr;
		this.min = min;
		this.cp = cp;
	}
	
	public String getname() {
		return name;
	}
	
	public String getdetail() {
		return detail;
	}
	public String gettime() {
		return time;
	}
	
	public MonthType gettype() {
		return type;
	}
	
	public int getyear() {
		return year;
	}
	
	public int getcp() {
		return cp;
	}
	
	
	public int gethr() {
		return hr;
	}
	
	public int gethp() {
		return hp;
	}
	
	public int getnof() {
		return nof;
	}
	
	public int getmin() {
		return min;
	}
	
	public void setname(String n) {
		 name = n;
	}
	
	public void setdetail(String n) {
		 detail = n;
	}
	
	public void settime(String n) {
		 n = time;
	}
	
	public void settype(MonthType a) {
		 type=a;
	}
	
	public void sethp(int h) {
		 hp = h;
	}
	public void setnof(int h) {
		 nof = h;
	}
	
	public void sethr(int h) {
		 hr = h;
	}
	
	public void setyear(int h) {
		 year = h;
	}
	
	public void setmin(int h) {
		 min = h;
	}
	
	public void setcp(int c) {
		 cp =c;
	}
	
	public String toto() {
		 return name;
	}
	
	public String toStrings() {
		String hrs =""+hr ;
		if(hr<10){
			hrs = "0"+hr;
		}
		String mins = ""+min ;
		if(min<10){
			mins = "0"+min;
		}
		
		return " ► \""+name+"\" [ Due date: "+cp+" "+type+" "+(year+2016)+" time: "+hrs+"."+mins+" ]"+"  【Prior "+hp+ " day】";
		}
	


}
