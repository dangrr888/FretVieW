#ifndef GUARD_UTILITY_FUNCS_H
#define GUARD_UTILITY_FUNCS_H

//Utility functions not associated with any particular class

#include "Note.hpp"
#include <vector>
#include <string>
#include <iostream>

void superimpose(const Note&, std::vector<std::vector<int> >&, bool); //function to rewrite contents of underlying container
                                                                      //depending on whether a note is added or removed
void plotter(const Note&, std::vector<std::vector<int> >&, int); //called by superimpose to write new data
bool space(char); //determines if char argument is a space
bool not_space(char); //determines if a char argument is a non-space

template<typename T>
T grab(const char* prompt, std::istream& is, std::ostream& os) //determies whether read character is of type T.
{
  T target;
  std::istream::iostate old_state = std::cin.exceptions(); //current exception mask                                          
  std::cin.exceptions(std::istream::failbit); //sets exception mask such that exception is thrown if read in input fails     

  for(;;) //forever                                                                                                     
    {
        try
	  {
	    os << prompt;
	    os.flush(); //flush buffer so that you see prompt with using endl and having to return to a new line    
	    is >> target; //if target wasn't an integer when reading input then exception is thrown                   
	    is.exceptions(old_state); //reset exception mask to old state                                           
	    return target;
	  }
        catch(std::istream::failure e) //catch exception                                                                
	  {
	    os << "Invalid input. Please try again." << std::endl;
	    is.clear(); //clear istream to read in new data                                                         
	    is.ignore(1024,'\n'); //ignores all characters on the line after that which caused the error            
	  }
    }
}

#endif
