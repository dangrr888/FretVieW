package testers;
import Scale.*;
import Scale.Note.*;

public class ScaleTester
{
    public static void main(String args[])
    {
	Scale s1 = new Scale();
	s1.add(Note.A());
	s1.remove(Note.A());
	s1.clear();

	Scale s2 = new Scale(1, "A#");
	s2.display(24);

	Scale s3 = new Scale(s2);
	s3.display(20);
    }
}