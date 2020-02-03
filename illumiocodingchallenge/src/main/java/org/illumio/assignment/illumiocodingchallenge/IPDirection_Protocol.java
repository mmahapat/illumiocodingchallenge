package org.illumio.assignment.illumiocodingchallenge;

// TODO: Auto-generated Javadoc
/**
 * The Class IPDirection_Protocol.
 */
public class IPDirection_Protocol {

	boolean inbound;

	boolean outbound;

	boolean tcp;

	boolean udp;

	/**
	 * Instantiates a new IP direction protocol.
	 *
	 * @param direction the direction
	 * @param protocol  the protocol
	 */
	public IPDirection_Protocol(String direction, String protocol) {

		if (protocol.equalsIgnoreCase("tcp"))
			this.tcp = true;
		else
			this.udp = true;

		if (direction.equalsIgnoreCase("inbound"))
			this.inbound = true;
		else
			this.outbound = true;

	}

	/**
	 * Adds the direction and protocol.
	 *
	 * @param newRule the new rule
	 */
	public void addDirection_Protocol(IPDirection_Protocol newRule) {
		if (newRule.inbound)
			this.inbound = true;
		if (newRule.outbound)
			this.outbound = true;
		if (newRule.tcp)
			this.tcp = true;
		if (newRule.udp)
			this.udp = true;

	}

	/**
	 * Checks if direction and protocol is allowed.
	 *
	 * @param direction the direction
	 * @param protocol  the protocol
	 * @return true, if successful
	 */
	public boolean checkifAllow(String direction, String protocol) {
		boolean Direction, Protocol;
		if (direction.equals("inbound")) {
			Direction = inbound;
		} else {
			Direction = outbound;
		}
		if (protocol.equals("tcp")) {
			Protocol = tcp;
		} else {
			Protocol = udp;
		}
		return Direction && Protocol;
	}
}
