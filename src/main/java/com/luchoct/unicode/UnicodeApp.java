/**
 *
 */
package com.luchoct.unicode;

import java.util.List;
import java.util.stream.Collectors;

import com.lexicalscope.jewel.cli.ArgumentValidationException;
import com.lexicalscope.jewel.cli.CliFactory;
import com.lexicalscope.jewel.cli.HelpRequestedException;

/**
 * @author Luis
 */
public class UnicodeApp {

	private List<UTF8> utf8s;

	public UnicodeApp(final UnicodeAppInput input) {
		utf8s = input.getCharacters().stream()
				.map(UTF8::new)
				.collect(Collectors.toList());
	}

	/**
	 * This method is for testing purpose.
	 */
	final void setUtf8s(final List<UTF8> utf8s) {
		this.utf8s = utf8s;
	}

	public final void printOutput() {
		for (final UTF8 utf8 : utf8s) {
			System.out.print("Unicode: <" + utf8.toUnicodeValue());
			System.out.print("> decimal: <" + utf8.toDecimalValue());
			System.out.println("> hex: <" + utf8.toHexadecimalValue() + ">");
		}
	}

	public static void main(final String[] args) {
		try {
			final UnicodeAppInput input = CliFactory.createCliUsingInstance(new UnicodeAppInput()).parseArguments(args);
			if (input.getCharacters() == null || input.getCharacters().isEmpty()) {
				System.err.println("Wrong arguments. You must specify a space-separated list of characters.");
			} else {
				new UnicodeApp(input).printOutput();
			}
		} catch (HelpRequestedException hre) {
			System.err.println(hre.getMessage());
		} catch (ArgumentValidationException ave) {
			System.err.println("Wrong arguments. For more information, use the arguments --help or -h");
		}
	}
}
