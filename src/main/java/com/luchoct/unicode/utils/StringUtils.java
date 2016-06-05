/**
 * 
 */
package com.luchoct.unicode.utils;

/**
 * @author Luis
 * 
 */
public final class StringUtils {

  private StringUtils() {
  }

  private static class Holder {
    public static final StringUtils INSTANCE = new StringUtils();
  }

  public static StringUtils getInstance() {
    return Holder.INSTANCE;
  }

  /**
   * It adds the given padding on the left of the input until the input reaches
   * the given length.
   * @param padding The character to add.
   * @param input The input to pad.
   * @param length The length to reach. If the input is longer that the length,
   *          no padding is added.
   * @return A string with the given length, which is the result of adding the
   *         padding n-times to the given input.
   */
  public String padToLength(final char padding, final String input, final int length) {
    final StringBuilder paddings = new StringBuilder();
    while (paddings.length() + input.length() < length) {
      paddings.append(padding);
    }
    return paddings.toString().concat(input);
  }
  
  
  public String[] split(final String input, final int length) {
    return input.split("(?<=\\G.{" + length + "})");
  }
}
