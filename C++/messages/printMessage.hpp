#ifndef PRINTMESSAGE_H_
#define PRINTMESSAGE_H_

#include <vector>
#include <string>
#include <iostream>

std::string::size_type width(const std::vector<std::string>&);  //determines width of vector<string>
std::vector<std::string> centre(const std::vector<std::string>&); //centres text in a vector<string>
std::vector<std::string> frame(const std::vector<std::string>&, char); //frames a vector<string>
void printMessage(std::ostream&, const std::string&); //print formatted version of contents of a specified text file

#endif
