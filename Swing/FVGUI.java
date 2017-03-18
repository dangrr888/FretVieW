/* Copyright (c) 2011-2012 Daniel Cumberbatch
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import Scale.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;
import java.util.*;
import Constants.*;
import Scale.Note.*;
import java.awt.print.*;

class PrintUtilities implements Printable
{
    public PrintUtilities(Component componentToBePrinted)  //constructor
    {
	this.componentToBePrinted = componentToBePrinted;
    }

    public static void printComponent(Component c) //this is static hence the creation of temporary
    {
	new PrintUtilities(c).print();
    }

    public void print() //PrintUtilities.print()
    {
	PrinterJob printJob = PrinterJob.getPrinterJob(); //static factory method
	printJob.setPrintable(this); //assign this.paint() to PrinterJob to render pages
	if (printJob.printDialog()) //returns boolean (rather than int) = true if user doesn't cancel the dialog
	        try
		    {
			printJob.print(); //calls print method of the prinateble class
		    }
		catch(PrinterException pe)
		    {
			System.out.println("Error printing: " + pe);
		    }
    }

    public int print(Graphics g, PageFormat pageFormat, int pageIndex) //specifies how to render pages
    {
	if (pageIndex > 0) {
	    return(NO_SUCH_PAGE);
	} else {
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	    disableDoubleBuffering(componentToBePrinted);
	    componentToBePrinted.paint(g2d);
	    //enableDoubleBuffering(componentToBePrinted); //makes things incredibly slow after preview/print
	    return(PAGE_EXISTS);
	}
    }

    public static void disableDoubleBuffering(Component c)
    {
	RepaintManager currentManager = RepaintManager.currentManager(c);
	currentManager.setDoubleBufferingEnabled(false);
    }

    /*
      public static void enableDoubleBuffering(Component c)
      {
      RepaintManager currentManager = RepaintManager.currentManager(c);
      currentManager.setDoubleBufferingEnabled(true);
      }
    */
    private Component componentToBePrinted;
}

//subclass representing dynamically allocated JMenuItem with default
//implementation for ActionListener bound to it.
@SuppressWarnings("serial")
class dynMenuItem extends JMenuItem implements ActionListener
{
    public dynMenuItem(String title, JTabbedPane j1, JMenu j2)
    {
	super(title);
	jtp = j1;
	jm = j2;
	addActionListener(this);
    }

    public int pos()
    {
	int i = 0;
	while(jm.getItem(i) != this && i != jtp.getTabCount())
	    ++i;
	return i;
    }

    public void actionPerformed(ActionEvent ae)
    {
	jtp.setSelectedIndex(pos());
    }

    static void shuffleAccelerators(JMenu jm)
    {
	for(int i = 0; i != jm.getItemCount(); ++i)
	    {
		dynMenuItem tmp = (dynMenuItem)jm.getItem(i);
		if(i < 10)
		    tmp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0+i, InputEvent.META_MASK));
	    }
    }

    JMenu jm;
    JTabbedPane jtp;
}

//subclass of FileFilter for FretView Source files
class FVFileFilter extends FileFilter
{
    public boolean accept(File file)
    {
	if(file.getName().endsWith(".fv")) return true;
	if(file.isDirectory()) return true;
	return false;
    }

    public String getDescription()
    {
	return "FretVieW Source File";
    }
}

@SuppressWarnings("serial")
class jbtnToolBar extends JButton
{
    public jbtnToolBar(String name, String filename)
    {
        super(new ImageIcon(filename));
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setToolTipText(name);
    }
}

//class to represent the FretVieW Help menu
@SuppressWarnings("serial")
class FVBrowser extends JFrame
{
    private Vector<String> urls = new Vector<String>();
    private int currIdx;
    private JButton jbtnPgBck, jbtnPgFwd, jbtnHome, jbtnOptns;
    //private JTextField jtfSearch;
    private JEditorPane editorPane;

    public FVBrowser(String title, String file, int width, int height)
    {
	super(title);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setSize(width, height);

	JPanel jpnMW = new JPanel();
        jpnMW.setLayout(new BorderLayout());
        jpnMW.setOpaque(true);
	jpnMW.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        String path = "File://" + (new File(file)).getAbsolutePath();
	final String homePath = path;
	urls.add(homePath);
	currIdx = 0;

        try {
            editorPane = new JEditorPane(homePath);
        } catch(IOException ioe) {
            System.err.println("Error displaying " + homePath);
        }

        editorPane.setEditable(false);
        editorPane.addHyperlinkListener(new HyperlinkListener()
            {
                public void hyperlinkUpdate(HyperlinkEvent hle)
                {
		    //System.out.println("Entered hyperlinkUpdate");
		    if(hle.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
			{
			    //System.out.println(currIdx);
			    //System.out.println(urls);
			    String s = hle.getURL().toString();
			    if(currIdx < urls.size() - 1)
				while(currIdx < urls.size() - 1)
				    {
					urls.remove(urls.size()-1);
					//System.out.println(urls);
				    }
			    urls.add(s);
			    ++currIdx;
			    try {
				editorPane.setPage(s);
			    } catch(IOException exc) {
				System.err.println("Error reeading " + s);
			    }
			    jbtnPgBck.setEnabled(true);
			    jbtnPgFwd.setEnabled(false);
			    //System.out.println(currIdx);
                            //System.out.println(urls);
			}
		    //System.out.println("Leaving hyperlinkUpdate");
                }
            });

	JToolBar jtb = new JToolBar(SwingConstants.HORIZONTAL);

	jbtnPgBck = new jbtnToolBar("Page Back", "images/pgbck.gif");
	jbtnPgBck.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    //System.out.println("Entered jbtnPgBck");
		    if(currIdx > 0)
			{
			    //System.out.println(currIdx);
			    //System.out.println(urls);
			    String s = urls.elementAt(currIdx-1);
			    try {
				editorPane.setPage(s);
			    } catch(IOException ioe) {
				System.err.println("Error reading page " + s);
			    }
			    --currIdx;
			    jbtnPgFwd.setEnabled(true);
			    if(currIdx == 0)
				jbtnPgBck.setEnabled(false);
			    //System.out.println(currIdx);
			    //System.out.println(urls);
			}
		    //System.out.println("Leaving jbtnPgBck");
		}
	    });
	jbtnPgBck.setEnabled(false);

	jbtnPgFwd = new jbtnToolBar("Page Forward", "images/pgfwd.gif");
	jbtnPgFwd.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    //System.out.println("Entered jbtnPgFwd");
		    if(currIdx < urls.size()-1)
			{
			    //System.out.println(currIdx);
			    //System.out.println(urls);
			    String s = urls.elementAt(currIdx + 1);
			    try {
				editorPane.setPage(s);
			    } catch(IOException ioe) {
				System.err.println("Error reading page " + s);
			    }
			    ++currIdx;
			    jbtnPgBck.setEnabled(true);
			    if(currIdx == (urls.size()-1))
				jbtnPgFwd.setEnabled(false);
			    //System.out.println(currIdx);
			    //System.out.println(urls);
			}
		    //System.out.println("Leaving jbtnPgFwd");
		}
	    });
	jbtnPgFwd.setEnabled(false);

	jbtnHome = new jbtnToolBar("Home", "images/home.gif");
	jbtnHome.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    if(currIdx < urls.size() -1)
		      	{
			    while(currIdx < urls.size() - 1)
				urls.remove(urls.size()-1);
			}
		    urls.add(homePath);
		    ++currIdx;
		    try {
			editorPane.setPage(homePath);
		    } catch(IOException ioe) {
			System.err.println("Error reading page " + homePath);
		    }
		    jbtnPgBck.setEnabled(true);
		    jbtnPgFwd.setEnabled(false);
		}
	    });

	jbtnOptns = new jbtnToolBar("Tools", "images/Optns.gif");
	final JPopupMenu jpmOptns = new JPopupMenu();
	jpmOptns.add(new JMenuItem("Zoom In"));
	jpmOptns.add(new JMenuItem("Zoom Out"));
	jpmOptns.addSeparator();
	jpmOptns.add(new JMenuItem("Find"));
	jpmOptns.addSeparator();
	jpmOptns.add(new JMenuItem("Print"));

	jbtnOptns.addMouseListener(new MouseAdapter()
	    {
		public void mousePressed(MouseEvent me)
		{
		    jpmOptns.show(me.getComponent(), 0, me.getComponent().getHeight());
		}
	    });

	final JLabel jlabSearch = new JLabel(new ImageIcon("images/Search.gif"));
	jlabSearch.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	JTextField jtfSearch = new JTextField(10);
	jtfSearch.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{

		}
	    });

	jtb.add(jbtnPgBck);
	jtb.add(jbtnPgFwd);
	jtb.addSeparator();
	jtb.add(jbtnHome);
	jtb.addSeparator();
	jtb.add(jbtnOptns);
	jtb.addSeparator(new Dimension(50,0));
	jtb.add(jlabSearch);
	jtb.add(jtfSearch);

	jpnMW.add(jtb, BorderLayout.NORTH);

	JPanel jpnTW = new JPanel();
	jpnTW.setLayout(new BorderLayout());
	jpnTW.setOpaque(true);
	jpnTW.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	jpnTW.add(new JScrollPane(editorPane), BorderLayout.CENTER);
	jpnMW.add(jpnTW, BorderLayout.CENTER);
	getContentPane().add(jpnMW);
	setVisible(false);
    }
}

