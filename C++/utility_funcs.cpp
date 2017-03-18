#include "utility_funcs.hpp"
#include "constants.hpp"
#include <vector>
#include <stdexcept>
#include <string>
#include <cctype>
#include "Note.hpp"

using std::vector; using std::domain_error;
using std::string; using std::isspace;

void superimpose(const Note& note, vector<vector<int> >& data, bool add)
{
  if(add)                    //if a note is to be added to current scale
    plotter(note, data, 1);
  else                       //note is to be removed
    plotter(note, data, 0);
}

void plotter(const Note& note, vector<vector<int> >& data, int sig) //rewrites entries of underlying container associated with Note argument
{
  vector<int>::size_type j = 0; //current fret number

  for(vector<vector<int> >::size_type i = 0; i != no_strings; ++i) //current string number
    {
      data[i][note.frets[j++]-1] = sig; //adds first of two fret numbers associated with note for this string
      data[i][note.frets[j++]-1] = sig; //adds second of two fret numbers assocaited with note for this string
    }
}

bool space(char c)
{
  return isspace(c);
}

bool not_space(char c)
{
  return !isspace(c);
}
