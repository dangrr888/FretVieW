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

package Scale.Note;
import java.io.*;

/**
 * 
 * Class defining static factory methods containing data associated
 * with various fretboard positions of all notes on the Western Scale. 
 *
 */
public class Note implements NoteInt
{
	
	/**
	 * Constructor returning Note object with specified name,
	 * specified alias, and specified fret positions for a 24 
	 * string guitar.
	 * 
	 * @param noteName - restricted name of current Note object.
	 * @param altName - restricted alias of current Note object.
	 * @param f - array containing fret positions of this particular
	 *            note, configured as follows: (E_1st, E_2nd, A_1st, 
	 *            A_2nd, D_1st, D_2nd, G_1st, G_2nd, b_1st, b_2nd, 
	 *            e_1st, e_2nd), as appropriate for a 24 string guitar.
	 * @return   Note object with specified name, specified alias, 
	 *           and specified fret positions for a 24 string guitar.
	 */
    private Note(String noteName, String altName, int[] f)
    {
        n = noteName;
        a = altName;
        frets = f;
    } // 3-parameter constructor

    /**
     * static factory method for the note A-flat.
     * 
     * @return a reference to a note initialized
     * 		   with information for A-flat.
     */
    public static Note Ab()
    {
    	int Ab[] = {4,16,11,23,6,18,1,13,9,21,4,16};
    	return new Note("Ab", "G#", Ab);
    } //method Ab

    /**
     * static factory method for the note A.
     * 
     * @return a reference to a note initialized
     * 		   with information for A.
     */
    public static Note A()
    {
    	int A[] = {5,17,12,24,7,19,2,14,10,22,5,17};
    	return new Note("A", "A", A);
    } // method A

    /**
     * static factory method for the note B-flat.
     * 
     * @return a reference to a note initialized
     * 		   with information for B-flat.
     */
    public static Note Bb()
    {
        int Bb[] = {6,18,1,13,8,20,3,15,11,23,6,18};
        return new Note("Bb", "A#", Bb);
    } // method Bb

    /**
     * static factory method for the note B.
     * 
     * @return a reference to a note initialized
     * 		   with information for B.
     */
    public static Note B()
    {
    	int B[] = {7,19,2,14,9,21,4,16,12,24,7,19};
    	return new Note("B", "Cb", B);
    } // method B

    /**
     * static factory method for the note C.
     * 
     * @return a reference to a note initialized
     * 		   with information for C.
     */
    public static Note C()
    {
    	int C[] = {8,20,3,15,10,22,5,17,1,13,8,20};
    	return new Note("C", "B#", C);
    } // method C

    /**
     * static factory method for the note C-sharp.
     * 
     * @return a reference to a note initialized
     * 		   with information for C-sharp.
     */
    public static Note Cs()
    {
    	int Cs[] = {9,21,4,16,11,23,6,18,2,14,9,21};
    	return new Note("C#", "Db", Cs);
    } // method C-sharp

    /**
     * static factory method for the note D.
     * 
     * @return a reference to a note initialized
     * 		   with information for D.
     */
    public static Note D()
    {
    	int D[] = {10,22,5,17,12,24,7,19,3,15,10,22};
    	return new Note("D", "D", D);
    } // method D

    /**
     * static factory method for the note E-flat.
     * 
     * @return a reference to a note initialized
     * 		   with information for E-flat.
     */
    public static Note Eb()
    {
    	int Eb[] = {11,23,6,18,1,13,8,20,4,16,11,23};
    	return new Note("Eb", "D#", Eb);
    } // method Eb

    /**
     * static factory method for the note E.
     * 
     * @return a reference to a note initialized
     * 		   with information for E.
     */
    public static Note E()
    {
    	int E[] = {12,24,7,19,2,14,9,21,5,17,12,24};
    	return new Note("E", "Fb", E);
    } // method E

    /**
     * static factory method for the note F.
     * 
     * @return a reference to a note initialized
     * 		   with information for F.
     */
    public static Note F()
    {
    	int F[] = {1,13,8,20,3,15,10,22,6,18,1,13};
    	return new Note("F", "E#", F);
    } // method F

    /**
     * static factory method for the note F-sharp.
     * 
     * @return a reference to a note initialized
     * 		   with information for F-sharp.
     */
    public static Note Fs()
    {
    	int Fs[] = {2,14,9,21,4,16,11,23,7,19,2,14};
    	return new Note("F#", "Gb", Fs);
    } // method F-sharp

    /**
     * static factory method for the note G.
     * 
     * @return a reference to a note initialized
     * 		   with information for G.
     */
    public static Note G()
    {
    	int G[] = {3,15,10,22,5,17,12,24,8,20,3,15};
    	return new Note("G", "G", G);
    } // method G

