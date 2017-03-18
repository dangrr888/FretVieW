package testers;
import Scale.Note.*;

class testNote
{
    public static void main(String args[])
    {
	Note test = Note.Ab();
	System.out.println(test.name());
	System.out.println(test.alias());

	String key = new String("K#");
	if(Note.valid_key(key))
	    {
		test = Note.strToNote(key);
		System.out.println(test.alias());
	    }
    }
}