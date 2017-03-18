#include "FbImpl.hpp"
#include "constants.hpp"
#include <vector>

using std::vector;

vector<vector<int> > FbImpl::generateFretBoard()
{
  vector<vector<int> > ret; //return container
  
  for(vector<vector<int> >::size_type i = 0; i != no_strings; ++i)
    ret.push_back(vector<int>(no_frets, 0)); //default initialise entries in grid to `0'

  return ret;
}
