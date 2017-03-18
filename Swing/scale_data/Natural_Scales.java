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

final class Natural_Scales
{
    private Natural_Scales()
    {
	throw new AssertionError();
    }

    static String[] Nat_Ab()
    {
	String[] sNat_Ab = {"Ab", "Bb", "B", "C#", "Eb", "E", "F#"};
	return sNat_Ab;
    }
    static String[] Nat_A()
    {
	String[] sNat_A = {"A", "B", "C", "D", "E", "F", "G"};
	return sNat_A;
    }
    
    static String[] Nat_Bb()
    {
	String[] sNat_Bb = {"Bb", "C", "C#", "Eb", "F", "F#", "Ab"};
	return sNat_Bb;
    }
    
    static String[] Nat_B()
    {
	String[] sNat_B = {"B", "C#", "D", "E", "F#", "G", "A"};
	return sNat_B;
    }
    
    static String[] Nat_C()
    {
	String[] sNat_C = {"C", "D", "E", "F", "G", "Ab", "Bb"};
	return sNat_C;
    }

    static String[] Nat_Cs()
    {
	String[] sNat_Cs = {"C#", "Eb", "F", "F#", "Ab", "A", "B"};
	return sNat_Cs;
    }
    
    static String[] Nat_D()
    {
	String[] sNat_D = {"D", "E", "F#", "G", "A", "Bb", "C"};
	return sNat_D;
    }
    
    static String[] Nat_Eb()
    {
	String[] sNat_Eb = {"Eb", "F", "G", "Ab", "Bb", "B", "C#"};
	return sNat_Eb;
    }
    
    static String[] Nat_E()
    {
	String[] sNat_E = {"E", "F#", "Ab", "A", "B", "C", "D"};
	return sNat_E;
    }
    
    static String[] Nat_F()
    {
	 String[] sNat_F = {"F", "G", "A", "Bb", "C", "C#", "Eb"};
	 return sNat_F;
    }
    
    static String[] Nat_Fs()
    {
	String[] sNat_Fs = {"F#", "Ab", "Bb", "B", "C#", "D", "E"};
	return sNat_Fs;
    }

    static String[] Nat_G()
    {
	String[] sNat_G = {"G", "A", "B", "C", "D", "Eb", "F"};
	return sNat_G;
    }
    
    static String header_nat = "Natural Minor Scale";
}
