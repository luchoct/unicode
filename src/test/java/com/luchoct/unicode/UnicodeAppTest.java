/**
 * 
 */
package com.luchoct.unicode;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Luis
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UnicodeAppTest {
  
  @Test
  public void testPrintOutput() {
    final UnicodeAppInput input = mock(UnicodeAppInput.class);
    
    given(input.getCharacters()).willReturn(new LinkedList<String>());
    
    final UTF8 utf8 = mock(UTF8.class);
    
    given(utf8.toUnicodeValue()).willReturn("unicodeTest");
    given(utf8.toHexadecimalValue()).willReturn("hexadecimalTest");
    given(utf8.toDecimalValue()).willReturn("decimalTest");
    
    final List<UTF8> utf8s = new LinkedList<UTF8>();
    utf8s.add(utf8);

    final UnicodeApp app = new UnicodeApp(input);
    app.setUtf8s(utf8s);
    
    app.printOutput();
    
    verify(utf8).toUnicodeValue();
    verify(utf8).toHexadecimalValue();
    verify(utf8).toDecimalValue();
  }

}
