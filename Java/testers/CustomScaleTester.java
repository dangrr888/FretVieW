package testers;
import Scale.*;
import Scale.Note.*;

public class CustomScaleTester
{
    public static void main(String args[])
    {
	CustomScale cs1 = new CustomScale();
	cs1.add(Note.strToNote("A#"));
	cs1.display(24);
    }
}