    /**
     * returns a reference to a Note object with
     * name equal to a specified String.
     * 
     * @param key - specified key. (Since Note names
     *              are restricted to: Ab, A, A#, Bb, 
     *              B, B#, Cb, C, C#, Db, D, D#, Eb, 
     *              E, E#, Fb, F, F#, Gb, G and G#, 
     *              it is suggested that key is checked 
     *              using Note.valid_key() first.)
     * 
     * @throws IllegalArgumentException
     * 
     * @return a reference to a Note object with
     *         name equal to a specified String.
     */
    public static Note strToNote(String key)
    {
    	if(key.equals("Ab") || key.equals("G#"))
    		return Ab();
    	else if(key.equals("A"))
    		return A();
    	else if(key.equals("Bb") || key.equals("A#"))
    		return Bb();
    	else if(key.equals("B") || key.equals("Cb"))
    		return B();
    	else if(key.equals("C") || key.equals("B#"))
    		return C();
    	else if(key.equals("C#") || key.equals("Db"))
    		return Cs();
    	else if(key.equals("D"))
    		return D();
    	else if(key.equals("Eb") || key.equals("D#"))
    		return Eb();
    	else if(key.equals("E") || key.equals("Fb"))
    		return E();
    	else if(key.equals("F") || key.equals("E#"))
    		return F();
    	else if(key.equals("F#") || key.equals("Gb"))
    		return Fs();
		else if(key.equals("G"))
			return G();
		else
			throw new IllegalArgumentException("Note does not exist!");
    } // method strToNote

    /**
     * Checks whether a specified String is equal to the name 
     * of a valid Note object.
     * 
     * @param key - specified String
     * 
     * @return bool indicating whether a specified String is 
     *         equal to the name of a valid Note object.
     */
    public static boolean valid_key(String key) //checks whether String argument is a valid Note name
    {
    	if(key.equals("Ab") || key.equals("A") || key.equals("A#") ||
    	   key.equals("Bb") || key.equals("B") || key.equals("B#") ||
	       key.equals("Bb") || key.equals("B") || key.equals("B#") ||
	       key.equals("Cb") || key.equals("C") || key.equals("C#") ||
	       key.equals("Db") || key.equals("D") || key.equals("D#") ||
	       key.equals("Eb") || key.equals("E") || key.equals("E#") ||
	       key.equals("Fb") || key.equals("F") || key.equals("F#") ||
	       key.equals("Gb") || key.equals("G") || key.equals("G#"))
    		return true;
    	return false;
    } // method valid_key

    /**
     * Accessor returning name of current Note object.
     * 
     * @return name of current Note object.
     */
    public String name()
    {
    	return n;
    } // method name

    /**
     * Accessor returning alias of current Note object.
     * 
     * @return alias of current Note object.
     */
    public String alias()
    {
    	return a;
    } // method alias

    /**
     * Displays the specified message, successively reads
     * a specified number of Strings from the default input
     * stream (or until "X" is entered) who's values should 
     * be equal to the names of valid Note objects, and returns
     * an array containing the entered Strings (Only used
     * in console-based application.)
     * 
     * @param msg - specified message.
     * @param n - specified number of Strings.
     * 
     * @throws IllegalArgumentException
     * @throws IOException
     * 
     * @return an array containing entered Strings.
     */
    public static String[] grabNotes(String msg, int n)
    {
        System.out.print(msg);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] key = new String[n];

        for(int count = 0; count < n; ++count)
        {
        	try {
        			String tmp = br.readLine();
        			
        			if(tmp.equals("X"))
        			{
        				key[count] = tmp;
        				break;
        			}
                    
        			if(!Note.valid_key(tmp))
                        throw new IllegalArgumentException();
                    
        			key[count] = tmp;
                } catch(IllegalArgumentException exc) {
                    System.out.println("Note does not exist, please try again.");
                } catch(IOException exc) {
                    System.out.println("I/O Exception, please try again.");
                }
        }
        
        return key;
    } // method grabNotes

    /**
     * Field containing name of current Note object.
     */
    private final String n;
    
    /**
     * Field containing alias name of current Note object.
     */
    private final String a;
    
	/** Array containing fret positions of this particular
	 *  note, configured as follows: (E_1st, E_2nd, A_1st, 
	 *  A_2nd, D_1st, D_2nd, G_1st, G_2nd, b_1st, b_2nd, 
	 *  e_1st, e_2nd), as appropriate for a 24 string guitar.
	 */
    protected final int[] frets;
    
} // class Note