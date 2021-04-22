import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student tests for the MorseCodeConverter class.
 * 
 * @author Raymond Karyshyn
 */
public class MorseCodeConverter_STUDENT_Test {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree() {
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

	@Test
	public void testConvertToEnglishString() {
		assertEquals("sos", MorseCodeConverter.convertToEnglish("... --- ..."));
		assertEquals("nicholas", MorseCodeConverter.convertToEnglish("-. .. -.-. .... --- .-.. .- ..."));
		assertEquals("ray k", MorseCodeConverter.convertToEnglish(".-. .- -.-- / -.-"));
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1 = "the quick brown fox jumps over the lazy dog";
		getFile("StudentTestFile.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1, converter1);
	}

	public void getFile(String in) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if (status == JFileChooser.APPROVE_OPTION) {
			try {
				inputFile = chooser.getSelectedFile();
				// readFile();
			} catch (Exception e) {
				// e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
