package org.illumio.assignment.illumiocodingchallenge;

//IP Addresses Range Stored in the IPRange Class

public class IPRange implements Comparable<IPRange> {

	private long begin;
	private long end;

	public IPRange(long start, long end) {
		
		this.begin = start;
		this.end = end;
	}

	public IPRange(String ip) {
		if(ip.contains("-")) {
			
			String[] range = ip.split("-");
			this.begin = ipToLong(range[0]);
			this.end = ipToLong(range[1]);
		} else {
			this.begin = ipToLong(ip);
			this.end = this.begin;
		}
	}
	public int compareTo(IPRange T) {
		if(this.begin == T.begin && this.end == T.end) {
			return 0;
		} else if(this.begin > T.begin) {
			return 1;
		} else {
			return -1;
		}
	}

	// Convert Ip Address to long.
	// Source https://www.mkyong.com/java/java-convert-ip-address-to-decimal-number/
	protected static long ipToLong(String ipAddress) {

		long result = 0;
		String[] ipAddressInArray = ipAddress.split("\\.");

		for(int i = 3; i >= 0; i--) {
			long ip = Long.parseLong(ipAddressInArray[3 - i]);
			result |= ip << (i * 8);
		}
		return result;
	}

	
	// Check if ip lies in the range
	public boolean contains(long ip) {
		return begin <= ip && end >= ip;
	}
}
