package scale_data;

final class Major_Scales
{
    private Major_Scales()
    {
	throw new AssertionError();
    }

    static String[] Maj_Ab() 
    {
	String[] sMaj_Ab = {"Ab", "Bb", "C", "C#", "Eb", "F", "G"};
	return sMaj_Ab;
    }

    static String[] Maj_A() 
    {
	String[] sMaj_A = {"A", "B", "C#", "D", "E", "F#", "Ab"};
	return sMaj_A;
    }

    static String[] Maj_Bb()
    {
	String[] sMaj_Bb = {"Bb", "C", "D", "Eb", "F", "G", "A"};
	return sMaj_Bb;
    }

    static String[] Maj_B() 
    {
	String[] sMaj_B = {"B", "C#", "Eb", "E", "F#", "Ab", "Bb"};
	return sMaj_B;
    }

    static String[] Maj_C() 
    {
	String[] sMaj_C = {"C", "D", "E", "F", "G", "A", "B"};
	return sMaj_C;
    }

    static String[] Maj_Cs()
    {
	String[] sMaj_Cs = {"C#", "Eb", "F", "F#", "Ab", "Bb", "C"};
	return sMaj_Cs;
    }

    static String[] Maj_D()
    {
	String[] sMaj_D = {"D", "E", "F#", "G", "A", "B", "C#"};
	return sMaj_D;
    }

    static String[] Maj_Eb()
    {
	String[] sMaj_Eb = {"Eb", "F", "G", "Ab", "Bb", "C", "D"};
	return sMaj_Eb;
    }

    static String[] Maj_E() 
    {
	String[] sMaj_E = {"E", "F#", "Ab", "A", "B", "C#", "Eb"};
	return sMaj_E;
    }

    static String[] Maj_F()
    {
	String[] sMaj_F = {"F", "G", "A", "Bb", "C", "D", "E"};
	return sMaj_F;
    }

    static String[] Maj_Fs()
    {
	String[] sMaj_Fs = {"F#", "Ab", "Bb", "B", "C#", "Eb", "F"};
	return sMaj_Fs;
    }

    static String[] Maj_G() 
    {
	String[] sMaj_G = {"G", "A", "B", "C", "D", "E", "F#"};
	return sMaj_G;
    }

    static String header_maj = "Major Scale";
}
