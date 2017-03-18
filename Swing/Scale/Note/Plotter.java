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
import Constants.*;

/**
 * A class possessing a static method to set the various positions
 * of the current fretboard to a specified value.
 *
 */
public class Plotter
{
	/**
	 * 
	 * sets the specified value at the various positions of the 
	 * specified note contained in the specified two-dimensional 
	 * array. 
	 * 
	 * @param note - the specified note
	 * @param data - the fretboard positions of the specified note
	 * @param sig - the specified value
	 *
	 */
    public static void plotter(Note note, int[][] data, int sig)
    {
    	int j = 0;
    	for(int i = 0; i != Constants.no_strings; ++i)
	    {
    		data[i][note.frets[j++]-1] = sig;
    		data[i][note.frets[j++]-1] = sig;
	    }
    } // method plotter
} // class Plotter