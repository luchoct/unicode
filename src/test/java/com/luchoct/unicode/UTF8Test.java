package com.luchoct.unicode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UTF8Test {
  
  @Test
  public void testPoundToUnicode() {
    assertEquals("U+00A3", new UTF8("£").toUnicodeValue());
  }

  @Test
  public void testPoundToHexaDecimal() {
    assertEquals("C2A3", new UTF8("£").toHexadecimalValue());
  }

  @Test
  public void testPoundToDecimal() {
    assertEquals("194 163", new UTF8("£").toDecimalValue());
  }

  @Test
  public void testLinearBSyllableB008AToUnicode() {
    //The surrogate pair D800 + DC00 is hexadecimal unicode 10000 of character 𐀀
    assertEquals("U+10000", new UTF8("𐀀").toUnicodeValue());
  }

  @Test
  public void testLinearBSyllableB008AToHexaDecimal() {
    //The surrogate pair D800 + DC00 is hexadecimal 0xF0908080 of character 𐀀
    assertEquals("F0908080", new UTF8("𐀀").toHexadecimalValue());
  }
  
  @Test
  public void testLinearBSyllableB008AToDecimal() {
    //The surrogate pair D800 + DC00 is decimal 4036001920 of character 𐀀
    assertEquals("240 144 128 128", new UTF8("𐀀").toDecimalValue());
  }
}
