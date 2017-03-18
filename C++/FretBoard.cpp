#include "FretBoard.hpp"
#include "Note.hpp"
#include "utility_funcs.hpp"
#include "constants.hpp"
#include <algorithm>
#include <vector>
#include <cstddef>
#include <iostream>
#include <sstream>
#include <cmath>
#include <string>

using std::find_if; using std::vector;
using std::size_t; using std::ostream;
using std::sort; using std::ostringstream;
using std::log10; using std::floor;
using std::string; using std::endl;

FretBoard::FretBoard(const std::vector<Note>& notes) //constructor taking vector of Notes
  : pImpl(new FbImpl)
{
  if(!notes.empty())
    {
      for(vector<Note>::size_type i = 0; i != notes.size(); ++i)
	add(notes[i]);
    }
}

FretBoard& FretBoard::operator=(FretBoard rhs) //copy-assignment operator
{
  using std::swap;

  swap(rhs.pImpl, pImpl);
  return *this;
}

void FretBoard::add(const Note& n) //adds a new note
{
  superimpose(n, pImpl->data, true);

  vector<Note>::const_iterator i = pImpl->notes.begin();
  while(i != pImpl->notes.end() && i->name() != n.name() && i->alias() != n.name()) 
    ++i;

  if(i == pImpl->notes.end()) //then note n doesn't exist in Scale
    pImpl->notes.push_back(n);
}

void FretBoard::remove(const Note& n) //removes a note
{
  superimpose(n, pImpl->data, false);

  vector<Note>::iterator i = pImpl->notes.begin();
  while(i != pImpl->notes.end() && i->name() != n.name())
    ++i;
  
  if(i != pImpl->notes.end())
    pImpl->notes.erase(i);
}

void FretBoard::clear() //clears all existing notes
{
  pImpl.reset(new FbImpl);
  pImpl->notes.clear();
}

size_t FretBoard::num_notes() const
{
  return pImpl->notes.size();
}

void FretBoard::display_notes(ostream& os) const
{
  vector<string> temp;
  for(vector<Note>::size_type i = 0; i != pImpl->notes.size(); ++i)
    temp.push_back(pImpl->notes[i].name());
  
  sort(temp.begin(), temp.end());

  for(vector<string>::size_type i = 0; i != temp.size(); ++i)
    os << temp[i] << " ";
}

vector<string> FretBoard::make_string(size_t str_num, const string& s, size_t num_frets) const
{
  static const string emptyFret = "-----";
  static const string nonEmptyFret = "--\\--";
  
  vector<string> ret(1, s);
  for(vector<int>::size_type i = 0; i != num_frets; ++i)
    {
      if(pImpl->data[str_num][i] == 1)
	ret.push_back(nonEmptyFret);
      else
	ret.push_back(emptyFret);
    }
  return ret;
}

void FretBoard::display_grid(ostream& os, size_t num_frets) const
{
  static const string emptyDivider = "|    ";
  const vector<string> stringDivider(num_frets + 1, emptyDivider);

  vector<string> Estring = make_string(0, "E  -", num_frets);   //construct guitar strings
  vector<string> Astring = make_string(1, "A  -", num_frets);
  vector<string> Dstring = make_string(2, "D  -", num_frets);
  vector<string> Gstring = make_string(3, "G  -", num_frets);
  vector<string> Bstring = make_string(4, "B  -", num_frets);
  vector<string> estring = make_string(5, "e  -", num_frets);

  vector<string> newStringDivider = stringDivider;
  newStringDivider.insert(newStringDivider.begin(), string("   "));

  ostringstream oss; //construct fret number panel   
  oss << "      " << 1 << "  ";
  if(num_frets > 1)
    {
      for(size_t i = 2; i != num_frets + 1; ++i)
	oss << string(2 - (int)floor(log10(i)), ' ') << i << "  ";
    }

  vector<string> fretNumbers;
  fretNumbers.push_back(oss.str());

  vector<vector<string> > ret;   //construct grid to be displayed
  ret.push_back(fretNumbers);
  ret.push_back(Estring);
  ret.push_back(newStringDivider);
  ret.push_back(Astring);
  ret.push_back(newStringDivider);    
  ret.push_back(Dstring);
  ret.push_back(newStringDivider);
  ret.push_back(Gstring);
  ret.push_back(newStringDivider);
  ret.push_back(Bstring);
  ret.push_back(newStringDivider);
  ret.push_back(estring);

  for(vector<vector<string> >::size_type i = 0; i != ret.size(); ++i)   //output grid
    {
      for(vector<string>::size_type j = 0; j != ret[i].size(); ++j)
	os << ret[i][j];
      os << endl;
    }
} 
