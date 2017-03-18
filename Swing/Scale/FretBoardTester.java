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

package Scale; //needs to be included as a package component in order to access FretBoard Constructor
import Scale.Note.*;

public class FretBoardTester
{
    public static void main(String args[])
    {
	FretBoard fb = new FretBoard();
	System.out.println(fb.num_notes());
	fb.display_notes();
	fb.display_grid(24);
	fb.add(Note.C());
	fb.display_notes();
	System.out.println();
	fb.display_grid(12);
	fb.add(Note.B());
        fb.display_notes();
	System.out.println();
	fb.display_grid(12);
	fb.remove(Note.C());
        fb.display_notes();
	System.out.println();
	fb.display_grid(12);
	fb.clear();
        fb.display_notes();
	System.out.println();
	fb.display_grid(12);

	Note[] notes = new Note[2];
	notes[0] = Note.B();
	notes[1] = Note.strToNote("A#");
	FretBoard fb2 = new FretBoard(notes);
	fb2.display_notes();
	System.out.println();
	fb2.display_grid(24);

	FretBoard fb3 = new FretBoard(fb2);
	fb2.remove(Note.B());
	fb3.display_notes();
	System.out.println();
	fb3.display_grid(23);

        fb2.display_notes();
        System.out.println();
        fb2.display_grid(24);
    }
}