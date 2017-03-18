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

package scale_data;

/**
 * 
 * final class containing static methods that return string arrays
 * containing the string representation of the notes of the notes
 * in the major pentatonic scales of the specified key.
 *
 */
final class Major_Pent_Scales
{
	/**
	 * default constructor. Since class is immutable, attempts
	 * by in-class code will throw AssertionError.
	 * 
	 * @throws AssertionError
	 */
    private Major_Pent_Scales()
    {
    	throw new AssertionError();
    } // default constructor

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic A-flat scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic A-flat scale.
     */
    static String[] MajPent_Ab()
    {
        String[] sMajPent_Ab = {"Ab", "Bb", "C", "Eb", "F"};
        return sMajPent_Ab;
    } // method MajPent_Ab

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic A scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic A scale.
     */
    static String[] MajPent_A()
    {
    	String[] sMajPent_A = {"A", "B", "C#", "E", "F#"};
    	return sMajPent_A;
    } // method MajPent_A

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic B-flat scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic B-flat scale.
     */    
    static String[] MajPent_Bb()
    {
    	String[] sMajPent_Bb = {"Bb", "C", "D", "F", "G"};
    	return sMajPent_Bb;
    } // method MajPent_Bb

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic B scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic B scale.
     */
    static String[] MajPent_B()
    {
    	String[] sMajPent_B = {"B", "C#", "Eb", "F#", "Ab"};
    	return sMajPent_B;
    } // method MajPent_B

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic C scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic C scale.
     */
    static String[] MajPent_C()
    {
    	String[] sMajPent_C = {"C", "D", "E", "G", "A"};
    	return sMajPent_C;
    } // method MajPent_C

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic C-sharp scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic C-sharp scale.
     */
    static String[] MajPent_Cs()
    {
    	String[] sMajPent_Cs = {"C#", "E", "F", "Ab", "Bb"};
    	return sMajPent_Cs;
    } // method MajPent_Cs

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic D scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic D scale.
     */
    static String[] MajPent_D()
    {
    	String[] sMajPent_D = {"D", "F", "F#", "A", "B"};
    	return sMajPent_D;
    } // method MajPent_D

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic E-flat scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic E-flat scale.
     */
    static String[] MajPent_Eb()
    {
    	String[] sMajPent_Eb = {"Eb", "F#", "G", "Bb", "C"};
    	return sMajPent_Eb;
    } // method MajPent_Eb

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic E scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic E scale.
     */
    static String[] MajPent_E()
    {
    	String[] sMajPent_E = {"E", "G", "Ab", "B", "C#"};
    	return sMajPent_E;
    } // method MajPent_E

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic F scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic F scale.
     */
    static String[] MajPent_F()
    {
    	String[] sMajPent_F = {"F", "Ab", "A", "C", "D"};
    	return sMajPent_F;
    } // method MajPent_F

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic F-sharp scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic F-sharp scale.
     */
    static String[] MajPent_Fs()
    {
    	String[] sMajPent_Fs = {"F#", "A", "Bb", "C#", "Eb"};
    	return sMajPent_Fs;
    } // method MajPent_Fs

    /**
     * static method returns a string array containing string
     * representation of notes in the major pentatonic G scale.
     * 
     * @return a string array containing string
     * representation of notes in the major pentatonic G scale.
     */
    static String[] MajPent_G()
    {	
    	String[] sMajPent_G = {"G", "Bb", "B", "D", "E"};
    	return sMajPent_G;
    } // method MajPent_G

    /**
     * string containing title segment identifying fixed scale objects
     * with a major pentatonic scale category.
     */
    static String header_maj_pent = "Major Pentatonic Scale";

} // class Major_Pent_Scales