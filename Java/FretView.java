import messages.*;
import java.io.*;
import Scale.Note.*;
import Scale.*;

class FretView
{
    static int grabInt(String msg, InputStream in, int min, int max)
    {
	System.out.println();
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	int target;
        for(;;)
            {
                try {
                    System.out.print(msg);
                    target = Integer.parseInt(br.readLine());
		    if(target < min || target > max)
			throw new IllegalArgumentException();
		    System.out.println();
		    return target;
		} catch(NumberFormatException exc) {
                    System.out.println("Invalid format, please try again.");
		}
                catch(IllegalArgumentException exc) {
                    System.out.println("Invalid option, please try again.");
                }
		catch(IOException exc) {
		    System.out.println("I/O Exception, please try again.");
		}
            }
    }

    public static void main(String args[])
    {
	Message welcome = new Message("./messages/welcome_message.txt");
	welcome.display_framed_and_centred('*');

	Message options = new Message("./messages/initialOptions.txt");
	options.display();
	
	int scale_type = FretView.grabInt("Your option: ", System.in, 1, 2);
	
	if(scale_type == 1)
	    {
		Message prefixedScaleOptions = new Message("./messages/prefixedScaleOptions.txt");
		prefixedScaleOptions.display();
		int scale_category = FretView.grabInt("Your option: ", System.in, 1, 6);
		
		String key = Note.grabNotes("Please select the key of your scale (i.e., Xb, X or X#, where X = A,B,C,D,E,F or G): ", System.in, 1)[0];

		Scale prefixed_scale = new Scale(scale_category, key);

		int num_frets = FretView.grabInt("Please select the number of Frets you would like to display (between 1 and 24): ", System.in, 1, 24);
		prefixed_scale.display(num_frets);
	    }
	else
	    {
		final int MAX_NOTES = 100;
		String[] tmp = Note.grabNotes("Please enter each of the notes in your scale "
					      + "(maximum of " + MAX_NOTES + " notes) "
					      + "(i.e., Xb, X or X#, where X = A,B,C,D,E,F or G),"
					      + " following each note by a RETURN and terminating "
					      + "your scale with an 'X': ", System.in, MAX_NOTES);

		int numNotes;
		for(numNotes = 0; !tmp[numNotes].equals("X"); ++numNotes)
		    ;

		String[] customNotes = new String[numNotes];
		for(int i = 0; i != numNotes; ++i)
		    customNotes[i] = tmp[i];

		CustomScale custom_scale = new CustomScale(customNotes);
		
		int num_frets = FretView.grabInt("Please select the number of Frets you would like to display (between 1 and 24): ", System.in, 1, 24);
		
		custom_scale.display(num_frets);

		Message customScaleOptions = new Message("./messages/customScaleOptions.txt");
		customScaleOptions.display();

		int customScaleOption = FretView.grabInt("Your Option: ", System.in, 1, 4);
		
		while(customScaleOption != 4)
		    {
			if(customScaleOption == 1 || customScaleOption == 2)
			    {
				if(customScaleOption == 1)
				    {
					String newNote = Note.grabNotes("Please enter a note to add: ", System.in, 1)[0];
					custom_scale.add(Note.strToNote(newNote));
				    }
				else
				    {
					String oldNote = Note.grabNotes("Please enter a note to remove: ", System.in, 1)[0];
					custom_scale.remove(Note.strToNote(oldNote));
				    }
				
				num_frets = FretView.grabInt("Please select the number of Frets you would like to display (between 1 and 24): ", System.in, 1, 24);
			    }
			else
			    custom_scale.clear();
			
			custom_scale.display(num_frets);
			
			customScaleOptions.display();
			
			customScaleOption = FretView.grabInt("Your Option: ", System.in, 1, 4);
		    }
	    }
	
	Message goodbye = new Message("./messages/goodbye_message.txt");
	goodbye.display_framed_and_centred('*');
    } 
}
