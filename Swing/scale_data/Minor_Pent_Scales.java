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

final class Minor_Pent_Scales
{
    private Minor_Pent_Scales()
    {
	throw new AssertionError();
    }

    static String[] MinPent_Ab()
    {
        String[] sMinPent_Ab = {"Ab", "B", "C#", "Eb", "F#"};
	return sMinPent_Ab;
    }

    static String[] MinPent_A()
    {
	String[] sMinPent_A = {"A", "C", "D", "E", "G"};
	return sMinPent_A;
    }

    static String[] MinPent_Bb()
    {
	String[] sMinPent_Bb = {"Bb", "C#", "Eb", "F", "Ab"};
	return sMinPent_Bb;
    }

    static String[] MinPent_B()
    {
	String[] sMinPent_B = {"B", "D", "E", "F#", "A"};
	return sMinPent_B;
    }

    static String[] MinPent_C()
    {
	String[] sMinPent_C = {"C", "Eb", "F", "G", "Bb"};
	return sMinPent_C;
    }

    static String[] MinPent_Cs()
    {
	String[] sMinPent_Cs = {"C#", "E", "F#", "Ab", "B"};
	return sMinPent_Cs;
    }

    static String[] MinPent_D()
    {
	String[] sMinPent_D = {"D", "F", "G", "A", "C"};
	return sMinPent_D;
    }

    static String[] MinPent_Eb()
    {
	String[] sMinPent_Eb = {"Eb", "F#", "Ab", "Bb", "C#"};
	return sMinPent_Eb;
    }

    static String[] MinPent_E()
    {
	String[] sMinPent_E = {"E", "G", "A", "B", "D"};
	return sMinPent_E;
    }

    static String[] MinPent_F()
    {
	String[] sMinPent_F = {"F", "Ab", "Bb", "C", "Eb"};
	return sMinPent_F;
    }

    static String[] MinPent_Fs()
    {
	String[] sMinPent_Fs = {"F#", "A", "B", "C#", "E"};
	return sMinPent_Fs;
    }

    static String[] MinPent_G()
    {
	String[] sMinPent_G = {"G", "Bb", "C", "D", "F"};
	return sMinPent_G;
    }

    static String header_min_pent = "Minor Pentatonic Scale";
}