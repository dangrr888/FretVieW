#include "minor_scales.hpp"
#include <vector>
#include <string>

using std::vector; using std::string;

const vector<string>& Min_Ab()
{
  static const char* const aMin_Ab[] = {"Ab", "Bb", "B", "C#", "Eb", "E", "F#"};
  static const vector<string> vMin_Ab(aMin_Ab, aMin_Ab + sizeof(aMin_Ab)/sizeof(*aMin_Ab));
  return vMin_Ab;
}

const vector<string>& Min_A()
{
  static const char* const aMin_A[] = {"A", "B", "C", "D", "E", "F", "G"};
  static const vector<string> vMin_A(aMin_A, aMin_A + sizeof(aMin_A)/sizeof(*aMin_A));
  return vMin_A;
}

const vector<string>& Min_As()
{
  return Min_Bb();
}

const vector<string>& Min_Bb()
{
  static const char* const aMin_Bb[] = {"Bb", "C", "C#", "Eb", "F", "F#", "Ab"};
  static const vector<string> vMin_Bb(aMin_Bb, aMin_Bb + sizeof(aMin_Bb)/sizeof(*aMin_Bb));
  return vMin_Bb;
}

const vector<string>& Min_B()
{
  static const char* const aMin_B[] = {"B", "C#", "D", "E", "F#", "G", "A"};
  static const vector<string> vMin_B(aMin_B, aMin_B + sizeof(aMin_B)/sizeof(*aMin_B));
  return vMin_B;
}

const vector<string>& Min_Bs()
{
  return Min_C();
}

const vector<string>& Min_Cb()
{
  return Min_B();
}

const vector<string>& Min_C()
{
  static const char* const aMin_C[] = {"C", "D", "Eb", "F", "G", "Ab", "Bb"};
  static const vector<string> vMin_C(aMin_C, aMin_C + sizeof(aMin_C)/sizeof(*aMin_C));
  return vMin_C;
}

const vector<string>& Min_Cs()
{
  static const char* const aMin_Cs[] = {"C#", "Eb", "E", "F#", "Ab", "A", "B"};
  static const vector<string> vMin_Cs(aMin_Cs, aMin_Cs + sizeof(aMin_Cs)/sizeof(*aMin_Cs));
  return vMin_Cs;
}

const vector<string>& Min_Db()
{
  return Min_Cs();
}

const vector<string>& Min_D()
{
  static const char* const aMin_D[] = {"D", "E", "F", "G", "A", "Bb", "C"};
  static const vector<string> vMin_D(aMin_D, aMin_D + sizeof(aMin_D)/sizeof(*aMin_D));
  return vMin_D;
}

const vector<string>& Min_Ds()
{
  return Min_Eb();
}

const vector<string>& Min_Eb()
{
  static const char* const aMin_Eb[] = {"Eb", "F", "F#", "Ab", "Bb", "C", "C#"};
  static const vector<string> vMin_Eb(aMin_Eb, aMin_Eb + sizeof(aMin_Eb)/sizeof(*aMin_Eb));
  return vMin_Eb;
}

const vector<string>& Min_E()
{
  static const char* const aMin_E[] = {"E", "F#", "G", "A", "B", "C#", "D"};
  static const vector<string> vMin_E(aMin_E, aMin_E + sizeof(aMin_E)/sizeof(*aMin_E));
  return vMin_E;
}

const vector<string>& Min_Es()
{
  return Min_F();
}

const vector<string>& Min_Fb()
{
  return Min_E();
}

const vector<string>& Min_F()
{
  static const char* const aMin_F[] = {"F", "G", "Ab", "Bb", "C", "D", "Eb"};
  static const vector<string> vMin_F(aMin_F, aMin_F + sizeof(aMin_F)/sizeof(*aMin_F));
  return vMin_F;
}

const vector<string>& Min_Fs()
{
  static const char* const aMin_Fs[] = {"F#", "Ab", "A", "B", "C#", "Eb", "E"};
  static const vector<string> vMin_Fs(aMin_Fs, aMin_Fs + sizeof(aMin_Fs)/sizeof(*aMin_Fs));
  return vMin_Fs;
}

const vector<string>& Min_Gb()
{
  return Min_Fs();
}

const vector<string>& Min_G()
{
  static const char* const aMin_G[] = {"G", "A", "Bb", "C", "D", "E", "F"};
  static const vector<string> vMin_G(aMin_G, aMin_G + sizeof(aMin_G)/sizeof(*aMin_G));
  return vMin_G;
}

const vector<string>& Min_Gs()
{
  return Min_Ab();
}
