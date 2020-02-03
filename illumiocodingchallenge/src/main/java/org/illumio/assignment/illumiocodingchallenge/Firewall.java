package org.illumio.assignment.illumiocodingchallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


/**
 * The Class Firewall.
 */
public class Firewall {

	/** The port map.
	 *  Using the port as Key and rest info stored in an IPTree */
	private HashMap<Integer, IPTree> portMap;


	/**
	 * Instantiates a new firewall.
	 *
	 * @param path the path
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Firewall(String path) throws FileNotFoundException, IOException {

		BufferedReader read = new BufferedReader(new FileReader(path));
		portMap = new HashMap<>();
		String line = "";
		while((line = read.readLine()) != null) {			
			String[] parts = line.split(",");
			if(parts[2].contains("-")) {

				String[] ports = parts[2].split("-");
				int begin = Integer.parseInt(ports[0]);
				int end = Integer.parseInt(ports[1]);
				
				for(int i = begin; i <= end; i++) {
					insert(i, parts[0], parts[1], parts[3]);
				}
			} else {


				insert(Integer.parseInt(parts[2]), parts[0], parts[1], parts[3]);
			}
		}
		read.close();
	}


	/**
	 * Insert.
	 *
	 * @param port the port
	 * @param direction the direction
	 * @param protocol the protocol
	 * @param ip the ip
	 */
	private void insert(Integer port, String direction, String protocol,
			String ip) {
		IPTree tree = portMap.getOrDefault(port,new IPTree());

		tree.insert(ip, new IPDirection_Protocol(direction, protocol));
		portMap.put(port, tree);
	}


	/**
	 * Accept packet.
	 *
	 * @param direction the direction
	 * @param protocol the protocol
	 * @param port the port
	 * @param ip the ip
	 * @return true, if successful
	 */
	public boolean accept_packet(String direction, String protocol,
			Integer port, String ip) {
		IPTree tree = portMap.get(port);
		if(tree == null) {
			return false;
		} else {
			return tree.isAllowed(ip, direction, protocol);
		}
	}




}
