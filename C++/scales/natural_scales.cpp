#include "natural_scales.hpp"
#include <vector>
#include <string>

using std::vector; using std::string;

const vector<string>& Nat_Ab()
{
  static const char* const aNat_Ab[] = {"Ab", "Bb", "B", "C#", "Eb", "E", "F#"};
  static const vector<string> vNat_Ab(aNat_Ab, aNat_Ab + sizeof(aNat_Ab)/sizeof(*aNat_Ab));
  return vNat_Ab;
}

const vector<string>& Nat_A()
{
  static const char* const aNat_A[] = {"A", "B", "C", "D", "E", "F", "G"};
  static const vector<string> vNat_A(aNat_A, aNat_A + sizeof(aNat_A)/sizeof(*aNat_A));
  return vNat_A;
}

const vector<string>& Nat_As()
{
  return Nat_Bb();
}

const vector<string>& Nat_Bb()
{
  static const char* const aNat_Bb[] = {"Bb", "C", "C#", "Eb", "F", "F#", "Ab"};
  static const vector<string> vNat_Bb(aNat_Bb, aNat_Bb + sizeof(aNat_Bb)/sizeof(*aNat_Bb));
  return vNat_Bb;
}

const vector<string>& Nat_B()
{
  static const char* const aNat_B[] = {"B", "C#", "D", "E", "F#", "G", "A"};
  static const vector<string> vNat_B(aNat_B, aNat_B + sizeof(aNat_B)/sizeof(*aNat_B));
  return vNat_B;
}

const vector<string>& Nat_Bs()
{
  return Nat_C();
}

const vector<string>& Nat_Cb()
{
  return Nat_B();
}

const vector<string>& Nat_C()
{
  static const char* const aNat_C[] = {"C", "D", "E", "F", "G", "Ab", "Bb"};
  static const vector<string> vNat_C(aNat_C, aNat_C + sizeof(aNat_C)/sizeof(*aNat_C));
  return vNat_C;
}

const vector<string>& Nat_Cs()
{
  static const char* const aNat_Cs[] = {"C#", "Eb", "F", "F#", "Ab", "A", "B"};
  static const vector<string> vNat_Cs(aNat_Cs, aNat_Cs + sizeof(aNat_Cs)/sizeof(*aNat_Cs));
  return vNat_Cs;
}

const vector<string>& Nat_Db()
{
  return Nat_Cs();
}

const vector<string>& Nat_D()
{
  static const char* const aNat_D[] = {"D", "E", "F#", "G", "A", "Bb", "C"};
  static const vector<string> vNat_D(aNat_D, aNat_D + sizeof(aNat_D)/sizeof(*aNat_D));
  return vNat_D;
}

const vector<string>& Nat_Ds()
{
  return Nat_Eb();
}

const vector<string>& Nat_Eb()
{
  static const char* const aNat_Eb[] = {"Eb", "F", "G", "Ab", "Bb", "B", "C#"};
  static const vector<string> vNat_Eb(aNat_Eb, aNat_Eb + sizeof(aNat_Eb)/sizeof(*aNat_Eb));
  return vNat_Eb;
}

const vector<string>& Nat_E()
{
  static const char* const aNat_E[] = {"E", "F#", "Ab", "A", "B", "C", "D"};
  static const vector<string> vNat_E(aNat_E, aNat_E + sizeof(aNat_E)/sizeof(*aNat_E));
  return vNat_E;
}

const vector<string>& Nat_Es()
{
  return Nat_F();
}

const vector<string>& Nat_Fb()
{
  return Nat_E();
}

const vector<string>& Nat_F()
{
  static const char* const aNat_F[] = {"F", "G", "A", "Bb", "C", "C#", "Eb"};
  static const vector<string> vNat_F(aNat_F, aNat_F + sizeof(aNat_F)/sizeof(*aNat_F));
  return vNat_F;
}

const vector<string>& Nat_Fs()
{
  static const char* const aNat_Fs[] = {"F#", "Ab", "Bb", "B", "C#", "D", "E"};
  static const vector<string> vNat_Fs(aNat_Fs, aNat_Fs + sizeof(aNat_Fs)/sizeof(*aNat_Fs));
  return vNat_Fs;
}

const vector<string>& Nat_Gb()
{
  return Nat_Fs();
}

const vector<string>& Nat_G()
{
  static const char* const aNat_G[] = {"G", "A", "B", "C", "D", "Eb", "F"};
  static const vector<string> vNat_G(aNat_G, aNat_G + sizeof(aNat_G)/sizeof(*aNat_G));
  return vNat_G;
}

const vector<string>& Nat_Gs()
{
  return Nat_Ab();
}
