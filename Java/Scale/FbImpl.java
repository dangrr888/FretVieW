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