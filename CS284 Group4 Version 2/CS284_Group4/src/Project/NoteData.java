package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class NoteData extends JFrame {

	private JButton lf1, sf1, np1, np2, ud1, dl1;
	private JTextArea bw1;
	private JPanel Right, left, pc1,newPoke1,newPoke3,newPoke4,newPoke5,newPoke6,newPoke7;
	private JTextField nm1, hp1, cp1;
	private JComboBox<MonthType> tp1;
	private JComboBox tp2, tp3, tp4;
	private ArrayList<notePanel> box;
	private JLabel pic;
	private JRadioButton d1, d2, d3;
	private ButtonGroup g1;
	private String Choose;
	private actionForNoteData ac;
	private Timer time;

	NoteData() {

		ac = new actionForNoteData();
		MonthType type[] = ac.getMonthType();
		String[] itp2 = ac.getitp2();
		String[] itp3 = ac.getitp3();
		String[] itp4 = ac.getitp4();
		box = new ArrayList();
		pic = new JLabel();
		pc1 = new JPanel();
		pc1.setLayout(new GridLayout(1, 0));
		pc1.add(pic);
		nm1 = new JTextField(15);
		tp1 = new JComboBox(type);
		tp2 = new JComboBox(itp2);
		tp3 = new JComboBox(itp3);
		tp4 = new JComboBox(itp4);
		hp1 = new JTextField(3);
		cp1 = new JTextField(10);
		g1 = new ButtonGroup();
		d1 = new JRadioButton("1 Day.");
		d2 = new JRadioButton("2 Day.");
		d3 = new JRadioButton("3 Day.");
		g1.add(d1);
		g1.add(d2);
		g1.add(d3);
		lf1 = new JButton("Load File");
		sf1 = new JButton("Save File");
		np2 = new JButton("Reset Note");
		np1 = new JButton("New Note");
		bw1 = new JTextArea("Please Enter detail.");
		bw1.setLineWrap(true);
		dl1 = new JButton("Delete Note");
		ud1 = new JButton("Update Note");
		Right = new JPanel();
		Right.setLayout(new BorderLayout());
		left = new JPanel();
		left.setLayout(new GridLayout(15, 1));
		JPanel LoadandSave = new JPanel();
		LoadandSave.add(lf1);
		LoadandSave.add(sf1);
		LoadandSave.setPreferredSize(new Dimension(0, 40));
		JPanel newPoke = new JPanel();
		newPoke.setBorder(new TitledBorder(""));
		newPoke.setLayout(new BorderLayout());
		newPoke1 = new JPanel();
		newPoke1.add(np1);
		newPoke1.add(np2);
		JPanel newPoke2 = new JPanel();
		newPoke2.setLayout(new BorderLayout());
		JScrollPane c1 = new JScrollPane(bw1);
		newPoke2.add(c1);
		newPoke3 = new JPanel();
		newPoke3.add(new JLabel("Note: "));
		newPoke3.add(nm1);
		JPanel newPoke3_1 = new JPanel();
		newPoke3_1.add(new JLabel("Prior notice: "));
		newPoke3_1.add(d1);
		newPoke3_1.add(d2);
		newPoke3_1.add(d3);
		newPoke4 = new JPanel();
		newPoke4.add(new JLabel("Month: "));
		newPoke4.add(tp1);
		newPoke5 = new JPanel();
		newPoke5.add(new JLabel("Day: "));
		newPoke5.add(hp1);
		newPoke5.add(new JLabel("Time: "));
		newPoke5.add(tp2);
		newPoke5.add(tp3);
		newPoke6 = new JPanel();
		newPoke6.add(new JLabel("Year: "));
		newPoke6.add(tp4);
		newPoke7 = new JPanel();
		newPoke7.add(ud1);
		newPoke7.add(dl1);
		newPoke.add(newPoke1, BorderLayout.NORTH);
		newPoke.add(newPoke2, BorderLayout.CENTER);
		JPanel newPokeforSouth = new JPanel();
		newPoke1.setBackground(new Color(51, 153, 255));
		newPoke3.setBackground(new Color(102, 187, 255));
		bw1.setBackground(new Color(204, 229, 255));
		newPoke4.setBackground(new Color(102, 187, 255));
		newPoke5.setBackground(new Color(102, 187, 255));
		newPoke6.setBackground(new Color(102, 187, 255));
		newPoke7.setBackground(new Color(51, 153, 255));
		newPokeforSouth.setLayout(new GridLayout(0, 1));
		newPoke2.add(newPoke3, BorderLayout.NORTH);
		newPokeforSouth.add(newPoke5);
		newPokeforSouth.add(newPoke4);
		newPokeforSouth.add(newPoke6);
		newPokeforSouth.add(newPoke3_1);
		newPokeforSouth.add(newPoke7);
		newPokeforSouth.setPreferredSize(new Dimension(0, 200));
		newPoke.add(newPokeforSouth, BorderLayout.SOUTH);
		
		

		///// TIMER ACTION //////
		time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(box != null){
					for (int i = 0; i < box.size(); i++) {
						
						String nof = "Nofication: " + box.get(i).toto() + " Please check notes that become red color.";
						String ck = ac.checkCurrenTime(box,i);
						String ck2 = ac.checkNowTime();
						if (ac.checktime(ck,ck2) && box.get(i).getnof() == 0) {

							JOptionPane.showMessageDialog(null, nof);
							box.get(i).setBackground(new Color(255, 0, 0));
							box.get(i).setnof(1);
							notePanel tmp = box.get(i);
							box.remove(i);
							box.add(0, tmp);
							resetleft();

						} else if ((ac.checktimecomp(ck,ck2) <= 0 && box.get(i).getnof() == 0) && !(ck.equals("16:01:00:00:00"))) {
							System.out.println(ck.compareTo(ck2));
							JOptionPane.showMessageDialog(null, nof);
							box.get(i).setBackground(new Color(255, 0, 0));
							box.get(i).setnof(1);
							notePanel tmp = box.get(i);
							box.remove(i);
							box.add(0, tmp);
							resetleft();
						}

					}
				}
				

			}
		});
		
		
		
		
		
		////// LOAD ACTION //////
		lf1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				File file = null;
				chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				file = new File("");
				int op = chooser.showOpenDialog(null);
				if (op == chooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					try {
						ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
						box = (ArrayList<notePanel>) inputStream.readObject();
						resetleft();

					} catch (Exception e1) {

					}
					resetleft();
				}
			}
		});
		
		
		////// SAVE FILE ACTION //////
		sf1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				File file = null;
				int op = chooser.showSaveDialog(null);
				file = new File("");
				if (op == chooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					try {

						ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
						stream.writeObject(box);

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		
		
		////// NEW NOTE ACTION //////
		np1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final notePanel x = new notePanel();
				x.setBackground(new Color(100, 150, 100));
				x.setLayout(new BorderLayout());
				x.setBorder(new TitledBorder(""));
				JLabel po = new JLabel();
				x.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
					}

					@Override
					public void mouseEntered(MouseEvent e) {
					}

					@Override
					public void mouseClicked(MouseEvent e) {

						nm1.setText(x.getname());
						tp1.setSelectedItem(x.gettype());
						tp2.setSelectedIndex(x.gethr());
						tp3.setSelectedIndex(x.getmin());
						tp4.setSelectedIndex(x.getyear());
						hp1.setText(""); // days
						cp1.setText("" + x.getcp()); // null
						Choose = x.toString();
						
						newPoke1.setBackground(new Color(51, 153, 255));
						newPoke3.setBackground(new Color(102, 187, 255));
						bw1.setBackground(new Color(204, 229, 255));
						newPoke4.setBackground(new Color(102, 187, 255));
						newPoke5.setBackground(new Color(102, 187, 255));
						newPoke6.setBackground(new Color(102, 187, 255));
						newPoke7.setBackground(new Color(51, 153, 255));
						ud1.setEnabled(true);
					}
				});
				
				//////////////////
				po.setText("Click For Edit.");
				x.add(po);
				left.add(x);
				box.add(x);
				validate();
				repaint();

			}
		});
		
		
		////// DELETE ACTION //////
		dl1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					for (int i = 0; i < box.size(); i++) {

						if (box.get(i).toString().equals(Choose)) {
							box.remove(i);
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error Cant delete this.");
				}
				resetleft();

			}
		});

		
		////// UPDATE ACTION //////
		ud1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					for (int i = 0; i < box.size(); i++) {

						if (box.get(i).toString().equals(Choose)) {
							box.get(i).removeAll();
							box.get(i).setname(nm1.getText());
							box.get(i).settype((MonthType) tp1.getSelectedItem());
							box.get(i).sethr(tp2.getSelectedIndex());
							box.get(i).setmin(tp3.getSelectedIndex());
							box.get(i).setyear(tp4.getSelectedIndex());
							box.get(i).settime("" + tp2.getSelectedItem() + ":" + tp3.getSelectedItem());
							box.get(i).setcp(Integer.valueOf(hp1.getText()));
							box.get(i).setBackground(new Color(200, 200, 200));
							box.get(i).setnof(0);
							box.get(i).setdetail(bw1.getText());

							if (d1.isSelected())
								box.get(i).sethp(1);
							else if (d2.isSelected())
								box.get(i).sethp(2);
							else if (d3.isSelected())
								box.get(i).sethp(3);
							else {
								throw new Exception();
							}

							if (box.get(i).getcp() <= 0 || box.get(i).getcp() > 31) {
								box.get(i).setBackground(new Color(255, 255, 0));
								Choose = box.get(i).toString();
								throw new Exception();
							}

						}
					}
					resetleft();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error Please check entered.");
				}

			}
		});
		

		////// RESET NOTE ACTION //////
		np2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				box.clear();
				resetleft();
			}
		});
		

		////// Auto Load default //////
		box = ac.LoadFile("dafault.dat");
		resetleft();
		
		
		////// FRAME SETUP //////
		Right.add(newPoke);
		JPanel cent = new JPanel();
		cent.setLayout(new GridLayout(1, 2));
		left.setBorder(new TitledBorder(""));
		cent.add(left);
		left.setBackground(new Color(255, 255, 255));
		cent.add(Right);
		add(cent);
		JLabel picture = new JLabel();
		ImageIcon ico = new ImageIcon("gif.dat");
		picture.setIcon(ico);
		add(picture, BorderLayout.NORTH);
		JPanel sout = new JPanel();
		JLabel s1 = new JLabel(" Copyright by Animus Team © 2016    : Project CS284 【 Group 4 】"); 
		sout.setLayout(new BorderLayout());
		sout.add(s1);
		sout.setPreferredSize(new Dimension(0, 30));
		JPanel soutside = new JPanel();
		soutside.setLayout(new BorderLayout());
		LoadandSave.setBorder(new TitledBorder(""));
		soutside.add(LoadandSave, BorderLayout.NORTH);
		soutside.add(sout, BorderLayout.SOUTH);
		add(soutside, BorderLayout.SOUTH);
		
		time.start();
		setTitle("Smart Check");
		setSize(670, 698);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void resetleft() {
		left.removeAll();
		left.setPreferredSize(new Dimension(400, 400));
		for (int i = 0; i < box.size(); i++) {
			final notePanel x = box.get(i);
			x.setLayout(new BorderLayout());
			x.removeAll();

			JLabel po = new JLabel();

			x.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					nm1.setText(x.getname());
					tp1.setSelectedItem(x.gettype());
					hp1.setText("" + x.getyear());
					cp1.setText("" + x.getcp());

					nm1.setText(x.getname());
					tp1.setSelectedItem(x.gettype());
					tp2.setSelectedIndex(x.gethr());
					tp3.setSelectedIndex(x.getmin());
					tp4.setSelectedIndex(x.getyear());
					hp1.setText("" + x.getcp()); // days
					bw1.setText(x.getdetail());

					switch (x.gethp()) {
					case 1:
						d1.setSelected(true);
						break;
					case 2:
						d2.setSelected(true);
						break;
					case 3:
						d3.setSelected(true);
						break;
					}
					
					if (x.getnof()== 1) {
						newPoke1.setBackground(new Color(204, 0, 0));
						newPoke3.setBackground(new Color(255, 0, 0));
						bw1.setBackground(new Color(255, 102, 102));
						newPoke4.setBackground(new Color(255, 0, 0));
						newPoke5.setBackground(new Color(255, 0, 0));
						newPoke6.setBackground(new Color(255, 0, 0));
						newPoke7.setBackground(new Color(204, 0, 0));
						ud1.setEnabled(false);
					} else {
						newPoke1.setBackground(new Color(51, 153, 255));
						newPoke3.setBackground(new Color(102, 187, 255));
						bw1.setBackground(new Color(204, 229, 255));
						newPoke4.setBackground(new Color(102, 187, 255));
						newPoke5.setBackground(new Color(102, 187, 255));
						newPoke6.setBackground(new Color(102, 187, 255));
						newPoke7.setBackground(new Color(51, 153, 255));
						ud1.setEnabled(true);
					}

					cp1.setText("" + x.getcp()); // null
					Choose = x.toString();

				}
			});
			if (x.getcp() == 0) {
				po.setText("Click For Edit.");
				x.setBackground(new Color(100, 150, 100));
				for (int j = 0; j < box.size(); j++) {
					if (box.get(j).getcp() == 0) {
						notePanel tmp = box.get(j);
						box.remove(j);
						box.add(tmp);
						Choose = tmp.toString();
						resetleft2();
					}
				}
			} else
				po.setText(x.toStrings());
			x.add(po, BorderLayout.CENTER);
			left.add(x);
			validate();
			repaint();
		}

		repaint();
	}

	public void resetleft2() {
		left.removeAll();
		left.setPreferredSize(new Dimension(400, 500));
		for (int i = 0; i < box.size(); i++) {
			final notePanel x = box.get(i);
			x.setLayout(new BorderLayout());
			x.removeAll();

			JLabel po = new JLabel();

			x.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					nm1.setText(x.getname());
					tp1.setSelectedItem(x.gettype());
					hp1.setText("" + x.getyear());
					cp1.setText("" + x.getcp());

					nm1.setText(x.getname());
					tp1.setSelectedItem(x.gettype());
					tp2.setSelectedIndex(x.gethr());
					tp3.setSelectedIndex(x.getmin());
					tp4.setSelectedIndex(x.getyear());
					hp1.setText("" + x.getcp()); // days
					bw1.setText(x.getdetail());

					switch (x.gethp()) {
					case 1:
						d1.setSelected(true);
						break;
					case 2:
						d2.setSelected(true);
						break;
					case 3:
						d3.setSelected(true);
						break;
					}

					cp1.setText("" + x.getcp()); // null
					
					if (x.getnof()== 1) {
						newPoke1.setBackground(new Color(204, 0, 0));
						newPoke3.setBackground(new Color(255, 0, 0));
						bw1.setBackground(new Color(255, 102, 102));
						newPoke4.setBackground(new Color(255, 0, 0));
						newPoke5.setBackground(new Color(255, 0, 0));
						newPoke6.setBackground(new Color(255, 0, 0));
						newPoke7.setBackground(new Color(204, 0, 0));
						ud1.setEnabled(false);
					} else {
						newPoke1.setBackground(new Color(51, 153, 255));
						newPoke3.setBackground(new Color(102, 187, 255));
						bw1.setBackground(new Color(204, 229, 255));
						newPoke4.setBackground(new Color(102, 187, 255));
						newPoke5.setBackground(new Color(102, 187, 255));
						newPoke6.setBackground(new Color(102, 187, 255));
						newPoke7.setBackground(new Color(51, 153, 255));
						ud1.setEnabled(true);
					}
					
					Choose = x.toString();

				}
			});
			if (x.getcp() == 0) {
				po.setText("Click For Edit.");
			} else
				po.setText(x.toStrings());
			x.add(po, BorderLayout.CENTER);
			left.add(x);
			validate();
			repaint();
		}

		repaint();
	}

	
	

	

	

	public static void main(String[] args) {

		NoteData x = new NoteData();

	}

}