class FVGUI
{
    JFrame jfrm; //Top-Level container
    JTabbedPane jtpFb, jtpCtrl; //Tabbed Pane containing Scale headers and images
    JFileChooser jfcOpen, jfcSave, jfcDefaultDir; //for generating open and save dialogs
    String[] scaleCat = {"Major", "Minor", "Major Pentatonic", "Minor Pentatonic", "Blues", "Natural Minor"}; //Fixed Scale categories
    String[] fixedKey = {"Ab","A","A#","Bb","B","B#","Cb","C","C#","Db","D","D#","Eb","E","E#","Fb","F","F#","Gb","G","G#"}; //Notes
    Integer[] num_frets_list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24}; //number of frets adoptable by scales
    Vector<Scale> scales = new Vector<Scale>(); //storage container for scales
    JButton jbtnAddNote, jbtnRemoveNote, jbtnClearScale;
    JMenu jmWindow;
    JMenuItem jmiEmpty;
    String defaultDir;
    JTextField jtfCurrDir;
    FVBrowser helpPallette, welcomePallette, quickstartPallette, releasenotesPallette;
    String defaultMarkerColour = Constants.defaultMarkerColour;
    int defaultMarkerIndex = Constants.defaultMarkerIndex;

    //returns String array containing fv file contents
    String[] readFile(String filename)
    {
	String[] ret = new String[6];
	FileReader fr;
	BufferedReader br;

	try {
	    fr = new FileReader(filename);
	    br = new BufferedReader(fr);
	} catch(FileNotFoundException exc) {
	    JOptionPane.showMessageDialog(jfrm, "Error Opening File", "Open Scale", JOptionPane.ERROR_MESSAGE);
	    return null;
	}

	try {
	    for(int i = 0; i != 6; ++i)
		{
		    String tmp = br.readLine();
		    int begin_idx = 0, end_idx = 0;
		    while(tmp.charAt(begin_idx) == ' ')
			++begin_idx;
		    end_idx = begin_idx;
		    while(tmp.charAt(end_idx) != '$')
			++end_idx;
		    if(begin_idx != end_idx)
			{
			    do {
				--end_idx;
			    } while(end_idx != begin_idx && tmp.charAt(end_idx) == ' ');
			    tmp = tmp.substring(begin_idx, end_idx+1);
			}
		    else
			tmp = null;
		    ret[i] = tmp;
		}
	} catch (IOException exc) {
	    JOptionPane.showMessageDialog(jfrm, "Error Reading File", "Open Scale", JOptionPane.ERROR_MESSAGE);
	    return null;
	}
	return ret;
    }

    //writes a properly formatted fv file for the scale stored in the idx'th element of scales
    //return boolean reflecting the success of the write
    boolean writeFile(File file, int idx)
    {
	try {
	    PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter(file)));
	    out.println(jtpFb.getTitleAt(idx) + "  $Scale Title");
	    if(scales.elementAt(idx).is_fixed()) //for Fixed Scales
		{
		    out.println("F" + "  $Fixed (F) or Custom (C)");
		    out.println(scales.elementAt(idx).get_cat() + "  $Fixed Scale Category: 1 = Major, 2 = Minor, etc.");
		    out.println(scales.elementAt(idx).get_key() + "  $Key of Fixed Scale");
		    out.println("  $Notes of Custom Scale");
		}
	    else //for Custom Scales
		{
		    out.println("C" + "  $Fixed (F) or Custom (C)");
		    out.println("  $Fixed Scale Category: 1 = Major, 2 = Minor, etc.");
		    out.println("  $Key of Fixed Scale");
		    out.println(scales.elementAt(idx).display_notes() + "  $Notes of Custom Scale");
		}
	    out.println(scales.elementAt(idx).get_num_frets() + "  $Number of Frets in Scale");
	    out.flush();
	    out.close();
	}
	catch(IOException exc) {
	    JOptionPane.showMessageDialog(jfrm, "Error writing file", "Save", JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	return true;
    }

    //generates and returns a Scale with specified category and key
    Scale generateFixedScale(int c, String k)
    {
	Scale sc = new Scale(c, k); //generate new scale
	sc.setMarker(defaultMarkerIndex, defaultMarkerColour); //set Marker
	scales.add(sc); //Adds Scale to Vector<Scale>
	return sc;
    }

    //parse new category, key and the selected index of the tabbedpane containing the scales
    JLabel[] replaceFixedScale(int c, String k, int idx)
    {
	int num_frets = scales.elementAt(idx).get_num_frets(); //retrieve current number of frets of selected scale
	int font_size = scales.elementAt(idx).get_font_size(); //retrieve current font size of selected scale

	Scale sc = new Scale(c, k); //generate a new Scale with new cat and key
	sc.setMarker(defaultMarkerIndex, defaultMarkerColour);
	sc.set_font_size(font_size); //set font size to previous

	scales.setElementAt(sc, idx); //replace old Scale in Vector<Scale> object, scales, at correct index with new Scale

	//regenerate JLabel here since we need both the new Scale and num_frets  and we can't parse both as return values
	JLabel[] ret = {
	    new JLabel(sc.displayHeader(), SwingConstants.CENTER),
            new JLabel(sc.display(num_frets), SwingConstants.CENTER)};
	return ret; //return the JLabel array, to be used in jpnScale, the output of which should be used to reset appropriate element of jtpFb
    }

    //generates an empty CustomScale, adds it to scales, and returns it
    Scale generateCustomScale(String[] notes)
    {
	Scale sc;
	if(notes == null)
	    sc = new CustomScale();
	else
	    sc = new CustomScale(notes);
	scales.add(sc);
	return sc;
    }

    String[] collectNotes(String s)
    {
	if(s == null)
	    return null;
	String[] ret = new String[fixedKey.length];
	int beg = 0, end = 0, num_notes = 0;
	while(beg != s.length() && end != s.length())
	    {
		while(beg != s.length() && s.charAt(beg) == ' ')
		    ++beg;
		end = beg;
		while(end != s.length() && s.charAt(end) != ' ')
		    ++end;
		if(beg != end)
		    {
			ret[num_notes] = s.substring(beg, end);
			++num_notes;
		    }
		beg = end;
	    }
	String[] ret2 = new String[num_notes];
	for(int i = 0; i != num_notes; ++i)
	    ret2[i] = ret[i];
	return ret2;
    }

    // returns JLabel array containing Scale header and corresponding image of Scale fretboard
    // of Scale argument, displaying a specified number of frets with the fretboard of a
    // specified font size (font is courier-new)
    JLabel[] jlabScale(Scale sc, int num_frets, int fsz)
    {
	sc.set_font_size(fsz);
	JLabel[] ret = {
	    new JLabel(sc.displayHeader(), SwingConstants.CENTER),
	    new JLabel(sc.display(num_frets), SwingConstants.CENTER)};
	return ret;
    }

    // returns correctly formatted JPanel instance containing scale fretboard
    JPanel jpnScale(JLabel[] jlabFb)
    {
	JPanel jpnFb = new JPanel();
	jpnFb.setLayout(new GridLayout(1,1));
	jpnFb.setOpaque(true);
	jpnFb.add(jlabFb[1]);
	jpnFb.setBackground(Color.WHITE);
	jpnFb.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	JScrollPane jscrlpFb = new JScrollPane(jpnFb);
	jscrlpFb.setColumnHeaderView(jlabFb[0]);
	jscrlpFb.setViewportBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.BLACK));
        jscrlpFb.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        jscrlpFb.getVerticalScrollBar().setUnitIncrement(10);
        jscrlpFb.getVerticalScrollBar().setBlockIncrement(10);
        jscrlpFb.getHorizontalScrollBar().setUnitIncrement(10);
        jscrlpFb.getHorizontalScrollBar().setBlockIncrement(10);
        JPanel jpnFbOuter = new JPanel();
        jpnFbOuter.setLayout(new BorderLayout());
        jpnFbOuter.setOpaque(true);
        jpnFbOuter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        jpnFbOuter.add(jscrlpFb);
	return jpnFbOuter;
    }

    // returns a JButton with specified actionCommand and image icon
    // to be used in Toolbar
    /*JButton jbtnToolBar(String name, String filename)
    {
        JButton jbtn = new JButton(new ImageIcon(filename));
        jbtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        jbtn.setHorizontalTextPosition(SwingConstants.CENTER);
        jbtn.setToolTipText(name);
	return jbtn;
    }
    */

    //Contstructor for FretVieW GUI
    FVGUI()
    {
	//Generate Frame
	jfrm = new JFrame("FretVieW");
	jfrm.setSize(1600, 600);
	jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//Generate Help and welcome pallette
	//helpPallette = new FVBrowser("FretVieW Help", "testpages/page1.html",1000,1000);
        //helpPallette = new FVBrowser("FretVieW Help", "help/index.html",1000,1000);
	//welcomePallette = new FVBrowser("Welcome to FretVieW", "help/welcome.html",500,500);
        //quickstartPallette = new FVBrowser("FretVieW Quick Start", "help/quickstart.html",500,500);
        //releasenotesPallette = new FVBrowser("FretVieW Release Notes", "help/releasenotes.html",500,500);

	//Generate main window
	JPanel jpnMW = new JPanel();
        jpnMW.setLayout(new BorderLayout());
        jpnMW.setOpaque(true);

        //Generate Tabbed Pane for Scales
        jtpFb = new JTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        jtpFb.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        jtpFb.setMinimumSize(new Dimension(170,1));

        //Generate ToolBar and buttons
	JToolBar jtb = new JToolBar("FretVieW ToolBox");

	//New Scale Button
	final JButton jbtnNew = new jbtnToolBar("New Scale", "./images/newScale.gif");
	jbtnNew.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    String[] species = {"Custom", "Fixed"};
		    int spec_arg  = JOptionPane.showOptionDialog(jfrm, "Select Scale Type", "New Scale",
								 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
								 null, species, species[1]);
		    if(spec_arg != JOptionPane.CLOSED_OPTION)
			{
			    Scale scTmp = null;
			    int cat_arg = 0, num_frets_arg = 0;
			    String key_arg = null, title_arg = null;

			    //get title
			    title_arg = (String) JOptionPane.showInputDialog(jfrm, "Provide Title", "New Scale",
									     JOptionPane.QUESTION_MESSAGE, null, null, "MyScale" + jtpFb.getTabCount());
			    if(title_arg == null)
				return;

			    switch(spec_arg)
				{
				case 0:    //Custom Scale
				    //generate Custom Scale
				    scTmp = generateCustomScale(null);
				    if(scTmp == null)
					return;
				    break;
				case 1:    //Fixed Scale
				    //get fixed scale category
				    String tmp = (String) JOptionPane.showInputDialog(jfrm, "Select Scale Category", "New Scale",
										      JOptionPane.QUESTION_MESSAGE, null, scaleCat, scaleCat[0]);
				    if(tmp == null)
					return;

				    while(cat_arg != scaleCat.length && tmp != scaleCat[cat_arg])
					++cat_arg;

				    //get fixed scale key
				    key_arg = (String) JOptionPane.showInputDialog(jfrm, "Select Key", "New Scale",
										   JOptionPane.QUESTION_MESSAGE, null, fixedKey, "Ab");
				    if(key_arg == null)
					return;

				    //generate Fixed Scale
				    scTmp = generateFixedScale(cat_arg+1, key_arg);
				    if(scTmp == null)
					return;
				    break;
				}

			    //get number of frets
			    num_frets_arg = (Integer) JOptionPane.showInputDialog(jfrm, "Select Number of Frets", "New Scale",
										  JOptionPane.QUESTION_MESSAGE, null, num_frets_list, 1);
			    if(num_frets_arg == 0)
				return;

			    jtpFb.add(title_arg, jpnScale(jlabScale(scTmp, num_frets_arg, Constants.defaultFontSize)));
			    if(jtpFb.getTabCount() > 1)
				jtpFb.setSelectedIndex(jtpFb.getTabCount()-1);

			    if(jmWindow.getItemCount() == 1 && jmWindow.getItem(0) == jmiEmpty)
				jmWindow.remove(jmiEmpty);
			    jmWindow.add(new dynMenuItem("Window " + jtpFb.getSelectedIndex() + " - " + jtpFb.getTitleAt(jtpFb.getSelectedIndex()),
							 jtpFb, jmWindow));
			    dynMenuItem.shuffleAccelerators(jmWindow);
			}
		}
	    });
	jtb.add(jbtnNew);

	//initialize default directory JFileChooser
	jfcDefaultDir = new JFileChooser(defaultDir);
	jfcDefaultDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	defaultDir = jfcDefaultDir.getCurrentDirectory().getPath();

	final JButton jbtnOpen = new jbtnToolBar("Open Scale", "images/openScale.gif");
	jbtnOpen.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jfcOpen = new JFileChooser(defaultDir);
		    jfcOpen.setFileFilter(new FVFileFilter());
		    int open_arg = jfcOpen.showOpenDialog(jfrm);
		    if(open_arg == JFileChooser.APPROVE_OPTION)
			{
			    String[] fileData = readFile(jfcOpen.getSelectedFile().getPath()); //reads data file and returns String[] with line contents up to "//"
			    if(fileData[1].equals("F")) //Fixed Scale
				jtpFb.add(fileData[0], jpnScale(jlabScale(generateFixedScale(Integer.parseInt(fileData[2]), fileData[3]), Integer.parseInt(fileData[5]), Constants.defaultFontSize)));
			    else
				{
				    String[] notes = collectNotes(fileData[4]); //returns null if fileData[4] is null
				    jtpFb.add(fileData[0], jpnScale(jlabScale(generateCustomScale(notes), Integer.parseInt(fileData[5]), Constants.defaultFontSize))); //if notes is null adds empty CustomScale
				};
                            if(jtpFb.getTabCount() > 1)
                                jtpFb.setSelectedIndex(jtpFb.getTabCount()-1);

			    if(jmWindow.getItemCount() == 1 && jmWindow.getItem(0) == jmiEmpty)
				jmWindow.remove(jmiEmpty);
			    jmWindow.add(new dynMenuItem("Window " + jtpFb.getSelectedIndex() + " - " + jtpFb.getTitleAt(jtpFb.getSelectedIndex()),
						       jtpFb, jmWindow));
			    dynMenuItem.shuffleAccelerators(jmWindow);
			}
		}
	    });
        jtb.add(jbtnOpen);

	final JButton jbtnClose = new jbtnToolBar("Close Scale", "images/closeScale.gif");
	jbtnClose.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    int idx = -1;
		    idx = jtpFb.getSelectedIndex();
		    if(idx != -1)
			{
			    String tName = jtpFb.getTitleAt(idx);
			    int confirm_arg = JOptionPane.showConfirmDialog(jfrm, "Are you sure you wish to close tab \"" + tName + "\" ?",
									    "Close Scale", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

			    if(confirm_arg == JOptionPane.YES_OPTION)
				{
				    jtpFb.remove(idx);
				    scales.remove(idx);
				}

			    jmWindow.remove(idx);
                            if(jmWindow.getItemCount() == 0)
                                jmWindow.add(jmiEmpty);
			    else
				dynMenuItem.shuffleAccelerators(jmWindow);
			}
		    else
			{
			    JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Close Scale", JOptionPane.WARNING_MESSAGE);
			}
		}
	    });
        jtb.add(jbtnClose);
        jtb.add(new JToolBar.Separator());

        final JButton jbtnSave = new jbtnToolBar("Save Scale", "images/save.gif");
        jbtnSave.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
		{
		    jfcSave = new JFileChooser(defaultDir);
		    jfcSave.setFileFilter(new FVFileFilter());
		    jfcSave.setSelectedFile(new File("default.fv"));
		    int idx = -1;
		    idx = jtpFb.getSelectedIndex();
		    if(idx != -1)
			{
			    boolean status = false;
			    int result = jfcSave.showSaveDialog(jfrm);
			    if(result == JFileChooser.CANCEL_OPTION)
				status = true;
			    else if (result == JFileChooser.APPROVE_OPTION)
				{
				    if(jfcSave.getSelectedFile().exists())
					{
					    int response = JOptionPane.showConfirmDialog(jfrm, "Overwrite existing file?",
											 "Confirm Overwrite", JOptionPane.OK_CANCEL_OPTION);
					    if(response == JOptionPane.CANCEL_OPTION)
						status = false;
					}
				    status = writeFile(jfcSave.getSelectedFile(), idx);
				}
			    else
				status = false;

			    if(!status)
				JOptionPane.showMessageDialog(jfrm, "I/O Error saving file!!", "Save Scale", JOptionPane.WARNING_MESSAGE);
			}
		    else
			JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Save Scale", JOptionPane.WARNING_MESSAGE);
		}
            });
        jtb.add(jbtnSave);
	jtb.add(new JToolBar.Separator());

        final JButton jbtnPrint = new jbtnToolBar("Print", "images/print.gif");
	jbtnPrint.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    PrintUtilities.printComponent(jtpFb.getSelectedComponent());
		}
	    });

        jtb.add(jbtnPrint);

	jbtnAddNote = new jbtnToolBar("Add Note", "images/addNote.gif");
	jbtnAddNote.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    if(jtpFb.getTabCount() != 0)
			{
			    int idx = jtpFb.getSelectedIndex();
			    if(!scales.elementAt(idx).is_fixed())
				{
				    String note = (String) JOptionPane.showInputDialog(jfrm, "Select Note", "Add Note",
                                                                                   JOptionPane.QUESTION_MESSAGE, null, fixedKey, "Ab");
                                    if(note == null)
                                        return;
				    scales.elementAt(idx).add(Note.strToNote(note));
				    jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
				}
			    else
				JOptionPane.showMessageDialog(jfrm, "Cannot Add Note to a Fixed Scale!", "Add Note", JOptionPane.WARNING_MESSAGE);
			}
		    else
			JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Add Tab", JOptionPane.WARNING_MESSAGE);
		}
	    });
        jtb.add(new JToolBar.Separator());
        jtb.add(jbtnAddNote);

        jbtnRemoveNote = new jbtnToolBar("Remove Note", "images/removeNote.gif");
        jbtnRemoveNote.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(jtpFb.getTabCount() != 0)
                        {
                            int idx = jtpFb.getSelectedIndex();
                            if(!scales.elementAt(idx).is_fixed())
                                {
				    if(scales.elementAt(idx).num_notes() > 0)
					{
					    String note = (String) JOptionPane.showInputDialog(jfrm, "Select Note", "Remove Note",
											       JOptionPane.QUESTION_MESSAGE, null, fixedKey, "Ab");
					    if(note == null)
						return;
					    scales.elementAt(idx).remove(Note.strToNote(note));
					    jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
					}
				    else
					JOptionPane.showMessageDialog(jfrm, "Scale is empty!", "Remove Note", JOptionPane.WARNING_MESSAGE);
                                }
                            else
                                JOptionPane.showMessageDialog(jfrm, "Cannot Remove Note from a Fixed Scale!", "Remove Note", JOptionPane.WARNING_MESSAGE);
                        }
                    else
                        JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Remove Tab", JOptionPane.WARNING_MESSAGE);
                }
            });
        jtb.add(jbtnRemoveNote);

        jbtnClearScale = new jbtnToolBar("Clear Scale", "images/clearScale.gif");
        jbtnClearScale.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(jtpFb.getTabCount() != 0)
                        {
                            int idx = jtpFb.getSelectedIndex();
                            if(!scales.elementAt(idx).is_fixed())
                                {
				    scales.elementAt(idx).clear();
				    jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
				}
			    else
                                JOptionPane.showMessageDialog(jfrm, "Cannot clear a Fixed Scale!", "Clear Scale", JOptionPane.WARNING_MESSAGE);
                        }
                    else
                        JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Clear Scale", JOptionPane.WARNING_MESSAGE);
                }
            });
        jtb.add(jbtnClearScale);

        final JButton jbtnAddFret = new jbtnToolBar("Add Fret", "images/addFret.gif");
	jbtnAddFret.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    if(jtpFb.getTabCount() != 0)
			{
			    int idx = jtpFb.getSelectedIndex();
			    int cur_num_frets = scales.elementAt(idx).get_num_frets();
			    if(cur_num_frets < Constants.no_frets)
				jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), cur_num_frets+1, scales.elementAt(idx).get_font_size()))); //this resets Scale::cur_num_frets by calling jpnScale with local cur_num_frets member
			    else
				JOptionPane.showMessageDialog(jfrm, "Maximum number of frets is 24", "Add Fret", JOptionPane.WARNING_MESSAGE);
			}
		    else
			JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Add Fret", JOptionPane.WARNING_MESSAGE);
		}
	    });
        jtb.add(new JToolBar.Separator());
        jtb.add(jbtnAddFret);

        final JButton jbtnRemoveFret = new jbtnToolBar("Remove Fret", "images/removeFret.gif");
        jbtnRemoveFret.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(jtpFb.getTabCount() != 0)
                        {
                            int idx = jtpFb.getSelectedIndex();
                            int cur_num_frets = scales.elementAt(idx).get_num_frets();
                            if(cur_num_frets > 1)
				jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), cur_num_frets-1, scales.elementAt(idx).get_font_size()))); //this resets Scale::cur_num_frets by calling jpnScale with local cur_num_frets member
                            else
                                JOptionPane.showMessageDialog(jfrm, "Minimum number of frets is 1", "Remove Fret", JOptionPane.WARNING_MESSAGE);
                        }
                    else
			JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Remove Fret", JOptionPane.WARNING_MESSAGE);
                }
            });
        jtb.add(jbtnRemoveFret);

        final JButton jbtnZoomIn = new jbtnToolBar("Zoom In", "images/zoomIn.gif");
	jbtnZoomIn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(jtpFb.getTabCount() != 0)
                        {
                            int idx = jtpFb.getSelectedIndex();
                            int cur_font_size = scales.elementAt(idx).get_font_size();
			    if(cur_font_size < Constants.maxFontSize)
				jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), cur_font_size + 1)));
			    else
				JOptionPane.showMessageDialog(jfrm, "Maximum font size is " + Constants.maxFontSize, "Zoom In", JOptionPane.WARNING_MESSAGE);
                        }
                    else
                        JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Zoom In", JOptionPane.WARNING_MESSAGE);
                }
            });
        jtb.add(new JToolBar.Separator());
        jtb.add(jbtnZoomIn);

        final JButton jbtnZoomOut = new jbtnToolBar("Zoom Out", "images/zoomOut.gif");
	jbtnZoomOut.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    if(jtpFb.getTabCount() != 0)
                        {
                            int idx = jtpFb.getSelectedIndex();
			    int cur_font_size = scales.elementAt(idx).get_font_size();
                            if(cur_font_size > 1)
				jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), cur_font_size - 1)));
                            else
                                JOptionPane.showMessageDialog(jfrm, "Minimum font size is 1", "Zoom Out", JOptionPane.WARNING_MESSAGE);
                        }
                    else
                        JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Zoom Out", JOptionPane.WARNING_MESSAGE);
                }
            });
        jtb.add(jbtnZoomOut);

	final JButton jbtnChangeMarker = new jbtnToolBar("Change Marker", "images/colour.png");
	jbtnChangeMarker.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
                    if(jtpFb.getTabCount() != 0)
                        {
                            int idx = jtpFb.getSelectedIndex();

                            String[] markers = Scale.getMarkers(scales.elementAt(idx).getMarkerColour());
                            int markerIdx = 0;
                            while(markerIdx != markers.length && !(markers[markerIdx].equals(scales.elementAt(idx).getMarker()))) ++markerIdx;
                            if(markerIdx == markers.length) return;

                            markers = Scale.getMarkers(Constants.defaultMarkerColour); //display list of choices in Constants.defaultMarkerColour just in case someone selects invisible
                            for(int i = 0; i != markers.length; ++i) markers[i] = "<html><FONT SIZE=5>" + markers[i].substring(1, markers[i].length()-2) + "</FONT>";
                            String result_m =  (String) JOptionPane.showInputDialog(jfrm, "Select Marker", "Change Marker",
										    JOptionPane.QUESTION_MESSAGE, null, markers, markers[markerIdx]);
                            markerIdx = 0;
                            while(markerIdx != markers.length && !(markers[markerIdx].equals(result_m))) ++markerIdx;
                            if(markerIdx == markers.length) return;

                            if(result_m != null)
                                {
                                    Color colour = JColorChooser.showDialog(jfrm, "Choose Marker Colour", Color.decode(scales.elementAt(idx).getMarkerColour()));
                                    if(colour != null)
                                        {
					    String primaries[] = {Integer.toHexString(colour.getRed()), Integer.toHexString(colour.getGreen()), Integer.toHexString(colour.getBlue())};
                                            String result_c = "#";
					    for(String s : primaries)
						{
						    s = s.length() == 1 ? "0" + s : s;
						    result_c += s;
						}

                                            int result_all = JOptionPane.showConfirmDialog(jfrm, "Apply to all scales?", "Change Marker", JOptionPane.YES_NO_CANCEL_OPTION);
                                            switch(result_all)
                                                {
                                                case JOptionPane.NO_OPTION:
                                                    scales.elementAt(idx).setMarker(markerIdx, result_c);
                                                    jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
                                                    break;
                                                case JOptionPane.YES_OPTION:
                                                    for(idx = 0; idx != jtpFb.getTabCount(); ++idx)
                                                        {
                                                            scales.elementAt(idx).setMarker(markerIdx, result_c);
                                                            jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
                                                            defaultMarkerColour = result_c;
                                                            defaultMarkerIndex = markerIdx;
                                                        }
                                                    break;
                                                case JOptionPane.CLOSED_OPTION:
                                                    break;
                                                }
                                        }
                                }
                        }
                    else
                        JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Rename Scale", JOptionPane.WARNING_MESSAGE);
                }
	    });
	jtb.add(new JToolBar.Separator());
	jtb.add(jbtnChangeMarker);

        final JButton jbtnHelp = new jbtnToolBar("Help", "images/help.gif");
	jbtnHelp.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
                  //helpPallette.setVisible(true);
		}
	    });
        jtb.add(new JToolBar.Separator());
        jtb.add(jbtnHelp);

        jpnMW.add(jtb, BorderLayout.NORTH); //add toolbar to main window

        // Generate Menus
	JMenuBar jmb = new JMenuBar();

        //Generate File Menu
        JMenu jmFile = new JMenu("File");
	jmFile.setMnemonic(KeyEvent.VK_F);

	final JMenuItem jmiNew = new JMenuItem("New Scale", KeyEvent.VK_N);
	jmiNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_MASK));
        jmiNew.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnNew.doClick();
		}
	    });
	jmFile.add(jmiNew);

        final JMenuItem jmiOpen = new JMenuItem("Open Scale", KeyEvent.VK_O);
	jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_MASK));
        jmiOpen.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnOpen.doClick();
		}
	    });
        jmFile.add(jmiOpen);

        final JMenuItem jmiClose = new JMenuItem("Close Scale", KeyEvent.VK_W);
	jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.META_MASK));
	jmiClose.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnClose.doClick();
		}
	    });
        jmFile.add(jmiClose);
	jmFile.add(new JSeparator());

        final JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
	jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK));
	jmiSave.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnSave.doClick();
		}
	    });
	jmFile.add(jmiSave);
        jmFile.add(new JSeparator());

        final JMenuItem jmiPrint = new JMenuItem("Print", KeyEvent.VK_P);
	jmiPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.META_MASK));
	jmiPrint.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnPrint.doClick();
		}
	    });
        jmFile.add(jmiPrint);
        jmFile.add(new JSeparator());

        final JMenuItem jmiQuit = new JMenuItem("Quit", KeyEvent.VK_Q);
	jmiQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.META_MASK));
	jmiQuit.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    int result = JOptionPane.showConfirmDialog(jfrm, "Quit FretVieW?");
		    if(result == JOptionPane.YES_OPTION)
			System.exit(0);
		}
	    });
        jmFile.add(jmiQuit);

        jmb.add(jmFile);

	//Generate Edit Menu
        JMenu jmEdit = new JMenu("Edit");
	jmEdit.setMnemonic(KeyEvent.VK_E);

        final JMenuItem jmiRename = new JMenuItem("Rename Scale", KeyEvent.VK_R);
	jmiRename.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.BUTTON3_MASK+InputEvent.SHIFT_MASK+2*InputEvent.META_MASK));
        jmiRename.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
		    if(jtpFb.getTabCount() != 0)
			{
			    String title_arg = (String) JOptionPane.showInputDialog(jfrm, "Provide Title", "Rename Scale",
										    JOptionPane.QUESTION_MESSAGE, null, null, jtpFb.getTitleAt(jtpFb.getSelectedIndex()));
			    if(title_arg == null)
				return;
			    jtpFb.setTitleAt(jtpFb.getSelectedIndex(), title_arg);
			    jmWindow.getItem(jtpFb.getSelectedIndex()).setText("Window " + jtpFb.getSelectedIndex() + " - " + jtpFb.getTitleAt(jtpFb.getSelectedIndex()));
			}
		    else
			JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Rename Scale", JOptionPane.WARNING_MESSAGE);
                }
            });
        jmEdit.add(jmiRename);
	jmEdit.add(new JSeparator());

	final JMenuItem jmiChangeMarker = new JMenuItem("Change Marker", KeyEvent.VK_M);
	jmiChangeMarker.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.META_MASK+InputEvent.SHIFT_MASK));
	jmiChangeMarker.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnChangeMarker.doClick();
		}
	    });
	jmEdit.add(jmiChangeMarker);
	jmEdit.add(new JSeparator());

	final JMenuItem jmiChangeDefaultDir = new JMenuItem("Change Current Directory", KeyEvent.VK_D);
	jmiChangeDefaultDir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.META_MASK));
	jmiChangeDefaultDir.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    int dd_arg = jfcDefaultDir.showDialog(jfrm, "Select");
		    if(dd_arg == JFileChooser.APPROVE_OPTION)
			{
			    if(!defaultDir.equals(jfcDefaultDir.getSelectedFile().getPath()) && jfcDefaultDir.getSelectedFile().isDirectory())
				{
				    defaultDir = jfcDefaultDir.getSelectedFile().getPath();
				    jtfCurrDir.setText(defaultDir);
				}
			}
		}
	    });
	jmEdit.add(jmiChangeDefaultDir);

	jmb.add(jmEdit);

        //Generate View Menu
        JMenu jmView = new JMenu("View");
	jmView.setMnemonic(KeyEvent.VK_V);

        final JMenu jmZoom = new JMenu("Zoom");
	jmZoom.setMnemonic(KeyEvent.VK_V);

        JMenuItem jmiZoomIn = new JMenuItem("Zoom In", KeyEvent.VK_EQUALS);
	jmiZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.META_MASK));
	jmiZoomIn.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnZoomIn.doClick();
		}
	    });
        jmZoom.add(jmiZoomIn);

        JMenuItem jmiZoomOut = new JMenuItem("Zoom Out", KeyEvent.VK_MINUS);
	jmiZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, InputEvent.META_MASK));
	jmiZoomOut.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnZoomOut.doClick();
		}
	    });
        jmZoom.add(jmiZoomOut);

        jmView.add(jmZoom);

        jmb.add(jmView);

        //Generate Tools Menu
        JMenu jmTools = new JMenu("Tools");
	jmTools.setMnemonic(KeyEvent.VK_T);

        final JMenuItem jmiAddNote = new JMenuItem("Add Note", KeyEvent.VK_A);
	jmiAddNote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.META_MASK+InputEvent.SHIFT_MASK));
        jmiAddNote.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    jbtnAddNote.doClick();
                }
            });
        jmTools.add(jmiAddNote);

        final JMenuItem jmiRemoveNote = new JMenuItem("Remove Note", KeyEvent.VK_R);
	jmiRemoveNote.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.META_MASK+InputEvent.SHIFT_MASK));
        jmiRemoveNote.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    jbtnRemoveNote.doClick();
                }
            });
        jmTools.add(jmiRemoveNote);

        final JMenuItem jmiClearScale = new JMenuItem("Clear Scale", KeyEvent.VK_C);
	jmiClearScale.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_MASK+InputEvent.SHIFT_MASK));
        jmiClearScale.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    jbtnClearScale.doClick();
                }
            });
        jmTools.add(jmiClearScale);
        jmTools.add(new JSeparator());

        final JMenuItem jmiAddFret = new JMenuItem("Add Fret", KeyEvent.VK_D);
	jmiAddFret.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.META_MASK));
        jmiAddFret.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    jbtnAddFret.doClick();
                }
            });
        jmTools.add(jmiAddFret);

        final JMenuItem jmiRemoveFret = new JMenuItem("Remove Fret", KeyEvent.VK_E);
	jmiRemoveFret.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.META_MASK));
        jmiRemoveFret.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    jbtnRemoveFret.doClick();
                }
            });
        jmTools.add(jmiRemoveFret);

        jmb.add(jmTools);

        //Generate Window Menu
        jmWindow = new JMenu("Window");
	jmiEmpty = new JMenuItem("<empty>");
	jmWindow.add(jmiEmpty);
	jmiEmpty.setEnabled(false);
	jmb.add(jmWindow);

        //Generate Help Menu
        JMenu jmHelp = new JMenu("Help");
	jmHelp.setMnemonic(KeyEvent.VK_H);

        JMenuItem jmiFVHelp = new JMenuItem("FretVieW Help", KeyEvent.VK_H);
	jmiFVHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.META_MASK+InputEvent.SHIFT_MASK));
	jmiFVHelp.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jbtnHelp.doClick();
		}
	    });

        JMenuItem jmiWelcome = new JMenuItem("Welcome to FretVieW", KeyEvent.VK_W);
	jmiWelcome.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                  //welcomePallette.setVisible(true);
                }
	    });
	jmiWelcome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.BUTTON3_MASK+2*InputEvent.META_MASK+InputEvent.SHIFT_MASK));

	JMenuItem jmiFVQS = new JMenuItem("FretVieW Quick Start", KeyEvent.VK_Q);
        jmiFVQS.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                  //quickstartPallette.setVisible(true);
                }
            });
	jmiFVQS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.BUTTON3_MASK+2*InputEvent.META_MASK+InputEvent.SHIFT_MASK));

        JMenuItem jmiFVRN = new JMenuItem("FretVieW Release Notes", KeyEvent.VK_R);
        jmiFVRN.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                  //releasenotesPallette.setVisible(true);
                }
            });
	jmiFVRN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.BUTTON3_MASK+2*InputEvent.META_MASK+InputEvent.SHIFT_MASK));

        JMenuItem jmiAboutFV = new JMenuItem("About FretVieW", KeyEvent.VK_A);
        jmiAboutFV.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
		    JLabel caption = new JLabel("<html><p><b><br><font size = 4>FretVieW</font></b><br><br>"
						+ "<font size = 2> Version 1.0<br><br>"
						+ "Copyright &#9400 2012 D.T. Cumberbatch<br>"
						+ "All rights reserved.</font></p></html>");
		    JOptionPane.showMessageDialog(jfrm, caption, "About FretVieW 1.0", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/fv.png"));
                }
            });
	jmiAboutFV.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.BUTTON3_MASK+2*InputEvent.META_MASK+InputEvent.SHIFT_MASK));
        jmHelp.add(jmiFVHelp);
        jmHelp.add(new JSeparator());
        jmHelp.add(jmiWelcome);
        jmHelp.add(jmiFVQS);
        jmHelp.add(jmiFVRN);
        jmHelp.add(new JSeparator());
        jmHelp.add(jmiAboutFV);
	jmb.add(jmHelp);

	//Current Directory TextField
	JLabel jlabCurrDir = new JLabel("Current Directory: ");
	jtfCurrDir = new JTextField(30);
	jtfCurrDir.setText(defaultDir);

	jtfCurrDir.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    File tmp = new File(jtfCurrDir.getText());
		    if(tmp.isDirectory())
			defaultDir = jtfCurrDir.getText();
		    else
			jtfCurrDir.setText(defaultDir);
		}
	    });
	JButton jbtnCurrDir = new jbtnToolBar("Change Current Directory", "./images/CurrDir.png");
	jbtnCurrDir.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    jmiChangeDefaultDir.doClick();
		}
	    });
        jtb.add(new JToolBar.Separator());
	jtb.add(jlabCurrDir);
	jtb.add(jtfCurrDir);
	jtb.add(jbtnCurrDir);

	//Generate Ctrl Pane
	jtpCtrl = new JTabbedPane();

	//Generate Fixed Scale Ctrl Pane
	JPanel jpnFixedInner = new JPanel();
	jpnFixedInner.setLayout(new GridLayout(12,1));
	jpnFixedInner.setOpaque(true);
	JLabel jlabScaleCat = new JLabel("  Scale Category:");
	jpnFixedInner.add(jlabScaleCat);
	final JComboBox jcbScaleCat = new JComboBox(scaleCat);
	jpnFixedInner.add(jcbScaleCat);
	jpnFixedInner.add(new JLabel());
	jpnFixedInner.add(new JSeparator(SwingConstants.HORIZONTAL));
	JLabel jlabFixedKey = new JLabel("  Key:");
	jpnFixedInner.add(jlabFixedKey);
	final JComboBox jcbFixedKey = new JComboBox(fixedKey);
	jpnFixedInner.add(jcbFixedKey);
	jpnFixedInner.add(new JLabel());
	jpnFixedInner.add(new JSeparator(SwingConstants.HORIZONTAL));
	final JButton jbtnFixedUpdate = new JButton("Update");
	jbtnFixedUpdate.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    if(jtpFb.getTabCount() != 0)
			{
			    int cat = jcbScaleCat.getSelectedIndex();
			    String key = (String) jcbFixedKey.getItemAt(jcbFixedKey.getSelectedIndex());
			    jtpFb.setComponentAt(jtpFb.getSelectedIndex(), jpnScale(replaceFixedScale(cat + 1, key, jtpFb.getSelectedIndex())));
			}
		    else
			JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Fixed Scale Update", JOptionPane.WARNING_MESSAGE);
		}
	    });
	jpnFixedInner.add(jbtnFixedUpdate);
	jpnFixedInner.add(new JLabel());
	jpnFixedInner.add(new JSeparator(SwingConstants.HORIZONTAL));
	jpnFixedInner.add(new JLabel());

	jpnFixedInner.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	JScrollPane jscrlpFixed = new JScrollPane(jpnFixedInner);
	jscrlpFixed.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	jscrlpFixed.getVerticalScrollBar().setUnitIncrement(10);
	jscrlpFixed.getVerticalScrollBar().setBlockIncrement(10);
	jscrlpFixed.getHorizontalScrollBar().setUnitIncrement(10);
	jscrlpFixed.getHorizontalScrollBar().setUnitIncrement(10);
	JPanel jpnFixedOuter = new JPanel();
	jpnFixedOuter.setLayout(new BorderLayout());
	jpnFixedOuter.setOpaque(true);
	jpnFixedOuter.add(jscrlpFixed);
	jpnFixedOuter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	jtpCtrl.addTab("Fixed", jpnFixedOuter);

	//Generate Custom Scale Ctrl Pane
	JPanel jpnCustomInner = new JPanel();
        jpnCustomInner.setLayout(new GridLayout(12,1));
        jpnCustomInner.setOpaque(true);
        JLabel jlabScaleChange = new JLabel("  Scale Change:");
        jpnCustomInner.add(jlabScaleChange);
        String[] scaleChange = {"Add Note", "Remove Note", "Clear Scale"};
        final JComboBox jcbScaleChange = new JComboBox(scaleChange);
        jpnCustomInner.add(jcbScaleChange);
        jpnCustomInner.add(new JLabel());
        jpnCustomInner.add(new JSeparator(SwingConstants.HORIZONTAL));

        JLabel jlabCustomNote = new JLabel("  Note:");
        jpnCustomInner.add(jlabCustomNote);
        String[] customNote = {"Ab", "A","A#", "Bb", "B", "B#", "Cb", "C", "C#", "Db", "D", "D#", "Eb", "E", "E#", "Fb", "F", "F#", "Gb", "G", "G#"};
        final JComboBox jcbCustomNote = new JComboBox(customNote);
        jpnCustomInner.add(jcbCustomNote);
        jpnCustomInner.add(new JLabel());
        jpnCustomInner.add(new JSeparator(SwingConstants.HORIZONTAL));

        JButton jbtnCustomUpdate = new JButton("Update");
	jbtnCustomUpdate.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent ae)
		{
		    if(jtpFb.getTabCount() != 0)
			{
			    int idx = jtpFb.getSelectedIndex();
			    int change = jcbScaleChange.getSelectedIndex();
			    String note = (String) jcbCustomNote.getItemAt(jcbCustomNote.getSelectedIndex());

			    switch(change)
				{
				case 0: //add note
				    scales.elementAt(idx).add(Note.strToNote(note));
				    jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
				    break;
				case 1: //remove note
                                    scales.elementAt(idx).remove(Note.strToNote(note));
                                    jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
				    break;
				case 2: //clear scale
                                    scales.elementAt(idx).clear();
                                    jtpFb.setComponentAt(idx, jpnScale(jlabScale(scales.elementAt(idx), scales.elementAt(idx).get_num_frets(), scales.elementAt(idx).get_font_size())));
				    break;
				}
			}
		    else
			JOptionPane.showMessageDialog(jfrm, "Pallette is Empty!", "Custom Scale Update", JOptionPane.WARNING_MESSAGE);
		}
	    });
        jpnCustomInner.add(jbtnCustomUpdate);
        jpnCustomInner.add(new JLabel());
        jpnCustomInner.add(new JSeparator(SwingConstants.HORIZONTAL));
        jpnCustomInner.add(new JLabel());

        jpnCustomInner.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JScrollPane jscrlpCustom = new JScrollPane(jpnCustomInner);
        jscrlpCustom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jscrlpCustom.getVerticalScrollBar().setUnitIncrement(10);
        jscrlpCustom.getVerticalScrollBar().setBlockIncrement(10);
        jscrlpCustom.getHorizontalScrollBar().setUnitIncrement(10);
        jscrlpCustom.getHorizontalScrollBar().setUnitIncrement(10);
        JPanel jpnCustomOuter = new JPanel();
        jpnCustomOuter.setLayout(new BorderLayout());
        jpnCustomOuter.setOpaque(true);
        jpnCustomOuter.add(jscrlpCustom);
        jpnCustomOuter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	jtpCtrl.addTab("Custom", jpnCustomOuter);
	jtpCtrl.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	jtpCtrl.setMinimumSize(new Dimension(245,1));

	//Generate Split Pane for Scales and control panel
	JSplitPane jspMW = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jtpCtrl, jtpFb);
	jspMW.setOneTouchExpandable(true);
	jspMW.setDividerSize(20);
	jpnMW.add(jspMW, BorderLayout.CENTER);
	jpnMW.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	jtpFb.addChangeListener(new ChangeListener()
	    {
		public void stateChanged(ChangeEvent ce)
		{
		    if(jtpFb.getTabCount() > 0)
			{
			    if(scales.elementAt(jtpFb.getSelectedIndex()).is_fixed()) //then selected scale is fixed
				{
				    jbtnAddNote.setEnabled(false);
				    jbtnRemoveNote.setEnabled(false);
				    jbtnClearScale.setEnabled(false);
				    jmiAddNote.setEnabled(false);
				    jmiRemoveNote.setEnabled(false);
				    jmiClearScale.setEnabled(false);
				    jtpCtrl.setEnabledAt(0, true);
				    jtpCtrl.setEnabledAt(1, false);
				    jtpCtrl.setSelectedIndex(0);
				}
			    else
				{
				    jbtnAddNote.setEnabled(true);
				    jbtnRemoveNote.setEnabled(true);
				    jbtnClearScale.setEnabled(true);
				    jmiAddNote.setEnabled(true);
				    jmiRemoveNote.setEnabled(true);
				    jmiClearScale.setEnabled(true);
				    jtpCtrl.setEnabledAt(0, false);
				    jtpCtrl.setEnabledAt(1, true);
				    jtpCtrl.setSelectedIndex(1);
				}
			    jbtnClose.setEnabled(true);
			    jbtnSave.setEnabled(true);
			    jbtnPrint.setEnabled(true);
			    jbtnAddFret.setEnabled(true);
			    jbtnRemoveFret.setEnabled(true);
			    jbtnZoomIn.setEnabled(true);
			    jbtnZoomOut.setEnabled(true);
			    jbtnChangeMarker.setEnabled(true);
			    jcbScaleCat.setEnabled(true);
			    jcbFixedKey.setEnabled(true);
			    jbtnFixedUpdate.setEnabled(true);
			    jmiClose.setEnabled(true);
			    jmiSave.setEnabled(true);
			    jmiPrint.setEnabled(true);
			    jmiAddFret.setEnabled(true);
			    jmiRemoveFret.setEnabled(true);
			    jmiRename.setEnabled(true);
			    jmiChangeMarker.setEnabled(true);
			    jmZoom.setEnabled(true);
			}
		    else
			{
			    jtpCtrl.setEnabledAt(0, false);
			    jtpCtrl.setEnabledAt(1, false);
			    jcbScaleCat.setEnabled(false);
			    jcbFixedKey.setEnabled(false);
			    jbtnFixedUpdate.setEnabled(false);
			    jbtnClose.setEnabled(false);
			    jbtnSave.setEnabled(false);
			    jbtnPrint.setEnabled(false);
			    jbtnAddNote.setEnabled(false);
			    jbtnRemoveNote.setEnabled(false);
			    jbtnClearScale.setEnabled(false);
			    jbtnAddFret.setEnabled(false);
			    jbtnRemoveFret.setEnabled(false);
			    jbtnZoomIn.setEnabled(false);
			    jbtnZoomOut.setEnabled(false);
			    jbtnChangeMarker.setEnabled(false);
			    jmiClose.setEnabled(false);
			    jmiSave.setEnabled(false);
			    jmiPrint.setEnabled(false);
			    jmiAddNote.setEnabled(false);
			    jmiRemoveNote.setEnabled(false);
			    jmiClearScale.setEnabled(false);
			    jmiAddFret.setEnabled(false);
			    jmiRemoveFret.setEnabled(false);
			    jmiRename.setEnabled(false);
			    jmiChangeMarker.setEnabled(false);
			    jmZoom.setEnabled(false);
			    jtpCtrl.setSelectedIndex(0);
			}
		}
	    });

	//disable ctrl panel, menuitems, and toolbar buttons on startup
	jtpCtrl.setEnabledAt(0, false);
	jtpCtrl.setEnabledAt(1, false);
	jcbScaleCat.setEnabled(false);
	jcbFixedKey.setEnabled(false);
	jbtnFixedUpdate.setEnabled(false);
	jbtnClose.setEnabled(false);
	jbtnSave.setEnabled(false);
	jbtnPrint.setEnabled(false);
	jbtnAddNote.setEnabled(false);
	jbtnRemoveNote.setEnabled(false);
	jbtnClearScale.setEnabled(false);
	jbtnAddFret.setEnabled(false);
	jbtnRemoveFret.setEnabled(false);
	jbtnZoomIn.setEnabled(false);
	jbtnZoomOut.setEnabled(false);
	jbtnChangeMarker.setEnabled(false);
	jmiClose.setEnabled(false);
	jmiSave.setEnabled(false);
	jmiPrint.setEnabled(false);
	jmiAddNote.setEnabled(false);
	jmiRemoveNote.setEnabled(false);
	jmiClearScale.setEnabled(false);
	jmiAddFret.setEnabled(false);
	jmiRemoveFret.setEnabled(false);
	jmiRename.setEnabled(false);
	jmiChangeMarker.setEnabled(false);
	jmZoom.setEnabled(false);
	jtpCtrl.setSelectedIndex(0);

	//generate frame
	jfrm.setJMenuBar(jmb);
	jfrm.getContentPane().add(jpnMW);
	jfrm.setVisible(true);
    }

    public static void main(String[] args)
    {
	//deploy GUI on the event dispatching thread
	SwingUtilities.invokeLater(new Runnable()
	    {
		public void run()
		{
		    new FVGUI();
		}
	    });
    }
}