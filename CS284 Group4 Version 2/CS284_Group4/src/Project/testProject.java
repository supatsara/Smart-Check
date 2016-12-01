package Project;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testProject {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFile() {
		actionForNoteData ac = new actionForNoteData();
		ArrayList<notePanel> box = new ArrayList<>();
		box = ac.LoadFile("default.dat");
				String now = ac.checkNowTime();
				String cur = ac.checkCurrenTime(box, 0);
				System.out.println("---- TEST LOAD FILE ----");
				System.out.println(now + "\n" + cur+"\n");
				assertEquals(now, cur);	
		
	}

	@Test
	public void testTimerlistener() {

		actionForNoteData ac = new actionForNoteData();
		ArrayList<notePanel> box = new ArrayList<>();
		box.add(new notePanel(MonthType.December, 0, 1, 3, 25)); // (month/year(2016=0)/day/hour/minute)
		String now = ac.checkNowTime();
		String cur = ac.checkCurrenTime(box, 0);
		System.out.println("---- TEST ACTION ----");
		System.out.println(now + "\n" + cur+"\n");
		assertEquals(now, cur);
		// 16:12:01:02:16 (day/month/year/hour/minute)
	}

	@Test
	public void testReturnMounth() {
		actionForNoteData ac = new actionForNoteData();
		assertEquals(ac.ckm("January"), "01");
		assertEquals(ac.ckm("February"), "02");
		assertEquals(ac.ckm("March"), "03");
		assertEquals(ac.ckm("April"), "04");
		assertEquals(ac.ckm("May"), "05");
		assertEquals(ac.ckm("June"), "06");
		assertEquals(ac.ckm("July"), "07");
		assertEquals(ac.ckm("August"), "08");
		assertEquals(ac.ckm("September"), "09");
		assertEquals(ac.ckm("October"), "10");
		assertEquals(ac.ckm("November"), "11");
		assertEquals(ac.ckm("December"), "12");

	}

	@Test
	public void testnowDate() {
		actionForNoteData x = new actionForNoteData();
		String tmp = x.getdate();
		String chk[] = tmp.split(" ");
		assertEquals(chk[0], "1"); // Day
		assertEquals(chk[1], "December"); // Month
		assertEquals(chk[2], "16"); // Year
	}

	@Test
	public void testnowTime() {
		actionForNoteData x = new actionForNoteData();
		String tmp = x.getdate();
		String chk[] = tmp.split(" ");
		assertEquals(chk[3], "03"); // Hour
		assertEquals(chk[4], "25"); // Minute
	}

}
