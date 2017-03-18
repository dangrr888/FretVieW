package Scale;
import Scale.Note.*;
import java.util.*;
import Constants.*;

class FretBoard implements FretBoardInt
{
    protected FretBoard()
    {
	Impl = new FbImpl();
    }

    protected FretBoard(Note[] notes)
    {
	Impl = new FbImpl();
	if(notes.length != 0)
	    {
		for(int i = 0; i != notes.length; ++i)
		    add(notes[i]);
	    }
    }

    protected FretBoard(FretBoard Fb)
    {
	Impl = new FbImpl(Fb.Impl);
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
		for(int j = 0, k = 0; j != Impl.notes.length; ++j)
		    {
			if(j != i)
			    tmp[k++] = Impl.notes[j];
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

    public void display_notes()
    {
	String temp[] = new String[Impl.notes.length];
	for(int i = 0; i != Impl.notes.length; ++i)
	    temp[i] = Impl.notes[i].name();

	Arrays.sort(temp, String.CASE_INSENSITIVE_ORDER);

	for(int i = 0; i != Impl.notes.length; ++i)
	    System.out.print(temp[i] + " ");
    }

    private String[] make_string(int str_num, String s, int num_frets)
    {
	String[] ret = new String[num_frets + 2];
	ret[0] = s;
	for(int i = 0; i != num_frets; ++i)
	    {
		if(Impl.data[str_num][i] == 1)
		    ret[i+1] = nonEmptyFret;
		else
		    ret[i+1] = emptyFret;
	    }
	ret[num_frets+1] = "-";
	return ret;
    }

    public void display_grid(int num_frets)
    {
	if(num_frets > 0)
	    {
		String[] newStringDivider = new String[num_frets + 2];
		newStringDivider[0] = "   ";
		for(int i = 1; i != newStringDivider.length; ++i)
		    newStringDivider[i] = emptyDivider;
		
		String[] Estring = make_string(0, "E  ", num_frets);
		String[] Astring = make_string(1, "A  ", num_frets);
		String[] Dstring = make_string(2, "D  ", num_frets);	
		String[] Gstring = make_string(3, "G  ", num_frets);
		String[] Bstring = make_string(4, "B  ", num_frets);
		String[] estring = make_string(5, "e  ", num_frets);
		
		String fretNumbers = new String("     " + 1 + "  ");
		if(num_frets > 1)
		    {
			for(int i = 2; i != num_frets + 1; ++i)
			    {
				int tmp = 3 - (int)Math.floor(Math.log10(i));
				for(int j = 0; j != tmp; ++j) 
				    fretNumbers += " ";
				fretNumbers += i + " ";
			    }
		    }
		
		System.out.println(fretNumbers);
		display_string(Estring);
		display_string(newStringDivider);
		display_string(Astring);
		display_string(newStringDivider);
		display_string(Dstring);
		display_string(newStringDivider);
		display_string(Gstring);
		display_string(newStringDivider);
		display_string(Bstring);
		display_string(newStringDivider);
		display_string(estring);
	    }
    }

    private void display_string(String[] s)
    {
	for(int i = 0; i != s.length; ++i)
	    System.out.print(s[i]);
	System.out.println();
    }

    private FbImpl Impl;
    private static final String emptyFret = "-----";
    private static final String nonEmptyFret = "--\\--";
    private static final String emptyDivider = "|    ";
}