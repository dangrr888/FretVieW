package Scale;
import Scale.Note.*;

public class Superimpose
{
    public static void superimpose(Note note, int[][] data, boolean add)
    {
	if(add)
	    Plotter.plotter(note, data, 1);
	else
	    Plotter.plotter(note, data, 0);
    }
}