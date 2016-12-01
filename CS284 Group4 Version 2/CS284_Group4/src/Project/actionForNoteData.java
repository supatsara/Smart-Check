package Project;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class actionForNoteData {

	public ArrayList<notePanel> LoadFile(String filename) {
		ArrayList<notePanel> box = new ArrayList<>();
		File file = new File("default.dat");
			try {
				ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
				ArrayList<notePanel> readObject = (ArrayList<notePanel>) inputStream.readObject();
				box = readObject;
				inputStream.close();
				return box;

			} catch (Exception e1) {

			}
		return box;
	}
	
	public String getdate() {
		Locale locale = new Locale("Eng", "ENG");
		SimpleDateFormat day = new SimpleDateFormat("d MMMM yy HH mm", locale);
		String x = day.format(new Date());
			return x;
	}
	

	public String ckk10(String num) {
		if (Integer.valueOf(num) < 10 && num.length() == 1) {
			return "0" + num;
		} else
			return num;
	}
	
	public String checkNowTime(){
		String now[] = getdate().split(" ");
		String date = now[0];
		String month = now[1];
		String year = now[2];
		String hr = now[3];
		String min = now[4];
		date = ckk10(date);
		hr = ckk10(hr);
		min = ckk10(min);
		
		String ck2 = "" + year + ":" + ckm(month) + ":" + date + ":" + hr + ":" + min;
		
		return ck2;
		
	}
	
	public String checkCurrenTime(ArrayList<notePanel> box,int i) {	
		
		String date2 = "" + box.get(i).getcp();
		String month2 = "" + box.get(i).gettype();
		String year2 = "" + (box.get(i).getyear() + 16);
		String hr2 = "" + box.get(i).gethr();
		String min2 = "" + box.get(i).getmin();

		int datei = Integer.valueOf(date2) - box.get(i).gethp();
		date2 = "" + datei;

		date2 = ckk10(date2);
		hr2 = ckk10(hr2);
		min2 = ckk10(min2);
		
		String ck = "";
		ck = year2 + ":" + ckm(month2) + ":" + date2 + ":" + hr2 + ":" + min2;
		return ck;
	}
	
	public boolean checktime(String day1,String day2) {
		return day1.equals(day2);
	}
	
	public int checktimecomp(String day1,String day2) {
		return day1.compareTo(day2);
	}
	
	public String ckm(String month) {
		if (month.equals("January")) {
			return "01";
		} else if (month.equals("February")) {
			return "02";
		} else if (month.equals("March")) {
			return "03";
		} else if (month.equals("April")) {
			return "04";
		} else if (month.equals("May")) {
			return "05";
		} else if (month.equals("June")) {
			return "06";
		} else if (month.equals("July")) {
			return "07";
		} else if (month.equals("August")) {
			return "08";
		} else if (month.equals("September")) {
			return "09";
		} else if (month.equals("October")) {
			return "10";
		} else if (month.equals("November")) {
			return "11";
		} else if (month.equals("December")) {
			return "12";
		}

		return "00";
	}
	
	public String[] getitp2() {
		String[] itp2 = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23" };
		return itp2;
	}
	
	public String[] getitp3() {
		String[] itp3 = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
				"32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
				"49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
		return itp3;
	}
	
	public String[] getitp4() {
		String[] itp4 = { "2016", "2017", "2018", "2019", "2020", "2021", "2021", "2022", "2023", "2024", "2025" };
		return itp4;
	}
	
	public MonthType[] getMonthType() {
		MonthType type[] = { MonthType.January, MonthType.February, MonthType.March, MonthType.April, MonthType.May,
				MonthType.June, MonthType.July, MonthType.August, MonthType.September, MonthType.October,
				MonthType.November, MonthType.December };
		return type;
	}
	
}
