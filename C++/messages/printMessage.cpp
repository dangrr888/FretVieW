#include "printMessage.hpp"
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <fstream>

using std::string; using std::vector;
using std::max; using std::ifstream;
using std::ostream; using std::endl;

string::size_type width(const vector<string>& v)
{
  string::size_type w = 0; 
  for(vector<string>::size_type i = 0; i != v.size(); ++i)
    w = max(w, v[i].size());

  return w;
}

vector<string> centre(const vector<string>& v)
{
  typedef string::size_type str_sz;

  vector<string> ret;

  str_sz w = width(v);

  for(vector<string>::size_type i = 0; i != v.size(); ++i)
    {
      str_sz spaces = (w - v[i].size());
      str_sz half_spaces = spaces/2;
      ret.push_back(string(half_spaces, ' ') + v[i] + string(spaces - half_spaces, ' '));
    }

  return ret;
}

vector<string> frame(const vector<string>& v, char c = '*')
{
  vector<string> ret;
  vector<string> message = centre(v);
  string::size_type w = width(v);
  const string border = string(w + 4, c);
  const string penultimate = string(1, c) + string(w + 2, ' ') + string(1, c);

  ret.push_back(border);
  ret.push_back(penultimate);

  for(vector<string>::size_type i = 0; i != message.size(); ++i)
    ret.push_back(string(1, c) + " " + message[i] + " " + string(1, c));

  ret.push_back(penultimate);
  ret.push_back(border);

  return ret;
}

void printMessage(ostream& os, const string& filename)
{
  ifstream infile(filename.c_str());
  
  vector<string> message_text;
  string s;

  while (getline(infile, s))
    message_text.push_back(s);

  vector<string> message = frame(message_text, '*');

  os << endl;

  for(vector<string>::size_type i = 0; i != message.size(); ++i)
    os << message[i] << endl;

  os << '\n' << '\n' << endl;

  os.clear();
}
