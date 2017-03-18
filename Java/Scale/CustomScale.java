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

    public void display(int num_frets)
    {
	if(num_notes() != 0)
	    {
		System.out.println();
		System.out.print("Custom scale");
		System.out.print(" ( ");
		display_notes();
		System.out.println(")\n");
		display_grid(num_frets);
		System.out.println();
	    }
	else 
	    {
		System.out.println("Your Scale is empty!");
		System.out.println();
	    }
    }
}