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

package Constants;

/**
 * A class containing constants.
 */
public class Constants
{
	/**
	 * no_frets - contains the maximum number of frets represented by a fretboard. 
	 */
    public static final int no_frets = 24;
    
    /**
     * no_strings - contains the number of strings represented by a fretboard.
     */
    public static final int no_strings = 6;
    
    /**
     * defaultFontSize - contains the default font size of the fretboard labeling.
     */
    public static final int defaultFontSize = 5;
    
    /**
     * maxFontSize - contains the maximum font size of the fretboard labeling
     */
    public static final int maxFontSize = 7;
    
    /**
     * defaultMarkerColour - contains the HTML hex code for the default marker colour
     */
    public static final String defaultMarkerColour = "#000000";
    
    /**
     * defaultMarkerIndex - contains the default index of the array referencing marker styles
     * for representing notes on the fretboard.
     */
    public static final int defaultMarkerIndex = 0;
}