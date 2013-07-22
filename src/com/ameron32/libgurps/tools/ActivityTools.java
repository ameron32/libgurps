package com.ameron32.libgurps.tools;

import java.io.File;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.ameron32.libgurps.References;

public class ActivityTools {
	
	Activity a;
	String directory;
	
	public ActivityTools(Activity a, String directory) {
		this.a = a;
		this.directory = directory;
	}
	
    public void openInPDF(String bookCode, String pageNumber) {
    	String[] refBookPage = new String[] { bookCode, pageNumber };
    	
        int pdfPageNumber = 0;
        int pageOffset = References.getOffsetByInitials(refBookPage[0]);

        File file = new File(directory
                + References.getFileNameByInitials(refBookPage[0]));
        Log.e("", directory
                + References.getFileNameByInitials(refBookPage[0]));
        pdfPageNumber = Integer.parseInt(refBookPage[1]) + pageOffset;
        Log.e("", pdfPageNumber + "");

        if (file.exists()) {
            Uri path = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(path, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("page", pdfPageNumber);

            try {
                a.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(a,
                        "No Application Available to View PDF",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
