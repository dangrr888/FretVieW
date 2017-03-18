#include "printInstructions.hpp"
#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using std::ostream; using std::vector;
using std::string; using std::ifstream;
using std::endl;

ostream& printOptions(ostream& os, const char* filename)
{
  os << endl;
  ifstream infile(filename);
  string s;
  while(getline(infile, s))
    os << s << endl;
  os << endl;
  return os;
}
