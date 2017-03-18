/* Copyright (c) 2011-2012 Daniel Cumberbatch
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package messages;
import java.io.*;

public class Message implements MessageInt
{
    public Message(String filename)
    {
	String s;
	FileReader fr;
	BufferedReader br;
	msglength = 0;
	msg = new String[MAX_MSG_LENGTH];

	try {
		fr = new FileReader(filename);
		br = new BufferedReader(fr);
	}
	catch(FileNotFoundException exc) {
	    System.out.println("Cannot open file.");
	    return;
	}
	
	try {
	    while((s = br.readLine()) != null)
		msg[msglength++] = s;
	}
	catch(IOException exc) {
	    System.out.println("Error reading file.");
	    return;
	}
	catch(ArrayIndexOutOfBoundsException exc) {
	    System.out.println("Message exceeds maximum size.");
	    return;
	}



	try {
	    fr.close();
	}
	catch(IOException exc) {
	    System.out.println("Error closing file.");
	    return;
	}
    }

    private int width()
    {
	int w = 0;
	for(int i = 0; i != msglength; ++i)
	    {
		int l = msg[i].length();
		w = (w > l) ? w : l;
	    }
	return w;
    } 

    public void centre()
    {
	int w = width();
	for(int i = 0; i != msglength; ++i)
	    {
		int spaces = w - msg[i].length();
		int half_spaces = spaces/2;
		msg[i] = simpleString(half_spaces, ' ') + msg[i] 
		    + simpleString(spaces - half_spaces, ' ');
	    }
    }

    public void frame(char c)
    {
	int w = width();
	String border = simpleString(w + 4, c);
	String penultamate = c + simpleString(w + 2, ' ') + c;
	String[] msg_fmd = new String[msglength + 4];
	msg_fmd[0] = border;
	msg_fmd[1] = penultamate;
	for(int i = 0; i != msglength; ++i)
	    msg_fmd[i+2] = c + " " + msg[i] + " " + c;
	msg_fmd[msglength+2] = penultamate;
	msg_fmd[msglength+3] = border;
	msg = msg_fmd;
	msglength += 4;
    }

    public void display()
    {
	for(int i = 0; i != msglength; ++i)
	    System.out.println(msg[i]);
    }

    public void display_framed_and_centred(char c)
    {
	centre();
	frame(c);
	display();
	System.out.println();
    }
    
    private String simpleString(int n, char c)
    {
	char[] ret = new char[n];
	for(int i = 0; i != n; ++i)
	    ret[i] = c;
	String retstr = new String(ret);
	return retstr;
    }
    
    private final int MAX_MSG_LENGTH = 1000;
    private int msglength;
    private String[] msg;
}