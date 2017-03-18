#ifndef GUARD_CONSTANTS_H
#define GUARD_CONSTANTS_H

//global constants, NOT TO BE CHANGED!!!

#include <cstddef>

const std::size_t no_frets = 24; //maximum number of frets to be displayed
const std::size_t no_strings = 6; //number of strings to be displayed

//header names for scale types that are available
const char* const header_maj = "Major Scale";
const char* const header_min = "Minor Scale";
const char* const header_maj_pent = "Major Pentatonic Scale";
const char* const header_min_pent = "Minor Pentatonic Scale";
const char* const header_blu = "Blues Scale"; 
const char* const header_nat = "Natural Minor Scale";

#endif
