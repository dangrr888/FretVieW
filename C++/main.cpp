//defininition if main() - main user interface 

#include "messages/printMessage.hpp"
#include "instructions/printInstructions.hpp"
#include "Note.hpp"
#include "scales/prefixed_notes.hpp"
#include "utility_funcs.hpp"
#include "scales/scale_category_str.hpp"
#include "constants.hpp"
#include "Scale.hpp"

#include <vector>
#include <string>
#include <iostream>
#include <algorithm>
#include <cstddef>

using std::vector; using std::string;
using std::endl; using std::cout; 
using std::cin; using std::sort;
using std::size_t;

int main()
{
  //Print welcome message
  printMessage(cout, "messages/welcome_message.txt"); //displays welcome message

  //Select Scale type
  printOptions(cout, "instructions/initialOptions.txt"); //displays intial options

  size_t scale_type = grab<size_t>("Your option: ", cin, cout);

  while(scale_type != 1 && scale_type != 2)
    scale_type = grab<size_t>("Invalid option, please try again: ", cin, cout);

  cout << endl;

  if(scale_type == 1) //Prefixed Scale
    {
      //Select Scale category
      printOptions(cout, "instructions/prefixedScaleOptions.txt");
     
      size_t scale_category = grab<size_t>("Your option: ", cin, cout);

      while(scale_category < 1 && scale_category > 6)
	scale_category = grab<size_t>("Invalid option, please try again: ", cin, cout);

      cout << endl;

      string category = scale_category_str(scale_category);
     
      //Select Scale Key 
      cout << "Please select the key of your scale (i.e., Xb, X or X#, where X = A,B,C,D,E,F or G): ";
      string key;
      cin >> key;

      while(!Note::valid_key(key))
	{
	  cout << "Invalid key, please try again: ";
	  cin >> key;
	}

      cout << endl;

      //Select size of fretboard to be displayed
      size_t num = grab<size_t>("Please select the number of Frets you would like to display (between 1 and 24): ", cin, cout);
      
      while(num < 1 || num > no_frets)
	num = grab<size_t>("Invalid option, please try again: ", cin, cout);

      //Construct Scale
      Scale user_prefixed_scale(category, key);

      //Display Scale
      user_prefixed_scale.display(cout, num);
    }
  else //Custom Scale
    {
      //Enter notes of custom scale
      cout << "Please enter each of the notes in your scale "
	   << "(i.e., Xb, X or X#, where X = A,B,C,D,E,F or G),"
	   << " following each note by a RETURN and terminating "
	   << "your scale with an 'X': "
	   << endl;
      string note;
      cin >> note;

      vector<string> customScaleNotes;

      while(note != "X")
	{	
	  if(Note::valid_key(note))
	    customScaleNotes.push_back(note);
	  else
	    {
	      while(!Note::valid_key(note))
		{
		  cout << "Invalid note, please try again: ";
		  cin >> note;
		}
	      customScaleNotes.push_back(note);
	    }
	  cin >> note;
	}

      cin.clear();

      cout << endl;

      //Select size of fretboard to be displayed
      size_t num = grab<size_t>("Please select the number of Frets you would like to display (between 1 and 24): ", cin, cout);
      
      while(num < 1 || num > no_frets)
        num = grab<size_t>("Invalid option, please try again: ", cin, cout);

      //construct custom scale
      CustomScale user_custom_scale(customScaleNotes); 
      
      //display custom scale
      user_custom_scale.display(cout, num);

      //print options for custom scale
      printOptions(cout, "instructions/customScaleOptions.txt"); //displays options for altering Custom Scale
      
      //read option for custom scale
      size_t customScaleOption = grab<size_t>("", cin, cout);
      while(customScaleOption < 1 && customScaleOption > 4)
	customScaleOption = grab<size_t>("Invalid option, please try again: ", cin, cout);

      while(customScaleOption != 4) //while user wishes not to exit
	{
	  if(customScaleOption == 1 || customScaleOption == 2)
	    {
	      if(customScaleOption == 1) //add a note
		{
		  string newNote;
		  cout << "Please enter a note to add: ";
		  cin >> newNote;
		  
		  while(!Note::valid_key(newNote))
		    {
		      cout << "Invalid note, please try again: ";
		      cin >> newNote;
		    }
		  
		  user_custom_scale.add(newNote);
		}
	      else //remove a note
		{
		  string oldNote;
		  cout << "Please enter a note to remove: ";
		  cin >> oldNote;
		  
		  while(!Note::valid_key(oldNote))
		    {
		      cout << "Invalid note, please try again: ";
		      cin >> oldNote;
		    }
		  
		  user_custom_scale.remove(oldNote);
		}

	      //Select size of fretboard to be displayed
	      num = grab<size_t>("Please select the number of Frets you would like to display (between 1 and 24): ", cin, cout);
	      
	      while(num < 1 || num > no_frets)
		num = grab<size_t>("Invalid option, please try again: ", cin, cout);
	    }
	  else if(customScaleOption == 3) //clear all notes on current fretboard
	    user_custom_scale.clear();
	  
	  cout << endl;

	  //display fretboard if notes are present
	  if(user_custom_scale.num_notes() !=0)
	    user_custom_scale.display(cout, num);
	  else
	    cout << "Your Scale is empty!" << endl;
	  
	  //print options for custom scale
	  printOptions(cout, "instructions/customScaleOptions.txt"); //displays options for altering Custom Scale

	  //read option for custom scale
	  customScaleOption = grab<size_t>("", cin, cout);
	  while(customScaleOption < 1 && customScaleOption > 4)
	    customScaleOption = grab<size_t>("Invalid option, please try again: ", cin, cout);

	} //exit loop when 4 is entered
    }

  //Print goodbye message                                                                                                                 
  printMessage(cout, "messages/goodbye_message.txt");
  
  return 0;
}
