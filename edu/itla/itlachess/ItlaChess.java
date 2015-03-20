/**
 * @author Raydelto
 */
package edu.itla.itlachess;

import edu.itla.itlachess.network.Server;

public class ItlaChess {
	public static void main(String[] args) {
		 Server.getInstance().listen(2222);
	}

}
