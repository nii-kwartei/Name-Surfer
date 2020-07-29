
/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */
import acm.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class NameSurferEntry implements NameSurferConstants {

	private String name;
	private ArrayList<Integer> ranks = new ArrayList<Integer>();

	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears in the data
	 * file. Each line begins with the name, which is followed by integers giving
	 * the rank of that name for each decade.
	 */
	public NameSurferEntry(String line) {
		// You fill this in //
		StringTokenizer st = new StringTokenizer(line, " ");
		name = st.nextToken();
		// convert the remaining of the line to arraylist of numbers
		while (st.hasMoreTokens()) {
			int numbers = Integer.parseInt(st.nextToken().trim());
			ranks.add(numbers);
		}

	}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular decade. The decade
	 * value is an integer indicating how many decades have passed since the first
	 * year in the database, which is given by the constant START_DECADE. If a name
	 * does not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		int rank = 0;
		int position = decade - START_DECADE;
		rank = ranks.get(position);
		return rank;
	}

	public ArrayList<Integer> getRanks() {
		// You need to turn this stub into a real implementation //
		return ranks;
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a NameSurferEntry.
	 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		String s = name + " [" ;
		for (int i = 0; i < 10; i++) {
			s += ranks.get(i) + " ";
		}
		s += "]";
		return s;

	}
}
