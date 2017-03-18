package Scale.Note;
import Constants.*;

public class Plotter
{
    public static void plotter(Note note, int[][] data, int sig)
    {
	int j = 0;
	for(int i = 0; i != Constants.no_strings; ++i)
	    {
		data[i][note.frets[j++]-1] = sig;
		data[i][note.frets[j++]-1] = sig;
	    }
    }
}