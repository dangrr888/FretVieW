package scale_data;

final class Minor_Scales
{
    private Minor_Scales()
    {
	throw new AssertionError();
    }

    static String[] Min_Ab()
    {
        String[] sMin_Ab = {"Ab", "Bb", "B", "C#", "Eb", "E", "F#"};
	return sMin_Ab;
    }
    static String[] Min_A()
    {
        String[] sMin_A = {"A", "B", "C", "D", "E", "F", "G"};
	return sMin_A;
    }

    static String[] Min_Bb()
    {
	String[] sMin_Bb = {"Bb", "C", "C#", "Eb", "F", "F#", "Ab"};
	return sMin_Bb;
    }

    static String[] Min_B()
    {
	String[] sMin_B = {"B", "C#", "D", "E", "F#", "G", "A"};
	return sMin_B;
    }

    static String[] Min_C()
    {
        String[] sMin_C = {"C", "D", "Eb", "F", "G", "Ab", "Bb"};
	return sMin_C;
    }

    static String[] Min_Cs()
    {
        String[] sMin_Cs = {"C#", "Eb", "E", "F#", "Ab", "A", "B"};
	return sMin_Cs;
    }

    static String[] Min_D()
    {
        String[] sMin_D = {"D", "E", "F", "G", "A", "Bb", "C"};
	return sMin_D;
    }

    static String[] Min_Eb()
    {
        String[] sMin_Eb = {"Eb", "F", "F#", "Ab", "Bb", "C", "C#"};
	return sMin_Eb;
    }

    static String[] Min_E()
    {
        String[] sMin_E = {"E", "F#", "G", "A", "B", "C#", "D"};
	return sMin_E;
    }

    static String[] Min_F()
    {
        String[] sMin_F = {"F", "G", "Ab", "Bb", "C", "D", "Eb"};
	return sMin_F;
    }

    static String[] Min_Fs()
    {
        String[] sMin_Fs = {"F#", "Ab", "A", "B", "C#", "Eb", "E"};
	return sMin_Fs;
    }

    static String[] Min_G()
    {
        String[] sMin_G = {"G", "A", "Bb", "C", "D", "E", "F"};
        return sMin_G;
    }

    static String header_min = "Minor Scale";
}