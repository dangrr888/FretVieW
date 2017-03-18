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
import scale_data.*;
import Constants.*;

public class Scale implements ScaleInt
{
    public Scale()
    {
	Fb = new FretBoard();
	category = null;
	key = null;
	font_size = Constants.defaultFontSize;
    }

    public Scale(int option, String k)
    {
	Prefixed_Notes tmp = new Prefixed_Notes(option, k);
	Fb = new FretBoard(generateNotes(tmp.getNotes()));
	category = tmp.getCategory();
	key = tmp.getKey();
	font_size = Constants.defaultFontSize;
    }

    protected Scale(FretBoard f)
    {
	Fb = new FretBoard(f);
	category = null;
	key = null;
	font_size = Constants.defaultFontSize;
    }

    public Scale(Scale rhs)
    {
	Fb = new FretBoard(rhs.Fb);
	category = rhs.category;
	key = rhs.key;
	font_size = rhs.font_size;
    }

    public void add(Note n)
    {
	System.out.println("Scale.add() - Cannot add note to a fixed Scale!");
    }

    public void remove(Note n)
    {
	System.out.println("Scale.remove() - Cannot remove note from a fixed Scale!");
    }

    public void clear()
    {
	System.out.println("Scale.clear() - Cannot remove note from a fixed Scale!");
    }

    public String display_notes()
    {
	return Fb.display_notes();
    }

    protected String display_grid(int num_frets)
    {
	return Fb.display_grid(num_frets);
    }

    public int num_notes()
    {
	return Fb.num_notes();
    }

    public String display(int num_frets)
    {
	current_num_frets = num_frets;
	String ret = "<html><font style=\"font-family:Courier\"><font size = " + font_size + ">";
	ret += display_grid(num_frets);
	ret += "</font></font>";
	return ret;
    }

    public String displayHeader()
    {
	String header = category + " in " + key;
	header += " ( ";
        header += display_notes();
        header += ")\n";
	return header;
    }

    protected static Note[] generateNotes(String[] notes)
    {
	Note[] ret = new Note[notes.length];
	
	for(int i = 0; i != notes.length; ++i)
	    {
		int j = 0;
		while(j != notes[i].length() && Character.isWhitespace(notes[i].charAt(j)))
		    ++j;
		int k = j;
		while(k != notes[i].length() && !Character.isWhitespace(notes[i].charAt(k)))
		    ++k;
		if(j != k)
		    {
			String tmp = notes[i].substring(j,k);
			if(Note.valid_key(tmp))
			    ret[i] = Note.strToNote(tmp);
		    }
	    } 
	return ret;
    }

    public boolean is_fixed()
    {
	return true;
    }

    public int get_cat()
    {
	if(category.equals("Major Scale"))
	    return 1;
	else if(category.equals("Minor Scale"))
	    return 2;
	else if(category.equals("Major Pentatonic Scale"))
	    return 3;
	else if(category.equals("Minor Pentatonic Scale"))
	    return 4;
	else if(category.equals("Blues Scale"))
	    return 5;
	else if(category.equals("Natural Minor Scale"))
	    return 6;
	return 0;
    } 

    public String get_key()
    {
	return new String(key);
    }
 
    public int get_num_frets()
    {
	return current_num_frets;
    }

    public int get_font_size()
    {
	return font_size;
    }

    public void set_font_size(int fsz)
    {
	font_size = fsz;
    }

    public void setMarker(int idx, String col)
    {
	Fb.setNonEmptyFret(idx, col);
    }

    public String getMarker()
    {
	return Fb.getNonEmptyFret();
    }
 
    public String getMarkerColour()
    {
	return Fb.getColour();
    }

    public static String[] getMarkers(String col)
    {
	return FretBoard.getMarkers(col);
    }

    protected int current_num_frets;
    protected FretBoard Fb;
    protected String category;
    protected String key;
    protected int font_size;
}