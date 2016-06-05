/**
 * 
 */
package com.luchoct.unicode;

import java.util.List;

import com.lexicalscope.jewel.cli.Option;
import com.lexicalscope.jewel.cli.Unparsed;

/**
 * @author Luis
 *
 */
public class UnicodeAppInput {
  
  private List<String> characters;

  private Boolean help;

  public List<String> getCharacters() {
    return characters;
  }

  @Unparsed(name = "characters")
  public final void setCharacters(final List<String> newCharacters) {
    characters = newCharacters;
  }

  public final Boolean getHelp() {
    return help;
  }

  @Option(helpRequest = true, description = "Display help", shortName = "h", longName = "help", defaultToNull = true)
  public final void setShowHelp(final Boolean help) {
    this.help = help;
  }
}
