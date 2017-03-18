package scale_data;

public class Prefixed_Notes
{
    public Prefixed_Notes(int option, String k) //maybe replace with a static factory method
    {
	key = k;
	category = scale_category_str(option);
	notes = prefixed_notes_select(k);
    }

    public void display()
    {
	for(int i = 0; i != notes.length; ++i)
	    System.out.print(notes[i] + " ");
	System.out.println();
    }

    private String scale_category_str(int option)
    {
	if(option == 1)
	    return Major_Scales.header_maj;
	else if(option == 2)
	    return Minor_Scales.header_min;
	else if(option == 3)
	    return Major_Pent_Scales.header_maj_pent;
	else if(option == 4)
	    return Minor_Pent_Scales.header_min_pent;
	else if(option == 5)
	    return Blues_Scales.header_blu;
	else if(option == 6)
	    return Natural_Scales.header_nat;
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }
   
    private String[] prefixed_notes_select(String k)
    {
	if(k.equals("Ab") || k.equals("G#"))
	    return prefixed_notes_Ab(category);
	else if(k.equals("A"))
	    return prefixed_notes_A(category);
	else if(k.equals("Bb") || k.equals("A#"))
	    return prefixed_notes_Bb(category);
	else if(k.equals("B") || k.equals("Cb"))
	    return prefixed_notes_B(category);
	else if(k.equals("C") || k.equals("B#"))
	    return prefixed_notes_C(category);
	else if(k.equals("C#") || k.equals("Db"))
	    return prefixed_notes_Cs(category);
	else if(k.equals("D"))
	    return prefixed_notes_D(category);
	else if(k.equals("Eb") || k.equals("D#"))
	    return prefixed_notes_Eb(category);
	else if(k.equals("E") || k.equals("Fb"))
	    return prefixed_notes_E(category);
	else if(k.equals("F") || k.equals("E#"))
	    return prefixed_notes_F(category);
	else if(k.equals("F#") || k.equals("Gb"))
	    return prefixed_notes_Fs(category);
	else if(k.equals("G"))
	    return prefixed_notes_G(category);
	else
	    {
		System.out.println("unknown option.");
		return null;
	    }
    }

    private String[] prefixed_notes_Ab(String c)
    {
	if(c.equals(Major_Scales.header_maj))
	    return Major_Scales.Maj_Ab();
	else if(c.equals(Minor_Scales.header_min))
	    return Minor_Scales.Min_Ab();
	else if(c.equals(Major_Pent_Scales.header_maj_pent))
	    return Major_Pent_Scales.MajPent_Ab();
	else if(c.equals(Minor_Pent_Scales.header_min_pent))
	    return Minor_Pent_Scales.MinPent_Ab();
	else if(c.equals(Blues_Scales.header_blu))
	    return Blues_Scales.Blu_Ab();
	else if(c.equals(Natural_Scales.header_nat))
	    return Natural_Scales.Nat_Ab();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_A(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_A();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_A();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_A();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_A();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_A();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_A();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_Bb(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_Bb();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_Bb();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_Bb();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_Bb();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_Bb();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_Bb();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_B(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_B();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_B();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_B();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_B();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_B();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_B();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_C(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_C();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_C();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_C();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_C();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_C();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_C();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_Cs(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_Cs();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_Cs();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_Cs();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_Cs();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_Cs();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_Cs();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_D(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_D();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_D();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_D();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_D();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_D();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_D();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_Eb(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_Eb();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_Eb();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_Eb();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_Eb();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_Eb();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_Eb();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_E(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_E();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_E();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_E();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_E();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_E();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_E();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_F(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_F();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_F();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_F();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_F();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_F();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_F();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_Fs(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_Fs();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_Fs();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_Fs();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_Fs();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_Fs();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_Fs();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    private String[] prefixed_notes_G(String c)
    {
        if(c.equals(Major_Scales.header_maj))
            return Major_Scales.Maj_G();
        else if(c.equals(Minor_Scales.header_min))
            return Minor_Scales.Min_G();
        else if(c.equals(Major_Pent_Scales.header_maj_pent))
            return Major_Pent_Scales.MajPent_G();
        else if(c.equals(Minor_Pent_Scales.header_min_pent))
            return Minor_Pent_Scales.MinPent_G();
        else if(c.equals(Blues_Scales.header_blu))
            return Blues_Scales.Blu_G();
        else if(c.equals(Natural_Scales.header_nat))
            return Natural_Scales.Nat_G();
	else
            {
		System.out.println("unknown option.");
                return null;
            }
    }

    public String getKey()
    {
	return key;
    }

    public String getCategory()
    {
	return category;
    }

    public String[] getNotes()
    {
	return notes.clone();
    }

    private final String key, category;
    private final String[] notes;
}