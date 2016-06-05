/**
 * 
 */
package com.luchoct.unicode;

import com.luchoct.unicode.utils.StringUtils;


/**
 * Class that stores the different representations of an UTF value.
 * @author Luis
 * 
 */
public class UTF8 {

  private int codePoint;
  
  private final String hexadecimalValue;
  private final String decimalValue;
  private final String unicodeValue;

  public UTF8(final String value) {
    codePoint = getCodePoint(value);
    unicodeValue = getUnicodeValue(codePoint);
    hexadecimalValue = getHexadecimalValue(codePoint);
    decimalValue = getDecimalValue(hexadecimalValue);
  }
  
  private int getCodePoint(final String value) {
    final char firstCharacter = value.charAt(0);
    if (Character.isHighSurrogate(firstCharacter)) {
      try {
        return Character.toCodePoint(firstCharacter, value.charAt(1));
      } catch (IndexOutOfBoundsException iobe) {
        throw new IllegalArgumentException("Wrong value", iobe);
      }
    } else {
      return Character.codePointAt(value, 0);
    }
  }

  private String getUnicodeValue(final int codePoint) {
    return String.format("U+%04x", codePoint).toUpperCase();
  }

  private String getDecimalValue(final String hexadecimalValue) {
    final StringBuilder decimalValue = new StringBuilder();
    
    final String[] hexadecimalPairs = StringUtils.getInstance().split(hexadecimalValue, 2);
    for (int i=0; i<hexadecimalPairs.length; i++) {
      decimalValue.append(String.valueOf(Long.parseLong(hexadecimalPairs[i], 16))).append(" ");
    }
    return decimalValue.toString().trim();
  }

  private String getHexadecimalValue(final String binaryValue) {
    return Long.toHexString(Long.parseLong(binaryValue, 2)).toUpperCase();
  }
  
  private String getHexadecimalValue(final int codePoint) {
    final String binaryUTF8Value = getBinaryValue(codePoint);
    return getHexadecimalValue(binaryUTF8Value);
  }
  
  private String getBinaryValue(final int codePoint) {
    final char padding = '0';
    final StringUtils utilities = StringUtils.getInstance();
    if (codePoint < 128) {
      //000000-00007F
      
      //Padding until we have got 8 binary characters.
      return utilities.padToLength(padding, Integer.toBinaryString(codePoint), 8);

    } else if (codePoint < 2048) {
      //000080-0007FF
      
      //Padding until we have got 16 binary characters.
      final String binaryCodePoint = utilities.padToLength(padding, Integer.toBinaryString(codePoint), 16);
      
      return "110" + binaryCodePoint.substring(5, 10) 
          + "10" + binaryCodePoint.substring(10, 16);
      
    } else if (codePoint < 65536) {
      //000800-00FFFF

      //Padding until we have got 16 binary characters.
      final String binaryCodePoint = utilities.padToLength(padding, Integer.toBinaryString(codePoint), 16);

      return "1110" + binaryCodePoint.substring(0, 4) 
          + "10" + binaryCodePoint.substring(5, 10)
          + "10" + binaryCodePoint.substring(10, 16);
      
    } else {
      //010000-10FFFF
      
      //Padding until we have got 16 binary characters.
      final String binaryCodePoint = utilities.padToLength(padding, Integer.toBinaryString(codePoint), 24);

      return "11110" + binaryCodePoint.substring(3, 6) 
          + "10" + binaryCodePoint.substring(6, 12)
          + "10" + binaryCodePoint.substring(12, 18)
          + "10" + binaryCodePoint.substring(18, 24);
    }    
  }
  
  public String toHexadecimalValue() {
    return hexadecimalValue;
  }

  public String toDecimalValue() {
    return decimalValue;
  }

  public String toUnicodeValue() {
    return unicodeValue;
  }
}
