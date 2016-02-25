/**
 * 
 */
package main;

import java.io.File;
import java.io.FileWriter;

/**
 * @author Maximilian
 *
 */
public class TrollingTools {

	/**
	 * Opens all CD-Drives. Will create a VBscript file in the temp folder and
	 * run it Opens all CD-Drives Will create a VBscript file in the temp folder
	 * and runs it
	 */
	public static void openCDdrive() {

		try {
			File file = File.createTempFile("open", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new FileWriter(file);
			String vbs = "Dim ts\r\nDim strDriveLetter\r\nDim intDriveLetter\r\nDim fs 'As Scripting.FileSystemObject\r\nConst CDROM = 4\r\nOn Error Resume Next\r\nSet fs = CreateObject(\"Scripting.FileSystemObject\")\r\nstrDriveLetter = \"\"\r\nFor intDriveLetter = Asc(\"A\") To Asc(\"Z\")\r\nErr.Clear\r\nIf fs.GetDrive(Chr(intDriveLetter)).DriveType = CDROM Then\r\nIf Err.Number = 0 Then\r\nstrDriveLetter = Chr(intDriveLetter)\r\nExit For\r\nEnd If\r\nEnd If\r\nNext\r\nSet oWMP = CreateObject(\"WMPlayer.OCX.7\" )\r\nSet colCDROMs = oWMP.cdromCollection\r\nFor d = 0 to colCDROMs.Count - 1\r\ncolCDROMs.Item(d).Eject\r\nNext 'null\r\n\r\nFor d = 0 to colCDROMs.Count - 1\r\ncolCDROMs.Item(d).Eject\r\nNext 'null\r\n\r\nset owmp = nothing\r\nset colCDROMs = nothing";
			fw.write(vbs);
			fw.close();
			Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
