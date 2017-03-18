#include "minor_pent_scales.hpp"
#include <vector>
#include <string>

using std::vector; using std::string;

const vector<string>& MinPent_Ab()
{
  static const char* const aMinPent_Ab[] = {"Ab", "B", "C#", "Eb", "F#"};
  static const vector<string> vMinPent_Ab(aMinPent_Ab, aMinPent_Ab + sizeof(aMinPent_Ab)/sizeof(*aMinPent_Ab));
  return vMinPent_Ab;
}

const vector<string>& MinPent_A()
{
  static const char* const aMinPent_A[] = {"A", "C", "D", "E", "G"};
  static const vector<string> vMinPent_A(aMinPent_A, aMinPent_A + sizeof(aMinPent_A)/sizeof(*aMinPent_A));
  return vMinPent_A;
}

const vector<string>& MinPent_As()
{
  return MinPent_Bb();
}

const vector<string>& MinPent_Bb()
{
  static const char* const aMinPent_Bb[] = {"Bb", "C#", "Eb", "F", "Ab"};
  static const vector<string> vMinPent_Bb(aMinPent_Bb, aMinPent_Bb + sizeof(aMinPent_Bb)/sizeof(*aMinPent_Bb));
  return vMinPent_Bb;
}

const vector<string>& MinPent_B()
{
  static const char* const aMinPent_B[] = {"B", "D", "E", "F#", "A"};
  static const vector<string> vMinPent_B(aMinPent_B, aMinPent_B + sizeof(aMinPent_B)/sizeof(*aMinPent_B));
  return vMinPent_B;
}

const vector<string>& MinPent_Bs()
{
  return MinPent_C();
}

const vector<string>& MinPent_Cb()
{
  return MinPent_B();
}

const vector<string>& MinPent_C()
{
  static const char* const aMinPent_C[] = {"C", "Eb", "F", "G", "Bb"};
  static const vector<string> vMinPent_C(aMinPent_C, aMinPent_C + sizeof(aMinPent_C)/sizeof(*aMinPent_C));
  return vMinPent_C;
}

const vector<string>& MinPent_Cs()
{
  static const char* const aMinPent_Cs[] = {"C#", "E", "F#", "Ab", "B"};
  static const vector<string> vMinPent_Cs(aMinPent_Cs, aMinPent_Cs + sizeof(aMinPent_Cs)/sizeof(*aMinPent_Cs));
  return vMinPent_Cs;
}

const vector<string>& MinPent_Db()
{
  return MinPent_Cs();
}

const vector<string>& MinPent_D()
{
  static const char* const aMinPent_D[] = {"D", "F", "G", "A", "C"};
  static const vector<string> vMinPent_D(aMinPent_D, aMinPent_D + sizeof(aMinPent_D)/sizeof(*aMinPent_D));
  return vMinPent_D;
}

const vector<string>& MinPent_Ds()
{
  return MinPent_Eb();
}

const vector<string>& MinPent_Eb()
{
  static const char* const aMinPent_Eb[] = {"Eb", "F#", "Ab", "Bb", "C#"};
  static const vector<string> vMinPent_Eb(aMinPent_Eb, aMinPent_Eb + sizeof(aMinPent_Eb)/sizeof(*aMinPent_Eb));
  return vMinPent_Eb;
}

const vector<string>& MinPent_E()
{
  static const char* const aMinPent_E[] = {"E", "G", "A", "B", "D"};
  static const vector<string> vMinPent_E(aMinPent_E, aMinPent_E + sizeof(aMinPent_E)/sizeof(*aMinPent_E));
  return vMinPent_E;
}

const vector<string>& MinPent_Es()
{
  return MinPent_F();
}

const vector<string>& MinPent_Fb()
{
  return MinPent_E();
}

const vector<string>& MinPent_F()
{
  static const char* const aMinPent_F[] = {"F", "Ab", "Bb", "C", "Eb"};
  static const vector<string> vMinPent_F(aMinPent_F, aMinPent_F + sizeof(aMinPent_F)/sizeof(*aMinPent_F));
  return vMinPent_F;
}

const vector<string>& MinPent_Fs()
{
  static const char* const aMinPent_Fs[] = {"F#", "A", "B", "C#", "E"};
  static const vector<string> vMinPent_Fs(aMinPent_Fs, aMinPent_Fs + sizeof(aMinPent_Fs)/sizeof(*aMinPent_Fs));
  return vMinPent_Fs;
}

const vector<string>& MinPent_Gb()
{
  return MinPent_Fs();
}

const vector<string>& MinPent_G()
{
  static const char* const aMinPent_G[] = {"G", "Bb", "C", "D", "F"};
  static const vector<string> vMinPent_G(aMinPent_G, aMinPent_G + sizeof(aMinPent_G)/sizeof(*aMinPent_G));
  return vMinPent_G;
}

const vector<string>& MinPent_Gs()
{
  return MinPent_Ab();
}
