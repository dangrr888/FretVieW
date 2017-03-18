package Scale.Note;
import java.io.*;
public class Note implements NoteInt
{
    /*                                                                 
  configuration of fret entries:                                   
  (E_1st, E_2nd, A_1st, A_2nd, D_1st, D_2nd, G_1st, G_2nd, b_1st, \
b_2nd, e_1st, e_2nd)                                               
    */

    private Note(String noteName, String altName, int[] f) //private constructor to generate method struct
    {
        n = noteName;
        a = altName;
        frets = f;
    }

    public static Note Ab() //static factory methods return references to Note objects for all notes
    {
	int Ab[] = {4,16,11,23,6,18,1,13,9,21,4,16};
	return new Note("Ab", "G#", Ab);
    }

    public static Note A()
    {
	int A[] = {5,17,12,24,7,19,2,14,10,22,5,17};
	return new Note("A", "A", A);
    }

    public static Note Bb()
    {
        int Bb[] = {6,18,1,13,8,20,3,15,11,23,6,18};
        return new Note("Bb", "A#", Bb);
    }

    public static Note B()
    {
	int B[] = {7,19,2,14,9,21,4,16,12,24,7,19};
	return new Note("B", "Cb", B);
    }

    public static Note C()
    {
	int C[] = {8,20,3,15,10,22,5,17,1,13,8,20};
	return new Note("C", "B#", C);
    }

    public static Note Cs()
    {
	int Cs[] = {9,21,4,16,11,23,6,18,2,14,9,21};
	return new Note("C#", "Db", Cs);
    }

    public static Note D()
    {
	int D[] = {10,22,5,17,12,24,7,19,3,15,10,22};
	return new Note("D", "D", D);
    }

    public static Note Eb()
    {
	int Eb[] = {11,23,6,18,1,13,8,20,4,16,11,23};
	return new Note("Eb", "D#", Eb);
    }

    public static Note E()
    {
	int E[] = {12,24,7,19,2,14,9,21,5,17,12,24};
	return new Note("E", "Fb", E);
    }

    public static Note F()
    {
	int F[] = {1,13,8,20,3,15,10,22,6,18,1,13};
	return new Note("F", "E#", F);
    }

    public static Note Fs()
    {
	int Fs[] = {2,14,9,21,4,16,11,23,7,19,2,14};
	return new Note("F#", "Gb", Fs);
    }

    public static Note G()
    {
	int G[] = {3,15,10,22,5,17,12,24,8,20,3,15};
	return new Note("G", "G", G);
    }

    public static Note strToNote(String s) //static factory method to return Note reference for a given String input 
    {                                       //valid_key() should be used first to avoid throwing IllegalArgumentException
	if(s.equals("Ab") || s.equals("G#"))
	    return Ab();
	else if(s.equals("A"))
	    return A();
	else if(s.equals("Bb") || s.equals("A#"))
	    return Bb();
	else if(s.equals("B") || s.equals("Cb"))
	    return B();
	else if(s.equals("C") || s.equals("B#"))
	    return C();
	else if(s.equals("C#") || s.equals("Db"))
	    return Cs();
	else if(s.equals("D"))
	    return D();
	else if(s.equals("Eb") || s.equals("D#"))
	    return Eb();
	else if(s.equals("E") || s.equals("Fb"))
	    return E();
	else if(s.equals("F") || s.equals("E#"))
	    return F();
	else if(s.equals("F#") || s.equals("Gb"))
	    return Fs();
	else if(s.equals("G"))
	    return G();
	else
	    {
		throw new IllegalArgumentException("Note does not exist!");
	    }
    }

    public static boolean valid_key(String key) //checks whether String argument is a valid Note name
    {
	if(key.equals("Ab") || key.equals("A") || key.equals("A#") ||
	   key.equals("Bb") || key.equals("B") || key.equals("B#") ||
	   key.equals("Bb") || key.equals("B") || key.equals("B#") ||
	   key.equals("Cb") || key.equals("C") || key.equals("C#") ||
	   key.equals("Db") || key.equals("D") || key.equals("D#") ||
	   key.equals("Eb") || key.equals("E") || key.equals("E#") ||
	   key.equals("Fb") || key.equals("F") || key.equals("F#") ||
	   key.equals("Gb") || key.equals("G") || key.equals("G#"))
	    return true;
	return false;
    }

    public String name() //accessor for Note name
    {
	return n;
    }

    public String alias() //accessor for Note alias
    {
	return a;
    }

    public static String[] grabNotes(String msg, InputStream in, int n)
    {
        System.out.print(msg);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] key = new String[n];
	String tmp;
	int count = 0;
        while(count < n)
            {
                try {
                    tmp = br.readLine();
                    if(tmp.equals("X"))
			{
			    key[count] = tmp;
			    break;
			}
                    if(!Note.valid_key(tmp))
                        throw new IllegalArgumentException();
                    key[count++] = tmp;
                } catch(IllegalArgumentException exc) {
                    System.out.println("Note does not exist, please try again.");
                }
                catch(IOException exc) {
                    System.out.println("I/O Exception, please try again.");
                }
            }
	return key;
    }

    private final String n; //storage fields for Note data, declared final to avoid 
                            //re-referencing (but not redefintion, which is not possible 
                            //without using Collections Framework)
    private final String a;
    protected final int[] frets;
}