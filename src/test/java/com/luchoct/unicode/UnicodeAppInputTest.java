/**
 *
 */
package com.luchoct.unicode;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.lexicalscope.jewel.cli.ArgumentValidationException;
import com.lexicalscope.jewel.cli.CliFactory;
import com.lexicalscope.jewel.cli.HelpRequestedException;

/**
 * @author Luis
 */
public class UnicodeAppInputTest {

	@Test
	public void testInputWithoutHelp() {
		final String character = "£";

		try {
			final UnicodeAppInput input =
					CliFactory.createCliUsingInstance(new UnicodeAppInput()).parseArguments(new String[]{character});

			assertThat(input.getCharacters(), notNullValue());
			assertThat(input.getCharacters(), hasSize(1));
			assertThat(input.getCharacters(), hasItem(character));

		} catch (ArgumentValidationException ave) {
			throw new AssertionError();
		}
	}

	@Test(expected = HelpRequestedException.class)
	public void testInputWithHelp() {
		CliFactory.createCliUsingInstance(new UnicodeAppInput()).parseArguments(new String[]{"--help"});
	}
}
