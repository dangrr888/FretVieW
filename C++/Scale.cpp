#include "Scale.hpp"
#include "utility_funcs.hpp"
#include "Note.hpp"
#include <vector>
#include <string>
#include <algorithm>
#include <iostream>
#include <cstddef>
#include <stdexcept>

using std::vector; using std::string;
using std::find_if; using std::ostream;
using std::size_t; using std::logic_error;
using std::endl;

Scale& Scale::operator=(Scale rhs) //deep copy of FretBoard resource using copy and swap
{
  using std::swap;

  swap(pFb, rhs.pFb);

  category = rhs.category;
  key = rhs.key;

  return *this;
}

void Scale::add(const Note&)
{
  if(pFb)
    throw logic_error("Scale::add() - Cannot add note to fixed Scale!");
  else
    throw logic_error("Scale::add() - Unbound FretBoard*!");
}

void Scale::remove(const Note&)
{
  if(pFb)
    throw logic_error("Scale::remove() - Cannot remove note from fixed Scale!");
  throw logic_error("Scale::remove() - Unbound FretBoard*!");
}

void Scale::clear()
{
  if(pFb)
    throw logic_error("Scale::clear() - Cannot clear a fixed Scale!");
  throw logic_error("Scale::clear() - Unbound FretBoard*!");
}

void Scale::display_notes(ostream& os) const
{
  if(pFb)
    pFb->display_notes(os);
  else
    throw logic_error("Scale::display_notes() - Unbound FretBoard*!");
}

void Scale::display_grid(ostream& os, size_t num_frets) const
{
  if(pFb)
    pFb->display_grid(os, num_frets);
  else
    throw logic_error("Scale::display_grid() - Unbound FretBoard*!");
}

size_t Scale::num_notes() const
{
  if(pFb)
    return pFb->num_notes();
  throw logic_error("Scale::num_notes() - Unbound FretBoard*!");
}

void Scale::display(ostream& os, size_t num_frets)
{
  if(pFb)
    {
      os << endl;
      string header = category + " in key of " + key;
      os << header;
      os << " ( ";
      display_notes(os);
      os << ")\n" << endl;
      display_grid(os, num_frets);
    }
  else
    throw logic_error("Scale::display() - Unbound FretBoard*!");
}

vector<Note> Scale::generateNotes(const vector<string>& notes)
{
  vector<Note> ret;

  for(vector<string>::size_type i = 0; i != notes.size(); ++i) //for each string entry in vector
    {
      string::const_iterator j = notes[i].begin(), k;
      j = find_if(j, notes[i].end(), not_space); //iterate through string to find first non space char 
      k = find_if(j, notes[i].end(), space); //iterate to find first space
      if(j != k) //if non-space data exits
	ret.push_back(string(j,k)); //construct string, return note from string using implicit Note ctor and 
                                    //append to return container
    }

  return ret;
}

CustomScale& CustomScale::operator=(const CustomScale& rhs)
{
  Scale::operator=(rhs);
}

void CustomScale::add(const Note& n)
{
  if(pFb)
    pFb->add(n);
  else
    throw logic_error("CustomScale::add() - Unbound FretBoard*!");
}

void CustomScale::remove(const Note& n)
{
  if(pFb)
    pFb->remove(n);
  else
    throw logic_error("CustomScale::remove() - Unbound FretBoard*!");
}

void CustomScale::clear()
{
  if(pFb)
    pFb->clear();
  else
    throw logic_error("CustomScale::clear() - Unbound FretBoard*!");
}

void CustomScale::display(ostream& os, size_t num_frets) const
{
  if(pFb)
    {
      if(num_notes() != 0)
	{
	  os << endl;
	  string header = "Custom scale";
	  os << header;
	  os << " ( ";
	  display_notes(os);
	  os << ")\n" << endl;
	  display_grid(os, num_frets);
	}
    }
  else
    throw logic_error("CustomScale::display() - Unbound FretBoard*!");
}
