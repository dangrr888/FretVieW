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