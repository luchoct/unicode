/**
 *
 */
package com.luchoct.unicode.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Luis
 */
public class StringUtilsTest {

	@Test
	public void testPadding() {
		assertEquals("aaaahello", StringUtils.getInstance().padToLength('a', "hello", 9));
	}

	@Test
	public void testPaddingInputTooLong() {
		assertEquals("hello", StringUtils.getInstance().padToLength('a', "hello", 2));
	}

	@Test
	public void testSplit() {
		assertEquals("he", StringUtils.getInstance().split("hello", 2)[0]);
		assertEquals("ll", StringUtils.getInstance().split("hello", 2)[1]);
		assertEquals("o", StringUtils.getInstance().split("hello", 2)[2]);
	}
}
