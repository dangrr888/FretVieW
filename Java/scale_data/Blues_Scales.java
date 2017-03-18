package scale_data;

final class Blues_Scales //immutable class accessible within package
{                        //contents are implicitely final
    private Blues_Scales()
    {
	throw new AssertionError();
    }

    static String[] Blu_Ab()
    {
        String[] sBlu_Ab = {"Ab", "B", "C#", "D", "Eb", "F#"};
	return sBlu_Ab;
    }
    
    static String[] Blu_A()
    {
	String[] sBlu_A = {"A", "C", "D", "Eb", "E", "G"};
	return sBlu_A;
    }

    static String[] Blu_Bb()
    {
	String[] sBlu_Bb = {"Bb", "C#", "Eb", "E", "F", "Ab"};
	return sBlu_Bb;
    }

    static String[] Blu_B()
    {
	String[] sBlu_B = {"B", "D", "E", "F", "F#", "A"};
	return sBlu_B;
    }

    static String[] Blu_C()
    {
	String[] sBlu_C = {"C", "Eb", "F", "F#", "G", "Bb"};
	return sBlu_C;
    }

    static String[] Blu_Cs()
    {
	String[] sBlu_Cs = {"C#", "E", "F#", "G", "Ab", "B"};
	return sBlu_Cs;
    }

    static String[] Blu_D()
    {
	String[] sBlu_D = {"D", "F", "G", "Ab", "A", "C"};
	return sBlu_D;
    }

    static String[] Blu_Eb()
    {
	String[] sBlu_Eb = {"Eb", "F#", "Ab", "A", "Bb", "C#"};
	return sBlu_Eb;
    }

    static String[] Blu_E()
    {
	String[] sBlu_E = {"E", "G", "A", "Bb", "B", "D"};
	return sBlu_E;
    }

    static String[] Blu_F()
    {
	String[] sBlu_F = {"F", "Ab", "Bb", "B", "C", "Eb"};
	return sBlu_F;
    }

    static String[] Blu_Fs()
    {
	String[] sBlu_Fs = {"F#", "A", "B", "C", "C#", "E"};
	return sBlu_Fs;
    }

    static String[] Blu_G()
    {
	String[] sBlu_G = {"G", "Bb", "C", "C#", "D", "F"};
	return sBlu_G;
    }

    static String header_blu = "Blues Scale";
}