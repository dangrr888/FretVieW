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

public class CustomScale extends Scale
{
    public CustomScale() 
    {}

    public CustomScale(String[] notes)
    {
	super(new FretBoard(generateNotes(notes)));
    }

    public CustomScale(CustomScale rhs)
    {
	super(rhs);
    }

    public void add(Note n)
    {
	Fb.add(n);
    }

    public void remove(Note n)
    {
	Fb.remove(n);
    }

    public void clear()
    {
	Fb.clear();
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
	String header = "Custom scale";
        header += " ( ";
        header += display_notes();
	header += ")\n";
        return header;
    }

    public boolean is_fixed()
    {
	return false;
    }
}