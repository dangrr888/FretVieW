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

package Scale;
import Scale.Note.*;
import java.util.*;
import Constants.*;

class FretBoard implements FretBoardInt
{
    protected FretBoard()
    {
	Impl = new FbImpl();
	setNonEmptyFret(Constants.defaultMarkerIndex, Constants.defaultMarkerColour);
    }

    protected FretBoard(Note[] notes)
    {
	Impl = new FbImpl();
	setNonEmptyFret(Constants.defaultMarkerIndex, Constants.defaultMarkerColour);
	if(notes.length != 0)
	    {
		for(int i = 0; i != notes.length; ++i)
		    add(notes[i]);
	    }
    }

    protected FretBoard(FretBoard Fb)
    {
	Impl = new FbImpl(Fb.Impl);
	colour = Fb.colour;
	nonEmptyFret = Fb.nonEmptyFret;
    }

    public void add(Note n)
    {
	Superimpose.superimpose(n, Impl.data, true);
	
	int i = 0;
	while(i != Impl.notes.length && Impl.notes[i].name().compareTo(n.name()) != 0)
	    ++i;

	if(i == Impl.notes.length)
	    {
		Note[] tmp = new Note[Impl.notes.length + 1];
		for(int j = 0; j != Impl.notes.length; ++j)
		    tmp[j] = Impl.notes[j];
		tmp[Impl.notes.length] = n;
		Impl.notes = tmp;
	    }
    }

    public void remove(Note n)
    {
	Superimpose.superimpose(n, Impl.data, false);

	int i = 0;
	while(i != Impl.notes.length && Impl.notes[i].name().compareTo(n.name()) != 0)
            ++i;

	if(i != Impl.notes.length)
	    {
		Note[] tmp = new Note[Impl.notes.length - 1];
		for(int j = 0, k = 0; j != Impl.notes.length; ++j) //bug was here, dont reset k  to 0 on each cycle of j-loop!!!
		    {
			if(j != i)
			    {
				tmp[k] = Impl.notes[j];
				++k;
			    }
		    }
		Impl.notes = tmp;
	    }
    }

    public void clear()
    {
	Impl = new FbImpl();
    }

    public int num_notes()
    {
	return Impl.notes.length;
    }

    public String display_notes() //***changed***
    {
	String temp[] = new String[Impl.notes.length];

	for(int i = 0; i != Impl.notes.length; ++i)
	    temp[i] = Impl.notes[i].name();

	Arrays.sort(temp, String.CASE_INSENSITIVE_ORDER);

	String ret = new String();
	for(int i = 0; i != Impl.notes.length; ++i)
	    ret += temp[i] + " ";

	return ret;
    }

    private String[] make_string(int str_num, String s, int num_frets)
    {
	String[] ret = new String[num_frets + 1];
	ret[0] = s;
	for(int i = 0; i != num_frets; ++i)
	    {
		if(Impl.data[str_num][i] == 1)
		    ret[i+1] = nonEmptyFret;
		else
		    ret[i+1] = emptyFret;
	    }
	return ret;
    }

    private String display_string(String[] s)
    {
        String ret = new String();
        for(int i = 0; i != s.length; ++i)
            ret += s[i];
        return ret;
    }

    public String display_grid(int num_frets)
    {
	if(num_frets > 0)
	    {
		String[] newStringDivider = new String[num_frets + 1];
		for(int i = 0; i != newStringDivider.length; ++i)
		    newStringDivider[i] = emptyDivider;
		
		String[] Estring = make_string(0, "E -", num_frets);
		String[] Astring = make_string(1, "A -", num_frets);
		String[] Dstring = make_string(2, "D -", num_frets);	
		String[] Gstring = make_string(3, "G -", num_frets);
		String[] Bstring = make_string(4, "B -", num_frets);
		String[] estring = make_string(5, "e -", num_frets);
		
		String fretNumbers = new String("&nbsp&nbsp&nbsp 1 ");
		if(num_frets > 1)
		    {
			for(int i = 2; i != num_frets + 1; ++i)
			    {
				fretNumbers += "&nbsp " + i;
				int tmp = 1 - (int)Math.floor(Math.log10(i));
				for(int j = 0; j != tmp; ++j)
				    fretNumbers += "&nbsp";
				
			    }
		    }
		
		String ret = fretNumbers + "<br>";
		ret += display_string(Estring) + "<br>";
		ret += display_string(newStringDivider) + "<br>";
		ret += display_string(Astring) + "<br>";
		ret += display_string(newStringDivider) + "<br>";
		ret += display_string(Dstring) + "<br>";
		ret += display_string(newStringDivider) + "<br>";
		ret += display_string(Gstring) + "<br>";
		ret += display_string(newStringDivider) + "<br>";
		ret += display_string(Bstring) + "<br>";
		ret += display_string(newStringDivider) + "<br>";
		ret += display_string(estring) + "<br>";

		return ret;
	    }
	return null;
    }

    public void setNonEmptyFret(int idx, String col)
    {
        colour = col;
        String[] tmp = getMarkers(colour);
        if(idx >= 0 && idx != tmp.length)
            nonEmptyFret = tmp[idx];
    }

    public String getNonEmptyFret()
    {
	return nonEmptyFret;
    }

    protected static String[] getMarkers(String col)
    {
	String[] ret = {"-<FONT COLOR=\"" + col + "\">\\</FONT>--",
			"-<FONT COLOR=\"" + col + "\">&#9677;</FONT>--"};
	return ret;
    }
    
    public String getColour()
    {
	return colour;
    }

    private FbImpl Impl;
    private String colour;
    private String nonEmptyFret;
    private static final String emptyFret = "----";
    private static final String emptyDivider = "&nbsp | ";
}