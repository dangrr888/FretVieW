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
import Constants.*;

class FbImpl
{
    protected FbImpl()
    {
	data = generateFretBoard();
	notes = new Note[0];
    }

    protected FbImpl(FbImpl Fb)
    {
	data = generateFretBoard();
	notes = new Note[Fb.notes.length];
	for(int i = 0; i != Fb.data.length; ++i)
	    for(int j = 0; j != Fb.data[i].length; ++j)
		data[i][j] = Fb.data[i][j];
	for(int i = 0; i != Fb.notes.length; ++i)
	    notes[i] = Fb.notes[i];
    }

    private static int[][] generateFretBoard()
    {
	int[][] ret = new int[Constants.no_strings][Constants.no_frets];
	for(int i = 0; i != ret.length; ++i)
	    for(int j = 0; j != ret[i].length; ++j)
		ret[i][j] = 0;
	return ret;
    }

    protected int[][] data;
    protected Note[] notes;
}