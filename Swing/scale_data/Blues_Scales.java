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
 * in the blues scales of the specified key.
 *
 */
final class Blues_Scales
{
	/**
	 * default constructor. Since class is immutable, attempts
	 * by in-class code will throw AssertionError.
	 * 
	 * @throws AssertionError
	 */
    private Blues_Scales()
    {
    	throw new AssertionError();
    } // default constructor

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues A-flat scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues A-flat scale.
     */
    static String[] Blu_Ab()
    {
        String[] sBlu_Ab = {"Ab", "B", "C#", "D", "Eb", "F#"};
        return sBlu_Ab;
    } // method Blu_Ab
    
    /**
     * static method returns a string array containing string
     * representation of notes in the Blues A scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues A scale.
     */
    static String[] Blu_A()
    {
    	String[] sBlu_A = {"A", "C", "D", "Eb", "E", "G"};
    	return sBlu_A;
    } //method Blu_A

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues B-flat scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues A-flat scale.
     */
    static String[] Blu_Bb()
    {
    	String[] sBlu_Bb = {"Bb", "C#", "Eb", "E", "F", "Ab"};
    	return sBlu_Bb;
    } // method Blu_Bb

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues A-flat scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues B scale.
     */
    static String[] Blu_B()
    {
    	String[] sBlu_B = {"B", "D", "E", "F", "F#", "A"};
    	return sBlu_B;
    } // method Blu_B

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues D scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues C scale.
     */
    static String[] Blu_C()
    {
    	String[] sBlu_C = {"C", "Eb", "F", "F#", "G", "Bb"};
    	return sBlu_C;
    } // method Blu_C

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues C-sharp scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues C-sharp scale.
     */
    static String[] Blu_Cs()
    {
    	String[] sBlu_Cs = {"C#", "E", "F#", "G", "Ab", "B"};
    	return sBlu_Cs;
    } // method Blu_Cs

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues D scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues D scale.
     */
    static String[] Blu_D()
    {
    	String[] sBlu_D = {"D", "F", "G", "Ab", "A", "C"};
    	return sBlu_D;
    } // method Blu_D

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues E-flat scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues E-flat scale.
     */
    static String[] Blu_Eb()
    {
    	String[] sBlu_Eb = {"Eb", "F#", "Ab", "A", "Bb", "C#"};
    	return sBlu_Eb;
    } // method Blu_Eb

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues E scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues E scale.
     */
    static String[] Blu_E()
    {
    	String[] sBlu_E = {"E", "G", "A", "Bb", "B", "D"};
    	return sBlu_E;
    } // method Blu_E

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues F scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues F scale.
     */
    static String[] Blu_F()
    {
    	String[] sBlu_F = {"F", "Ab", "Bb", "B", "C", "Eb"};
    	return sBlu_F;
    } // method Blu_F

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues F-sharp scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues F-sharp scale.
     */
    static String[] Blu_Fs()
    {
    	String[] sBlu_Fs = {"F#", "A", "B", "C", "C#", "E"};
    	return sBlu_Fs;
    } // method Blu_Fs

    /**
     * static method returns a string array containing string
     * representation of notes in the Blues G scale.
     * 
     * @return a string array containing string
     * representation of notes in the Blues G scale.
     */
    static String[] Blu_G()
    {
    	String[] sBlu_G = {"G", "Bb", "C", "C#", "D", "F"};
    	return sBlu_G;
    } // method Blu_G

    /**
     * string containing title segment identifying fixed scale objects
     * with a blues scale category.
     */
    static String header_blu = "Blues Scale";

} // class Major_Pent_Scales