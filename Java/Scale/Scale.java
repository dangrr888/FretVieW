package Scale;
import Scale.Note.*;
import scale_data.*;

public class Scale implements ScaleInt
{
    public Scale()
    {
	Fb = new FretBoard();
	category = null;
	key = null;
    }

    public Scale(int option, String k)
    {
	Prefixed_Notes tmp = new Prefixed_Notes(option, k);
	Fb = new FretBoard(generateNotes(tmp.getNotes()));
	category = tmp.getCategory();
	key = tmp.getKey();
    }

    protected Scale(FretBoard f)
    {
	Fb = new FretBoard(f);
	category = null;
	key = null;
    }

    public Scale(Scale rhs)
    {
	Fb = new FretBoard(rhs.Fb);
	category = rhs.category;
	key = rhs.key;
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

    protected void display_notes()
    {
	Fb.display_notes();
    }

    protected void display_grid(int num_frets)
    {
	Fb.display_grid(num_frets);
    }

    public int num_notes()
    {
	return Fb.num_notes();
    }

    public void display(int num_frets)
    {
	System.out.println();
	String header = category + " in " + key;
	System.out.print(header);
	System.out.print(" ( ");
	display_notes();
	System.out.println(")\n");
	display_grid(num_frets);
	System.out.println();
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
    
    protected FretBoard Fb;
    protected String category;
    protected String key;
}