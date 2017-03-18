#include "scale_category_str.hpp"
#include "../constants.hpp"
#include <string>
#include <stdexcept>
#include <cstddef>

using std::string; using std::domain_error;
using std::size_t;

string scale_category_str(size_t option)
{
  if(option == 1)
    return header_maj;
  else if(option == 2)
    return header_min;
  else if(option == 3)
    return header_maj_pent;
  else if(option == 4)
    return header_min_pent;
  else if(option == 5)
    return header_blu;
  else if(option == 6)
    return header_nat;
  else
    throw domain_error("unknown option");
}
